package org.example.loaders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.example.classes.Dish;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

@Data
@Slf4j
@AllArgsConstructor
public class MenuDishLoaderJson implements JsonDataLoader<Integer, Dish> {
    private String pathToFile;

    @Override
    public Map<Integer, Dish> load() {
        Dish dish;
        Map<Integer, Dish> menuDishes = new HashMap<>();
        JSONObject jsonData = this.getJSON(pathToFile);

        if (jsonData == null) {
            return null;
        }

        if (jsonData.keySet().size() != 1) {
            log.error("Error in file {}. Wrong JSON format", pathToFile);
            return null;
        }

        JSONArray array = jsonData.getJSONArray("menu_dishes");
        for (Object value : array) {
            JSONObject currentMap = (JSONObject) value;
            if (currentMap.keySet().size() != 4) {
                log.error("Error in file {}. Wrong JSON format", pathToFile);
                return null;
            }
            try {
                dish = Dish.builder()
                        .id((Integer) currentMap.get("menu_dish_id"))
                        .price(Double.parseDouble(currentMap.get("menu_dish_price").toString()))
                        .isActive((Boolean) currentMap.get("menu_dish_active"))
                        .cardId((Integer) currentMap.get("menu_dish_card"))
                        .build();
            } catch (Exception e) {
                log.error("Error in file {}. Error message: {}", pathToFile, e.getMessage());
                return null;
            }
            menuDishes.put(dish.getId(), dish);
        }

        return menuDishes;
    }
}
