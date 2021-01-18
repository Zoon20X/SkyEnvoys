package me.zoon20x.skyenvoys.commands;

import me.zoon20x.skyenvoys.SkyEnvoys;
import me.zoon20x.skyenvoys.commands.TabComplete.AdminTabComplete;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AdminEnvoys implements CommandExecutor {
    public AdminEnvoys(SkyEnvoys skyEnvoys){
        skyEnvoys.getCommand("adminEnvoys").setTabCompleter(new AdminTabComplete());
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
    }
}
