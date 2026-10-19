# java-project

这个目录用来放工程本体。**由组员 2 负责搭建，其他人不要动这个文件。**

## 怎么把项目放进来

```bash
cd java-project
git clone https://github.com/TheAlgorithms/Java.git .
rm -rf .git                      # 去掉它自己的 git 历史，让它成为本仓库的普通目录
git log -1 --format=%H           # 已经没意义了，版本号要在 rm 之前记
```

正确顺序是**先记版本号再删 .git**：

```bash
cd java-project
git clone https://github.com/TheAlgorithms/Java.git .
git log -1 --format=%H           # ← 把这 40 位记下来，写进根目录 README
rm -rf .git
```

## 搭好之后要做的事

1. 改 `pom.xml`：删掉 `<arg>-Werror</arg>`（不删的话，大模型生成的测试会因警告而编译失败，可编译性数据全错）
2. 确认 `jacoco-maven-plugin` 已经在 pom 里（0.8.15），**不要再加第二个**
3. 跑 `mvn test`，确认能生成 `target/site/jacoco/index.html`
4. 把 JDK / Maven / JaCoCo 版本和那个 commit 号写进仓库根目录的 README

## 四组测试放哪

都放在 `src/test/java` 下，**与被测类同一个包**，靠类名后缀区分：

```
src/test/java/com/thealgorithms/maths/
├── GCDTest.java            ← 仓库原有，保留不动
├── GCDDatasetTest.java     ← 组员 4
├── GCDManualTest.java      ← 组员 5 / 6
├── GCDLlmATest.java        ← 组员 7
└── GCDLlmBTest.java        ← 组员 7
```

跑单组：

```bash
mvn test -Dtest='*ManualTest'
mvn test -Dtest='*DatasetTest'
mvn test -Dtest='*LlmATest'
mvn test -Dtest='*LlmBTest'
```

**不要提交 `target/` 目录**，`.gitignore` 已经排除了。
