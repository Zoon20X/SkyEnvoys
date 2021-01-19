package me.zoon20x.skyenvoys.files;



import me.zoon20x.skyenvoys.SkyEnvoys;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.util.UUID;

public class AsyncFileCache {

    private static File getFile(String id){
        return new File(SkyEnvoys.getInstance().getDataFolder(),   "/"+id);
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
                    File file = getFile(SkyEnvoys.getEnvoyTypesFolder() + "/" +x);
                    FileConfiguration configuration = null;
                    if(file != null){
                        configuration = getConfig(file);
                    }
                    if(configuration !=null){

                    }
                }
            }
        }.runTaskAsynchronously(SkyEnvoys.getInstance());


    }


}
