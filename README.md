# 课题 2：单元测试框架与覆盖率分析

8 人小组作业。核心内容：JUnit 5 + JaCoCo 环境搭建，以及对四组测试用例（人工 / 数据集自带 / 两个大模型）的对照实验。

**答辩时间：2026-10-30（周五）**

---

## 零、Windows 同学先看

**除了组长，其余同学都是 Windows。** 下面六件事配好，后面文档里的命令才能照抄。

### 1. 装 Git for Windows（自带 Git Bash）

下载 https://git-scm.com/download/win ，一路下一步即可。

装完在开始菜单里找 **Git Bash** —— **所有文档里的命令都在 Git Bash 里敲**，不要用 PowerShell。
原因：文档里的 `find`、`grep`、`for ... do ... done` 都是 bash 语法，PowerShell 里不认。

### 2. 一行命令修掉中文文件名乱码

```bash
git config --global core.quotepath false
```

不设的话，`git status` 里中文文件名会显示成 `\346\241\210\344\276\213...` 这种东西。本仓库文件名全是中文，不设会很难受。

### 3. 装 JDK

到 https://adoptium.net 下 Temurin **21** 或 **25**，安装时勾选设置 `JAVA_HOME`。

### 4. 装 Maven（重要，别用老版本）

*   到 https://maven.apache.org/download.cgi 下 `apache-maven-3.9.x-bin.zip`
*   解压到比如 `C:\tools\apache-maven-3.9.9`
*   把这个目录下的 `bin` 加进系统 PATH
*   重开 Git Bash，`mvn -v` 第一行要显示 **3.9.x**

也可以用 `winget install Apache.Maven`。

> **系统里如果有老的 Maven（3.5 / 3.6），不要用。** 这个工程的插件要求 3.6.3 以上，老版本会报各种各样的插件错误。

### 5. 换行符不用管

仓库里已经放了 `.gitattributes`，Windows 和 macOS 提交时不会互相把整个文件标成改动。**不用去设 `core.autocrlf`。**

### 6. 打开文件

Git Bash 里用 `start 文件名`，或者在资源管理器里双击。

---

## 一、每个人只碰自己的文件

| 谁 | 只改这里的 | 别碰 |
|---|---|---|
| 组长 | `report/`、`README.md`、合并 PPT | 别人的代码 |
| 组员 2 | `java-project/` 的 `pom.xml`、根目录 `README` 里的命令 | 其他人的测试文件 |
| 组员 3 | `docs/04-数据总表.xlsx` | 别人的表 |
| 组员 4 | `docs/01-案例清单.xlsx` + 20 个 `*DatasetTest.java` | 别人的测试文件 |
| 组员 5 | `docs/02a-人工耗时-组员5.xlsx` + 10 个 `*ManualTest.java` | 组员 6 的表和文件 |
| 组员 6 | `docs/02b-人工耗时-组员6.xlsx` + 10 个 `*ManualTest.java` | 组员 5 的表和文件 |
| 组员 7 | `docs/03-Prompt原文.md` + 40 个 `*LlmATest.java` / `*LlmBTest.java` | `pom.xml` |
| 组员 8 | `docs/05-工具调研.md`、`slides/` | 别人的 md |

`docs/00-组员分工说明.docx` 是总说明，每人先读自己那一章。**这份文档要改由组长统一改，改完提交。**

---

## 二、第一次：把仓库拉下来

仓库是**公开**的，**不需要 GitHub 账号、不用登录**就能拉：

```bash
git clone https://github.com/Gardenia-OvO/unit-test-coverage.git
cd unit-test-coverage
```

配过 SSH 的同学也可以用这条（这条需要账号）：

```bash
git clone git@github.com:Gardenia-OvO/unit-test-coverage.git
```

**拉不下来怎么办**：如果 clone 卡住不动，或者报 `SSL_ERROR_SYSCALL` / `Connection timed out`，是这个网络连 `github.com:443` 不稳，换上面那条 SSH 命令重试；装了 GitHub CLI 的话 `gh repo clone Gardenia-OvO/unit-test-coverage` 也行。多试两次通常就好。

> **公开只解决「能拉」，不解决「能推」。**
> 要往仓库里提交，仍然需要自己的 GitHub 账号，并且被组长加进协作者。
> 完全没有账号的同学，直接看第六节。

---

## 三、每次交东西之前：先拉

```bash
git pull
```

**这一步每天第一次干活前必须做。** 不做就会在提交时冲突，处理起来比拉一下麻烦十倍。

---

## 四、交东西：只提交自己的文件

以组员 5 为例（其他人照着自己的目录改）：

```bash
git pull
git add java-project/src/test/java/com/thealgorithms/maths/GCDManualTest.java
git add "docs/02a-人工耗时-组员5.xlsx"
git commit -m "组员5：提交 10 个人工测试与耗时表"
git push
```

如果 `git push` 报 `rejected`，说明别人刚推过东西，执行：

```bash
git pull
git push
```

---

## 五、四条禁令

1. **不要 `git add .`** —— 会把别人的半成品、你自己的 `target/` 统统带上。
2. **不要 `git push -f`** —— 会覆盖掉别人的提交，直接弄丢工作。
3. **不要改别人的文件**。要改先在群里说一声。
4. **不要提交 `target/` 目录**（`.gitignore` 已经挡掉了，但别手动加）。

---

## 六、注册账号并加入仓库

所有人统一用 git 提交。**首次使用，照 [`docs/06-新成员加入指南.md`](docs/06-新成员加入指南.md) 做完三件事**：注册账号 → 接受邀请 → 配一次 Token（第一次 push 弹密码框，粘的是 Token，不是账号密码）。

网络打不开 github.com、实在注册不了的：把东西打成 `组员X-任务名.zip` 发群里，组长代提，提交信息注明「代提：组员X」。

> ⚠️ 仓库是公开的。提交记录和表格里的名字写「组员 5」这种编号，**真名写在纸质报告里**，不要写进仓库。

---

## 目录说明

```
├── docs/
│   ├── 00-组员分工说明.docx   ★ 每人先读自己那一章
│   ├── 01-案例清单.xlsx       组员 4
│   ├── 02a/02b-人工耗时.xlsx  组员 5 / 6 各一份
│   ├── 03-Prompt原文.md       组员 7
│   ├── 04-数据总表.xlsx       组员 3
│   ├── 05-工具调研.md         组员 8
│   └── 06-新成员加入指南.md   账号、Token、报错对照表
├── java-project/   TheAlgorithms/Java 工程（组员 2 搭建）
├── slides/         答辩 PPT
└── report/         最终报告（组长）
```
