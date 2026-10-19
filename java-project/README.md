# java-project

工程本体放这里。**由组员 2 搭建，其他人不要动这个文件。**

## 怎么把项目放进来

**先记版本号，再删 `.git`**，顺序错了就拿不到 commit 号了：

```bash
cd java-project
git clone https://github.com/TheAlgorithms/Java.git .
git log -1 --format=%H      # ← 记下这 40 位
rm -rf .git                  # 去掉它自己的历史，让它成为本仓库的普通目录
```

之后的配置（删 `-Werror`、确认 JaCoCo 已在 pom、跑 `mvn test`）见 `docs/00-组员分工说明.docx` 第一章。

## 四组测试放哪

都放 `src/test/java`，**与被测类同一个包**，靠类名后缀区分：

```
src/test/java/com/thealgorithms/maths/
├── GCDTest.java             ← 仓库原有，保留不动
├── GCDDatasetTest.java      ← 组员 4
├── GCDManualTest.java       ← 组员 5 / 6
├── GCDLlmATest.java         ← 组员 7
└── GCDLlmBTest.java         ← 组员 7
```

`target/` 不用提交，`.gitignore` 已经排除了。
