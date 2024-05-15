package leetcode.linkedlist.linkedlist1_500;

import org.apache.commons.lang3.time.StopWatch;

/**
 * 反转链表II
 *
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
    
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }
    
    
    ListNode successor = null; // 后驱节点
    
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }
    
    
    /**
     * 反转整个链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
    
    /**
     * 反转前n个链表
     *
     * @param head
     * @param n
     * @return
     */
    ListNode successor1 = null;
    
    public ListNode reverseN1(ListNode head, int n) {
        if (n == 1) {
            successor1 = head.next;
            return head;
        }
        
        ListNode last = reverseN1(head.next, n - 1);
        head.next.next = head;
        head.next = successor1;
        return last;
        
    }
    
    
}
