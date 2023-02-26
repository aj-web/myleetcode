package leetcode.linkedlist.linkedlist1_500;

import org.apache.commons.lang3.time.StopWatch;

/**
 * 单链表的倒数第 k 个节点
 *
 * @author : chezj
 * @date : 2022/10/24 22:22
 */
public class Problem19 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem19 p = new Problem19();
        ListNode b = new ListNode(4);
        ListNode b1 = new ListNode(1);
        b.next = b1;
        ListNode b2 = new ListNode(8);
        b1.next = b2;
        ListNode b3 = new ListNode(4);
        b2.next = b3;
        ListNode b4 = new ListNode(5);
        b3.next = b4;
        p.removeNthFromEnd(b, 2);
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    /**
     * 遍历两次
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //首先一个head的指针
        ListNode p = head;
        //声明虚拟头结点，且下一个节点为head
        ListNode dummy = new ListNode(-1, head);
        
        //遍历求和
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        
        //再次遍历
        ListNode cur = dummy;
        for (int i = 1; i < count - n + 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
    
    
    /**
     * 遍历一次
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        
        ListNode p1 = head;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        ListNode p2 = dummy;
        
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return dummy.next;
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
    
    
    /**
     * 复习
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        //首先一个head的指针
        ListNode p = head;
        
        ListNode dummy = new ListNode(-1, head);
        
        for (int i = 0; i < n; i++) {
            p = p.next;
        }
        
        ListNode curr = dummy;
        while (p != null) {
            curr = curr.next;
            p = p.next;
        }
        curr.next = curr.next.next;
        return dummy.next;
    }
    
}
