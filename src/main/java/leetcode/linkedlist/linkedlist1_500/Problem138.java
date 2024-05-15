package leetcode.linkedlist.linkedlist1_500;

import org.apache.commons.lang3.time.StopWatch;

import java.util.HashMap;

/**
 * 随机链表的复制
 *
 * @author : chezj
 * @date : 2024/4/2 15:27
 */
public class Problem138 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem138 p = new Problem138();
        
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    
    public Node copyRandomList(Node head) {
        
        HashMap<Node, Node> originToClone = new HashMap<>();
        
        for (Node p = head; p != null; p = p.next) {
            if (!originToClone.containsKey(p)) {
                originToClone.put(p, new Node(p.val));
            }
        }
        
        for (Node p = head; p != null; p = p.next) {
            if (p.next != null) {
                originToClone.get(p).next = originToClone.get(p.next);
                
            }
            if (p.random != null) {
                originToClone.get(p).random = originToClone.get(p.random);
            }
        }
        
        return originToClone.get(head);
    }
    
    
    class Node {
        
        int val;
        
        Node next;
        
        Node random;
        
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
