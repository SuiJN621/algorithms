package com.fundamental.data.stack;

/**
 * @author Sui
 * @date 2018/5/21 20:09
 */
public class BinaryTransfer {

    public static void main(String[] args) {
        String binary = new BinaryTransfer().toBinary(100);
        System.out.println(binary);
    }

    private ArrayStack<Integer> stack = new ArrayStack<>();

    public String toBinary(int i){
        while(i > 0){
            stack.push(i % 2);
            i /= 2;
        }
        StringBuilder binaryString = new StringBuilder();
        while(!stack.isEmpty()){
            binaryString.append(stack.pop());
        }
        return binaryString.toString();
    }
}
