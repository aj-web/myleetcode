package test;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : chezj
 * @date : 2024/2/12 12:30
 */
public class Test {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Test p = new Test();

        /*int[] a = new int[]{1, 3, 5, 7, 9, 0, 0, 0, 0, 0};
        int[] b = new int[]{2, 4, 6, 8, 10};
        p.merge1(a, 5, b, 5);*/
//        System.out.println(p.removeDuplicates(new int[]{1, 1, 2}));

//        p.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
//        p.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
//        System.out.println(p.search("sadbutsad", "sad"));
        System.out.println(p.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*//当nums1为0，同理直接复制
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, m, n);
        }
        //当nums2为0，那么数组1的长度nums1.length等于m，直接放回nums1
        if (n == 0) {

        }

        if (m != 0 && n != 0) {
            System.arraycopy(nums2, 0, nums1, m, n);
            Arrays.sort(nums1);
        }*/
        //综合上述代码简化：
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }


    /**
     * 优化：双指针。从尾部开始插入
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int idx = m + n - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                nums1[idx] = nums2[p2--];
            } else if (p2 == -1) {
                nums1[idx] = nums1[p1--];
            } else if (nums1[p1] >= nums2[p2]) {
                nums1[idx] = nums1[p1--];
            } else {
                nums1[idx] = nums2[p2--];
            }
            idx--;
        }
    }


    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    /**
     * 使得出现次数超过两次的元素只出现两次
     *
     * @param nums
     * @return
     */
    public int removeDuplicates1(int[] nums) {
        if ((nums.length == 0)) {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        int count = 0;

        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            } else {
                if (slow < fast && count < 2) {
                    slow++;
                    nums[slow] = nums[fast];
                }
            }
            fast++;
            count++;
            if (fast < nums.length && nums[fast] != nums[fast - 1]) {
                count = 0;
            }
        }
        return slow + 1;
    }


    public void rotate(int[] nums, int k) {
        //数组长度
        int length = nums.length;
        //取余得到最终旋转的步数
        k = k % length;
        int[] temp = new int[nums.length];
        for (int i = 0; i < length; i++) {
            temp[(i + k) % length] = nums[i];
        }

        System.arraycopy(temp, 0, nums, 0, length);


        //======================第二种解法
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k % nums.length - 1);
        reverse(nums, k % nums.length, nums.length - 1);

    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;

        }


    }


    public int hIndex(int[] citations) {
        int h = 0;
        Arrays.sort(citations);
        int i = citations.length - 1;

        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }

    public int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        String target = split[split.length - 1];
        String replace = target.replace(" ", "");
        return replace.length();

    }

    public String longestCommonPrefix(String[] strs) {

        String first = strs[0];
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            for (String str : strs) {
                if (i >= str.length()) {
                    return res.toString();
                }
                char c1 = str.charAt(i);
                if (c1 != c) {
                    return res.toString();
                }
            }
            res.append(c);
        }
        return res.toString();
    }


    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        for (int i = 0; i <= m - n; i++) {
            int j;
            for (j = 0; j < n; j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
            if (j == n) {
                return i;
            }
        }
        return -1;
    }


    private int[] buildNext(String pat) {
        int len = pat.length();
        int[] next = new int[len];
        next[0] = 0; // 长度为1的字符串，其最长可匹配前缀后缀长度为0

        // j是最长可匹配前缀子串的下一个字符位置，i是最长可匹配后缀子串的下一个字符位置
        for (int i = 1, j = 0; i < len; i++) {
            // 处理pat[i] != pat[j]的情况
            while (j > 0 && pat.charAt(i) != pat.charAt(j)) {
                // 回溯到较短的相同前缀后缀
                j = next[j - 1];
            }
            // 处理pat[i] == pat[j]的情况
            if (pat.charAt(i) == pat.charAt(j)) {
                j++;
            }
            // 将j（前缀的长度）赋值给next[i]
            next[i] = j;
        }
        return next;
    }

    public int search(String txt, String pat) {
        int M = pat.length();
        int N = txt.length();
        if (M == 0) return 0; // 边界情况，空模式串
        int[] next = buildNext(pat);

        // i是txt的位置，j是pat的位置
        for (int i = 0, j = 0; i < N; i++) {
            // 处理txt[i] != pat[j]，回溯j
            while (j > 0 && txt.charAt(i) != pat.charAt(j)) {
                j = next[j - 1];
            }
            // 处理txt[i] == pat[j]
            if (txt.charAt(i) == pat.charAt(j)) {
                j++;
            }
            // 完整匹配
            if (j == M) {
                return i - M + 1; // 返回匹配的起始位置
            }
        }

        return -1; // 未找到匹配
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        s = sb.toString();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

//    public boolean isSubsequence(String s, String t) {
//        int p1 = 0;
//        int p2 = 0;
//        while (p1 < s.length() && p2 < t.length()) {
//            char c1 = s.charAt(p1);
//            char c2 = t.charAt(p2);
//            if (c1 == c2) {
//                p1++;
//            }
//            p2++;
//        }
//        return i == s.length();
//    }


    /**
     * 只返回一组结果的方法
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0;
        int hi = numbers.length - 1;

        while (lo < hi) {
            int sum = numbers[lo] + numbers[hi];
            if (sum < target) {
                lo++;
            } else if (sum > target) {
                hi--;
            } else {
                return new int[]{lo + 1, hi + 1};
            }

        }

        return new int[0];
    }


    public List<List<Integer>> twoSum1(int[] numbers, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start;
        int hi = numbers.length - 1;

        while (lo < hi) {
            int sum = numbers[lo] + numbers[hi];
            int left = numbers[lo];
            int right = numbers[hi];
            if (sum < target) {
                while (lo < hi && left == numbers[lo]) {
                    lo++;
                }
            } else if (sum > target) {
                while (lo < hi && right == numbers[hi]) {
                    hi--;

                }
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(numbers[lo]);
                list.add(numbers[hi]);
                res.add(list);
                while (lo < hi && left == numbers[lo]) {
                    lo++;
                }
                while (lo < hi && right == numbers[hi]) {
                    hi--;

                }
            }
        }
        return res;
    }


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> twoSum1 = twoSum1(nums, i + 1, -nums[i]);
            for (List<Integer> integers : twoSum1) {
                integers.add(nums[i]);
                {
                    res.add(integers);
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }
}
