package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chezhijun
 * @descririon 寻找四数之和
 * @date 2021/8/19
 */
public class Problem18 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 0, -1, 0, -2, 2};
        fourSum(a, 0);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length < 4) {
            return result;
        }

        if (nums.length == 4) {
            if (nums[0] + nums[1] + nums[2] + nums[3] == target) {
                result.add(Arrays.asList(nums[0]));
            }
            return result;
        }

        Arrays.sort(nums);
        int leftjudge = 0;
        int righrjudge = 0;


        jump:
        for (int i = 0; i < nums.length - 1; i++) {
            int p1 = i;
            int p2 = i + 1;
            int p3 = nums.length - 2;
            int p4 = nums.length - 1;
            for (int j = nums.length - 1; j > 0; j--) {
                while (p2 < p3) {

                    leftjudge = nums[p2];
                    righrjudge = nums[p3];

                    if (nums[p1] + nums[p2] + nums[p3] + nums[p4] == target) {
                        result.add(Arrays.asList(nums[p1], nums[p2], nums[p3], nums[p4]));


                        p2++;
                        p3--;

                        if (p2>=p3){
                            break ;
                        }
                        if (leftjudge == nums[p2]) {
                            if (p2 + 1 < p3) {
                                p2++;
                            } else {
                                break;
                            }
                        }

                        if (righrjudge == nums[p3]) {
                            if (p3 - 1 > p2) {
                                p3--;
                            } else {
                                break;
                            }
                        }

                        /*if (p2>p3){
                            break ;
                        }*/

                    } else if (nums[p1] + nums[p2] + nums[p3] + nums[p4] > target) {
                        p3--;
                    } else if (nums[p1] + nums[p2] + nums[p3] + nums[p4] < target) {
                        p2++;
                    }
                }

                //这里
                if (nums[p1] + leftjudge + righrjudge + nums[p4] < target) {
                    break jump;
                } else {
                    break;
                }
            }
        }


        return result;
    }
}
