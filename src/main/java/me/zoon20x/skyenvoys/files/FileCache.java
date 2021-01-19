package me.zoon20x.skyenvoys.files;


import me.zoon20x.skyenvoys.SkyEnvoys;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.HashMap;

public class FileCache {

    private static HashMap<String, FileConfiguration> cache = new HashMap<>();

    static Plugin plugin = SkyEnvoys.getInstance();


    public static void createFile(File file, FileConfiguration config, String Location, String secLoc, String Name){
        if (file == null) {
            file = new File(plugin.getDataFolder() + Location);
            config = YamlConfiguration.loadConfiguration(file);
            plugin.getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "SkyEnvoys>> Loading Module File " + Name + ".yml");
        }

        if (!file.exists()) {
            plugin.getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "SkyEnvoys>> Creating Module File " + Name + ".yml");
            plugin.saveResource(secLoc, false);
        } else {
            return;
        }
    }


    public static void addFileToCache(String name, FileConfiguration config){
        if(!cache.containsKey(name)){
            if(!cache.containsValue(config)){
                cache.put(name, config);

            }
        }
    }

    public static void clearCache(){
        cache.clear();
    }
    public static FileConfiguration getConfig(String name){
        return cache.get(name);
    }

}
