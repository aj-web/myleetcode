package leetcode.array.array501_1000;

import org.apache.commons.lang3.time.StopWatch;

/**
 * 寻找比目标字母大的最小字母
 *
 * @author : chezj
 * @date : 2022/8/20 16:13
 */
public class Problem744 {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem744 p = new Problem744();
        char[] c = new char[]{'c', 'f', 'j'};
        System.out.println(p.nextGreatestLettersadas(c, 'j'));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }


    public char nextGreatestLetter(char[] letters, char target) {
        if (target == 'z') {
            return letters[0];
        }

        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > target) {
                return letters[i];
            }
        }

        return letters[0];
    }


    public char nextGreatestLettersadas(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        if (letters[right] <= target) {
            return letters[0];
        }

        while (left < right) {
            int mid = left + ((right - left) >> 1) / 2;
            if (letters[mid] == target) {
                //寻找比目标字母大的最小字母
                //当两个字母相等，左移
                left = mid + 1;
            } else if (letters[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;

            }

            //check操作
            if (left == right) {
                if (letters[right] > target) {
                    return letters[right];
                } else {
                    return letters[0];
                }
            }

        }
        return target;
    }

}

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid;
        }
        return -1;
    }
}
