package me.zoon20x.skyenvoys.events.CustomEvents;

import me.zoon20x.skyenvoys.Containers.EnvoyContainer;
import me.zoon20x.skyenvoys.SkyEnvoys;
import me.zoon20x.skyenvoys.utils.EnvoySpawnReason;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class SkyEnvoyTrigger {


    public static void triggerEnvoySummonEvent(EnvoyContainer envoy, EnvoySpawnReason reason){
        new BukkitRunnable() {
            @Override
            public void run() {
                EnvoySummonEvent envoySummonEvent = new EnvoySummonEvent(envoy, reason);
                Bukkit.getPluginManager().callEvent(envoySummonEvent);
                if(!envoySummonEvent.isCancelled()){

                }
            }
        }.runTask(SkyEnvoys.getInstance());
    }
    public static void triggerEnvoySummonEvent(EnvoyContainer envoy, EnvoySpawnReason reason, Player player){
        new BukkitRunnable() {
            @Override
            public void run() {
                EnvoySummonEvent envoySummonEvent = new EnvoySummonEvent(envoy, reason, player);
                Bukkit.getPluginManager().callEvent(envoySummonEvent);
            }
        }.runTask(SkyEnvoys.getInstance());
    }
    public static void triggerEnvoySummonEvent(EnvoyContainer envoy, EnvoySpawnReason reason, String plugin){
        new BukkitRunnable() {
            @Override
            public void run() {
                EnvoySummonEvent envoySummonEvent = new EnvoySummonEvent(envoy, reason, plugin);
                Bukkit.getPluginManager().callEvent(envoySummonEvent);
            }
        }.runTask(SkyEnvoys.getInstance());
    }
}
