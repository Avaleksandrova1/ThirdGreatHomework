package org.example.agents;

import lombok.Data;
import org.example.classes.Cooker;
import org.example.constants.AgentNamesConstants;

@Data
public class CookerAgent {
    private String name;
    private Cooker cooker;
    private String operationAgentName;

    public CookerAgent(Cooker cooker, String operationAgentName) {
        this.name = AgentNamesConstants.COOKER_AGENT_START_NAME + cooker.getId();
        this.cooker = cooker;
        this.operationAgentName = operationAgentName;
    }

    public void setup() {
    }

    private void activateOperationAgent() {
    }

    private void deactivateOperationAgent() {
    }
}
