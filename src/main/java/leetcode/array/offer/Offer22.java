package leetcode.array.offer;

import org.apache.commons.lang3.time.StopWatch;

/**
 * @author : chezj
 * @date : 2022/10/13 17:16
 */
public class Offer22 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Offer22 p = new Offer22();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        ListNode l3 = new ListNode(3);
        l2.next = l3;
        ListNode l4 = new ListNode(4);
        l3.next = l4;
        ListNode l5 = new ListNode(5);
        l4.next = l5;
        p.getKthFromEnd(l1, 2);
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    
    public ListNode getKthFromEnd(ListNode head, int k) {
        int size = 0;
        ListNode node = head;
        while (node != null) {
            size++;
            node = node.next;
        }
        if (k > size) {
            return null;
        }
        if (size == 1) {
            return head;
        }
        
        for (node = head; size > k; size--) {
            node = node.next;
        }
        return node;
    }
    
    
    public ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode fast = head, slow = head;
        while (fast != null && k > 0) {
            k--;
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    
    
    public static class ListNode {
        
        int val;
        
        ListNode next;
        
        ListNode(int x) {
            val = x;
        }
    }
}
