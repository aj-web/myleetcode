package leetcode.array.doing;

import org.apache.commons.lang3.time.StopWatch;

/**
 * 删除排序链表中的重复元素 II 对比I来说，他的思路就是新创建一个链表，然后一个指针遍历取值，一个指针组装
 *
 * @author : chezj
 * @date : 2022/10/25 16:29
 */
public class Problem82 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem82 p = new Problem82();
        ListNode d = new ListNode(3, null);
        ListNode c = new ListNode(2, d);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(1, b);
        p.deleteDuplicates(a);
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    /**
     * 双指针
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode slow = dummy;
        ListNode fast = head;
        
        while (fast != null) {
            if (fast.next != null && fast.val == fast.next.val) {
                while (fast.next != null && fast.val == fast.next.val) {
                    fast = fast.next;
                }
                fast = fast.next;
                if (fast == null) {
                    slow.next = null;
                }
            } else {
                slow.next = fast;
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }
    
    /**
     * 递归求解
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates1(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val != head.next.val) {
            // 如果头结点和身后节点的值不同，则对之后的链表去重即可
            head.next = deleteDuplicates(head.next);
            return head;
        }
        // 如果如果头结点和身后节点的值相同，则说明从 head 开始存在若干重复节点
        // 越过重复节点，找到 head 之后那个不重复的节点
        while (head.next != null && head.val == head.next.val) {
            head = head.next;
        }
        // 直接返回那个不重复节点开头的链表的去重结果，就把重复节点删掉了
        return deleteDuplicates(head.next);
    }
    
    
    public ListNode deleteDuplicates20240515(ListNode head) {
        ListNode dummy = new ListNode(-1);
        //创建两个指正
        ListNode p = dummy;
        ListNode q = head;
        //开始遍历和组装
        while (q != null) {
            if (q.next != null && q.val == q.next.val) {
                while (q.next != null && q.val == q.next.val) {
                    q = q.next;
                }
                q = q.next;
                if (q == null) {
                    p.next = null;
                }
            } else {
                p.next = q;
                q = q.next;
                p = p.next;
            }
        }
        return dummy.next;
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
