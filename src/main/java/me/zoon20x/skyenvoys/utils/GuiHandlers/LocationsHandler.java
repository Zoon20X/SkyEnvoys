package me.zoon20x.skyenvoys.utils.GuiHandlers;

import me.zoon20x.skyenvoys.Containers.EnvoyContainer;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

public class LocationsHandler implements InventoryHolder {
    private GuiType type;
    private EnvoyContainer container;

    public LocationsHandler(GuiType type, EnvoyContainer container){
        this.type = type;
        this.container = container;
    }
    public LocationsHandler(GuiType type){
        this.type = type;

    }


    @NotNull
    @Override
    public Inventory getInventory() {
        return null;
    }
}
