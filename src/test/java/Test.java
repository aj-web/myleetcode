/**
 * @author chezhijun
 * @descririon
 * @date 2022/4/21
 */
public class Test {
    
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder(
                "ALTER TABLE t_employees_alls_12 DROP KEY key_local_row_update_time_t_employees_alls_ ");
        StringBuilder s1 = new StringBuilder("ALTER TABLE t_employees_alls_12  DROP KEY uk_index_t_employees_alls_ ");
        
        for (int i = 0; i < 16; i++) {
            s.append(i).append(";");
            s1.append(i).append(";");
            System.out.println(s);
            System.out.println(s1);
        }
    }
}
