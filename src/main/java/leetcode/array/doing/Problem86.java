package leetcode.array.doing;

import lombok.ToString;
import org.apache.commons.lang3.time.StopWatch;

/**
 * 分割链表
 *
 * @author : chezj
 * @date : 2022/10/18 23:42
 */
public class Problem86 {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem86 p = new Problem86();

        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }


    public ListNode partition(ListNode head, int x) {

        // 存放小于 x 的链表的虚拟头结点
        ListNode dummy1 = new ListNode(-1);
        // 存放大于等于 x 的链表的虚拟头结点
        ListNode dummy2 = new ListNode(-1);
        ListNode left = dummy1;
        ListNode right = dummy2;
        ListNode p = head;
        while (p != null) {
            if (p.val >= x) {
                right.next = p;
                right = right.next;
            } else {
                left.next = p;
                left = left.next;
            }
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        left.next = dummy2.next;
        return dummy1.next;
    }


    @ToString
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int x) {
            val = x;
            next = null;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
