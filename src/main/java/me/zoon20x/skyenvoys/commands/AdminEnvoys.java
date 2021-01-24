package me.zoon20x.skyenvoys.commands;

import me.zoon20x.skyenvoys.Containers.EnvoyContainer;
import me.zoon20x.skyenvoys.SkyEnvoys;
import me.zoon20x.skyenvoys.commands.TabComplete.AdminTabComplete;
import me.zoon20x.skyenvoys.utils.EnvoyList;
import me.zoon20x.skyenvoys.utils.GuiHandlers.GUICreatorHandler;
import me.zoon20x.skyenvoys.utils.GuiHandlers.GuiType;
import me.zoon20x.skyenvoys.utils.MessagesUtil;
import me.zoon20x.skyenvoys.utils.UtilsCollector;
import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.EntityArmorStand;
import net.minecraft.server.v1_16_R3.PacketPlayOutSpawnEntityLiving;
import net.minecraft.server.v1_16_R3.WorldServer;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.Locale;

public class AdminEnvoys implements CommandExecutor {
    private SkyEnvoys envoys;

    public AdminEnvoys(SkyEnvoys skyEnvoys) {
        skyEnvoys.getCommand("adminEnvoys").setTabCompleter(new AdminTabComplete());
        skyEnvoys.getCommand("adminEnvoys").setExecutor(this);
        envoys = skyEnvoys;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                args1(args, player);
            }
            if (args.length == 2) {
                args2(args, player);
            }
            return true;
        }
        return false;
    }


    private void args1(String[] args, Player player) {
        switch (args[0]) {
            case "Creator":
                player.sendMessage(MessagesUtil.basicColor(MessagesUtil.getLangData().getAdminCreatorNeedName()));
                break;
            case "Editor":
                player.sendMessage(MessagesUtil.basicColor(MessagesUtil.getLangData().getAdminEditorNeedName()));
                break;
        }
    }

    private void args2(String[] args, Player player) {
        switch (GuiType.valueOf(args[0].toUpperCase())) {
            case CREATE:
                for (EnvoyContainer envoy : EnvoyList.getAllEnvoys()) {
                    if (args[1].equalsIgnoreCase(envoy.getName())) {
                        player.sendMessage(MessagesUtil.basicColor(MessagesUtil.getLangData().getAdminCreatorCreated()
                                .replace("{command_envoyName}", envoy.getName())));
                        return;
                    }
                }

                if (UtilsCollector.runEnvoyCreation(args[1])) {

                }

                break;
            case EDIT:
                for (EnvoyContainer envoy : EnvoyList.getAllEnvoys()) {
                    if (args[1].equalsIgnoreCase(envoy.getName())) {
                        GUICreatorHandler edit = new GUICreatorHandler(envoy);
                        player.openInventory(edit.getInventory());
                        return;
                    }
                }
                player.sendMessage(MessagesUtil.basicColor(MessagesUtil.getLangData().getAdminEditorNoExist()
                        .replace("{command_envoyName}", args[1])));
                break;
        }
    }
}
