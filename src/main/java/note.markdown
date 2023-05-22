# 数组笔记

## 1.双指针

#### 1.1前后指针

```aidl
{
    int slow = 0;
    int fast = 0;
    while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // 数组长度为索引 + 1
        return slow + 1;
}
```

前后指针技巧：

1. 通过控制slow++和nums[slow] = nums[fast]两行代码的顺讯可以控制数组第一个元素是否被覆盖
2. 通过快指针对特定某个target进行判断，可以进行数组target去重(只能去除重复target)

#### 1.2前后指针之滑动窗口

- 什么时候应该移动 right 扩大窗口？窗口加入字符时，应该更新哪些数据？
- 什么时候窗口应该暂停扩大，开始移动 left 缩小窗口？从窗口移出字符时，应该更新哪些数据？
- 我们要的结果应该在扩大窗口时还是缩小窗口时进行更新？

```

public static String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            //判断左侧窗口是否需要收缩
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }

            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

```

### 1.3左右指针

## 2.二分查找

```
/**
    
    * 二分查找基础班，直接返回mid，查找区间[lefy,right]
     *注意当时完整区间的时候
     *while (left <= right) 要使用 <= ，因为left == right是有意义的，所以使用 <=
     *if (nums[middle] > target) right 要赋值为 middle - 1，因为当前这个nums[middle]一定不是target，那么接下来要查找的左区间结束下标位置就是 middle - 1 
     *
     * @param nums
     * @param target
     * @return
     */
    int binary_search(int[] nums, int target) {
        int left = 0, right = nums.length - 1; 
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1; 
            } else if(nums[mid] == target) {
                // 直接返回
                return mid;
            }
        }
        // 直接返回
        return -1;
    }


     当然二分查找基础版也有开区间版本
      * 二分查找 ：查找范围为[left，right)
     *
     * @param nums
     * @param target
     * @return
     */
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
        
while(left <= right) 的终止条件是 left == right + 1，写成区间的形式就是 [right + 1, right]，或者带个具体的数字进去 [3, 2]，可见这时候区间为空，因为没有数字既大于等于 3 又小于等于 2 的吧。所以这时候 while 循环终止是正确的，直接返回 -1 即可。

while(left < right) 的终止条件是 left == right，写成区间的形式就是 [right, right]，或者带个具体的数字进去 [2, 2]，这时候区间非空，还有一个数 2，但此时 while 循环终止了。也就是说区间 [2, 2] 被漏掉了，索引 2 没有被搜索，如果这时候直接返回 -1 就是错误的。



      **尤其注意，左闭右开时，nums[mid] < target后面的处理不一定为left = mid + 1**
      二分查找算法的关键是根据你的问题需求去决定 left 和 right 指针的移动方式，而不是完全依赖于数组是递增还是递减。具体的，这两种情况应该这样理解：
left = mid + 1：这意味着你可以确认索引在 mid 及其左边的元素都不是你在查找的目标。例如，在一个递增的数组中查找目标值，如果 mid 的元素小于目标，那么你可以确定目标只可能出现在 mid 的右侧，因此，更新 left = mid + 1。
right = mid：这意味着你可以确认索引在 mid 及其右边的元素都不是你在查找的目标。例如，在一个递减的数组中查找第一个负数，如果 mid 的元素是负数，那么你可以确定所有在 mid 右侧的元素都是负数，你需要继续查找 mid 的左侧，因此，更新 right = mid。
     * 二分查找查找最左边界 ：注意查找范围为[left，right)
     *注意这里是可以化简的，
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchLeft(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // 注意
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }

        return left;
    }


    /**
     * 二分查找查找最左边界 ：注意查找范围为[left，right]
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchLeftUnite(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1; // 注意
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        return left;
    }


    /**
     * 二分查找查找最右边界 ：注意查找范围为[left，right)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchRight(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // 注意
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                //这里不能收缩，因为右侧为开区间，如果，mid-1的话，那么指针就直接指向3，漏了一个数6    {1,.....,3,6,8}
                right = mid;
            }
        }
        return left;
    }


    /**
     * 二分查找查找最右边界 ：注意查找范围为[left，right]
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchRightUnite(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length-1; // 注意
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                //这里可以收缩边界
                right = mid-1;
            }
        }
        return left;
    }
        
```

### 2.1数组中重复的元素

利用数组下标加上正负判断来操作

## 3.二维数组处理

一维数组寻址地址： loc = loc_init + index*size

假设二维数组 int[][] a = new int[m][n]
二维数组寻址地址： loc = loc_init + (i*m +j)*n

## 4.动态规划解题思路

1. 状态
2. 选择
3. 明确dp函数或者dp数组的定义
4. 明确base case

### 4.1**动态规划特点**

1. 重叠子问题
2. 状态转移方程
3. 最优子结构 题型：求最值 核心：穷举

### 4.2解题套路

1. 明确状态
2. 明确选择
3. 明确DP函数或者DP数组的定义
4. 确定base case

- 设计状态
- 写出状态转移方程
- 设定初始状态
- 执行状态转移
- 返回最终的解

函数的参数，或者数组的索引都是会变的一个状态 利用递归函数进行一个计算，最终做出最优选择

最简单的情况