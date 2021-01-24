package me.zoon20x.skyenvoys.utils.GuiHandlers;

import me.zoon20x.skyenvoys.Containers.EnvoyContainer;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

public class LocationsHandler implements InventoryHolder {
    private EnvoyContainer container;

    public LocationsHandler(EnvoyContainer container){
        this.container = container;
    }



    @NotNull
    @Override
    public Inventory getInventory() {
        Inventory inventory = Bukkit.createInventory(this, 9*3, "Locations Settings");

        return null;
    }
}
