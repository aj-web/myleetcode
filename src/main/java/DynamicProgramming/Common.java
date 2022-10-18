package DynamicProgramming;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : chezj
 * @date : 2022/10/14 11:34 1.求字符串的子串 2.求字符串的子序列
 */
public class Common {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Common p = new Common();
        p.getSubSequence("123");
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    /**
     * 求出所有子序列
     *
     * @param s
     */
    public ArrayList<ArrayList<String>> getSubSequence(String s) {
        ArrayList<ArrayList<String>> allList = new ArrayList<>();
        int size = 1 << s.length();
        for (int i = 1; i < size; i++) {
            ArrayList<String> aList = new ArrayList<>();
            for (int j = 0; j < s.length(); j++) {
                /* 重要：这句是最重要的代码:是 0-7 分别与运算 1，2，4
                 * 000 001 010 011 100 101 110 111
                 *
                 */
                if ((i & (1 << j)) != 0) {
                    aList.add(String.valueOf(s.charAt(j)));
                }
            }
            allList.add(aList);
        }
        System.out.println(allList);
        return allList;
    }
    
    
    /**
     * 所有子串
     *
     * @param s
     */
    public void getSubCharacter(String s) {
        for (int i = 0; i <= s.length(); i++) {
            for (int k = 0; k < i; k++) {
                System.out.println(s.substring(k, i));
            }
        }
    }
    
    
    /**
     * 求出字符串的全排列 ："abc"的全排列是：abc、acb、bac、bca、cab、cba
     *
     * @param str
     * @param result
     */
    public void permutation(String str, String result) {
                /* 全排列 递归实现
                          递归树：
          str:          a            b                c
                      ab ac         ba   bc         ca   cb
        result:        abc acb        bac    bca      cab   cba
         */
        
        // 当result长度等于长度，说明已经遍历到叶子节点，直接打印
        if (result.length() == str.length()) { // 表示遍历完了一个全排列结果
            System.out.println(result);
        } else {
            for (int i = 0; i < str.length(); i++) {
                // 判断result中没有 a、b、c
                if (result.indexOf(str.charAt(i)) < 0) {
                    permutation(str, result + str.charAt(i));
                }
            }
        }
    }
    
    /**
     * 获取所有子序列的全排列 ab:a b ab ba
     *
     * @param str
     */
    public List<String> combination(String str) {
        ArrayList<String> allList = new ArrayList<>();
        int size = 1 << str.length();// 2^n次方
        for (int mark = 0; mark < size; mark++) {
            ArrayList<String> aList = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                /* 重要：这句是最重要的代码:是 0-7 分别与运算 1，2，4
                 * 000 001 010 011 100 101 110 111
                 *
                 */
                if ((mark & (1 << i)) != 0) {
                    aList.add(str.charAt(i) + "");
                }
            }
            allList.add(String.join("", aList));
        }
        //allList.forEach((item)->{System.out.println(item);});
        return allList;
    }
}
