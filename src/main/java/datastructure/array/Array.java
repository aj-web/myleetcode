package datastructure.array;

/**
 * 本来想自己实现数组
 * 最终发现数组是个很特别的对象，由native方法支撑
 * 核心就是数组初始化    (E[])new Object(capacity)
 */
public class Array<E> {
    private int size;
    private E[] data;


    int[] a = new int[]{};

    public Array() {
        this.size = 10;
    }


    //数组初始化，注意这里是创建了一个指定大小的:Object[capacity]
    public Array(int capacity) {
        E[] e = (E[]) new Object[capacity];
        this.size = 0;
    }

    /*// 获取数组的容量
    public int getCapacity(){
        return data.length;
    }


    // 获取数组中的元素个数
    public int getSize(){
        return size;
    }


    public void add(int index, E e) {
        if (index>this.size){
            throw new IllegalArgumentException("超出数组长度");
        }
        if (0==this.size){
            throw new IllegalArgumentException("数组未初始化");
        }



    }


    public void remove(int index) {

    }*/


}
