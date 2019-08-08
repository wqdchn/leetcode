package src.easy;

import java.util.Stack;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/valid-parentheses/
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 * @author: wqdong
 * @create: 2019-08-08 14:47
 **/
public class Valid_parentheses {

    public static void main(String[] args){
        String s = "()[]{}";
        if (isValid(s)){
            System.out.println("括号有效");
        } else {
            System.out.println("括号无效");
        }
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (ch == '('){
                stack.push(')');
            } else if (ch == '['){
                stack.push(']');
            } else if (ch == '{'){
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.pop() != ch){//注意，这里要先判断栈是否为空，然后再判断顶部元素是否匹配，如果先判断匹配，那可能会人为造成栈空
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
