package org.example.agents;

import lombok.Data;
import org.example.constants.AgentNamesConstants;

@Data
public class OrderAgent {
    private String name;

    public OrderAgent(String dishName, String visitorName, String dishOrder) {
        this.name = AgentNamesConstants.ORDER_AGENT_START_NAME + dishName + "_" + visitorName + "_" + dishOrder;
    }

    public void setup() {
    }

    public void sendDishTimeLeft() {
    }

    public void askProcessForTimeLeft() {
    }

    public void reserveProduct() {
    }

    public void unreserveProduct() {
    }
}
