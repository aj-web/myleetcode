import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author chezhijun
 * @descririon
 * @date 2021/8/16
 */
public class ReflectTest {

    public void test(String args[]) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }


    public static void main(String[] args) throws Exception{
        String[] s = new String[]{"aa","bb"};
        Class<ReflectTest> clazz = (Class<ReflectTest>) Class.forName("ReflectTest");
        Method method = clazz.getMethod("test", String[].class);
        Constructor constructor = clazz.getConstructor();
         ReflectTest rt = (ReflectTest)constructor.newInstance();
        // method.invoke(rt,(Object) s);
        rt.test(new String[]{"1","2","3"});
    }
}
