package org.example.classes;

import lombok.Data;
import org.json.JSONArray;
import org.json.JSONObject;
import lombok.AllArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
public class Menu {
    private Map<Integer, Dish> dishes;

    public JSONObject toJSON() {
        JSONArray jsonArray = new JSONArray();
        for (Map.Entry<Integer, Dish> entry : dishes.entrySet()) {
            jsonArray.put(entry.getValue().toJSON());
        }
        return new JSONObject().put("dishes", jsonArray);
    }
}