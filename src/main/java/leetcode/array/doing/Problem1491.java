package leetcode.array.doing;

import java.util.Arrays;

/**
 * @author : chezj
 * @date : 2022/8/15 10:40
 */
public class Problem1491 {
    public static void main(String[] args) {
        int[] p =new int[]{4000,3000,1000,2000};
        System.out.println(average1(p));

    }


    public static double average(int[] salary) {
        return (double) Arrays.stream(salary).sorted().skip(1).limit(salary.length-2).sum()/(salary.length-2);
    }

    public static double average1(int[] salary) {
        Arrays.sort(salary);
        int count = 0;
        int index = 1;
        while (index< salary.length-1){
            count+=salary[index];
            index++;
        }
        return (double) count/ (salary.length-2);
    }
}
