package me.zoon20x.skyenvoys.commands;

import me.zoon20x.skyenvoys.SkyEnvoys;
import me.zoon20x.skyenvoys.commands.TabComplete.AdminTabComplete;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminEnvoys implements CommandExecutor {
    private SkyEnvoys envoys;
    public AdminEnvoys(SkyEnvoys skyEnvoys){
        skyEnvoys.getCommand("adminEnvoys").setTabCompleter(new AdminTabComplete());
        skyEnvoys.getCommand("adminEnvoys").setExecutor(this);
        envoys = skyEnvoys;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            return true;
        }
        return false;
    }
}
