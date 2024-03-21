package ru.progwards.java1.lessons.sets;

import java.io.FileReader;
import java.util.*;

public class LettersInFile {
    public static String process(String fileName) throws Exception {
        String resultLine = "";
        Set<String> resSet = new TreeSet<>();

        try (FileReader reader = new FileReader(fileName);
             Scanner scanner = new Scanner(reader)) {

            while (scanner.hasNextLine()) {
                String[] split = scanner.nextLine().replaceAll("[^a-zA-Zа-яА-Я]"," ").split("");
                resSet.addAll(Arrays.asList(split));
            }
        }

        for (String s : resSet) {
            resultLine += s;
        }
        return resultLine;
    }

    public static void main(String[] args) {

    }
}
