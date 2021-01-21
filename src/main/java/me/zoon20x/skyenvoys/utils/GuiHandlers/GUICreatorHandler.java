package me.zoon20x.skyenvoys.utils.GuiHandlers;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

public class GUICreatorHandler implements InventoryHolder {
    private GuiType type;

    public GUICreatorHandler(GuiType type){
        this.type = type;
    }


    @Override
    public Inventory getInventory() {
        Inventory inventory = Bukkit.createInventory(this, InventoryType.HOPPER, "Envoy " + type);


        return inventory;
    }
}
