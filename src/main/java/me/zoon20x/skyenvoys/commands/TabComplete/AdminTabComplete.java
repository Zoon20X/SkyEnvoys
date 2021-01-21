package me.zoon20x.skyenvoys.commands.TabComplete;

import me.zoon20x.skyenvoys.Containers.EnvoyContainer;
import me.zoon20x.skyenvoys.utils.EnvoyList;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AdminTabComplete implements TabCompleter {
    private static final String[] args1 = {"Creator","Editor"};
    private static final ArrayList<String> envoysList = new ArrayList<>();
    //create a static array of values

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        //create new array
        final List<String> completions = new ArrayList<>();
        //copy matches of first argument from list (ex: if first arg is 'm' will return just 'minecraft')
        if (args.length == 1) {
            StringUtil.copyPartialMatches(args[0], Arrays.asList(args1), completions);
        }
        if (args.length == 2) {
            if (args[0].equalsIgnoreCase("Editor")) {
                envoysList.clear();
                for (EnvoyContainer container : EnvoyList.getAllEnvoys()) {
                    envoysList.add(container.getName());
                }
                StringUtil.copyPartialMatches(args[1], envoysList, completions);
            }
        }
        //sort the list
        Collections.sort(completions);
        return completions;

    }
}
