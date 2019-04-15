package com.fundamental.data.queue;

/**
 * @author Sui
 * @date 2018/5/28 20:15
 */
public class Josephus {

    public static void main(String[] args) {

    }

    private static ArrayQueue<Integer> getArrayQueue(int size){
        ArrayQueue<Integer> queue = new ArrayQueue<>(size);
        for(int i = 0; i < size; i++){
            queue.enqueue(i);
        }
        return queue;
    }
}
