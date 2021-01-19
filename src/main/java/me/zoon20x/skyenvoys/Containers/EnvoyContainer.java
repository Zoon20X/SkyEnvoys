package me.zoon20x.skyenvoys.Containers;

import me.zoon20x.skyenvoys.Containers.settings.EnvoyEffects;
import me.zoon20x.skyenvoys.Containers.settings.EnvoyEvents;
import me.zoon20x.skyenvoys.Containers.settings.EnvoyMessages;
import me.zoon20x.skyenvoys.Containers.settings.EnvoyTime;
import org.bukkit.Location;

import java.util.ArrayList;

public class EnvoyContainer implements EnvoysSetup{

    private String name;
    private ArrayList<Location> locations;
    private EnvoyEffects effects;
    private EnvoyMessages messages;
    private EnvoyTime time;
    private EnvoyEvents events;

    public EnvoyContainer(String name, ArrayList<Location> locations, EnvoyEffects effects, EnvoyMessages messages, EnvoyTime time, EnvoyEvents events){
        this.name = name;
        this.locations = locations;
        this.effects = effects;
        this.messages = messages;
        this.time = time;
        this.events = events;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ArrayList<Location> getLocations() {
        return locations;
    }

    @Override
    public EnvoyEffects getEffects() {
        return effects;
    }

    @Override
    public EnvoyMessages getMessages() {
        return messages;
    }

    @Override
    public EnvoyTime getTime() {
        return time;
    }

    @Override
    public EnvoyEvents getEvents() {
        return events;
    }

    @Override
    @Deprecated
    public void setEffects(EnvoyEffects effects) {
        this.effects = effects;
    }

    @Override
    @Deprecated
    public void setMessages(EnvoyMessages messages) {
        this.messages = messages;
    }

    @Override
    @Deprecated
    public void setTime(EnvoyTime time) {
        this.time = time;
    }

    @Override
    @Deprecated
    public void setEvents(EnvoyEvents events) {
        this.events = events;
    }


}
