package leetcode.array.doing;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;

/**
 * 链表的中间结点
 *
 * @author : chezj
 * @date : 2022/10/23 17:46
 */
public class Problem876 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem876 p = new Problem876();
        
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    /**
     * 循环计数
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        return list.get(list.size() / 2);
    }
    
    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public ListNode middleNode1(ListNode head) {
        ListNode fast = head, slow = head;
        ArrayList<ListNode> list = new ArrayList<>();
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
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
