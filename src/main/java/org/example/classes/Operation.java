package org.example.classes;

import lombok.Data;
import lombok.Builder;
import org.json.JSONObject;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/*
 *
 * 10. Агент-операция - создается в процессе приготовления блюда
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Operation {
    private int id;
    private int process;
    private int card;
    private String started;
    private String ended;
    private int equipId;
    private int cookerId;
    private boolean isActive;

    public JSONObject toJSON() {
        return new JSONObject()
                .put("oper_id", id)
                .put("oper_proc", process)
                .put("oper_card", card)
                .put("oper_started", started)
                .put("oper_ended", ended)
                .put("oper_equip_id", equipId)
                .put("oper_coocker_id", cookerId)
                .put("oper_active", isActive);
    }
}