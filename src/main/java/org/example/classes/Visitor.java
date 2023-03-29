package org.example.classes;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.json.JSONObject;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Visitor {
    private String name;
    private String orderStarted;
    private String orderEnded;
    private int orderTotal;
    private List<OrderDish> orderDishes;

    public JSONObject toJSON() {
        return new JSONObject()
                .put("vis_name", name)
                .put("vis_order_started", orderStarted)
                .put("vis_order_ended", orderEnded)
                .put("vis_order_total", orderTotal)
                .put("vis_ord_dishes", orderDishes);
    }
}