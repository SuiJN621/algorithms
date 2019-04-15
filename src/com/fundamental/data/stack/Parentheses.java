package com.fundamental.data.stack;

/**
 * @author Sui
 * @date 2018/5/21 19:47
 */
public class Parentheses {

    public static void main(String[] args) {
        boolean result = new Parentheses().checkParentheses("()()()()(}{{}{{][][]{}[]{}[]{}");
        System.out.println(result);
    }

    private ArrayStack<Character> stack = new ArrayStack<>();

    public boolean checkParentheses(String expression){
        String target = expression.replaceAll(" ", "");

        for(Character character : target.toCharArray()){
            if(character == '(' || character == '[' || character == '{'){
                stack.push(character);
            }else if(character == ')'){
                if(stack.pop() != '('){
                    return false;
                }
            }else if(character == ']'){
                if(stack.pop() != '['){
                    return false;
                }
            }else if(character == '}'){
                if(stack.pop() != '{'){
                    return false;
                }
            } else{
                throw new UnsupportedOperationException("unknown character in expression");
            }
        }
        return stack.isEmpty();
    }
}
