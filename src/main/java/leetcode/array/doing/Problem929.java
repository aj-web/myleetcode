package leetcode.array.doing;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : chezj
 * @date : 2022/9/1 17:57
 */
public class Problem929 {
    
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<String>();
        for (String email : emails) {
            int i = email.indexOf('@');
            String local = email.substring(0, i).split("\\+")[0]; // 去掉本地名第一个加号之后的部分
            local = local.replace(".", ""); // 去掉本地名中所有的句点
            emailSet.add(local + email.substring(i));
        }
        return emailSet.size();
    }
}
