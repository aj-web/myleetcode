package leetcode.array.array1_500;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author : chezj
 * @date : 2022/8/15 14:31
 */
public class Problem705 {

    MyHashSet myHashSet = new MyHashSet();


}


class MyHashSet {

    boolean[] data = new boolean[1000008];


    public MyHashSet() {

    }

    public void add(int key) {
        data[key] = true;
    }

    public void remove(int key) {
        data[key] = false;
    }

    public boolean contains(int key) {
        return data[key];
    }
}


class MyHashSet1 {

    private static final int BASE = 769;
    private LinkedList[] data;

    public MyHashSet1() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; ++i) {
            data[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int hash = hash(key);
        Iterator<Integer> iterator = data[hash].iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == key) {
                return;
            }
        }
        data[hash].addLast(key);
    }

    public void remove(int key) {
        int hash = hash(key);
        Iterator<Integer> iterator = data[hash].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                data[hash].remove(element);
                return;
            }
        }
    }

    public boolean contains(int key) {
        int hash = hash(key);
        Iterator<Integer> iterator = data[hash].iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == key) {
                return true;
            }
        }
        return false;
    }

    private static int hash(int key) {
        return key % BASE;
    }
}