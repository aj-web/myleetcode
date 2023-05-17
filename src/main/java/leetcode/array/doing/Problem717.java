package leetcode.array.doing;

/**
 * 1比特与2比特字符
 *
 * @author : chezj
 * @date : 2022/8/19 17:04
 */
public class Problem717 {
    
    public static void main(String[] args) {
        System.out.println(isOneBitCharacter(new int[] {1, 1, 1, 0}));
    }
    
    public static boolean isOneBitCharacter(int[] bits) {
        int length = bits.length;
        if (length == 0) {
            return false;
        }
        if (length == 1) {
            return true;
        }
        
        int count = 0;
        
        //题目固定结尾为0
        for (int i = length - 2; i >= 0; i--) {
            if (bits[i] == 0) {
                break;
            }
            if (bits[i] == 1) {
                count++;
            }
        }
        return count % 2 == 0;
        
    }
}
