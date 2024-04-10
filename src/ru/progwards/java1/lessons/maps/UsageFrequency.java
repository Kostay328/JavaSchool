package ru.progwards.java1.lessons.maps;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsageFrequency {
    private Map<Character, Integer> letterFrequency = new HashMap<>();
    private Map<String, Integer> wordFrequency = new HashMap<>();

    public void processFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line);
            }
        }catch (Exception e){}
    }

    private void processLine(String line) {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            String word = matcher.group();
            incrementWordFrequency(word);
            for (char c : word.toCharArray()) {
                incrementLetterFrequency(c);
            }
        }
    }

    private void incrementLetterFrequency(char c) {
        letterFrequency.putIfAbsent(c, 0);
        int count = letterFrequency.get(c) + 1;
        letterFrequency.put(c, count);
    }

    private void incrementWordFrequency(String word) {
        wordFrequency.putIfAbsent(word, 0);
        int count = wordFrequency.get(word) + 1;
        wordFrequency.put(word, count);
    }

    public Map<Character, Integer> getLetters() {
        return Collections.unmodifiableMap(letterFrequency);
    }

    public Map<String, Integer> getWords() {
        return Collections.unmodifiableMap(wordFrequency);
    }
}
