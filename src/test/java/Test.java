/**
 * @author chezhijun
 * @descririon
 * @date 2022/4/21
 */
public class Test {
    public static void main(String[] args) {
//        String s1 = new String("test");
//        System.out.println(s1 == s1.intern());

        String s2 = new StringBuilder("te").append("st").toString();
        System.out.println(s2 == s2.intern());


        String s1 = new String("java");
        System.out.println(s1 == s1.intern());
    }
}
