package datastructure.array;


/**
 * 使用数组实现ArrayList
 * @param <E>
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
     * 开始不理解 后面发现这个add方法  124  在 add(2,3)后，会变成1234
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        checkPositionIndex(index);
        int cap = data.length;
        if (index==cap){
            resize(cap<<1);
        }
        // 搬移数据 data[index..] -> data[index+1..]
        System.arraycopy(data, index,
                data, index + 1,
                size - index);
        data[index] = e;
        size++;
    }


    public E remove(int index) {
        checkElementIndex(index);
        int cap = data.length;
        if (size == cap / 4) {
            resize(cap / 2);
        }
        E datum = data[index];
        System.arraycopy(data, index + 1,
                data, index,
                size - index - 1);
        data[index] = null;
        size--;
        return datum;
    }


    // 查
    public E get(int index) {
        checkElementIndex(index);
        return data[index];
    }


    // 查
    public E set(int index, E Element) {
        checkElementIndex(index);
        E datum = data[index];
        data[index] = Element;
        return datum;
    }


    /**
     * 扩容
     *
     * @param newCapacity
     */
    public void resize(int newCapacity) {
        if (size>newCapacity){
            return;
        }
        E[] temp = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        // System.arraycopy(data, 0, temp, 0, size);
        data = temp;

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


    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }


    /**
     * 仅针对add方法进行判断
     *
     * @param index
     * @return
     */
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }



    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>(8);
        myArrayList.add(0, "a");
        myArrayList.add(1, "b");
//        myArrayList.add(2, "c");
//        myArrayList.add(3, "d");
        myArrayList.remove(1);
        System.out.println("end");
    }

}
