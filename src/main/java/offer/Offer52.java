package offer;

import org.apache.commons.lang3.time.StopWatch;

/**
 * 两个链表的第一个公共节点
 *
 * @author : chezj
 * @date : 2023/8/30 16:55
 */
public class Offer52 {
    
    class ListNode {
        
        int val;
        
        ListNode next;
        
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Offer52 p = new Offer52();
        
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    /**
     * 通过某些方式，让 p1 和 p2 能够同时到达相交节点 c1
     *
     * @param headA
     * @param headB
     * @return
     */
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        
        return null;
    }
    
    /**
     * 计算链表长度，从举例尾结点相同举例的位置出发
     *
     * @param headA
     * @param headB
     * @return
     */
    ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        
        //计算headA长度
        int i1 = 0;
        while (p1 != null) {
            p1 = p1.next;
            i1++;
        }
        
        //计算headB长度
        int i2 = 0;
        while (p2 != null) {
            p2 = p2.next;
            i2++;
        }
        
        p1 = headA;
        p2 = headB;
        while (i1 > i2) {
            p1 = p1.next;
            i1--;
        }
        while (i2 > i1) {
            p2 = p2.next;
            i2--;
        }
        
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return p1;
    }
}



