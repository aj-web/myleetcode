package datastructure.array;

import java.util.ArrayList;

public class ArrayTest {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(10);
//        arrayList.add(0,"a");
        arrayList.add(1, "b");
        arrayList.add(3, "a");

/*        int[] a = new int[10];
        a[0] = 1;
        a[4] = 5;*/

        System.out.println("end");
    }
}
