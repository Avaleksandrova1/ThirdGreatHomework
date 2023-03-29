package org.example.loaders;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import lombok.AllArgsConstructor;
import org.example.classes.Equipment;

import java.util.HashMap;
import java.util.Map;

@Data
@Slf4j
@AllArgsConstructor
public class EquipmentLoaderJson implements JsonDataLoader<Integer, Equipment> {
    private String pathToFile;

    @Override
    public Map<Integer, Equipment> load() {
        Map<Integer, Equipment> equipments = new HashMap<>();
        JSONObject jsonData = this.getJSON(pathToFile);

        if (jsonData == null) {
            return null;
        }

        if (jsonData.keySet().size() != 1) {
            log.error("Error in file {}. Wrong JSON format", pathToFile);
            return null;
        }

        for (String key : jsonData.keySet()) {
            JSONArray array = jsonData.getJSONArray(key);
            for (Object value : array) {
                JSONObject currentMap = (JSONObject) value;
                Equipment equipment;
                try {
                    equipment = Equipment.builder()
                            .id((Integer) currentMap.get("equip_id"))
                            .type((Integer) currentMap.get("equip_type"))
                            .name((String) currentMap.get("equip_name"))
                            .isActive((Boolean) currentMap.get("equip_active"))
                            .build();
                } catch (Exception e) {
                    log.error("Error in file {}. Error message: {}", pathToFile, e.getMessage());
                    return null;
                }
                equipments.put(equipment.getType(), equipment);
            }
        }
        return equipments;
    }
}
