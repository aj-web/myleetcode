package leetcode.array.array1_500;

import java.util.ArrayList;

/**
 * LeetCode392：判断子序列 判断s是否为t的子序列 1.通过快慢指针处理 2.通过二分查找优化
 */
public class Problem392 {
    
    public static void main(String[] args) {
        String s = "acb";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }
    
    public static boolean isSubsequenceViolent(String s, String t) {
        int slow = 0;
        int fast = 0;
        if (s.length() == 0) {
            return true;
        }
        
        if (t.length() == 0) {
            return false;
        }
        while (fast < t.length()) {
            if (t.charAt(fast) == s.charAt(slow)) {
                slow++;
                if (slow == s.length()) {
                    return true;
                }
            }
            fast++;
        }
        return false;
    }
    
    public static boolean isSubsequence(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        
        //处理数组转化为[a,[1,3,7]]的形式
        ArrayList<Integer>[] index = new ArrayList[256];
        for (int i = 0; i < tLength; i++) {
            char c = t.charAt(i);
            if (index[c] == null) {
                index[c] = new ArrayList<>();
            }
            index[c].add(i);
        }
        
        int point = 0;
        for (int i = 0; i < sLength; i++) {
            char j = s.charAt(i);
            if (index[j] == null) {
                return false;
            }
            int left_bound = left_bound(index[j], point);
            if (left_bound == index[j].size()) {
                return false;
            }
            point = index[j].get(left_bound) + 1;
        }
        return false;
    }
    
    
    public static int left_bound(ArrayList<Integer> nums, int j) {
        int left = 0;
        int right = nums.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums.get(mid) < j) {
                left = mid + 1;
            } else if (nums.get(mid) > j) {
                right = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
