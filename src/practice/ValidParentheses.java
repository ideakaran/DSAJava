package practice;

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {

        if(s.length() % 2 == 1)
            return false;

        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '(')
            {
                stack.push(')');
            }
            else if(s.charAt(i) == '{')
            {
                stack.push('}');
            }
            else if(s.charAt(i) == '[')
            {
                stack.push(']');
            }
            else if(stack.isEmpty() || stack.pop() != s.charAt(i))
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()(([]))"));
    }
}
