package me.zoon20x.skyenvoys.utils;

import me.zoon20x.skyenvoys.Containers.EnvoyContainer;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.HashMap;

public class EnvoyList {

    private static HashMap<String, EnvoyContainer> envoys = new HashMap<>();

    public static boolean addEnvoy(String id, EnvoyContainer container){
        if(envoys.containsKey(id)){
           return false;
        }
        envoys.put(id, container);
        return true;

    }
    public static void resetEnvoys(){
        envoys.clear();
    }
    public static boolean hasEnvoy(String id){
        return envoys.containsKey(id);
    }

    //Can return null, be sure to use hasEnvoy before running this as if it doesn't contain the envoy
    //it will throw a nullPointerException
    @Nullable
    public static EnvoyContainer getEnvoy(String id){
        if(!hasEnvoy(id)){
            return null;
        }
        return envoys.get(id);
    }

    //Returns all envoys added to the envoy cache, this can return null

    @Nullable
    public static Collection<EnvoyContainer> getAllEnvoys(){
        return envoys.values();
    }

}
