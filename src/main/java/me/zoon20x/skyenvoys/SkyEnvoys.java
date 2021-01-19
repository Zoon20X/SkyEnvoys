package me.zoon20x.skyenvoys;

import me.zoon20x.skyenvoys.utils.UtilsCollector;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class SkyEnvoys extends JavaPlugin {

    private static Plugin instance;
    private static SkyEnvoys skyEnvoys;
    private static File EnvoyTypesFolder;
    private static File SettingsFolder;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        skyEnvoys = this;
        this.saveDefaultConfig();
        UtilsCollector.RunPlugin();
        EnvoyTypesFolder = new File(getDataFolder(), "EnvoyTypes");
        EnvoyTypesFolder.mkdirs();
        SettingsFolder = new File(getDataFolder(), "Settings");
        SettingsFolder.mkdirs();

        this.saveConfig();
        System.out.println(ChatColor.WHITE + "=============================");
        System.out.println(ChatColor.AQUA + "SkyEnvoys Plugin");
        System.out.println(ChatColor.AQUA + "Developer: Zoon20X");
        System.out.println(ChatColor.AQUA + "Version: " + this.getDescription().getVersion());
        System.out.println(ChatColor.AQUA + "MC-Compatible: 1.8-1.16.5");
        System.out.println(ChatColor.WHITE + "Enabled");
        System.out.println(ChatColor.WHITE + "=============================");

    }

    public static Plugin getInstance(){
        return instance;
    }
    public static SkyEnvoys getSkyEnvoys(){
        return skyEnvoys;
    }
    public static File getEnvoyTypesFolder(){
        return EnvoyTypesFolder;
    }
    public static File getSettingsFolder(){
        return SettingsFolder;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
