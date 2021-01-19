package me.zoon20x.skyenvoys.Containers;

import me.zoon20x.skyenvoys.Containers.settings.EnvoyEffects;
import me.zoon20x.skyenvoys.Containers.settings.EnvoyEvents;
import me.zoon20x.skyenvoys.Containers.settings.EnvoyMessages;
import me.zoon20x.skyenvoys.Containers.settings.EnvoyTime;
import org.bukkit.Location;

import java.util.ArrayList;

public interface EnvoysSetup {

    String getName();
    ArrayList<Location> getLocations();
    EnvoyEffects getEffects();
    EnvoyMessages getMessages();
    EnvoyTime getTime();
    EnvoyEvents getEvents();

    void setEffects(EnvoyEffects effects);
    void setMessages(EnvoyMessages messages);
    void setTime(EnvoyTime time);
    void setEvents(EnvoyEvents events);


}
