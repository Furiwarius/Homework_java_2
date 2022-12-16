package simple_calculator;

import java.util.Scanner;


public class inputModule {
    public static String inputExpression() {
        System.out.println("exit для завершения программы");
        System.out.println("+ используется для сложения");
        System.out.println("- используется для вычитания");
        System.out.println("* используется для умножения");
        System.out.println("/ используется для деления");
        System.out.println("Пример: 1+3");

        Scanner newInput = new Scanner(System.in);

        System.out.print("Введите выражение: ");
        // isEmpty()
        while (true) {
            if (newInput.hasNextLine()){
                String expression = newInput.nextLine();
                newInput.close();
                return expression;
            }
        }
    }

    public static boolean exitCheck(String str) {
        // если введенная строка "выход" конец программы
        if (str=="exit"){
            return false;
        } 
        else {
            return true;
        }
    }
}
