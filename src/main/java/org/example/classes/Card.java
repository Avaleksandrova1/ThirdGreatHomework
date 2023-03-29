package org.example.classes;

import lombok.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private int id;
    private String dishName;
    private String description;
    private double time;
    private List<CardOperation> cardOperations;

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("card_id", id);
        jsonObject.put("dish_name", dishName);
        jsonObject.put("card_descr", description);
        jsonObject.put("card_time", time);
        jsonObject.put("operations", cardOperations);
        JSONArray jsonArray = new JSONArray();
        for (CardOperation cardOperation : cardOperations) {
            jsonArray.put(cardOperation.toJson());
        }
        return jsonObject;
    }

}