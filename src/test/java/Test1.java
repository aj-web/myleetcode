import java.util.regex.Pattern;

public class Test1 {
    
    public static void main(String[] args) {
        boolean matches = Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$", "2022-09-08");
        
        String s = "\"Column column = record.getColumn(1);\\n\" +\n"
                + "                \" String oriValue = column.asString();\\n\" +\n"
                + "                \" String newValue = oriValue.substring(0, 3);\\n\" +\n"
                + "                \" record.setColumn(1, new StringColumn(newValue));\\n\" +\n"
                + "                \" return record;\"";
        
        String s1 = "record.setColumn(1, new StringColumn(\"xxx\"))";
        System.out.println(matches);
    }
}
