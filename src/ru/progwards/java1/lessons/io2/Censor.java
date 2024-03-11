package ru.progwards.java1.lessons.io2;

import java.io.*;

public class Censor {

    public static void censorFile(String inoutFileName, String[] obscene) throws CensorException {

        try (RandomAccessFile censor = new RandomAccessFile(inoutFileName, "rw")) {

            for (long i = 0; i < censor.length(); ) {
                long currentLinePointer = censor.getFilePointer();
                String currentLine = censor.readLine();
                long nextLinePointer = censor.getFilePointer();

                String[] currLineArr = currentLine.split("[ ,\\-.!\"?#()]");
                for (int j = 0; j < currLineArr.length; j++) {
                    for (String s : obscene) {
                        if (currLineArr[j].equals(s)) {
                            censor.seek(currentLinePointer + currentLine.indexOf(currLineArr[j]));
                            for (int z = 0; z < currLineArr[j].length(); z++) {
                                censor.write('*');
                            }
                        }
                    }
                }
                i = nextLinePointer;
            }
        } catch (Exception e) {
            throw new CensorException(e.getMessage(), inoutFileName);
        }
    }


    static class CensorException extends Exception {
        String message;
        String fileName;

        CensorException(String message, String fileName) {
            super(message);
            this.fileName = fileName;
        }

        @Override
        public String toString() {
            return fileName + ":" + message;
        }
    }

    public static void main(String[] args) {
        String[] obs = {"Java", "Oracle", "Sun", "Microsystems"};
        try {
            censorFile("C:\\rr\\inoutFile.txt", obs);
        } catch (CensorException e) {
            e.printStackTrace();
        }
    }
}
