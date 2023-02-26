package leetcode.array.array1_500;

import java.util.*;

public class Problem350 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        System.out.println(intersect(nums1, nums2));
    }


    /**
     * 两个hash表
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>(nums1.length);
        Map<Integer, Integer> map2 = new HashMap<>(nums2.length);
        List<Integer> result = new ArrayList<>();
        for (int i : nums1) {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        }

        for (int i : nums2) {
            map2.put(i, map2.getOrDefault(i, 0) + 1);
        }

        if (map2.size() >= map1.size()) {
            for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
                if (map1.containsKey(entry.getKey())) {
                    int min = Math.min(map1.get(entry.getKey()), entry.getValue());
                    for (int i = 0; i < min; i++) {
                        result.add(entry.getKey());
                    }
                }
            }
        } else {
            for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
                if (map2.containsKey(entry.getKey())) {
                    int min = Math.min(map2.get(entry.getKey()), entry.getValue());
                    for (int i = 0; i < min; i++) {
                        result.add(entry.getKey());
                    }
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }


    /**
     * 优化版本：使用一个hash
     * 放弃使用stream操作返回结果
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>(nums1.length);
        List<Integer> result = new ArrayList<>();
        for (int i : nums1) {
            Integer count = map1.getOrDefault(i, 0);
            map1.put(i, count + 1);
        }

        for (int i : nums2) {
            if (map1.containsKey(i)) {
                Integer key = map1.get(i);
                if (key > 0) {
                    map1.put(i, key - 1);
                    result.add(i);
                }
            }
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
//        return result.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }


    /**
     * 进阶，若果两个数组是有序
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        int length1 = nums1.length;
        int length2 = nums2.length;
        int p1 = 0;
        int p2 = 0;
        while (p1 < length1 && p2 < length2) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                result.add(nums1[p1]);
                p1++;
                p2++;
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}
