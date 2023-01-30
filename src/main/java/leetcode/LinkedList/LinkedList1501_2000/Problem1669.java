package leetcode.LinkedList.LinkedList1501_2000;

import org.apache.commons.lang3.time.StopWatch;

/**
 * @author : chezj
 * @date : 2023/1/30 11:36
 */
public class Problem1669 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem1669 p = new Problem1669();
        
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
        
        System.out.println(p.mergeInBetween(a, 1, 2, b));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        ListNode pummy = new ListNode(-1);
        pummy.next = list1;
        ListNode curr = pummy;
        
        ListNode pummy2 = new ListNode(-1);
        pummy2.next = list2;
        ListNode curr2 = pummy2;
        
        ListNode head2 = curr2.next;
        ListNode tail2 = new ListNode();
        while (curr2.next != null) {
            curr2 = curr2.next;
            if (curr2.next == null) {
                tail2 = curr2;
            }
        }
        
        while (curr.next != null) {
        
        }
        
        return null;
    }
    
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
}
