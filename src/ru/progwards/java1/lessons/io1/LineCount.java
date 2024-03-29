package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LineCount {
    public static int calcEmpty(String fileName){
        int res = 0;
        try{
            FileReader reader = new FileReader(fileName);
            Scanner scanner = new Scanner(reader);
            try {
                while (scanner.hasNextLine()){
                    if (scanner.nextLine().isEmpty()){
                        res++;
                    }
                }
            }finally {
                scanner.close();
            }
        }catch (IOException e){
            return -1;
        }
        return res;
    }
}
