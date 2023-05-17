//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//
///**
// * @author chezhijun
// * @descririon
// * @date 2022/4/13
// */
//public class Aestest {
//    public static void main(String[] args) {
//        String s = "{\n" +
//                "    \"sb\": {\n" +
//                "        \"consistent\": 3,\n" +
//                "        \"data\": {\n" +
//                "            \"sb\": true\n" +
//                "        }\n" +
//                "    }}";
//        JSONObject parse = (JSONObject) JSONObject.parse(s);
//
//
//        ttt(parse);
//        System.out.println();
//    }
//
//    public static void ttt(JSONObject jsonObject) {
//        JSONObject jsonObject1 = new JSONObject();
//        for (String str : jsonObject.keySet()) {
//            switch (str) {
//                case "s":
//                    jsonObject1.put("hook", jsonObject.getJSONObject("s").getJSONObject("sa").getJSONObject("data")
//                    .getString("sa"));
//                    jsonObject1.put("inject", jsonObject.getJSONObject("s").getJSONObject("sb").getJSONObject
//                    ("data").getString("sa"));
//                    break;
//                default:
//                    jsonObject1.put(str, jsonObject.getString(str));
//                    break;
//            }
//        }
//    }
//
//
//}
