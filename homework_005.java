/*
 * Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки.
 * Если значение null, то параметр не должен попадать в запрос.
 * Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 * homework_005
*/
 public class homework_005 {
    public static void main(String[] args) {
        StringBuilder request = new StringBuilder("select * from students where ");
        String rightPart = rightRequest();
        if (rightPart!="null"){
            request.append(rightPart);
        }
        else {
            request.replace(request.indexOf("where"), request.length(), "");
        }
        System.out.println(request);
    }   
    
    public static String rightRequest() {
        int index = (int) (Math.random()*4);
        String[] request = new String[] {"Ivanov", "Russia", "Moscow", "null"};
        return request[index];
    }
    
 }