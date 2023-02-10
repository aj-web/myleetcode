package leetcode.array.Array1001_1500;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : chezj
 * @date : 2023/2/10 14:24
 */
public class Problem1233 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem1233 p = new Problem1233();
        System.out.println(p.removeSubfolders(new String[] {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"}));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        result.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            StringBuilder prefix = new StringBuilder(result.get(result.size() - 1)).append("/");
            if (!folder[i].startsWith(prefix.toString())) {
                result.add(folder[i]);
            }
        }
        return result;
    }
}
