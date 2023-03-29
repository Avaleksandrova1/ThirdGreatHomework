package org.example.classes;

import lombok.Data;
import org.json.JSONArray;
import org.json.JSONObject;
import lombok.AllArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
public class CardsMenu {
    Map<Integer, Card> cards;

    public JSONObject toJSON() {
        JSONArray jsonArray = new JSONArray();
        for (Map.Entry<Integer, Card> entry : cards.entrySet()) {
            jsonArray.put(entry.getValue().toJSON());
        }
        return new JSONObject().put("cards", jsonArray);
    }
}
