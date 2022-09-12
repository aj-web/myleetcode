/**
 * @author : chezj
 * @date : 2022/9/8 11:31
 */
class test {
    static void main(String[] args) {
        /*Date date = new Date();
        if (!match("20220908")){
            print date
        }*/


        /*Column column = record.getColumn(3)
        String oriValue = column.asString();
        Boolean val1 = oriValue ==~ "^\\d{4}-\\d{2}-\\d{2}\$"
        if(!val1){
            Date date = new Date();
            record.setColumn(3, new DateColumn(date))*/
    }


    static Boolean match(String s){
        def reg = ~'^\\d{4}-\\d{2}-\\d{2}\$'
        return s ==~ reg
    }












}
