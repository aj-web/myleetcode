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
        
        ListNode preA = list1;
        for (int i = 0; i < a - 1; i++) {
            preA = preA.next;
        }
        
        ListNode preB = preA;
        for (int i = 0; i < b - a + 2; i++) {
            preB = preB.next;
        }
        
        preA.next = list2;
        
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = preB;
        
        return list1;
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
}
