package com.fundamental.data.queue;

import java.util.Iterator;

/**
 * @author Sui
 * @date 2018/5/21 17:55
 */
public class LinkedQueue<E> implements Iterable<E> {

    protected class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> previous;

        Node(E element) {
            this.element = element;
        }
    }

    private Node<E> head;

    private Node<E> tail;

    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
        //或 return head == null;
    }

    public void enqueue(E element) {
        Node<E> node = new Node<>(element);
        if (head == null) {
            head = tail = node;
        } else {
            Node<E> oldTail = tail;
            oldTail.next = node;
            node.previous = oldTail;
            tail = node;
        }
        size++;
    }

    public E dequeue() {
        if (size == 0)
            throw new IndexOutOfBoundsException("stack is empty");

        Node<E> node = head;
        if (size == 1) {
            head = tail = null;
        } else {
            head = node.next;
            head.previous = null;
        }
        size--;
        return node.element;
    }

    public boolean find(E key){
        Iterator<E> iterator = iterator();
        boolean result = false;
        while(iterator.hasNext()){
            result = iterator.next().equals(key);
        }
        return result;
    }

    public void remove(E target){
        Node<E> current = head;
        while(current != null){
            if(current.element.equals(target)){
                current.next = null;
            }
            current = current.next;
        }
    }

    public boolean delete(int index) {
        //链表为空
        if (size == 0) {
            return false;
        }
        //链表大小为1
        else if (size == 1 && index == 1) {
            head = tail = null;
        }
        //删除头或尾情况
        else if (size == index) {
            tail = tail.previous;
            tail.next = null;
            size--;
            return true;
        } else if (index == 1) {
            head = head.next;
            head.previous = null;
            size--;
            return true;
        } else if (index > size) {
            throw new IndexOutOfBoundsException("index is larger than size");
        }
        //从头开始便利找到目标
        Node target = head;
        for (int i = 1; i < index; i++) {
            target = target.next;
        }
        assert target != null : "unbelievable";
        target.previous.next = target.next;
        target.next.previous = target.previous;
        size--;
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E element = current.element;
                current = current.next;
                return element;
            }
        };
    }

    public static void main(String[] args) {
        LinkedQueue<String> strings = new LinkedQueue<>();
        strings.enqueue("1");
        strings.enqueue("2");
        strings.enqueue("3");
        strings.enqueue("4");
        System.out.println(strings.find("4"));
    }
}
