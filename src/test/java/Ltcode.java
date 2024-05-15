import org.apache.commons.lang3.time.StopWatch;

/**
 * @author : chezj
 * @date : 2024/3/14 16:28
 */
public class Ltcode {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Ltcode p = new Ltcode();

        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }


    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;

    }


}
