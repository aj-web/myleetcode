package leetcode.array.doing;

import org.apache.commons.lang3.time.StopWatch;

import java.util.PriorityQueue;

/**
 * 合并 k 个有序链表
 * 优先级队列（默认最小堆）
 *
 * @author : chezj
 * @date : 2022/10/24 17:07
 */
public class Problem23 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem23 p = new Problem23();
        
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        //虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        
        while (!pq.isEmpty()) {
            ListNode poll = pq.poll();
            p.next = poll;
            
            if (poll.next != null) {
                pq.add(poll.next);
            }
            p = p.next;
        }
        
        return dummy.next;
        
    }
    
    
    class ListNode {
        
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
