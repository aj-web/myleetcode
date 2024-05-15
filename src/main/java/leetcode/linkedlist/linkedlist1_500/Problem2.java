package leetcode.linkedlist.linkedlist1_500;

import org.apache.commons.lang3.time.StopWatch;

/**
 * @author : chezj
 * @date : 2024/3/14 16:58
 */
public class Problem2 {
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


    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem2 p = new Problem2();
        ListNode c = new ListNode(3, null);
        ListNode b = new ListNode(4, c);
        ListNode a = new ListNode(2, b);


        ListNode f = new ListNode(4, null);
        ListNode e = new ListNode(6, f);
        ListNode d = new ListNode(5, e);

        p.addTwoNumbers(a, d);
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode p1 = l1;
        ListNode p2 = l2;
        boolean adder = false;
        ListNode res = new ListNode(-1);

        ListNode p = res;
        while (p1 != null || p2 != null || adder) {

            int temp = 0;
            if (p1 != null) {
                temp = temp + p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                temp = temp + p2.val;
                p2 = p2.next;
            }

            if (adder) {
                temp++;
                adder = false;
            }
            if (temp >= 10) {
                adder = true;
                temp = temp % 10;
            }

            p.next = new ListNode(temp);
            p = p.next;

        }
        return res.next;

    }

}
