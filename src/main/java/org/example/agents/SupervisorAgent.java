package org.example.agents;

import lombok.Data;
import org.example.constants.AgentNamesConstants;

@Data
public class SupervisorAgent {
    private String name;

    public SupervisorAgent(String name) {
        this.name = AgentNamesConstants.SUPERVISOR_AGENT_START_NAME + name;
    }

    public void setup() {
    }

    public void createNewOrderAgent() {
    }

    public void deleteOrderAgent() {
    }

    public void askWarehouseAgentToReserveProduct(String productName, double amount) {
    }
}
