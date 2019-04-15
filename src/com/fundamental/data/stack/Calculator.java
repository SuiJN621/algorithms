package com.fundamental.data.stack;

import java.util.Stack;

/**
 * @author Sui
 * @date 2018/5/20 0:29
 */
public class Calculator {
    //TODO:数字多位如何处理?
    public static void main(String[] args) {
        System.out.println(calculate("(1 + (((2 * 3) - (5 - 8)) / 2 ))"));
    }

    private static double calculate(String expression) {
        Stack<Character> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        String s = expression.replaceAll(" ", "");
        char[] chars = s.toCharArray();
        if (chars.length != 0) {
            for (int i = 0; i < chars.length; i++) {
                char aChar = chars[i];
                if (aChar == '+' || aChar == '-' || aChar == '*' || aChar == '/') {
                    ops.push(aChar);
                } else if (Character.isDigit(aChar)) {
                    vals.push(Double.parseDouble(Character.toString(aChar)));
                } else if (aChar == ')') {
                    Double val1 = vals.pop();
                    Double val2 = vals.pop();
                    Character pop = ops.pop();
                    if (pop == '+') vals.push(val1 + val2);
                    else if (pop == '-') vals.push(val2 - val1);
                    else if (pop == '*') vals.push(val1 * val2);
                    else if (pop == '/') vals.push(val2 / val1);
                }
            }
        }
        return vals.pop();
    }
}
