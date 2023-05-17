package leetcode.array.doing;

/**
 * @author : chezj
 * @date : 2022/10/7 22:21
 */
public class Problem1784 {
    
    public boolean checkOnesSegment(String s) {
        
        String[] split = s.split("0");
        return split.length == 1;
        
    }
}
