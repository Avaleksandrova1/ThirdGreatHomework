package org.example.classes;

import lombok.Data;
import lombok.Builder;
import org.json.JSONObject;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationType {
    private int id;
    private String name;

    public JSONObject toJSON() {
        return new JSONObject()
                .put("operation_type_id", id)
                .put("operation_type_name", name);
    }
}

