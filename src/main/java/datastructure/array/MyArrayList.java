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


    public void add(int index, E e) {
        checkPositionIndex(5);


        int cap = data.length;
        if (size==cap){
            resize(2<<cap);
        }

        // 搬移数据 data[index..] -> data[index+1..]
        System.arraycopy(data, index,
                data, index + 1,
                size - index);
        // 插入
        data[index] = e;
        size++;
    }


    public E remove(int index){
        checkElementIndex(index);
        E datum = data[index];
        int cap = data.length;
        // 可以缩容，节约空间
        if (size == cap / 4) {
            resize(cap / 2);
        }
        System.arraycopy(data,index+1,data,index,size-index-1);
        data[size-1] = null;

        return datum;
    }


    // 查
    public E get(int index) {
        // 检查索引越界
        checkElementIndex(index);

        return data[index];
    }


    // 查
    public E set(int index,E Element) {
        // 检查索引越界
        checkElementIndex(index);
        E temp = data[index];
        data[index] = Element;
        return temp;
    }



    /**
     * 扩容
     * @param newCapacity
     */
    public void resize(int newCapacity){
        if (size>newCapacity){
            return;
        }

        E[] temp = (E[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            temp[i] =  data[i];
        }

        data = temp;
    }

    /**
     * 检查 index 索引位置是否可以存在元素
     */
    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    /**
     * 检查 index 索引位置是否可以添加元素
     */
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
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
