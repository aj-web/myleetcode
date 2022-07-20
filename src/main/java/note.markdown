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



### 1.2左右指针






## 2.二分查找

```
/**
    
    * 二分查找基础班，直接返回mid，查找区间[lefy,right]
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


     当然二分查找基础版也有开区间版本，但是一般都是闭区间
     为了篇幅过长，这里就不写了


     * 二分查找查找最左边界 ：注意查找范围为[left，right)
     *
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

## 3.二维数组处理

一维数组寻址地址： loc = loc_init + index*size

假设二维数组 int[][] a = new int[m][n]
二维数组寻址地址： loc = loc_init + (i*m +j)*n




## 4.动态规划

#### 4.1**动态规划特点**
1. 重叠子问题
2. 状态转移方程
3. 最优子结构
   题型：求最值
   核心：穷举

### 4.2解题套路
1. 明确状态
2. 明确选择
3. 明确DP函数或者DP数组的定义
4. 确定base case