package oldpractice;

import java.util.Stack;

class BasicCalculator2 {

    public int calculate(String s) {

        if(s.isEmpty() || s == null) {
            return 0;
        }
        Stack<Integer> stack = new Stack();
        int curr = 0;
        int sum = 0;
        char op = '+';

        for(int i=0; i < s.length(); i++) {

            if(Character.isDigit(s.charAt(i))) {
                curr = curr * 10 + s.charAt(i) - '0';
            }

            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || (i == s.length() - 1)) {
                if(op == '+') {
                    stack.push(curr);
                }

                if(op == '-') {
                    stack.push(-curr);
                }

                if(op == '/') {
                    int lastVal = stack.pop();
                    stack.push(lastVal / curr);
                }

                if(op == '*') {
                    int lastVal = stack.pop();
                    stack.push(curr * lastVal);
                }
                op = s.charAt(i);
                curr = 0;
            }
        }

        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        BasicCalculator2 bc = new BasicCalculator2();
        String s = "2*3+4";
        int result = bc.calculate(s);
        System.out.println("result = " + result);
    }
}