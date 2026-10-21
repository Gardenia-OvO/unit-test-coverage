# The Algorithms - Java

[![Build](https://github.com/TheAlgorithms/Java/actions/workflows/build.yml/badge.svg?branch=master)](https://github.com/TheAlgorithms/Java/actions/workflows/build.yml)
[![codecov](https://codecov.io/gh/TheAlgorithms/Java/graph/badge.svg?token=XAdPyqTIqR)](https://codecov.io/gh/TheAlgorithms/Java)
[![Discord chat](https://img.shields.io/discord/808045925556682782.svg?logo=discord&colorB=7289DA&style=flat-square)](https://discord.gg/c7MnfGFGa6)
[![Gitpod ready-to-code](https://img.shields.io/badge/Gitpod-ready--to--code-blue?logo=gitpod)](https://gitpod.io/#https://github.com/TheAlgorithms/Java)


You can run and edit the algorithms, or contribute to them using Gitpod.io (a free online development environment) with a single click.

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/TheAlgorithms/Java)

### All algorithms are implemented in Java (for educational purposes)
These implementations are intended for learning purposes. As such, they may be less efficient than the Java standard library.

## Contribution Guidelines
Please read our [Contribution Guidelines](CONTRIBUTING.md) before you contribute to this project.

## Algorithms
Our [directory](DIRECTORY.md) has the full list of applications.

### 一、实验环境

- JDK 版本：21.0.12.1
- Maven 版本：3.9.16
- JaCoCo 版本：0.8.15
- 项目 Commit：d9b86d1992b8bd4cadbd832822c792628117e69d

### 二、pom.xml 修改说明

1. 已删除 Maven Compiler Plugin 中的 `<arg>-Werror</arg>`，保留 `<arg>-Xlint:all</arg>`。原因是避免将编译警告直接视为编译失败，影响测试代码可编译性的统计。
2. JUnit 版本：老师要求使用 JUnit 5，将版本改成 5.13.4后可行。
3. JaCoCo 使用项目原有的 0.8.15 配置，保留已有的 `prepare-agent` 和 `report` 配置，不重复添加插件。

### 三、四组测试运行命令

#### 1. 人工测试组 A

```bash
mvn test -Dtest='*ManualTest'
```

#### 2. 数据集自带测试组 B

```bash
mvn test -Dtest='*DatasetTest'
```

#### 3. 模型 A 测试组 C

```bash
mvn test -Dtest='*LlmATest'
```

#### 4. 模型 B 测试组 D

```bash
mvn test -Dtest='*LlmBTest'
```

### 四、覆盖率报告

运行测试后，JaCoCo 覆盖率报告路径为：

`target/site/jacoco/index.html`

使用浏览器打开该文件，可以查看代码行覆盖率和分支覆盖率。
![img.png](img.png)

### 五、说明

首次使用时，请先安装并正确配置 JDK 和 Maven。

进入项目根目录后，先执行以下命令验证环境：

```bash
mvn test
```
第一次运行需要下载依赖，可能需要几分钟。
运行结束后，重点看最后的输出：
- BUILD SUCCESS：Maven 构建成功。
- BUILD FAILURE：构建失败，需要看报错。
- 测试报告中出现 Failures: 0、Errors: 0：说明这次执行的测试没有失败或报错。

需要单独运行某一组测试时，使用上面的分组命令。测试结果和覆盖率数据以实际运行结果为准。
