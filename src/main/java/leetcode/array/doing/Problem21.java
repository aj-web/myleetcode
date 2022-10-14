package leetcode.array.doing;

import org.apache.commons.lang3.time.StopWatch;

/**
 * @author : chezj
 * @date : 2022/10/13 16:10
 */
public class Problem21 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem21 p = new Problem21();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        
        l4.next = l5;
        l5.next = l6;
        
        p.mergeTwoLists(l1, l4);
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(0);
        ListNode current = res;
        while (null != list1 && null != list2) {
            if (list1.val <= list2.val) {
                current.next = list1;
                current = current.next;
                list1 = list1.next;
            } else {
                current.next = list2;
                current = current.next;
                list2 = list2.next;
            }
            
        }
        if (null == list1) {
            current.next = list2;
        } else if (null == list2) {
            current.next = list1;
        }
        return res.next;
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
