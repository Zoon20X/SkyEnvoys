package me.zoon20x.skyenvoys.events;

import me.zoon20x.skyenvoys.SkyEnvoys;
import me.zoon20x.skyenvoys.utils.GuiHandlers.GUICreatorHandler;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GUIEvents implements Listener {
    private SkyEnvoys envoys;

    public GUIEvents(SkyEnvoys envoys){
        this.envoys = envoys;
    }


    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        if(event.getClickedInventory() == null){
            return;
        }
        if(event.getCurrentItem() == null){
            return;
        }
        if(event.getInventory().getHolder() instanceof GUICreatorHandler){
            event.setCancelled(true);
            GUICreatorHandler guiCreatorHandler = (GUICreatorHandler) event.getClickedInventory().getHolder();
            Inventory inventory = event.getInventory();
            ItemStack item = event.getCurrentItem();
            if (guiCreatorHandler.getLocationsItem().equals(item)) {
                System.out.println("Locations");
                return;
            }
            if(guiCreatorHandler.getSettingsItem().equals(item)){
                System.out.println("Settings");
                return;
            }
            if(guiCreatorHandler.getItems().equals(item)){
                System.out.println("Envoy Items");
                return;
            }

        }
    }


}
