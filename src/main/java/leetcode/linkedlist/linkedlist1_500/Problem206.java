package leetcode.linkedlist.linkedlist1_500;

import org.apache.commons.lang3.time.StopWatch;

/**
 * 反转链表
 *
 * @author : chezj
 * @date : 2023/2/20 17:41
 */
public class Problem206 {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem206 p = new Problem206();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode listNode = p.reverseList(listNode1);
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }


    public ListNode reverseList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode lastNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return lastNode;

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
