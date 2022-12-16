/*
 * Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
 */

import java.util.logging.*;
import java.io.IOException;



public class homework_006 {
    public static void main(String[] args) throws IOException {
        int[] newArray = arrayGenerator();
        printArray(newArray);
        bubbleSorted(newArray);
        printArray(newArray);
    }


    public static void bubbleSorted(int[] array)  throws IOException{
        Logger logger = Logger.getLogger(homework_006.class.getName());
        logger.setLevel(Level.INFO);
        FileHandler consolLogger = new FileHandler("log.xml");
        logger.addHandler(consolLogger);
        XMLFormatter xml = new XMLFormatter();
        consolLogger.setFormatter(xml);

        boolean swapped = true;
        int buffer;
        while (swapped) {
            swapped = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i-1]>array[i]) {
                    buffer = array[i];
                    array[i] = array[i-1];
                    array[i-1] = buffer;
                    swapped = true;
                    logger.info("Element "+array[i]+" moved to position "+i);
                }
                else {
                    logger.info("Loop iteration passed without change");
                }
            }
        }
    }


    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }


    public static int[] arrayGenerator() {
        int[] randomArray = new int[10];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = (int) (Math.random()*50)+1;    
        }
        return randomArray;
    }
}
