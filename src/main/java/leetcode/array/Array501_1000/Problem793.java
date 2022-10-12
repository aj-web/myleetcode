package leetcode.array.Array501_1000;

/**
 * @author : chezj
 * @date : 2022/8/28 20:10
 */
public class Problem793 {


    /**
     * 穷举，超时
     *
     * @param k
     * @return
     */
    public int preimageSizeFZF(int k) {
        int res = 0;
        for (int n = 0; n < Integer.MAX_VALUE; n++) {
            if (trailingZeroes(n) < k) {
                continue;
            }
            if (trailingZeroes(n) > k) {
                break;
            }
            if (trailingZeroes(n) == k) {
                res++;
            }
        }
        return res;
    }


    /* 主函数 */
    public int preimageSizeFZF1(int K) {
        // 左边界和右边界之差 + 1 就是答案
        return (int) (right_bound(K) - left_bound(K) + 1);
    }

    /* 搜索 trailingZeroes(n) == K 的左侧边界 */
    long left_bound(int target) {
        long lo = 0, hi = Long.MAX_VALUE;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (trailingZeroes(mid) < target) {
                lo = mid + 1;
            } else if (trailingZeroes(mid) > target) {
                hi = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    /* 搜索 trailingZeroes(n) == K 的右侧边界 */
    long right_bound(int target) {
        long lo = 0, hi = Long.MAX_VALUE;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (trailingZeroes(mid) < target) {
                lo = mid + 1;
            } else if (trailingZeroes(mid) > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo - 1;
    }


    public int trailingZeroes(int n) {
        int res = 0;
        for (int i = n; i / 5 > 0; i = i / 5) {
            res += i / 5;
        }
        return res;
    }


    long trailingZeroes(long n) {
        long res = 0;
        for (long d = n; d / 5 > 0; d = d / 5) {
            res += d / 5;
        }
        return res;
    }
}
