package org.example.classes;

import lombok.*;
import org.json.JSONObject;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDish {
    private int orderDishId;
    private int menuDishId;

    public JSONObject toJSON() {
        return new JSONObject()
                .put("vis_ord_dish_id", orderDishId)
                .put("vis_menu_dish_id", menuDishId);
    }
}


