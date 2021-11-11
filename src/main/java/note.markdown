# 笔记

### 1.二分查找

```
/**
* 这里的取中位数采用优化写法，取中位数低位
* 对应的循环中，中位数移动使用left = mid +1
* 
**/
while (left<right){
    int mid = left + (right-left)/2;
    if (nums[mid]>target){
        right = mid;
    }else if (nums[mid]<target){
        left = mid +1;
    }else {
        return mid;
    }
}
```

```
/**
* 这里的取中位数采用优化写法，取中位数低位
* 对应的循环中，中位数移动使用right = mid -1
*
**/
while (left<right){
    int mid = left + (right-left)/2+1;
    if (nums[mid]>target){
        right = mid -1;
    }else if (nums[mid]<target){
        left = mid ;
    }else {
        return mid;
    }
}

```


有序数组去重
给定一个有序数组，数组中有正数、负数或者0，对数组中所有的数求平方后问有多少个不同的值
