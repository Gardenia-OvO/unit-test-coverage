# 大模型生成记录（组员 7 维护）

> 作业原文要求：「LLM 需给出具体版本、关键参数与完整 Prompt 原文」。下面三块缺一样就扣分。

## 一、模型与参数

| 模型 | 精确版本号 | temperature | top_p | max_tokens | 联网 | 对话轮次 | 生成日期 |
|---|---|---|---|---|---|---|---|
| 模型 A |  |  |  |  | 关闭 | 1 轮 |  |
| 模型 B |  |  |  |  | 关闭 | 1 轮 |  |

> 版本号每次生成都当场记。模型版本会悄悄更新，今天记的和三天后可能不一样。

## 二、完整 Prompt 原文

> 20 个类都用这一份，只换【包名】和【被测类源码】两处，其余一个字不改。

```
你是一名资深 Java 测试工程师。请为下面这个 Java 类编写 JUnit 5 单元测试。

【硬性约束】
1. 仅使用 JUnit 5（org.junit.jupiter.api），断言使用 org.junit.jupiter.api.Assertions。
   如需参数化测试，使用 @ParameterizedTest 配合 @ValueSource / @CsvSource。
2. 测试代码必须能通过 javac 编译。只能使用项目 pom.xml 中已有的依赖：
   JUnit Jupiter（org.junit.jupiter.api）、AssertJ（org.assertj.core.api）、
   Apache Commons Lang3（org.apache.commons.lang3）。
   不得引入 pom.xml 中不存在的任何新依赖。
3. 不得修改被测类；只能调用被测类中真实存在的公开方法，不得虚构方法或重载。
4. 每个测试方法只验证一个行为；方法名使用 should_期望结果_when_条件 的形式。
5. 若被测方法对非法输入抛出异常，使用 assertThrows 断言具体的异常类型。
6. 不要编写 main 方法，不要输出任何解释性文字。

【输出格式】
只输出一个 java 代码块，内容为一个完整可编译的测试类：
- 包名与下面给出的包名保持一致
- 类名为 <被测类名>Test
- 所有需要的 import 必须写全

【包名】
<在此填写包名，例如 com.thealgorithms.maths>

【被测类源码】
<在此粘贴被测类完整源码>
```

## 三、生成记录表

| 序号 | 案例 | 模型 | 生成时间 | 编译通过 | 错误类型 | 是否人工改动 |
|---|---|---|---|---|---|---|
| 1 |  | A |  |  |  |  |
| 2 |  | B |  |  |  |  |
| … |  |  |  |  |  |  |

**允许改的只有两处**：类名（改成 XxxLlmATest）、包名。方法体一个字都不能动。
**编译不过不许修**——编不过本身就是结论。
