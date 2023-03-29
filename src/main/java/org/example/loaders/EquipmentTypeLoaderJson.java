package org.example.loaders;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import lombok.AllArgsConstructor;
import org.example.classes.EquipmentType;

import java.util.HashMap;
import java.util.Map;

@Data
@Slf4j
@AllArgsConstructor
public class EquipmentTypeLoaderJson implements JsonDataLoader<Integer, EquipmentType> {
   private String pathToFile;

   @Override
   public Map<Integer, EquipmentType> load() {
        Map<Integer, EquipmentType> equipmentTypes = new HashMap<>();
        JSONObject jsonData = this.getJSON(pathToFile);

        if (jsonData == null) {
            return null;
        }

        for (String key : jsonData.keySet()) {
            JSONArray array = jsonData.getJSONArray(key);
            for (Object value : array) {
                JSONObject currentMap = (JSONObject) value;
                EquipmentType equipmentType;
                try {
                    equipmentType = EquipmentType.builder()
                            .id((Integer) currentMap.get("equip_type_id"))
                            .name((String) currentMap.get("equip_type_name"))
                            .build();
                } catch (Exception e) {
                    log.error("Error in file {}. Error message: {}", pathToFile, e.getMessage());
                    return null;
                }
                equipmentTypes.put(equipmentType.getId(), equipmentType);
            }
        }
        return equipmentTypes;
   }
}
