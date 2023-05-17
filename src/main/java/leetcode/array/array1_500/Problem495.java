package leetcode.array.array1_500;

/**
 * leetcode：提莫攻击
 */
public class Problem495 {
    
    public static void main(String[] args) {
        int[] a = new int[] {1, 2};
        System.out.println(findPoisonedDuration(a, 2));
    }
    
    
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int expire = 0;
        int ans = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (timeSeries[i] >= expire) {
                ans += duration;
            } else {
                ans += timeSeries[i] + duration - expire;
            }
            
            expire = timeSeries[i] + duration;
        }
        
        return ans;
    }
}
