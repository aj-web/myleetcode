package datastructure.List;

import java.util.NoSuchElementException;

/**
 * 使用双链表实现LinkedList
 *
 * @author : chezj
 * @date : 2022/10/12 17:00
 */
public class MyLinkedListDouble<E> {
    
    
    final private Node<E> head, tail;
    
    private int size;
    
    private class Node<E> {
        
        E val;
        
        Node<E> prev;
        
        Node<E> next;
        
        Node(E e) {
            this.val = e;
        }
    }
    
    public MyLinkedListDouble() {
        head = null;
        tail = null;
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }
    
    
    /***** 增 *****/
    public void addLast(E e) {
        Node<E> x = new Node<>(e);
        Node<E> temp = tail.prev;
        // temp <-> tail
        temp.next = x;
        x.prev = temp;
        
        x.next = tail;
        tail.prev = x;
        // temp <-> x <-> tail
        size++;
    }
    
    public void addFirst(E e) {
        Node<E> x = new Node<>(e);
        Node<E> temp = head.next;
        // head <-> temp
        temp.prev = x;
        x.next = temp;
        
        head.next = x;
        x.prev = head;
        // head <-> x <-> temp
        size++;
    }
    
    public void add(int index, E element) {
        checkPositionIndex(index);
        if (index == size) {
            addLast(element);
            return;
        }
        
        // 找到 index 对应的 Node
        Node<E> p = getNode(index);
        Node<E> temp = p.prev;
        // temp <-> p
        
        // 新要插入的 Node
        Node<E> x = new Node<>(element);
        
        p.prev = x;
        temp.next = x;
        
        x.prev = temp;
        x.next = p;
        
        // temp <-> x <-> p
        
        size++;
    }
    
    
    /***** 删 *****/
    public E removeFirst() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        Node<E> node = head.next;
        head.next = node.next;
        node.next.prev = head;
        node.next = node.prev = null;
        return node.val;
    }
    
    
    public E removeLast() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        Node<E> node = tail.prev;
        node.prev.next = tail;
        tail.prev = node.prev;
        node.next = node.prev = null;
        return node.val;
    }
    
    public E remove(int index) {
        Node<E> node = getNode(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        
        node.next = node.prev = null;
        size--;
        return node.val;
        
    }
    
    /***** 查 *****/
    public E get(int index) {
        checkElementIndex(index);
        return getNode(index).val;
    }
    
    
    public E getFirst() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        return head.next.val;
    }
    
    public E getLast() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        return tail.prev.val;
    }
    
    
    /***** 改 *****/
    public E Set(int index, E val) {
        Node<E> node = getNode(index);
        E old = node.val;
        node.val = val;
        return old;
    }
    
    
    /***** 其他工具函数 *****/
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public Node<E> getNode(int index) {
        checkElementIndex(index);
        Node<E> res = head;
        for (int i = 0; i < index; i++) {
            res = res.next;
        }
        
        return res;
    }
    
    
    public boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }
    
    public boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }
    
    /**
     * 检查 index 索引位置是否可以存在元素
     */
    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
    
    /**
     * 检查 index 索引位置是否可以添加元素
     */
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
    
    
}
