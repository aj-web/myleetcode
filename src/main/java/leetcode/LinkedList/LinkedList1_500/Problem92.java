package leetcode.LinkedList.LinkedList1_500;

import org.apache.commons.lang3.time.StopWatch;

/**
 * @author : chezj
 * @date : 2023/2/20 17:50
 */
public class Problem92 {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem92 p = new Problem92();

        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        

        return null;
    }

    private static class ListNode {

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
