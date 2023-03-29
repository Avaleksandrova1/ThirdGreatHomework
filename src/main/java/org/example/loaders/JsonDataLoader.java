package org.example.loaders;

import org.example.helpers.FileLoader;
import org.json.JSONObject;

import java.io.File;
import java.util.Map;
import java.nio.file.Files;
import java.io.IOException;

public interface JsonDataLoader<K, T> {
    Map<K, T> load();

    default JSONObject getJSON(String pathToFile) {
        return FileLoader.getJSON(pathToFile);
    }
}
