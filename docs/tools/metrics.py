#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
统计四组测试的「规模」与「冗余率」——直接从源码算，不需要别人提供表格。

用法（在 java-project/ 目录下执行）：
    python ../docs/tools/metrics.py
    python ../docs/tools/metrics.py --csv > ../docs/raw/metrics.csv

输出列：
    组, 文件数, 测试方法数, 断言数, 每文件方法数, 每方法断言数, 冗余率%

口径说明：
  · 测试方法数：@Test 与 @ParameterizedTest 的出现次数
  · 断言数：assertXxx( 的出现次数（含 assertThrows / assertAll）
  · 冗余率：两两比较测试方法体，文本相似度 ≥ 0.8 记为“重复”；
            冗余率 = 涉及重复的方法数 ÷ 总方法数
    （注意：不能用“重复对数 ÷ 方法数”，那会超过 100%，是错误的）
"""

import difflib
import os
import re
import sys

TEST_ROOT = os.path.join("src", "test", "java")
GROUPS = [("数据集自带", "DatasetTest"),
          ("人工", "ManualTest"),
          ("模型A", "LlmATest"),
          ("模型B", "LlmBTest")]
THRESHOLD = 0.8


def split_methods(path):
    text = open(path, encoding="utf-8", errors="ignore").read()
    parts = re.split(r"@(?:Test|ParameterizedTest)[^\n]*\n", text)[1:]
    return [re.sub(r"\s+", " ", p).strip() for p in parts if p.strip()]


def collect(suffix):
    files, methods, asserts = [], [], 0
    for root, _, names in os.walk(TEST_ROOT):
        for name in names:
            if not name.endswith(suffix + ".java"):
                continue
            p = os.path.join(root, name)
            files.append(p)
            methods += split_methods(p)
            asserts += len(re.findall(r"assert[A-Za-z]+\s*\(", open(p, encoding="utf-8", errors="ignore").read()))
    return files, methods, asserts


def redundancy(methods):
    n = len(methods)
    if n < 2:
        return 0.0
    involved = set()
    for i in range(n):
        for j in range(i + 1, n):
            if difflib.SequenceMatcher(None, methods[i], methods[j]).ratio() >= THRESHOLD:
                involved.add(i)
                involved.add(j)
    return 100.0 * len(involved) / n


def main():
    as_csv = "--csv" in sys.argv
    if as_csv:
        print("组,文件数,测试方法数,断言数,每文件方法数,每方法断言数,冗余率%")
    else:
        print("%-12s %-6s %-8s %-8s %-10s %-10s %s"
              % ("组", "文件", "方法", "断言", "方法/文件", "断言/方法", "冗余率"))

    for label, suffix in GROUPS:
        files, methods, asserts = collect(suffix)
        n = len(files)
        m = len(methods)
        row = [label, str(n), str(m), str(asserts),
               "%.1f" % (m / n) if n else "-",
               "%.1f" % (asserts / m) if m else "-",
               "%.1f" % redundancy(methods)]
        if as_csv:
            print(",".join(row))
        else:
            print("%-12s %-6s %-8s %-8s %-10s %-10s %s"
                  % (label, row[1], row[2], row[3], row[4], row[5], row[6]))


if __name__ == "__main__":
    main()
