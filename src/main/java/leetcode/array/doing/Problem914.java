package leetcode.array.doing;

/**卡牌分组
 * @author : chezj
 * @date : 2022/8/31 17:42
 */
public class Problem914 {
    
    public boolean hasGroupsSizeX(int[] deck) {
        int[] cursor = new int[10000];
        
        for (int i : deck) {
            cursor[i]++;
        }
        
        int g = -1;
        for (int i = 0; i < 10000; ++i) {
            if (cursor[i] > 0) {
                if (g == -1) {
                    g = cursor[i];
                } else {
                    g = gcd(g, cursor[i]);
                }
            }
        }
        return g >= 2;
    }
    
    
    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }
    
    
}
