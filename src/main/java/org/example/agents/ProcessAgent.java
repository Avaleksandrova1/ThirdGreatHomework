package org.example.agents;

import lombok.Data;
import org.example.constants.AgentNamesConstants;

@Data
public class ProcessAgent {
    private String name;
    private String timeLeft;

    // TODO

    public ProcessAgent(String visitorName, String dishName, String dishOrder) {
        this.name = AgentNamesConstants.PROCESS_AGENT_START_NAME + visitorName + "_" + dishName + "_" + dishOrder;
        timeLeft = countLeftTime();
    }

    public void setup() {}

    private void sendTimeLeft() {}

    private String getTimeLeft() {
        // TODO
        return timeLeft;
    }

    private String countLeftTime() {
        // TODO
        return timeLeft;
    }



}
