package org.example.agents;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
public class WarehouseAgent {
    private List<String> productsAgentsNames;
    private HashMap<String, Double> availableProducts;

    public WarehouseAgent() {
        this.productsAgentsNames = new ArrayList<>();
        this.availableProducts = new HashMap<>();
    }

    public void setup() {}

    public void addProductAgent(String productAgentName) {
        productsAgentsNames.add(productAgentName);
    }


    /**
     * Add product to warehouse
     * @param productName name of product
     * @param amount amount of product
     */
    public void addProduct(String productName, double amount) {
        if (availableProducts.containsKey(productName)) {
            amount += availableProducts.get(productName);
        }
        availableProducts.put(productName, amount);
    }

    /**
     * Check if there is enough products in warehouse
     * @param productName name of product
     * @param amount amount of product
     * @return true if there is enough products, otherwise false
     */
    private boolean isEnoughProducts(String productName, double amount) {
        if (availableProducts.containsKey(productName)) {
            if (availableProducts.get(productName) >= amount) {
                return true;
            }
        }
        return false;
    }

    /**
     * Reserve products from warehouse
     * @param productName name of product
     * @param amount amount of product
     * @return null if there is not enough products, otherwise return name of product agent
     */
    private String reserveProducts(String productName, double amount) {
        return null;
    }


}
