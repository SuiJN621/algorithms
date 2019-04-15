package com.fundamental.data.stack;

/**
 * @author Sui
 * @date 2018/5/25 17:31
 */
public class PostorderExpressionExecutor {

    public static void main(String[] args) {
        String transfer = new PostorderExpressionExecutor().transfer("((1 + 2) - ((2 * 3) / (4 - 9)))");
        System.out.println(transfer);
    }

    private ArrayStack<Character> operatorStack = new ArrayStack<>();

    public String transfer(String expression){

        char[] chars = expression.replaceAll(" ", "").toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c == '(') ;
            else if (c == '+' || c == '-' || c == '*' || c == '/') operatorStack.push(c);
            else if (c == ')') sb.append(operatorStack.pop());
            else sb.append(c);
        }
        return sb.toString();
    }
}
