import org.apache.commons.lang3.time.StopWatch;

/**
 * @author : chezj
 * @date : 2024/3/17 16:13
 */
public class Test2 {
    
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
    
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Test2 p = new Test2();
        
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (null == list1) {
            return list2;
        }
        
        if (list2 == null) {
            return list1;
        }
        ListNode res = new ListNode(-1);
        ListNode p = res;
        ListNode p1 = list1;
        ListNode p2 = list2;
        
        while (p1 != null || p2 != null) {
            if (p1 == null) {
                p.next = p2;
                break;
            } else if (null == p2) {
                p.next = p1;
                break;
            } else if (p1.val <= p2.val) {
                p.next = new ListNode(p1.val);
                p = p.next;
                p1 = p1.next;
            } else {
                p.next = new ListNode(p2.val);
                p = p.next;
                p2 = p2.next;
            }
        }
        return res.next;
        
    }
    
}







