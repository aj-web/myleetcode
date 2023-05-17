package leetcode.array.doing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 杨辉三角
 *
 * @TODO
 */
public class Problem118 {
    
    public static void main(String[] args) {
    
    }
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        for (int i = 1; i <= numRows; i++) {
            if (i == 0) {
                result.add(Arrays.asList(0));
                continue;
            }
        }
        return result;
        
    }
    
}
