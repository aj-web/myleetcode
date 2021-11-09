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