package org.example.helpers;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileLoader {
    private FileLoader() {
        throw new RuntimeException("Cannot create instance of this class");
    }

    public static File getFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new RuntimeException("File not found");
        }
        return file;
    }

    public static JSONObject getJSON(String pathToFile) {
        JSONObject jsonData;
        try {
            String line = new String(Files.readAllBytes(getFile(pathToFile).toPath()));
            line = line.replace("\t", "\n").replace("\n", "");
            if (line.isEmpty()) {
                throw new RuntimeException("File is empty");
            }
            jsonData = new JSONObject(line);
        } catch (IOException | RuntimeException e) {
            System.out.printf("Error %s in file %s. Error message: %s\n", e, pathToFile, e.getMessage());
            return null;
        }
        return jsonData;
    }
}
