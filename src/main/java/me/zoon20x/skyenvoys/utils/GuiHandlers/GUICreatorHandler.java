package me.zoon20x.skyenvoys.utils.GuiHandlers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import me.zoon20x.skyenvoys.Containers.EnvoyContainer;
import me.zoon20x.skyenvoys.utils.MessagesUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Skull;
import org.bukkit.craftbukkit.libs.org.apache.commons.codec.binary.Base64;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class GUICreatorHandler implements InventoryHolder {
    private EnvoyContainer container;

    public GUICreatorHandler(EnvoyContainer container){
        this.container = container;
    }

    @NotNull
    @Override
    public Inventory getInventory() {
        Inventory inventory = Bukkit.createInventory(this, InventoryType.HOPPER, "Envoy - " + container.getName());
        loadEditor(inventory);
        SettingsHandler settingsHandler = new SettingsHandler(container);
        settingsHandler.loadCachedItems("Lightning", true);
        settingsHandler.loadCachedItems("FallingBlock", false);
        settingsHandler.loadCachedItems("Messages", false);
        settingsHandler.loadCachedItems("EnvoyBlock", false);
        settingsHandler.loadCachedItems("SaveEnvoy", false);
        settingsHandler.loadCachedItems("TimeSettings", false);
        settingsHandler.loadCachedItems("EnvoyEvents", false);
        settingsHandler.loadCachedItems("Glass", false);

        return inventory;
    }

    @NotNull
    public EnvoyContainer getEnvoy(){
        return this.container;
    }

    private void loadEditor(Inventory inv){
        inv.setItem(2, getSettingsItem());
        inv.setItem(1, getLocationsItem());
        inv.setItem(3, getItems());
    }

    public ItemStack getSettingsItem(){
        ItemStack itemStack = new ItemStack(Material.COMMAND_BLOCK);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(MessagesUtil.basicColor("&b&oSettings"));
        itemStack.setItemMeta(meta);
        return itemStack;

    }
    public ItemStack getLocationsItem() {
        ItemStack itemStack = new ItemStack(Material.COMPASS);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(MessagesUtil.basicColor("&b&oLocations"));
        itemStack.setItemMeta(meta);
        return itemStack;
    }
    public ItemStack getItems() {
        ItemStack itemStack = new ItemStack(Material.CHEST);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(MessagesUtil.basicColor("&b&oAdd Items to Envoy"));
        itemStack.setItemMeta(meta);
        return itemStack;
    }
}
