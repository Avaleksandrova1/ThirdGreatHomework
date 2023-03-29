package org.example.loaders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.example.classes.Card;
import org.example.classes.CardOperation;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Slf4j
@AllArgsConstructor
public class CardLoaderJson implements JsonDataLoader<Integer, Card> {
    private String pathToFile;

    @Override
    public Map<Integer, Card> load() {
        JSONObject jsonData = this.getJSON(pathToFile);
        Map<Integer, Card> cards = new HashMap<>();

        if (jsonData == null) {
            return null;
        }

        if (jsonData.keySet().size() != 1) {
            log.error("Error in file {}. Wrong JSON format", pathToFile);
            return null;
        }

        JSONArray array = jsonData.getJSONArray("dish_cards");
        for (Object value : array) {
            JSONObject currentCard = (JSONObject) value;
            Card card;
            try {
                card = Card.builder()
                        .id((Integer) currentCard.get("card_id"))
                        .dishName(((String) currentCard.get("dish_name")))
                        .description((String) currentCard.get("card_descr"))
                        .time(Double.parseDouble(currentCard.get("card_time").toString()))
                        .build();
            } catch (Exception e) {
                log.error("Error {} in file {}. Error message: {}", e, pathToFile, e.getMessage());
                return null;
            }

            JSONArray operationsArray = currentCard.getJSONArray("operations");
            List<CardOperation> cardOperations = new ArrayList<>();
            for (Object operation : operationsArray) {
                try {
                    JSONObject cardOperationJSON = (JSONObject) operation;
                    CardOperation cardOperation = CardOperation.builder()
                            .type((Integer) cardOperationJSON.get("oper_type"))
                            .equipType((Integer) cardOperationJSON.get("equip_type"))  // нововведения в json
                            .time((Double.parseDouble(cardOperationJSON.get("oper_time").toString())))
                            .asyncPoint((Integer) cardOperationJSON.get("oper_async_point"))
                            .build();

                    List<Map<String, Number>> operationProducts = new ArrayList<>();
                    JSONArray productsArray = cardOperationJSON.getJSONArray("oper_products");
                    if (productsArray.length() == 0) {
                        log.error("Error in file {}. Wrong JSON format. No products in operation", pathToFile);
                        return null;
                    }
                    for (Object product : productsArray) {
                        JSONObject currentProduct = (JSONObject) product;
                        Map<String, Number> productMap = new HashMap<>();
                        productMap.put("prod_type", (Number) currentProduct.get("prod_type"));
                        productMap.put("prod_quantity", (Number) currentProduct.get("prod_quantity"));
                        operationProducts.add(productMap);
                    }
                    cardOperation.setProductsId(operationProducts);
                    cardOperations.add(cardOperation);
                } catch (Exception e) {
                    log.error("Error {} in file {}. Error message: {}", e, pathToFile, e.getMessage());
                    return null;
                }
            }
            card.setCardOperations(cardOperations);
            cards.put(card.getId(), card);
        }
        return cards;
    }
}
