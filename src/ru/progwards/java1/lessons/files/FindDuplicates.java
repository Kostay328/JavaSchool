package ru.progwards.java1.lessons.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDuplicates {
    public List<List<String>> findDuplicates(String startPath) {
        List<List<String>> res = new ArrayList<>();
        List<FileData> fdl = new ArrayList<>();
    try {
        Files.walkFileTree(Paths.get(startPath), new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                File fileStr = new File(file.toString());
                if (fileStr.isFile()) {
                    FileData fileData = new FileData();
                    fileData.name = file.getFileName().toString();
                    fileData.lastModified = fileStr.lastModified();
                    fileData.length = fileStr.length();
                    fileData.file = fileStr;
                    fileData.path = file.toAbsolutePath();
                    fileData.pathList.add(file.toAbsolutePath().toString());
                    fdl.add(fileData);
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                return FileVisitResult.CONTINUE;
            }
        });
    }catch (IOException e){}

        for (int i = 0; i < fdl.size(); i++) {
            for (int j = i + 1; j < fdl.size(); ) {
                if (compareFileData(fdl.get(i), fdl.get(j))) {
                    fdl.get(i).pathList.add(fdl.get(j).path.toString());
                    fdl.remove(j);
                    continue;
                }
                j++;
            }
        }

        for (FileData fd : fdl) {
            if (fd.pathList.size() > 1)
                res.add(fd.pathList);
        }
        return res;
    }

    private boolean compareFileData(FileData fd1, FileData fd2) {
        if (!fd1.name.equals(fd2.name) || fd1.length != fd2.length || fd1.lastModified != fd2.lastModified)
            return false;

        try {
            return Arrays.equals(Files.readAllBytes(fd1.path), Files.readAllBytes(fd2.path));
        }catch (IOException e) {
            return false;
        }
    }
}
class FileData {
    String name;
    long lastModified;
    long length;
    File file;
    Path path;
    List<String> pathList = new ArrayList<>();
}
