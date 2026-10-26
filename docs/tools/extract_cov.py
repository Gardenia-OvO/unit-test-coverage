#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
从 JaCoCo 的 jacoco.csv 提取 26 个案例的覆盖率。

用法：
    python docs/tools/extract_cov.py ../docs/raw/cov-dataset.csv
    python docs/tools/extract_cov.py ../docs/raw/cov-manual.csv  --group 人工

输出（stdout）：CSV，可直接粘进 Excel
    序号,案例,CSV类名,行覆盖%,分支覆盖%

说明：
  · 26 个案例里有 2 个“清单类名 ≠ 实际被测类名”，已在 CASES 里显式处理：
      #17 MedianOfRunningArray —— 清单是抽象父类，测试实例化其子类。
           父类的 insert/getMedian 是 final，四组都执行同一份代码，
           因此统计父类 MedianOfRunningArray 本身。
      #26 StackOfLinkedList   —— 同文件中有 StackOfLinkedList / Node / LinkedListStack，
           真正可实例化的是 LinkedListStack。
  · 找不到的类会输出 “—”，并在 stderr 提示，方便发现该组缺失的案例。
"""

import csv
import sys

# (序号, 清单类名, [CSV 中可能的类名，按优先级])
CASES = [
    (1,  "GCD",                          ["GCD"]),
    (2,  "FibonacciLoop",                ["FibonacciLoop"]),
    (3,  "PrimeCheck",                   ["PrimeCheck"]),
    (4,  "SieveOfEratosthenes",          ["SieveOfEratosthenes"]),
    (5,  "BinarySearch",                 ["BinarySearch"]),
    (6,  "LinearSearch",                 ["LinearSearch"]),
    (7,  "InterpolationSearch",          ["InterpolationSearch"]),
    (8,  "KMPSearch",                    ["KMPSearch"]),
    (9,  "ReverseString",                ["ReverseString"]),
    (10, "Palindrome",                   ["Palindrome"]),
    (11, "CountWords",                   ["CountWords"]),
    (12, "LongestCommonPrefix",          ["LongestCommonPrefix"]),
    (13, "InsertionSort",                ["InsertionSort"]),
    (14, "BubbleSort",                   ["BubbleSort"]),
    (15, "DeterminantOfMatrix",          ["DeterminantOfMatrix"]),
    (16, "ExtendedEuclideanAlgorithm",   ["ExtendedEuclideanAlgorithm"]),
    (17, "MedianOfRunningArray",         ["MedianOfRunningArray"]),
    (18, "QuadraticEquationSolver",      ["QuadraticEquationSolver"]),
    (19, "SumOfDigits",                  ["SumOfDigits"]),
    (20, "JumpSearch",                   ["JumpSearch"]),
    (21, "SortedLinkedList",             ["SortedLinkedList"]),
    (22, "LZ78",                         ["LZ78"]),
    (23, "DamerauLevenshteinDistance",   ["DamerauLevenshteinDistance"]),
    (24, "BitRotate",                    ["BitRotate"]),
    (25, "PermutationCipher",            ["PermutationCipher"]),
    (26, "StackOfLinkedList",            ["LinkedListStack", "StackOfLinkedList"]),
]


def pct(covered, missed):
    total = covered + missed
    return 100.0 * covered / total if total else None


def main():
    if len(sys.argv) < 2:
        sys.exit("用法: python extract_cov.py <jacoco.csv> [--group 名称]")

    path = sys.argv[1]
    group = ""
    if "--group" in sys.argv:
        group = sys.argv[sys.argv.index("--group") + 1]

    # 读入 CSV：CLASS -> (line%, branch%)
    table = {}
    with open(path, encoding="utf-8-sig") as f:
        for r in csv.DictReader(f):
            cls = r.get("CLASS", "").strip()
            if not cls:
                continue
            try:
                lp = pct(int(r["LINE_COVERED"]), int(r["LINE_MISSED"]))
                bp = pct(int(r["BRANCH_COVERED"]), int(r["BRANCH_MISSED"]))
            except (KeyError, ValueError):
                continue
            # 同名类若出现多次（不同包），保留覆盖率较高者
            prev = table.get(cls)
            if prev is None or (lp or 0) > (prev[0] or 0):
                table[cls] = (lp, bp)

    rows = []
    missing = []
    for no, name, candidates in CASES:
        hit = next((c for c in candidates if c in table), None)
        if hit is None:
            missing.append((no, name))
            rows.append((no, name, "—", "—", "—"))
        else:
            lp, bp = table[hit]
            rows.append((no, name, hit,
                         "—" if lp is None else "%.1f" % lp,
                         "—" if bp is None else "%.1f" % bp))

    # 输出
    print("序号,案例,CSV类名,行覆盖%,分支覆盖%")
    for r in rows:
        print(",".join(str(x) for x in r))

    # 汇总
    lps = [float(r[3]) for r in rows if r[3] != "—"]
    bps = [float(r[4]) for r in rows if r[4] != "—"]
    tag = (" [%s]" % group) if group else ""
    print("#%s 有效案例 %d / 26    行覆盖均值 %.1f%%    分支覆盖均值 %.1f%%"
          % (tag, len(lps),
             sum(lps) / len(lps) if lps else 0,
             sum(bps) / len(bps) if bps else 0), file=sys.stderr)
    if missing:
        print("# 未找到：" + "、".join("%d %s" % m for m in missing), file=sys.stderr)


if __name__ == "__main__":
    main()
