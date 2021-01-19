package me.zoon20x.skyenvoys.utils;

import me.zoon20x.skyenvoys.SkyEnvoys;
import me.zoon20x.skyenvoys.commands.AdminEnvoys;
import me.zoon20x.skyenvoys.events.PlayerEvents;
import me.zoon20x.skyenvoys.files.AsyncFileCache;
import org.bukkit.event.Listener;

public class UtilsCollector {

    public static void RunPlugin(){
        RunEvents();
        RunCommands(SkyEnvoys.getSkyEnvoys());
        AsyncFileCache.startAsyncCreate();
    }
    public static void RunEvents(){
        SkyEnvoys.getInstance().getServer().getPluginManager().registerEvents(new PlayerEvents(SkyEnvoys.getSkyEnvoys()), SkyEnvoys.getInstance());

    }
    public static void RunCommands(SkyEnvoys skyEnvoys){
        AdminEnvoys adminEnvoys = new AdminEnvoys(skyEnvoys);

    }
    public static void RunConnectedPlugins(){

    }


}
