package org.example.loaders;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import lombok.AllArgsConstructor;
import org.example.classes.OperationType;

import java.util.Map;
import java.util.HashMap;

@Data
@Slf4j
@AllArgsConstructor
public class OperationTypeLoaderJson implements JsonDataLoader<Integer, OperationType> {
    private String pathToFile;

    @Override
    public Map<Integer, OperationType> load() {
        Map<Integer, OperationType> operationTypes = new HashMap<>();
        JSONObject jsonData = this.getJSON(pathToFile);

        if (jsonData == null) {
            return null;
        }

        for (String key : jsonData.keySet()) {
            JSONArray array = jsonData.getJSONArray(key);
            for (Object value : array) {
                JSONObject currentOperationJson = (JSONObject) value;
                OperationType operationType;
                try {
                    operationType = OperationType.builder()
                            .id((Integer) currentOperationJson.get("oper_type_id"))
                            .name((String) currentOperationJson.get("oper_type_name"))
                            .build();
                } catch (Exception e) {
                    log.error("Error in file {}. Error message: {}", pathToFile, e.getMessage());
                    return null;
                }
                operationTypes.put(operationType.getId(), operationType);
            }
        }
        return operationTypes;
    }
}
