package my_datastructures;

import java.util.NoSuchElementException;

class MyLinkedList {
    // ====== Node class
    private class Node {
        Node prev;
        Integer value;
        Node next;
    }

    // private members
    private Node head;
    private Node tail;
    private int len;

    // functionalities
    public Integer getFirst() {
        if (len == 0)
            throw new NoSuchElementException();
        return head.value;
    }

    public Integer getLast() {
        if (len == 0)
            throw new NoSuchElementException();
        return tail.value;
    }

    public Integer removeFirst() {
        if (len == 0)
            throw new NoSuchElementException();
        len--;
        var res = head.value;
        head = head.next;
        head.prev = null;
        return res;
    }

    public Integer removeLast() {
        if (len == 0)
            throw new NoSuchElementException();
        len--;
        var res = tail.value;
        tail = tail.prev;
        tail.next = null;
        return res;
    }

    public void addFirst(Integer element) {
        if (len == 0) {
            head = tail = new Node();
            head.value = element;
        } else {
            var node = new Node();
            node.value = element;
            node.next = head;
            head.prev = node;
            head = node;
        }
        len++;
    }

    public void addLast(Integer element) {
        if (len == 0) {
            head = tail = new Node();
            head.value = element;
        } else {
            var node = new Node();
            node.value = element;
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        len++;
    }

    public boolean contains(Object obj) {
        for (var node = head; node != null; node = node.next) {
            if (node.value.equals(obj))
                return true;
        }
        return false;
    }

    public int size() {
        return len;
    }

    public boolean add(Integer element) {
        addLast(element);
        return true;
    }

    public boolean remove(Object o) {
        Node prev = null;
        for (var node = head; node != null; node = node.next) {
            if (node.value.equals(o)) {
                if (prev != null)
                    prev.next = node.next;
                if (node.next != null)
                    node.next.prev = prev;
                return true;
            }
            prev = node;
        }
        return false;
    }

    public boolean addAll(MyLinkedList list) {
        if (list == null)
            throw new NullPointerException();
        for (var node = list.head; node != null; node = node.next)
            add(node.value);
        return list.len != 0;
    }
}

public class MyLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
