package leetcode.LinkedList.LinkedList1_500;

import org.apache.commons.lang3.time.StopWatch;

/**
 * 移除链表元素
 *
 * @author : chezj
 * @date : 2022/11/2 23:47
 */
public class Problem203 {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem203 p = new Problem203();
        ListNode a = new ListNode(8);

        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }


    public ListNode removeElements(ListNode head, int val) {
        ListNode pummy = new ListNode(-1);
        pummy.next = head;
        ListNode cur = pummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return pummy.next;
    }


    public static class ListNode {

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
