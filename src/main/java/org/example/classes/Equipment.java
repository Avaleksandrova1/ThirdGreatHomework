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
public class Equipment {
    private int id; // нововведения в json
    private int type;
    private String name;
    private boolean isActive;

    public JSONObject toJSON() {
        return new JSONObject()
                .put("equip_id", id)
                .put("equip_type", type)
                .put("equip_name", name)
                .put("equip_active", isActive);
    }
}
