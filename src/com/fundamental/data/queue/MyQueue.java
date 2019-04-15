package com.fundamental.data.queue;

/**
 * @author Sui
 * @date 2018/9/7 16:02
 */
public class MyQueue {

    private int[] data;

    private int size;

    private int head;

    private int tail;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyQueue(int k) {
        data = new int[k];
        size = k;
        head = 0;
        tail = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else if (isEmpty()) {
            data[0] = value;
            head = tail = 1;
        } else {
            tail = tail == size ? 1 : ++tail;
            data[tail - 1] = value;
        }
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else if (head == tail) {
            data[head - 1] = 0;
            head = tail = 0;
        } else {
            data[head - 1] = 0;
            head = head == size ? 1 : ++head;
        }
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (!isEmpty()) {
            return data[head - 1];
        } else {
            return 0;
        }
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (!isEmpty()) {
            return data[tail - 1];
        } else {
            return 0;
        }
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return head == 0 && tail == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return head > tail ? head - tail == 1 : head == 1 && tail == size;
    }


    public static void main(String[] args) {
        MyQueue circularQueue = new MyQueue(3); // set the size to be 3
        System.out.println(circularQueue.enQueue(1));  // return true
        System.out.println(circularQueue.enQueue(2));  // return true
        System.out.println(circularQueue.enQueue(3));  // return true
        System.out.println(circularQueue.enQueue(4));  // return false, the queue is full
        System.out.println(circularQueue.Rear());  // return 3
        System.out.println(circularQueue.isFull());  // return true
        System.out.println(circularQueue.deQueue());  // return true
        System.out.println(circularQueue.enQueue(4));  // return true
        System.out.println(circularQueue.Rear());
    }

}
