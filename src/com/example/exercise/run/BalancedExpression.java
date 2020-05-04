package com.example.exercise.run;

import com.example.exercise.datastructures.stack.Stack;

public class BalancedExpression {

    public static void main(String[] args) {
        boolean isBalanced = checkBalance("[()]{}{[()()]()}");
        System.out.println(isBalanced ? "Balanced" : "Not Balanced");
    }

    public static boolean checkBalance(String expression) {
        boolean isBalanced = true;
        if (expression == null || expression.length() == 0) {
            return isBalanced;
        }
        Stack stack = new Stack(expression.length());
        char[] chars = expression.toCharArray();
        // keep pushing to the stack till closing bracket is found.
        // [{()}] [()]{}{[()()]()}
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ']' || chars[i] == '}' || chars[i] == ')' ) {
                char pop = (char) stack.pop();
                if ((chars[i] == ']' && pop != '[') || (chars[i] == '}' && pop != '{') || (chars[i] == ')' && pop != '(')) {
                    isBalanced = false;
                    break;
                }
            } else {
                stack.push(chars[i]);
            }
        }

        if (!stack.isEmpty()) {
            isBalanced = false;
        }
        return isBalanced;
    }
}
