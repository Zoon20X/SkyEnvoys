package me.zoon20x.skyenvoys.events.CustomEvents;

import com.sun.istack.internal.Nullable;
import me.zoon20x.skyenvoys.utils.EnvoySpawnReason;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class EnvoySummonEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();
    private final EnvoySpawnReason reason;
    private Player player;
    private String plugin;


    public EnvoySummonEvent(EnvoySpawnReason reason){
        this.reason = reason;
    }
    public EnvoySummonEvent(EnvoySpawnReason reason, Player player){
        this.reason = reason;
        this.player = player;

    }
    public EnvoySummonEvent(EnvoySpawnReason reason, String plugin){
        this.reason = reason;
        this.plugin = plugin;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }


    public EnvoySpawnReason getReason() {
        return reason;
    }

    //Please use getReason and check if it is a PLAYER or PLUGIN before running these functions

    //Can return null if a player did not use a item to spawn the envoy even if
    //they used a command, commands are classes as console usage
    @Nullable
    public Player getPlayer() {
        return player;
    }

    //Can return null if a plugin did not trigger the envoy
    @Nullable
    public String getPlugin() {
        return plugin;
    }
}
