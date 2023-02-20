package leetcode.LinkedList.LinkedList1_500;

import org.apache.commons.lang3.time.StopWatch;

/**
 * @author : chezj 删除排序链表中的重复元素
 * @date : 2023/2/10 17:41
 */
public class Problem83 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem83 p = new Problem83();
        
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null) {
            if (fast.val != slow.val) {
                //slow++
                //num[slow] = num[fast]
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        //特殊情况全是重复
        slow.next = null;
        return head;
    }
    
    
    private class ListNode {
        
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
