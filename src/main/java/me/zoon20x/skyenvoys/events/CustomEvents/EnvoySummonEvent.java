package me.zoon20x.skyenvoys.events.CustomEvents;

import me.zoon20x.skyenvoys.Containers.EnvoyContainer;
import me.zoon20x.skyenvoys.utils.EnvoySpawnReason;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.Nullable;


public class EnvoySummonEvent extends Event implements Cancellable {
    private static final HandlerList HANDLERS = new HandlerList();
    private final EnvoyContainer envoy;
    private final EnvoySpawnReason reason;
    private Player player;
    private String plugin;
    private Boolean isCancelled;


    public EnvoySummonEvent(EnvoyContainer envoy, EnvoySpawnReason reason){
        this.envoy = envoy;
        this.reason = reason;
        this.isCancelled = false;

    }
    public EnvoySummonEvent(EnvoyContainer envoy,EnvoySpawnReason reason, Player player){
        this.envoy = envoy;
        this.reason = reason;
        this.player = player;
        this.isCancelled = false;

    }
    public EnvoySummonEvent(EnvoyContainer envoy,EnvoySpawnReason reason, String plugin){
        this.envoy = envoy;
        this.reason = reason;
        this.plugin = plugin;
        this.isCancelled = false;

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

    public EnvoyContainer getEnvoy() {
        return envoy;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.isCancelled = cancel;
    }
}
