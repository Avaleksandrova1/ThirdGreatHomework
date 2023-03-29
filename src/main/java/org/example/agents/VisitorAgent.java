package org.example.agents;

import lombok.Data;
import org.example.classes.Visitor;
import org.example.constants.AgentNamesConstants;

@Data
public class VisitorAgent {
    private String name;
    private Visitor visitor;

    public VisitorAgent(Visitor visitor) {
        this.visitor = visitor;
        name = AgentNamesConstants.VISITOR_AGENT_START_NAME + visitor.getName();
    }

    public void setup() {}

    private void addMenuToOrder() {}

    private void deleteMenuFromOrder() {}

    private void deactivateDish() {}

    private void activateDish() {}

    private void askSupervisorForOrder() {}

    private void cancelOrder() {}

    private void askSupervisorForOrderTimeLeft() {}
}
