package leetcode.array.Array1_500;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode228：汇总区间
 * AC
 */
public class Problem228 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,4,5,7};
        System.out.println(summaryRanges(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length==0){
            result.add("0");
            return result;
        }
        if (nums.length==1){
            result.add(String.valueOf(nums[0]));
            return result;
        }

        int left =0;
        int right = 1;
        for (; right < nums.length; right++) {
            if (nums[right-1]+1!=nums[right]){
                if (right==left+1){
                    result.add(String.valueOf(nums[left]));
                }else {
                    result.add(nums[left]+"->"+nums[right-1]);
                }
                left=right;
            }
            if (left == nums.length-1){
                result.add(String.valueOf(nums[nums.length-1]) );
            }
            if (right==nums.length-1 && left!=nums.length-1){
                result.add(nums[left]+"->"+nums[right]);
            }
        }
        return result;
    }


    public List<String> summaryRanges1(int[] nums) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            ret.add(temp.toString());
        }
        return ret;
    }
}
