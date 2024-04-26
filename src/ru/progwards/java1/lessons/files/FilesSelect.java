package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FilesSelect {
    public void selectFiles(String inFolder, String outFolder, List<String> keys) {
        Path inPath = Paths.get(inFolder);
        if (!Files.exists(inPath)) {
            return;
        }

        Path outPath = Paths.get(outFolder);
        if (!Files.exists(outPath)) {
            try {
                Files.createDirectory(outPath);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        try {
            Files.walk(inPath)
                    .filter(path -> path.toString().endsWith(".txt"))
                    .forEach(path -> {
                        try {
                            String content = new String(Files.readAllBytes(path));

                            for (String key : keys) {
                                if (content.contains(key)) {

                                    Path subFolderPath = outPath.resolve(key);
                                    if (!Files.exists(subFolderPath)) {
                                        Files.createDirectory(subFolderPath);
                                    }

                                    Path targetPath = subFolderPath.resolve(path.getFileName());
                                    Files.copy(path, targetPath);
                                    System.out.println("Файл " + path + " скопирован в " + targetPath);
                                    break;
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}