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
public class Cooker {
    private int id;
    private String name;
    private boolean isActive;

    public JSONObject toJSON() {
        return new JSONObject()
                .put("cook_id", id)
                .put("cook_name", name)
                .put("cook_active", isActive);
    }
}