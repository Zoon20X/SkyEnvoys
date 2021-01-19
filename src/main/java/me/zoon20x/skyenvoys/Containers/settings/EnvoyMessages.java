package me.zoon20x.skyenvoys.Containers.settings;

import lombok.Data;

@Data
public class EnvoyMessages {

    private String summon;
    private String finish;


    public EnvoyMessages(String summon, String finish){
        this.summon = summon;
        this.finish = finish;
    }


}
