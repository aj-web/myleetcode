package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chezhijun
 * @descririon 寻找四数之和
 * TODO 做到这题的时候差不多一个月写题了，郁闷
 * @date 2021/8/19
 */
public class Problem18 {
    public static void main(String[] args) {
        int[] a = new int[]{2,2,2,2,2};
        fourSum1(a, 8).stream().forEach(x -> {
            System.out.println(x);
        });
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length < 4) {
            return result;
        }

        if (nums.length == 4) {
            if (nums[0] + nums[1] + nums[2] + nums[3] == target) {
                result.add(Arrays.asList(nums[0], nums[1], nums[2], nums[3]));
            }
            return result;
        }

        Arrays.sort(nums);
        int leftjudge = 0;
        int righrjudge = 0;


        for (int i = 0; i < nums.length - 1; i++) {

            jump:
            for (int j = nums.length - 1; j > 0; j--) {

                int p1 = i;
                int p2 = i + 1;
                int p3 = j - 1;
                int p4 = j;

                while (p2 < p3) {

                    leftjudge = nums[p2];
                    righrjudge = nums[p3];

                    if (nums[p1] + nums[p2] + nums[p3] + nums[p4] == target) {
                        result.add(Arrays.asList(nums[p1], nums[p2], nums[p3], nums[p4]));


                        p2++;
                        p3--;

                        if (p2 >= p3) {
                            break;
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

                    } else if (nums[p1] + nums[p2] + nums[p3] + nums[p4] > target) {
                        p3--;
                        if (p3 == p2) {
                            break;
                        }
                    } else if (nums[p1] + nums[p2] + nums[p3] + nums[p4] < target) {
                        p2++;
                        if (p2 == p3) {
                            break;
                        }
                    }
                }

                if (nums[p1] == nums[p2] && nums[p3] == nums[p4] && nums[p2] == nums[p3]) {
                    return result;
                }
                //这里
                if (nums[p1] + leftjudge + righrjudge + nums[p4] <= target) {
                    break jump;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }

        if (nums.length == 4) {
            if (nums[0] + nums[1] + nums[2] + nums[3] == target) {
                result.add(Arrays.asList(nums[0], nums[1], nums[2], nums[3]));
            }
            return result;
        }

        Arrays.sort(nums);


        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length - 2; j++) {
                int p1 = i;
                int p2 = j;
                int p3 = j + 1;
                int p4 = nums.length - 1;


                while (p3 < p4) {
                    if (nums[p1] + nums[p2] + nums[p3] + nums[p4] == target) {
                        result.add(Arrays.asList(nums[p1], nums[p2], nums[p3], nums[p4]));

                        p3++;
                        if (p3 >= p4) {
                            break;
                        }
                        while (nums[p3 - 1] == nums[p3]) {
                            if (p3 + 1 <= p4) {
                                p3++;
                            } else {
                                break ;
                            }
                        }

                    } else if (nums[p1] + nums[p2] + nums[p3] + nums[p4] > target) {
                        p4--;
                        while (nums[p4 + 1] == nums[p4]) {
                            if (p3 < p4 - 1) {
                                p4--;
                            } else {
                                break ;
                            }
                        }
                    } else {
                        p3++;
                        while (nums[p3 - 1] == nums[p3]) {
                            if (p3 + 1 < p4) {
                                p3++;
                            } else {
                                break ;
                            }
                        }
                    }


                }

                if (nums[p1] == nums[p2] && nums[p3] == nums[p4] && nums[p2] == nums[p3]) {
                    return result;
                }


            }
        }

        return result;
    }
}
