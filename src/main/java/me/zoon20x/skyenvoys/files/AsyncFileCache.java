package me.zoon20x.skyenvoys.files;



import me.zoon20x.skyenvoys.Containers.EnvoyContainer;
import me.zoon20x.skyenvoys.Containers.settings.EnvoyEffects;
import me.zoon20x.skyenvoys.Containers.settings.EnvoyEvents;
import me.zoon20x.skyenvoys.Containers.settings.EnvoyMessages;
import me.zoon20x.skyenvoys.Containers.settings.EnvoyTime;
import me.zoon20x.skyenvoys.SkyEnvoys;
import me.zoon20x.skyenvoys.utils.ChestStates;
import me.zoon20x.skyenvoys.utils.EnvoyList;
import me.zoon20x.skyenvoys.utils.MessagesUtil;
import org.bukkit.Effect;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

public class AsyncFileCache {

    private static File getFile(String id){
        return new File(SkyEnvoys.getInstance().getDataFolder(),   "/"+id);
    }
    private static File getEnvoyTypesFile(String id){
        return new File(SkyEnvoys.getEnvoyTypesFolder(),   "/"+id);
    }
    private static FileConfiguration getConfig(File file){
        return YamlConfiguration.loadConfiguration(file);
    }


    public static void startAsyncCreate() {
        //FileCache.createFile(getFile(""), getConfig(getFile("")), ".yml", ".yml", "");

        startAsyncCache();
    }



    public static void startAsyncCache() {
        new BukkitRunnable(){
            @Override
            public void run() {
                //FileCache.addFileToCache("", getConfig(getFile("")));

                File dir = SkyEnvoys.getEnvoyTypesFolder();
                for(String x : dir.list()){
                    System.out.println(x);
                    File settings = getEnvoyTypesFile(x + "/Settings.yml");
                    File items = getEnvoyTypesFile(x + "/Items.yml");
                    File locations = getEnvoyTypesFile(x + "/Locations.yml");
                    FileConfiguration settingsConfig = null;
                    FileConfiguration itemsConfig = null;
                    FileConfiguration locationsConfig = null;


                    if(settings != null && items !=null && locations !=null){
                        settingsConfig = getConfig(settings);
                        itemsConfig = getConfig(items);
                        locationsConfig = getConfig(locations);
                    }else{
                        System.out.println(MessagesUtil.basicColor("&c" + x + "&4could not be loaded, please check you have all the files"));
                    }
                    if(settingsConfig !=null && itemsConfig !=null && locationsConfig !=null){
                        EnvoyEffects effects = new EnvoyEffects(settingsConfig.getBoolean("Effects.Lightning"), settingsConfig.getBoolean("FallingBlock.Enabled"), settingsConfig.getInt("FallingBlock.DropHeight"));
                        EnvoyMessages messages = new EnvoyMessages(settingsConfig.getString("Message.Summon"), settingsConfig.getString("Message.Finish"));
                        EnvoyEvents events = new EnvoyEvents(
                                settingsConfig.getBoolean("SummonEvent.Message-Enabled"),
                                settingsConfig.getBoolean("FinishEvent.Message-Enabled"),
                                ChestStates.valueOf(settingsConfig.getString("FinishEvent.ChestOption")));
                        Boolean summonTime = settingsConfig.getBoolean("Time.Summon.Enabled");
                        Boolean finishTime = settingsConfig.getBoolean("Time.Finish.Enabled");

                        EnvoyTime time = null;
                        if (summonTime && finishTime) {
                            String summonUnits = settingsConfig.getString("Time.Summon.Units");
                            String finishUnits = settingsConfig.getString("Time.Finish.Units");

                            Integer summonAmount = settingsConfig.getInt("Time.Summon.Amount");
                            Integer finishAmount = settingsConfig.getInt("Time.Finish.Amount");
                            time = new EnvoyTime(true, true, summonUnits, finishUnits, summonAmount, finishAmount);

                        }else if(!summonTime && !finishTime){
                            time = new EnvoyTime();
                        }else{
                            String units = "";
                            Integer amount = 0;
                            if(summonTime){
                                units = settingsConfig.getString("Time.Summon.Units");
                                amount = settingsConfig.getInt("Time.Summon.Amount");
                                time = new EnvoyTime(true, false, units, amount);
                            }else if(finishTime){
                                units = settingsConfig.getString("Time.Finish.Units");
                                amount = settingsConfig.getInt("Time.Finish.Amount");
                                time = new EnvoyTime(false, true, units, amount);
                            }
                        }
                        EnvoyContainer container = new EnvoyContainer(x, new ArrayList<>(), effects, messages, time, events);
                        EnvoyList.addEnvoy(x, container);
                    }else{
                        System.out.println(MessagesUtil.basicColor("&c" + x + "&4could not be loaded, please check you have all the files"));
                    }
                }
            }
        }.runTaskAsynchronously(SkyEnvoys.getInstance());


    }


}
