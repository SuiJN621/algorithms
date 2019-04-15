package com.fundamental.data.queue;

/**
 * @author Sui
 * @date 2018/5/25 22:26
 */
@SuppressWarnings("unchecked")
public class ArrayQueue<E> {

    private final int DEFAULT_CAPACITY = 10;

    private E[] data;
    private int size = 0;

    public ArrayQueue() {
        this.data = (E[]) new Object[DEFAULT_CAPACITY];  //Java不允许直接创建泛型数组 new E[] 是不合法的
    }

    public ArrayQueue(int capacity) {
        this.data = (E[]) new Object[capacity];
    }

    public void enqueue(E element){
        if(data.length == size)
            resize(data.length * 2);

        data[size++] = element;
    }

    public E dequeue(){
        if(isEmpty())
            throw new IndexOutOfBoundsException("no element in queue");
        if(size <= data.length / 4)
            resize(data.length / 2);

        E element = data[0];
        System.arraycopy(data, 1, data, 0, --size);
        data[size] = null;
        return element;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    private void resize(int capacity){
        E[] newData = (E[]) new Object[capacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }
}
