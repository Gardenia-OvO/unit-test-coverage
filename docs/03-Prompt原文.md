# 大模型生成记录（组员 7 维护）

> 作业原文要求：「LLM 需给出具体版本、关键参数与完整 Prompt 原文」。下面三块缺一样就扣分。

## 一、模型与参数

| 模型 | 精确版本号 | temperature | top_p | max_tokens | 联网 | 对话轮次 | 生成日期 |
|---|---|---|---|---|---|---|---|
| 模型 A | kimi-k3-1-pro-261024 | 1 | 0.95 | 8192 | 关闭 | 1 轮 | 2026/10/26 |
| 模型 B | deepseek-v4-1-flash-economy-261017 | 1 | 0.95 | 8192 | 关闭 | 1 轮 | 2026/10/26 |

> 版本号每次生成都当场记。模型版本会悄悄更新，今天记的和三天后可能不一样。

## 二、完整 Prompt 原文

> 26个类都用这一份，只换【包名】和【被测类源码】两处，其余一个字不改。Prompt 模板由本小组设计，26 个案例使用完全相同的模板，仅替换包名和源码，未针对任何单个案例调整。

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

| 序号 | 案例                       | 模型 | 生成时间 | 编译通过 | 错误类型 | 是否人工改动 |
| ---- | -------------------------- | ---- | -------- | -------- | -------- | ------------ |
| 1    | GCD                        | A    | 13:42    | 是       | OK       | 否           |
| 2    | GCD                        | B    | 12:36    | 是       | OK       | 否           |
| 3    | FibonacciLoop              | A    | 13:45    | 是       | OK       | 否           |
| 4    | FibonacciLoop              | B    | 12:38    | 是       | OK       | 否           |
| 5    | PrimeCheck                 | A    | 13:47    | 是       | OK       | 仅import     |
| 6    | PrimeCheck                 | B    | 12:38    | 是       | OK       | 仅import     |
| 7    | SieveOfEratosthenes        | A    | 13:49    | 是       | OK       | 否           |
| 8    | SieveOfEratosthenes        | B    | 12:40    | 是       | OK       | 否           |
| 9    | BinarySearch               | A    | 13:51    | 是       | OK       | 否           |
| 10   | BinarySearch               | B    | 12:41    | 是       | OK       | 否           |
| 11   | LinearSearch               | A    | 13:53    | 是       | OK       | 否           |
| 12   | LinearSearch               | B    | 12:43    | 是       | OK       | 否           |
| 13   | InterpolationSearch        | A    | 13:55    | 是       | OK       | 否           |
| 14   | InterpolationSearch        | B    | 12:46    | 是       | OK       | 否           |
| 15   | KMPSearch                  | A    | 16:32    | 是       | OK       | 否           |
| 16   | KMPSearch                  | B    | 12:47    | 是       | OK       | 否           |
| 17   | ReverseString              | A    | 14:01    | 是       | OK       | 否           |
| 18   | ReverseString              | B    | 12:48    | 是       | OK       | 否           |
| 19   | Palindrome                 | A    | 14:02    | 是       | OK       | 否           |
| 20   | Palindrome                 | B    | 13:49    | 是       | OK       | 否           |
| 21   | CountWords                 | A    | 14:05    | 是       | OK       | 否           |
| 22   | CountWords                 | B    | 12:51    | 是       | OK       | 否           |
| 23   | LongestCommonPrefix        | A    | 14:07    | 是       | OK       | 否           |
| 24   | LongestCommonPrefix        | B    | 12:52    | 是       | OK       | 否           |
| 25   | InsertionSort              | A    | 16:37    | 是       | OK       | 否           |
| 26   | InsertionSort              | B    | 12:53    | 是       | OK       | 否           |
| 27   | BubbleSort                 | A    | 14:12    | 是       | OK       | 否           |
| 28   | BubbleSort                 | B    | 12:54    | 是       | OK       | 否           |
| 29   | DeterminantOfMatrix        | A    | 14:13    | 是       | OK       | 否           |
| 30   | DeterminantOfMatrix        | B    | 12:55    | 是       | OK       | 否           |
| 31   | ExtendedEuclideanAlgorithm | A    | 14:15    | 是       | OK       | 否           |
| 32   | ExtendedEuclideanAlgorithm | B    | 12:56    | 是       | OK       | 否           |
| 33   | MedianOfRunningArray       | A    | 16:41    | 是       | OK       | 否           |
| 34   | MedianOfRunningArray       | B    | 12:57    | 是       | OK       | 否           |
| 35   | QuadraticEquationSolver    | A    | 14:21    | 是       | OK       | 否           |
| 36   | QuadraticEquationSolver    | B    | 13:25    | 是       | OK       | 否           |
| 37   | SumOfDigits                | A    | 14:24    | 是       | OK       | 否           |
| 38   | SumOfDigits                | B    | 13:26    | 是       | OK       | 否           |
| 39   | JumpSearch                 | A    | 14:27    | 是       | OK       | 否           |
| 40   | JumpSearch                 | B    | 13:29    | 是       | OK       | 否           |
| 41   | SortedLinkedList           | A    | 14:29    | 是       | OK       | 否           |
| 42   | SortedLinkedList           | B    | 13:31    | 是       | OK       | 否           |
| 43   | LZ78                       | A    | 16:58    | 是       | OK       | 否           |
| 44   | LZ78                       | B    | 13:33    | 是       | OK       | 否           |
| 45   | DamerauLevenshteinDistance | A    | 14:35    | 是       | OK       | 否           |
| 46   | DamerauLevenshteinDistance | B    | 13:34    | 是       | OK       | 否           |
| 47   | BitRotate                  | A    | 14:38    | 无产出   | TIMEOUT  | 否           |
| 48   | BitRotate                  | B    | 13:37    | 是       | OK       | 否           |
| 49   | PermutationCipher          | A    | 14:42    | 无产出   | TIMEOUT  | 否           |
| 50   | PermutationCipher          | B    | 13:38    | 是       | OK       | 否           |
| 51   | StackOfLinkedList          | A    | 14:45    | 是       | OK       | 否           |
| 52   | StackOfLinkedList          | B    | 13:39    | 是       | OK       | 否           |

### 记录说明

- 全部请求均为**单轮**：每次调用独立发起，不携带历史上下文；失败重试为重新发送同一请求，不属于多轮对话。
- **无产出**：该案例在 3 次尝试内均因服务端超时未返回内容，未生成测试文件。此情况不计入"编译失败"，编译通过列填「无产出」。
- **仅 import**：因上游包名大小写不一致（被测类位于 `maths.Prime`，测试位于 `maths.prime`），在模型输出基础上仅补充了 `import` 语句，方法体未做任何修改。

**允许改的只有两处**：类名（改成 XxxLlmATest）、包名。方法体一个字都不能动。
**编译不过不许修**——编不过本身就是结论。