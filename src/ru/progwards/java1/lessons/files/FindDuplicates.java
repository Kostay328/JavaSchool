package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FindDuplicates {
    public List<List<String>> findDuplicates(String startPath) {
        try {
            List<List<String>> duplicates = new ArrayList<>();
            Files.walkFileTree(Paths.get(startPath), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    String filePath = file.toString();
                    String fileName = filePath.substring(startPath.length() + 1); // Получаем имя файла
                    String fileContent = new String(Files.readAllBytes(file));

                    // Проверяем, есть ли уже дубликаты с таким же именем, размером, датой и содержимым
                    for (List<String> duplicate : duplicates) {
                        if (duplicate.get(0).equals(fileName) &&
                                duplicate.get(1).equals(String.valueOf(attrs.size())) &&
                                Objects.equals(fileContent, new String(Files.readAllBytes(Paths.get(duplicate.get(3)))))) {
                            // Если дубликат найден, добавляем текущий путь к списку дубликатов
                            duplicate.add(filePath);
                            return FileVisitResult.CONTINUE;
                        }
                    }

                    // Если дубликат не найден, создаем новый список для хранения информации о дубликате
                    List<String> newDuplicate = new ArrayList<>();
                    duplicates.add(newDuplicate);

                    return FileVisitResult.CONTINUE;
                }
            });
            return duplicates;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
