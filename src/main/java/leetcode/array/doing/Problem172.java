package leetcode.array.doing;

/**
 * 阶乘后的零 @TODO
 *
 * @author : chezj
 * @date : 2022/8/28 20:04
 */
public class Problem172 {

    public int trailingZeroes(int n) {
        int res = 0;
        for (int i = n; i / 5 > 0; i = i / 5) {
            res += i / 5;
        }
        return res;
    }
}
