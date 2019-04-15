package com.fundamental.data.stack;

import java.util.Iterator;

/**
 * @author Sui
 * @date 2018/5/21 16:43
 */
@SuppressWarnings("unchecked")
public class ArrayStack<E> implements Iterable<E> {

    private static int DEFAULT_CAPACITY = 10;

    private E[] data;

    private int size = 0;

    public ArrayStack() {
        this.data = (E[]) new Object[DEFAULT_CAPACITY];  //Java不允许直接创建泛型数组 new E[] 是不合法的
    }

    public ArrayStack(int capacity) {
        this.data = (E[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(E element) {
        if (size == data.length)
            resize(data.length * 2);

        data[size++] = element;
    }

    public E pop() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Array stack is empty");

        E element = data[--size];
        data[size] = null;   //将弹出的元素删除
        if (size > 0 && size == data.length / 4)
            resize(data.length / 2);
        return element;
    }

    public E peek() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Array stack is empty");

        E element = data[--size];
        if (size > 0 && size == data.length / 4)
            resize(data.length / 2);
        return element;
    }

    public void clear() {
        data = (E[]) new Object[size];
    }

    public static <E> ArrayStack<E> copy(ArrayStack<E> source) {

        ArrayStack<E> reverseCopy = new ArrayStack<>();
        ArrayStack<E> copy = new ArrayStack<>();
        while (source.iterator().hasNext()) {
            reverseCopy.push(source.iterator().next());
        }
        while (reverseCopy.iterator().hasNext()) {
            copy.push(reverseCopy.iterator().next());
        }
        return copy;
    }

    private void resize(int max) {
        E[] newData = (E[]) new Object[max];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return size > 0;
            }

            @Override
            public E next() {
                return data[--size];
            }
        };
    }
}
