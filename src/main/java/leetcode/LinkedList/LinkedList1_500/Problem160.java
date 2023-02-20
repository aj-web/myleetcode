package leetcode.LinkedList.LinkedList1_500;

import lombok.ToString;
import org.apache.commons.lang3.time.StopWatch;

/**
 * 相交链表
 *
 * @author : chezj
 * @date : 2022/10/17 23:08
 */
public class Problem160 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem160 p = new Problem160();
        ListNode a = new ListNode(8);
        ListNode b = new ListNode(4);
        ListNode b1 = new ListNode(1);
        b.next = b1;
        ListNode b2 = new ListNode(8);
        b1.next = b2;
        ListNode b3 = new ListNode(4);
        b2.next = b3;
        ListNode b4 = new ListNode(5);
        b3.next = b4;
        System.out.println(p.getIntersectionNode(a, b).val);
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            if (tempA == null) {
                tempA = headB;
            } else {
                tempA = tempA.next;
            }
            if (tempB == null) {
                tempB = headA;
            } else {
                tempB = tempB.next;
            }
        }
        return tempA;
    }
    
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }
    
    
    @ToString
    private static class ListNode {
        
        int val;
        
        ListNode next;
        
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }
            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }
        return a;
    }
}
