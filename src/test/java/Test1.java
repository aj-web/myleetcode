import java.lang.reflect.Array;

public class Test1 {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6};
        int[] b = new int[20];

        b[1] = 20;
        a[1] = 1000;
        System.out.println(b[1]);
        System.out.println(a[1]);
    }
}
