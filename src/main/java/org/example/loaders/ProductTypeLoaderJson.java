package org.example.loaders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.example.classes.ProductType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

@Data
@Slf4j
@AllArgsConstructor
public class ProductTypeLoaderJson implements JsonDataLoader<Integer, ProductType> {
    private String pathToFile;

    @Override
    public Map<Integer, ProductType> load() {
        Map<Integer, ProductType> productTypes = new HashMap<>();
        JSONObject jsonData = this.getJSON(pathToFile);

        if (jsonData == null) {
            return null;
        }

        for (String key : jsonData.keySet()) {
            JSONArray array = jsonData.getJSONArray(key);
            for (Object value : array) {
                JSONObject currentProductTypeJson = (JSONObject) value;
                ProductType productType;
                try {
                    productType = ProductType.builder()
                            .id((Integer) currentProductTypeJson.get("prod_type_id"))
                            .name((String) currentProductTypeJson.get("prod_type_name"))
                            .isFood((Boolean) currentProductTypeJson.get("prod_is_food"))
                            .build();
                } catch (Exception e) {
                    log.error("Error in file {}. Error message: {}", pathToFile, e.getMessage());
                    return null;
                }
                productTypes.put(productType.getId(), productType);
            }
        }
        return productTypes;
    }
}
