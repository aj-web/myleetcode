package datastructure.array;

import java.util.NoSuchElementException;

/**
 * 单链表实现
 *
 * @author : chezj
 * @date : 2022/10/12 23:04
 */
public class MyLinkedListSingle<E> {

    private final Node<E> head, tail;
    private int size;

    private static class Node<E> {
        E val;
        Node<E> next;

        Node(E val) {
            this.val = val;
        }
    }

    public MyLinkedListSingle() {
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        head.next = tail;

        this.size = 0;
    }

    /***** 增 *****/

    public void addFirst(E e) {
        Node<E> x = new Node<>(e);
        Node<E> temp = head.next;

        // head -> temp
        x.next = temp;
        head.next = x;
        // head -> x -> temp

        size++;
    }

    public void addLast(E e) {
        Node<E> x = new Node<>(e);
        Node<E> temp;
        if (size - 1 >= 0) {
            temp = getNode(size - 1);
        } else {
            temp = head;
        }
        // temp -> tail
        x.next = tail;
        temp.next = x;
        // temp -> x -> tail
        size++;
    }

    public void add(int index, E element) {
        checkPositionIndex(index);

        // 判断特殊情况
        if (index == size) {
            addLast(element);
            return;
        }

        Node<E> x = new Node<>(element);
        Node<E> p = getNode(index);
        Node<E> temp;
        if (index - 1 >= 0) {
            temp = getNode(index - 1);
        } else {
            temp = head;
        }

        // temp -> p
        x.next = p;
        temp.next = x;
        // temp -> x -> p

        size++;
    }


    /***** 删 *****/

    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<E> x = head.next;
        // head -> x -> ...
        head.next = head.next.next;
        x.next = null;
        // head -> ...

        size--;

        return x.val;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node<E> x = getNode(size - 1);
        Node<E> temp;
        if (size - 2 >= 0) {
            temp = getNode(size - 2);
        } else {
            temp = head;
        }
        // temp -> x -> tail
        temp.next = tail;
        x.next = null;
        // temp -> tail

        size--;
        return x.val;
    }

    public E remove(int index) {
        checkElementIndex(index);

        Node<E> p = getNode(index);
        Node<E> prev;
        if (index - 1 >= 0) {
            prev = getNode(index - 1);
        } else {
            prev = head;
        }

        Node<E> next = p.next;
        // prev -> p -> next
        prev.next = next;
        p.next = null;
        // prev -> next

        size--;
        return p.val;
    }


    /***** 查 *****/

    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.next.val;
    }

    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return getNode(size - 1).val;
    }

    public E get(int index) {
        checkElementIndex(index);
        Node<E> p = getNode(index);
        return p.val;
    }


    /***** 改 *****/
    public E set(int index, E val) {
        Node<E> node = getNode(index);
        E oldVal = node.val;
        node.val = val;
        return oldVal;
    }


    /***** 其他工具函数 *****/
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
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

    // 返回 index 对应的 Node
    // 注意：请保证传入的 index 是合法的
    private Node<E> getNode(int index) {
        checkElementIndex(index);
        Node<E> p = head.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p;
    }
}
