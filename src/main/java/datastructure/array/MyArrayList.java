package datastructure.array;



/**
 * 动态数组
 */
public class MyArrayList<E> {
    private int size;
    private E[] data;

    /**
     * 默认初始化容量10
     */
    public MyArrayList(){
        this(10);
    }

    public MyArrayList(int cacpcity){
        this.data = (E[]) new Object[cacpcity];
        this.size = 0;
    }


    public int getCapacity(){
        return data.length;
    }


    // 获取数组中的元素个数
    public int getSize(){
        return size;
    }


    public void add(int index, E e) {
        if (index>this.data.length){
            throw new IllegalArgumentException("超出数组长度");
        }
        if (0==this.data.length){
            throw new IllegalArgumentException("数组未初始化");
        }


//      一种情况：容量为3的数组，已经放了3个值，执行第四次add时

        if (size+1>this.data.length){
            throw new IllegalArgumentException("需要扩容");
        }


        for (int i = this.size-1;i>0;i--){
            data[i+1] = data[i];
        }
        data[index]  = e;
        size++;

    }


    public void remove(int index) {

    }


    public static void main(String[] args) {
        MyArrayList<String > myArrayList = new MyArrayList<>(3);
        myArrayList.add(0,"a");
        myArrayList.add(1,"b");
        myArrayList.add(2,"d");
        myArrayList.add(3,"e");
    }

}
