package leetcode.LinkedList.LinkedList1_500;

import org.apache.commons.lang3.time.StopWatch;

/**
 * @author : chezj
 * @date : 2023/2/10 17:41
 */
public class Problem83 {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem83 p = new Problem83();

        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }

    public ListNode deleteDuplicates(ListNode head) {
        return null;
    }


    public class ListNode {

        int val;

        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
