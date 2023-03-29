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
public class Dish {
    private int id;
    private double price;
    private boolean isActive;
    private int cardId;

    public JSONObject toJSON() {
        return new JSONObject()
                .put("menu_dish_id", id)
                .put("menu_dish_card", cardId)
                .put("menu_dish_price", price)
                .put("menu_dish_active", isActive);
    }
}
