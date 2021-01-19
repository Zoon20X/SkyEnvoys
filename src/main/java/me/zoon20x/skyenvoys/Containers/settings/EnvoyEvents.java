package me.zoon20x.skyenvoys.Containers.settings;

import lombok.Data;
import me.zoon20x.skyenvoys.utils.ChestStates;

@Data
public class EnvoyEvents {

    private Boolean finishMessage;
    private Boolean summonMessage;
    private ChestStates state;

    public EnvoyEvents(Boolean summonMessage, Boolean finishMessage, ChestStates state){
        this.summonMessage = summonMessage;
        this.finishMessage = finishMessage;
        this.state = state;
    }


}
