package org.example.agents;

import lombok.Data;
import org.example.classes.Equipment;

@Data
public class EquipmentAgent {
    private Equipment equipment;
    private String dishUniqueName;  // name of dish agent

    public EquipmentAgent(Equipment equipment, String dishUniqueName) {
        this.equipment = equipment;
        this.dishUniqueName = dishUniqueName;
    }

    public void setup() {
    }
}
