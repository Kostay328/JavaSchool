package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharFilter {
    public static void filterFile(String inFileName, String outFileName, String filter) throws IOException {

        try {
            FileReader reader = new FileReader(inFileName);
            FileWriter writer = new FileWriter(outFileName);
            try {
                for (int ch; (ch = reader.read()) >= 0; ) {
                    if (filter.contains(Character.toString((char) ch))) {
                        continue;
                    }
                    writer.write(ch);
                }
            } finally {
                reader.close();
                writer.close();
            }
        } catch (IOException e) {
            throw new IOException(e);
        }
    }
}
