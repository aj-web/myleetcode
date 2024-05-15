/**
 * @author : chezj
 * @date : 2024/3/17 14:02
 */
public class Test1 {
    
    static String res = "add_";
    
    public static void main(String[] args) throws InterruptedException {
        
        //        CountDownLatch countDownLatch = new CountDownLatch(3);
        //
        //        Thread a = new Thread(() -> {
        //            try {
        //                Thread.sleep(1000);
        //            } catch (InterruptedException e) {
        //                e.printStackTrace();
        //            }
        //            res = res + "a";
        //            countDownLatch.countDown();
        //        });
        //
        //        Thread b = new Thread(() -> {
        //            try {
        //                a.join();
        //            } catch (InterruptedException e) {
        //                e.printStackTrace();
        //            }
        //            res = res + "b";
        //            countDownLatch.countDown();
        //        });
        //
        //        Thread c = new Thread(() -> {
        //            try {
        //                b.join();
        //            } catch (InterruptedException e) {
        //                e.printStackTrace();
        //            }
        //            res = res + "c";
        //            countDownLatch.countDown();
        //        });
        //
        //        a.start();
        //        b.start();
        //        c.start();
        //        System.out.println("before " + res);
        //        countDownLatch.await();
        //
        //        System.out.println("after " + res);
        
    }
    
    static class Base {
        
        public Base() {
            System.out.print("Base");
        }
    }
    
    static class Base1 extends Base {
        
        public static void main(String[] args) {
            
            Integer a = 100;
            Integer b = 100;
            Integer c = 300;
            Integer d = 300;
            String a1 = "aaaa";
            String b1 = new String("aaaa");
            //            System.out.println(a == b);
            //            System.out.println(c == d);
            System.out.println(a1 == "aaaa");
            System.out.println(b1 == "aaaa");
            //            Base base = new Base();
            //            Base1 base1 = new Base1();
            
        }
    }
    
}
