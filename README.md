# 课题 2：单元测试框架与覆盖率分析

8 人小组作业。核心内容：JUnit 5 + JaCoCo 环境搭建，以及对四组测试用例（人工 / 数据集自带 / 两个大模型）的对照实验。

**答辩时间：2026-10-30（周五）**

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

## 六、没有 GitHub 账号怎么办

先说清楚两件事，别混：

| 你想做的事 | 需不需要账号 |
|---|---|
| 把仓库**拉**下来、看文档、跑代码 | **不需要**，仓库是公开的 |
| 把自己写的东西**推**上去 | **需要**，而且要组长把你加成协作者 |

所以：

- **只写字、不推代码的同学**（比如组员 5、6、8）：**不用注册账号**。把你的 10 个测试类或表格打成 zip，命名 `组员X-任务名.zip`（例：`组员5-人工测试.zip`），发群里。组长解压后按目录搬进去，并在提交信息里注明「代提：组员X」。
- **想自己推的同学**：注册一个 GitHub 账号（免费，两分钟，不用信用卡），把用户名发群里，组长加协作者，你点一下邮件里的邀请就能推。

两条路都行，但都必须在群里说一声你交了，否则组长会漏掉。

> ⚠️ 仓库现在是**公开**的，任何人都能看到。表格里的「设计者」一栏填「组员 5」这种编号就行，**真名写在还没公开的纸质报告里**，不要写进这个仓库。

---

## 目录说明

```
├── docs/           各种表格、Prompt 原文、调研稿、总说明书
├── java-project/   TheAlgorithms/Java 工程（由组员 2 搭好）
├── slides/         答辩 PPT
└── report/         最终报告
```
