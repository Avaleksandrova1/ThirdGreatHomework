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
public class Product {
    // Входит в "справочник типов продуктов / расходников"
    private int id;
    private int type;
    private String name;
    private String company;
    private String unit;
    private double quantity;
    private double cost;
    private String delivered;
    private String validUntil;

    public JSONObject toJSON() {
        return new JSONObject()
                .put("prod_item_id", id)
                .put("prod_item_type", type)
                .put("prod_item_name", name)
                .put("prod_item_company", company)
                .put("prod_item_unit", unit)
                .put("prod_item_quantity", quantity)
                .put("prod_item_cost", cost)
                .put("prod_item_delivered", delivered)
                .put("prod_item_valid_until", validUntil);
    }
}