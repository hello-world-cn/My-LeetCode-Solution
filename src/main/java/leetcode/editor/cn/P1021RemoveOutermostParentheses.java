//有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"
//，"(())()" 和 "(()(()))" 都是有效的括号字符串。 
//
// 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。 
//
// 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。 
//
// 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。 
//
// 
//
// 示例 1： 
//
// 输入："(()())(())"
//输出："()()()"
//解释：
//输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
//删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。 
//
// 示例 2： 
//
// 输入："(()())(())(()(()))"
//输出："()()()()(())"
//解释：
//输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
//删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
// 
//
// 示例 3： 
//
// 输入："()()"
//输出：""
//解释：
//输入字符串为 "()()"，原语化分解得到 "()" + "()"，
//删除每个部分中的最外层括号后得到 "" + "" = ""。
// 
//
// 
//
// 提示： 
//
// 
// S.length <= 10000 
// S[i] 为 "(" 或 ")" 
// S 是一个有效括号字符串 
// 
// Related Topics 栈 
// 👍 151 👎 0

package leetcode.editor.cn;

//Java：删除最外层的括号
public class P1021RemoveOutermostParentheses {
    public static void main(String[] args) {
        Solution solution = new P1021RemoveOutermostParentheses().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeOuterParentheses(String S) {
            StringBuilder result = new StringBuilder();
            // 直接用数组取代栈
            // 栈顶索引
            int count = 0;
            int len = S.length();

            // 遍历字符串
            char[] s = S.toCharArray();
            for (char ch : s) {
                if (ch == '(') {
                    // '(' 之前有数据, 当前必属原语
                    if (count > 0) {
                        // 直接拼接
                        result.append(ch);
                    }
                    count++;
                } else {
                    // 出栈
                    count--;
                    // ')' 出栈后有数据, 出栈元素必属原语
                    if (count > 0) {
                        result.append(ch);
                    }
                }
            }
            return  result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}