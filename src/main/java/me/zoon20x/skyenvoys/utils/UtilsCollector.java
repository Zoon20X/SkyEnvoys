package me.zoon20x.skyenvoys.utils;

import me.zoon20x.skyenvoys.SkyEnvoys;
import me.zoon20x.skyenvoys.commands.AdminEnvoys;
import me.zoon20x.skyenvoys.events.GUIEvents;
import me.zoon20x.skyenvoys.events.PlayerEvents;
import me.zoon20x.skyenvoys.files.AsyncFileCache;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;

public class UtilsCollector {

    public static void RunPlugin(){
        RunEvents();
        RunCommands(SkyEnvoys.getSkyEnvoys());
        AsyncFileCache.startAsyncCreate();
    }
    public static void RunEvents(){
        SkyEnvoys.getInstance().getServer().getPluginManager().registerEvents(new PlayerEvents(SkyEnvoys.getSkyEnvoys()), SkyEnvoys.getInstance());
        SkyEnvoys.getInstance().getServer().getPluginManager().registerEvents(new GUIEvents(SkyEnvoys.getSkyEnvoys()), SkyEnvoys.getInstance());

    }
    public static void RunCommands(SkyEnvoys skyEnvoys){
        AdminEnvoys adminEnvoys = new AdminEnvoys(skyEnvoys);

    }
    public static void RunConnectedPlugins(){

    }

    //only run if you are creating the envoy within the plugin, this will generate the default files
    //will return a boolean, it returns false if failed, and returns true if it successfully created all files
    public static Boolean runEnvoyCreation(String name){

        File settingsFile = new File(SkyEnvoys.getEnvoyTypesFolder() + "/" + name + "/Settings.yml");
        FileConfiguration settingsConfig = YamlConfiguration.loadConfiguration(settingsFile);
        loadDefaultSettings(name, settingsConfig);
        File itemsFile = new File(SkyEnvoys.getEnvoyTypesFolder() + "/" + name + "/Items.yml");
        FileConfiguration itemsConfig = YamlConfiguration.loadConfiguration(itemsFile);
        File locationsFile = new File(SkyEnvoys.getEnvoyTypesFolder() + "/" + name + "/Locations.yml");
        FileConfiguration locationsConfig = YamlConfiguration.loadConfiguration(locationsFile);
        try {
            settingsConfig.save(settingsFile);
            itemsConfig.save(itemsFile);
            locationsConfig.save(locationsFile);
            AsyncFileCache.LoadEnvoys();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean hasAvailableSlot(Inventory inventory){

        for (ItemStack item: inventory.getContents()) {
            if(item == null) {
                return true;
            }
        }
        return false;
    }

    public static ItemStack createItem(String x, int amount, int data){
        System.out.println(x);
        return new ItemStack(Material.valueOf(x), amount, (short) data);
    }

    private static FileConfiguration loadDefaultSettings(String name, FileConfiguration configuration) {

        System.out.println(MessagesUtil.basicColor("&bSkyEnvoys>> &fLoading Settings data"));
        configuration.set("Name", name);
        configuration.set("EnvoyBlock.Type", "CHEST");
        configuration.set("EnvoyBlock.Data", 0);
        System.out.println(MessagesUtil.basicColor("&bSkyEnvoys>> &fAdding Default Effects"));
        configuration.set("Effects.Lightning", false);
        configuration.set("Effects.FallingBlock.Enabled", false);
        configuration.set("Effects.FallingBlock.DropHeight", 10);
        System.out.println(MessagesUtil.basicColor("&bSkyEnvoys>> &fAdding Default Messages"));
        configuration.set("Message.Summon", "&f{envoy_name} &bhas been summoned");
        configuration.set("Message.Finish", "&f{envoy_name} &bhas finished, next envoy in &f{envoy_time_start}");
        System.out.println(MessagesUtil.basicColor("&bSkyEnvoys>> &fAdding Default Time data"));
        configuration.set("Time.Summon.Enabled", false);
        configuration.set("Time.Summon.Units", "Minutes");
        configuration.set("Time.Summon.Amount", 30);
        configuration.set("Time.Finish.Enabled", false);
        configuration.set("Time.Finish.Units", "Minutes");
        configuration.set("Time.Finish.Amount", 10);
        System.out.println(MessagesUtil.basicColor("&bSkyEnvoys>> &fAdding Default Events"));
        configuration.set("FinishEvent.ChestOption", "LOCK");
        configuration.set("FinishEvent.Message-Enabled", false);
        configuration.set("SummonEvent.Message-Enabled", false);

        return configuration;
    }

}
