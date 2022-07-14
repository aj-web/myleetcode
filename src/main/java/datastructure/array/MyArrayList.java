package datastructure.array;


import java.util.Arrays;

/**
 * 动态数组
 */
public class MyArrayList<E> {
    /**
     * 数据中的元素个数，区别于数组容量
     */
    private int size;
    /**
     * 存储数据的数组
     */
    private E[] data;

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * 默认初始化容量10
     */
    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int cacpcity) {
        this.data = (E[]) new Object[cacpcity];
        this.size = 0;
    }


    public int getCapacity() {
        return data.length;
    }


    // 获取数组中的元素个数
    public int getSize() {
        return size;
    }


    /**
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index > size) {
            grow(data.length);
        }

        //从后往前遍历集合，找到对应位置，插入即可
        for (int i = size; i > index; i--) {
            //将元素统一往后面移动，上一个元素为i的值
            data[i] = data[i - 1];
        }
        //将要添加的元素添加到指定的索引处
        data[index] = e;
        //数组下标+1
        size++;

    }



    public void remove(int index) {

    }


    public void grow(int nowCapacity) {
        int oldCapacity = data.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);

        //判断负数情况
        if (newCapacity - nowCapacity < 0) {
            newCapacity = nowCapacity;
        }
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            if ((nowCapacity < 0)) {
                throw new OutOfMemoryError();
            }
            newCapacity = nowCapacity > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
        }

        data = Arrays.copyOf(data, newCapacity);
    }


    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>(3);
        myArrayList.add(0, "a");
        myArrayList.add(1, "b");
        myArrayList.add(2, "d");
        System.out.println("end");
    }

}
