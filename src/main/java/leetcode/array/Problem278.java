package leetcode.array;

/**
 * @author chezhijun
 * @descririon 第一个错误的版本
 * @date 2021/11/8
 */
public class Problem278 {
    public static void main(String[] args) {
        System.out.println(1>>1);
        int firstBadVersion = firstBadVersion(5);
        System.out.println(firstBadVersion);
    }

    public static int firstBadVersion(int n) {

        if (isBadVersion(1)){
            return 1;
        }

        int left = 1;
        int right = n ;
        int mid;
        while (left < right) {
            mid = left + (right - left) /2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left =mid+1;
            }
        }

        return left;
    }

    /**
     * @param version
     * @return
     */
    public static boolean isBadVersion(int version) {
        return version == 4 ? true : false;
    }
}
