
#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import csv
import difflib
import os
import re
import sys

TEST_ROOT = os.path.join("src", "test", "java")

GROUPS = [
    ("数据集自带", "DatasetTest"),
    ("人工", "ManualTest"),
    ("LLM-A", "LlmATest"),
    ("LLM-B", "LlmBTest"),
]

THRESHOLD = 0.8


def split_methods(path):
    """按测试注解切分源码，沿用原脚本的文本相似度统计思路。"""
    with open(path, encoding="utf-8", errors="ignore") as f:
        source = f.read()

    # 先去掉注释，减少注释文字造成的相似度误判
    source = re.sub(r"/\*.*?\*/", "", source, flags=re.S)
    source = re.sub(r"//[^\n]*", "", source)

    parts = re.split(r"@(?:Test|ParameterizedTest)\b", source)[1:]

    methods = []
    for part in parts:
        part = re.sub(r"\s+", " ", part).strip()
        if part:
            methods.append(part)

    return methods


def redundancy(methods):
    """参与至少一组相似度 >= 阈值比较的方法数 / 方法总数。"""
    n = len(methods)
    if n < 2:
        return 0.0, 0

    involved = set()

    for i in range(n):
        for j in range(i + 1, n):
            ratio = difflib.SequenceMatcher(
                None, methods[i], methods[j]
            ).ratio()

            if ratio >= THRESHOLD:
                involved.add(i)
                involved.add(j)

    return 100.0 * len(involved) / n, len(involved)


def main():
    if not os.path.isdir(TEST_ROOT):
        print(
            "错误：找不到 src/test/java。"
            "请在 java-project 目录下运行此脚本。",
            file=sys.stderr,
        )
        sys.exit(1)

    writer = csv.writer(sys.stdout)
    writer.writerow([
        "案例", "测试组", "测试文件",
        "测试方法数", "参与重复的方法数", "冗余率%"
    ])

    found = 0

    for group_name, suffix in GROUPS:
        for root, _, names in os.walk(TEST_ROOT):
            for name in sorted(names):
                if not name.endswith(suffix + ".java"):
                    continue

                path = os.path.join(root, name)
                case_name = name[:-len(suffix + ".java")]

                methods = split_methods(path)
                rate, involved = redundancy(methods)

                writer.writerow([
                    case_name,
                    group_name,
                    name,
                    len(methods),
                    involved,
                    f"{rate:.1f}",
                ])
                found += 1

    print(
        f"\n统计完成：找到 {found} 个测试文件。",
        file=sys.stderr,
    )


if __name__ == "__main__":
    main()