package me.zoon20x.skyenvoys.utils.GuiHandlers;

import me.zoon20x.skyenvoys.Containers.EnvoyContainer;
import me.zoon20x.skyenvoys.SkyEnvoys;
import me.zoon20x.skyenvoys.files.FileCache;
import me.zoon20x.skyenvoys.utils.UtilsCollector;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class SettingsHandler implements InventoryHolder {
    private EnvoyContainer container;
    private static HashMap<String, ItemStack> cachedItems = new HashMap<>();

    public SettingsHandler(EnvoyContainer container){
        this.container = container;
    }

    public void loadCachedItems(String value, Boolean reset) {
        if (reset) {
            cachedItems.clear();
        }
        ;
        FileConfiguration config = FileCache.getConfig("settingsGUI");
        String x = config.getString("Items." + value + ".Type");
        System.out.println(x);
        ItemStack data;
        if (x.equalsIgnoreCase("{EnvoyItems_Block}")) {
            data = container.getEnvoyBlock();
        } else {
            data = UtilsCollector.createItem(config.getString("Items." + value + ".Type"), config.getInt("Items." + value + ".Amount"), config.getInt("Items." + value + ".Data"));
        }
        if(config.getBoolean("Items." + value + ".EmptySpaces")){
            value = "SkyEnvoys-Background";
        }
        cachedItems.put(value, data);
    }

    @NotNull
    @Override
    public Inventory getInventory() {
        Inventory inventory = Bukkit.createInventory(this, 9*3, "Settings GUI");
        new BukkitRunnable() {
            @Override
            public void run() {
                inventory.setItem(1, cachedItems.get("Lightning"));
                inventory.setItem(10, cachedItems.get("FallingBlock"));
                inventory.setItem(19, cachedItems.get("Messages"));
                inventory.setItem(22, cachedItems.get("SaveEnvoy"));
                inventory.setItem(7, cachedItems.get("TimeSettings"));
                inventory.setItem(16, cachedItems.get("EnvoyEvents"));
                inventory.setItem(4, cachedItems.get("EnvoyBlock"));
                if(cachedItems.containsKey("SkyEnvoys-Background")){

                    for(int i=0;i<9*3;i++){
                        if(inventory.getItem(i) ==null){
                            inventory.setItem(i, cachedItems.get("SkyEnvoys-Background"));
                        }
                    }
                }
            }
        }.runTaskAsynchronously(SkyEnvoys.getSkyEnvoys());



        return inventory;
    }


    public Boolean isClickedItem(ItemStack item){
        return cachedItems.values().contains(item);
    }
    public String getItemID(ItemStack item){
        for(String x : cachedItems.keySet()){
            if(cachedItems.get(x).equals(item)){
                return x;
            }
        }
        return "";
    }
}
