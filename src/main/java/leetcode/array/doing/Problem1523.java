package leetcode.array.doing;

/**
 * @author : chezj
 * @date : 2022/8/15 9:45
 * description:leetcode:1523. 在区间范围内统计奇数数目
 */
public class Problem1523 {
    public static void main(String[] args) {

        System.out.println(countOdds(21, 22));
    }

    public static int countOdds(int low, int high) {
        int i = low % 2;
        int j = high % 2;

        if (i!=0){
            return (high-low)/2+1;
        }else if (j == 0){
            return (high-low)/2;
        }else{
            return (high-low)/2+1;
        }
    }
}
