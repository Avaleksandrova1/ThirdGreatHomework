package org.example.loaders;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import lombok.AllArgsConstructor;
import org.example.classes.Visitor;
import org.example.classes.OrderDish;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

@Data
@Slf4j
@AllArgsConstructor
public class VisitorLoaderJson implements JsonDataLoader<String, Visitor> {
    private String pathToFile;

    @Override
    public Map<String, Visitor> load() {
        Map<String, Visitor> visitors = new HashMap<>();
        JSONObject jsonData = this.getJSON(pathToFile);

        if (jsonData == null) {
            return null;
        }

        for (String key : jsonData.keySet()) {
            JSONArray array = jsonData.getJSONArray(key);
            for (Object value : array) {
                JSONObject currentMap = (JSONObject) value;
                Visitor visitor;
                try {
                    visitor = Visitor.builder()
                            .name(((String) currentMap.get("vis_name")))
                            .orderStarted((String) currentMap.get("vis_ord_started"))
                            .orderEnded((String) (currentMap.get("vis_ord_ended")))
                            .orderTotal((Integer) currentMap.get("vis_ord_total"))
                            .build();
                } catch (Exception e) {
                    log.error("Error in file {}. Error message: {}", pathToFile, e.getMessage());
                    return null;
                }

                List<OrderDish> orderDishes = new ArrayList<>();
                JSONArray dishesArray = currentMap.getJSONArray("vis_ord_dishes");
                for (Object dish : dishesArray) {
                    try {
                        JSONObject superDishJSON = (JSONObject) dish;
                        OrderDish orderDish = OrderDish.builder()
                                .orderDishId((Integer) superDishJSON.get("ord_dish_id"))
                                .menuDishId((Integer) superDishJSON.get("menu_dish"))
                                .build();
                        orderDishes.add(orderDish);
                    } catch (Exception e) {
                        log.error("Error in file {}. Error message: {}", pathToFile, e.getMessage());
                        return null;
                    }
                }
                visitor.setOrderDishes(orderDishes);

                visitors.put(visitor.getName(), visitor);
            }
        }
        return visitors;
    }
}
