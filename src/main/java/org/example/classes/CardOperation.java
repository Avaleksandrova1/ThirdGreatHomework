package org.example.classes;

import lombok.Data;
import lombok.Builder;
import org.json.JSONArray;
import org.json.JSONObject;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardOperation {
    private int type;
    private int equipType;
    private double time;
    private int asyncPoint;
    List<Map<String, Number>> productsId;

    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject()
                .put("oper_type", type)
                .put("equip_type", equipType)
                .put("oper_time", time)
                .put("oper_async_point", asyncPoint)
                .put("oper_products", new JSONArray());
        for (Map<String, Number> product : productsId) {
            JSONObject productJson = new JSONObject();
            productJson.put("prod_type", product.get("prod_type"));
            productJson.put("prod_quiantity", product.get("prod_quiantity"));
            jsonObject.append("oper_products", productJson);
        }
        return jsonObject;
    }
}
