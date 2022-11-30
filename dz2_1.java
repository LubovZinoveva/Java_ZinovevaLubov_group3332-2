import java.util.HashMap;

/*Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, 
используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки. Если значение null, 
то параметр не должен попадать в запрос. Параметры для фильтрации: 
{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"} */

public class dz2_1 {
    public static void main(String[] args) {
        HashMap<String, String> data = new HashMap<>();
        data.put("name", "Ivanov");
        data.put("country", "Russia");
        data.put("city", "Moscow");
        data.put("age", null);
        System.out.println(createWhere(data));
    }
    public static String createWhere(HashMap<String, String> d){
        StringBuilder sb = new StringBuilder();
        sb.append("where ");
        for (HashMap.Entry<String,String> sample : d.entrySet()) {
            if (sample.getValue() != null)
            {
                sb.append(sample.getKey() + " = " + sample.getValue() + " and ");
            }
         }
         String result = sb.substring(0, sb.length() - 5);
         return result;
    }
}
