package me.zoon20x.skyenvoys.Containers.settings;

import lombok.Data;

@Data
public class EnvoyEffects {

    private Boolean lightning;
    private Boolean fallingBlock;
    private Integer dropHeight;

    public EnvoyEffects(Boolean lightning, Boolean fallingBlock, Integer dropHeight){
        this.lightning = lightning;
        this.fallingBlock = fallingBlock;
        this.dropHeight = dropHeight;
    }
    public EnvoyEffects(Boolean lightning, Boolean fallingBlock){
        this.lightning = lightning;
        this.fallingBlock = fallingBlock;
        this.dropHeight = 0;
    }


}
