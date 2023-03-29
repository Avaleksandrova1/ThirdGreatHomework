package org.example.classes;

import lombok.Data;
import lombok.Builder;
import org.json.JSONObject;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductType {
    private int id;
    private String name;
    private boolean isFood;

    public JSONObject toJSON() {
        return new JSONObject()
                .put("product_type_id", id)
                .put("product_type_name", name)
                .put("product_type_is_food", isFood);
    }
}
