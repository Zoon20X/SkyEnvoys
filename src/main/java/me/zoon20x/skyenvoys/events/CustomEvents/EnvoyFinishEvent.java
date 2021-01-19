package me.zoon20x.skyenvoys.events.CustomEvents;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class EnvoyFinishEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();


    public EnvoyFinishEvent(){

    }


    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }
}
