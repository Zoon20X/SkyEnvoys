package me.zoon20x.skyenvoys.Containers.settings;

import lombok.Data;

import org.jetbrains.annotations.Nullable;

@Data
public class EnvoyTime {

    private Boolean summonTime;
    private Boolean finishTime;

    private String summonUnits;
    private String finishUnits;

    private Integer summonAmount;
    private Integer finishAmount;

    //Use if both times are different and on
    public EnvoyTime(Boolean summonTime, Boolean finishTime, String summonUnits, String finishUnits, Integer summonAmount, Integer finishAmount){
        this.summonTime = summonTime;
        this.finishTime = finishTime;

        this.summonUnits = summonUnits;
        this.finishUnits = finishUnits;

        this.summonAmount = summonAmount;
        this.finishAmount = finishAmount;
    }
    //Use if both times are the same or only using 1
    public EnvoyTime(Boolean summonTime, Boolean finishTime, String units, Integer amount){
        if(summonTime){
            this.summonTime = true;
            this.summonUnits = units;
            this.summonAmount = amount;
        }
        if(finishTime){
            this.finishTime = true;
            this.finishUnits = units;
            this.finishAmount = amount;
        }
    }

    //Use if you aren't using any form of time
    //if you plan to use time and use this be sure to use the setters to update the values later
    public EnvoyTime() {
        this.summonTime = false;
        this.finishTime = false;

    }


    @Nullable
    public String getSummonUnits() {
        return summonUnits;
    }

    @Nullable
    public String getFinishUnits() {
        return finishUnits;
    }

    @Nullable
    public Integer getSummonAmount() {
        return summonAmount;
    }

    @Nullable
    public Integer getFinishAmount() {
        return finishAmount;
    }


    @Deprecated
    public void setFinishAmount(Integer finishAmount) {
        this.finishAmount = finishAmount;
    }

    @Deprecated
    public void setFinishUnits(String finishUnits) {
        this.finishUnits = finishUnits;
    }

    @Deprecated
    public void setSummonAmount(Integer summonAmount) {
        this.summonAmount = summonAmount;
    }

    @Deprecated
    public void setSummonUnits(String summonUnits) {
        this.summonUnits = summonUnits;
    }
}
