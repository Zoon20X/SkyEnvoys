package me.zoon20x.skyenvoys.events;

import me.zoon20x.skyenvoys.SkyEnvoys;
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
    }

}
