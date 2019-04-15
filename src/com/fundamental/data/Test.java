package com.fundamental.data;

import com.fundamental.data.stack.ArrayStack;

/**
 * @author Sui
 * @date 2018/5/21 16:44
 */
public class Test {

    public static void main(String[] args) {
        ArrayStack<String> testCopy = new ArrayStack<>();
        testCopy.push("1");
        testCopy.push("2");
        testCopy.push("3");

        ArrayStack<String> copy = ArrayStack.copy(testCopy);
        while (!copy.isEmpty()) {
            System.out.println(copy.peek());
        }
    }
}
