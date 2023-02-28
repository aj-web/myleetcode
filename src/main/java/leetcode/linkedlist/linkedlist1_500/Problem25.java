package leetcode.LinkedList.linkedlist1_500;

import org.apache.commons.lang3.time.StopWatch;

/**
 * @author : chezj
 * @date : 2023/2/27 15:03
 */
public class Problem25 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem25 p = new Problem25();
        
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        return null;
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
