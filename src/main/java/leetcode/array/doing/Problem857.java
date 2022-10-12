package leetcode.array.doing;

/**
 * @author : chezj
 * @TODO
 * @date : 2022/9/11 14:31
 */
public class Problem857 {


    /**
     * 动态规划
     *
     * @param quality
     * @param wage
     * @param k
     * @return
     */
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {

        int m = quality.length, n = quality.length;


        int count = 0;
        for (int i = 1; i < m; i++) {
            int quai = quality[i];
            for (int j = 0; j < i; j++) {
                int quaj = quality[j];

                int c = quai / quaj;

                //以wagej为工资最小值
                int wagi = wage[j] * c;
                //以wagei为工资最小值
                int wagj = quaj / c;
                if (wagi >= wage[i]) {

                }


            }
        }


        return 0L;
    }
}
