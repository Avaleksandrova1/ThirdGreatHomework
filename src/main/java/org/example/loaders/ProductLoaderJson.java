package org.example.loaders;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import lombok.AllArgsConstructor;
import org.example.classes.Product;

import java.util.Map;
import java.util.HashMap;

@Data
@Slf4j
@AllArgsConstructor
public class ProductLoaderJson implements JsonDataLoader<Integer, Product> {
    private String pathToFile;

    @Override
    public Map<Integer, Product> load() {
        Map<Integer, Product> products = new HashMap<>();
        JSONObject jsonData = this.getJSON(pathToFile);

        if (jsonData == null) {
            return null;
        }

        for (String key : jsonData.keySet()) {
            JSONArray array = jsonData.getJSONArray(key);
            for (Object value : array) {
                JSONObject currentProductLoader = (JSONObject) value;
                Product currentProduct;
                try {
                    currentProduct = Product.builder()
                            .id((Integer) currentProductLoader.get("prod_item_id"))
                            .type((Integer) (currentProductLoader.get("prod_item_type")))
                            .name((String) currentProductLoader.get("prod_item_name"))
                            .company((String) currentProductLoader.get("prod_item_company"))
                            .unit((String) currentProductLoader.get("prod_item_unit"))
                            .quantity((Double.parseDouble(currentProductLoader.get("prod_item_quantity").toString())))
                            .cost((Double.parseDouble(currentProductLoader.get("prod_item_cost").toString())))
                            .delivered((String) currentProductLoader.get("prod_item_delivered"))
                            .validUntil((String) currentProductLoader.get("prod_item_valid_until"))
                            .build();
                } catch (Exception e) {
                    log.error("Error {} in file {}. Error message: {}", e, pathToFile, e.getMessage());
                    return null;
                }
                products.put(currentProduct.getId(), currentProduct);
            }
        }
        return products;
    }
}
