package leetcode.linkedlist.linkedlist1_500;

import lombok.ToString;
import org.apache.commons.lang3.time.StopWatch;

/**
 * 旋转链表
 *
 * @author : chezj
 * @TODO
 * @date : 2023/2/17 16:14
 */
public class Problem61 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem61 p = new Problem61();
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        a.next = b;
        b.next = c;
        System.out.println(p.rotateRight(a, 4));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    /**
     * 找到分割点，从而进行链表分割即可
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (null == head || 0 == k || null == head.next) {
            return head;
        }
        ListNode tail = head;
        int count = 1;
        while (tail.next != null) {
            tail = tail.next;
            count++;
        }
        //环状求移动路径
        int len = count - (k % count);
        if (len == count) {
            return head;
        }
        tail.next = head;
        while (len-- > 0) {
            tail = tail.next;
        }
        ListNode ans = tail.next;
        tail.next = null;
        return ans;
    }
    
    
    public ListNode rotateRight20240515(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int count = 1;
        ListNode index = head;
        while (index.next != null) {
            count++;
            index = index.next;
        }
        int move = count - (k % count);
        //注意这里index已经遍历到尾部了，直接连接头部形成环形链表，然后切割。
        index.next = head;
        while (move-- > 0) {
            index = index.next;
        }
        //注意断开环形链表的时候要取到答案的头结点。
        ListNode ans = index.next;
        index.next = null;
        return ans;
    }
    
    
    @ToString
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
