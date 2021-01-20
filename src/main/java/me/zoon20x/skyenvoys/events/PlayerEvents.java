package me.zoon20x.skyenvoys.events;

import me.zoon20x.skyenvoys.Containers.settings.EnvoyEvents;
import me.zoon20x.skyenvoys.SkyEnvoys;
import me.zoon20x.skyenvoys.events.CustomEvents.EnvoySummonEvent;
import me.zoon20x.skyenvoys.events.CustomEvents.SkyEnvoyTrigger;
import me.zoon20x.skyenvoys.utils.EnvoyList;
import me.zoon20x.skyenvoys.utils.EnvoySpawnReason;
import me.zoon20x.skyenvoys.utils.MessagesUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerEvents implements Listener {
    private SkyEnvoys envoys;

    public PlayerEvents(SkyEnvoys envoys){
        this.envoys = envoys;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        SkyEnvoyTrigger.triggerEnvoySummonEvent(EnvoyList.getEnvoy("Default"), EnvoySpawnReason.PLUGIN, "SkyEnvoys");
    }


    @EventHandler
    public void onEnvoySpawnEvent(EnvoySummonEvent event){
        System.out.println(event.getPlugin());
        System.out.println(event.getEnvoy().getName());
        System.out.println(event.getEnvoy().getTime().getSummonTime());
        System.out.println(event.getEnvoy().getTime().getFinishTime());
        Bukkit.broadcastMessage(MessagesUtil.basicColor(event.getEnvoy().getMessages().getSummon().replace("{envoy_name}", event.getEnvoy().getName())));
        System.out.println(MessagesUtil.basicColor(event.getEnvoy().getEvents().getState().toString()));
    }
}
