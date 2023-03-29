package org.example.agents;

import lombok.Data;
import org.example.classes.Product;

@Data
public class ProductAgent {
    private Product product;

    public ProductAgent(Product product) {
        this.product = product;
    }

    public void setup() {
    }

    public void deactivation() {
    }

    public void unreserve() {
    }
}
