package me.zoon20x.skyenvoys.utils;

import me.zoon20x.skyenvoys.Containers.settings.LangContainer;
import org.bukkit.ChatColor;

import java.util.HashMap;

public class MessagesUtil {

    private static LangContainer langData;

    public static LangContainer getLangData(){
        return langData;
    }
    public static void setLangData(LangContainer data){
        langData = data;
    }


    public static String basicColor(String x){
        return ChatColor.translateAlternateColorCodes('&', x);
    }


}
