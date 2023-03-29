package org.example.agents;

import lombok.Data;
import org.example.constants.AgentNamesConstants;

import java.util.List;

@Data
public class DishAgent {
    private String name;
    private String visitorName;
    private String dishOrder;
    private List<String> processesNames;  // request DEACTIVATE_PROCESS_NAME + processesNames[i]
    private List<String> operationsNames;
    private List<String> productsNames;
    boolean isReady;

    public DishAgent(String visitorName, String dishOrder, List<String> processes, List<String> operations, List<String> products) {
        this.name = AgentNamesConstants.DISH_AGENT_START_NAME + visitorName + "_" + dishOrder;
        this.visitorName = visitorName;
        this.dishOrder = dishOrder;
        this.processesNames = processes;
        this.operationsNames = operations;
        this.productsNames = products;
        this.isReady = false;
    }

    public void setup() {
    }

    private void deactivateProcess(String processName) {
    }

    private void deactivateOperation(String operationName) {
    }

    private void deactivateProduct(String productName) {
    }

    private void deactivateMyself() {
    }

}
