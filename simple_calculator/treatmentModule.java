package simple_calculator;

import java.util.Arrays;


public class treatmentModule {
    public static int processing(String exception) {
        // получаем выражение "1*2" как пример
        String[] array = parseExpression(exception); 
        int result = performance(array);

        return result;
    }

    public static String[] parseExpression(String expression) {
        // разбиваем строку на составляющие 
        String[] resultArray = new String[3];

        char[] arrayChar = expression.toCharArray();
        char[] signs = new char[]{'+', '-', '*', '/'};

        for (int i = 0; i < arrayChar.length; i++) {
                for (int j = 0; j < signs.length; j++) {
                    if (arrayChar[i]==signs[j]){
                        resultArray[1]=Character.toString(arrayChar[i]);
                        resultArray[0]= new String(Arrays.copyOfRange(arrayChar, 0, i)); 
                        resultArray[2]= new String(Arrays.copyOfRange(arrayChar, i+1, arrayChar.length));
                    }
                }
        }
        return resultArray;
    }

    public static int performance(String[] array) {
        // рассчитываем в зависимости от знака
        int result = 0;
        switch (array[1]) {
            case "+":
                result=Integer.parseInt(array[0])+Integer.parseInt(array[2]);
                break;
            case "-":
                result=Integer.parseInt(array[0])-Integer.parseInt(array[2]);
                break;
            case "*":
                result=Integer.parseInt(array[0])*Integer.parseInt(array[2]);
                break;
            case "/":
                result=Integer.parseInt(array[0])/Integer.parseInt(array[2]);
                break;
        }
        return result;
    }


}
