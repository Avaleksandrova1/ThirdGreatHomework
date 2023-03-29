package org.example.loaders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.example.classes.Cooker;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

@Data
@Slf4j
@AllArgsConstructor
public class CookerLoaderJson implements JsonDataLoader<Integer, Cooker> {
    private String pathToFile;

    @Override
    public Map<Integer, Cooker> load() {
        JSONObject jsonData = this.getJSON(pathToFile);
        Map<Integer, Cooker> cookers = new HashMap<>();

        if (jsonData == null) {
            return null;
        }

        if (jsonData.keySet().size() != 1) {
            log.error("Error in file {}. Wrong JSON format", pathToFile);
            return null;
        }

        JSONArray array = jsonData.getJSONArray("cookers");
        for (Object value : array) {
            Cooker cooker;
            JSONObject currentMap = (JSONObject) value;
            try {
                cooker = Cooker.builder()
                        .id((Integer) currentMap.get("cook_id"))
                        .name((String) currentMap.get("cook_name"))
                        .isActive((Boolean) currentMap.get("cook_active"))
                        .build();
            } catch (Exception e) {
                log.error("Error in file {}. Error message: {}", pathToFile, e.getMessage());
                return null;
            }
            cookers.put(cooker.getId(), cooker);
        }

        return cookers;
    }

}
