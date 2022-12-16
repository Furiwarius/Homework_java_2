/*
 * Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
 * 
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.*;


public class homework_007 {
    public static void main(String[] args) {
        try {
            File file = new File("dict.json");
            InputStreamReader fr = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                System.out.println(parserStr(line));
                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public static StringBuilder parserStr(String str) {
        StringBuilder resultString = new StringBuilder("Студент 1 получил 2 по предмету 3");
        ArrayList<Character> charArray = new ArrayList<Character>();
        for (Character ch : str.toCharArray()) {
            charArray.add(ch);
        }        

        int step;
        for (int i = 0; i < charArray.size(); i++) {
            if (charArray.get(i)=='"') {
                ArrayList<Character> list = new ArrayList<>(charArray.subList(i+1, charArray.subList(i+1, charArray.size()).indexOf('"')+i+1));
                switch (assembly(list).toString()) {
                    case "фамилия":
                        step = charArray.toString().lastIndexOf("1")+3;
                        ArrayList<Character> nameList= new ArrayList<>(charArray.subList(step, charArray.indexOf('"')));

                        resultString.replace(resultString.indexOf("1"), resultString.lastIndexOf("1")+2, assembly(nameList).toString());
                        break;
                    case "оценка":
                        step = charArray.toString().lastIndexOf("2")+3;
                        ArrayList<Character> gradeList= new ArrayList<>(charArray.subList(step, charArray.indexOf('"')));

                        resultString.replace(resultString.indexOf("2"), resultString.lastIndexOf("2")+2, assembly(gradeList).toString());
                        break;
                    
                    case "предмет":
                        step = charArray.toString().lastIndexOf("3")+3;
                        ArrayList<Character> subjectList= new ArrayList<>(charArray.subList(step, charArray.indexOf('"')));

                        resultString.replace(resultString.indexOf("3"), resultString.lastIndexOf("3"), assembly(subjectList).toString());
                        break;
                }   
            }
            System.err.println(resultString);
        }

        return resultString;
    }


    public static StringBuilder assembly(ArrayList<Character> l) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < l.size(); i++) {
        char s = l.get(i);
            if (s!='[' || s!=']' || s!=' ' || s!=',') {
                result.append(s);
            }
        }
        return result;
    }
}
