package leetcode.array.doing;

import lombok.ToString;

/**
 * 环形链表
 *
 * @author : chezj
 * @date : 2022/10/19 23:37
 */
public class Problem141 {
    
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
            
        }
        return false;
    }
    
    
    @ToString
    public static class ListNode {
        
        int val;
        
        ListNode next;
        
        ListNode(int x) {
            val = x;
            next = null;
        }
        
    }
    
}
