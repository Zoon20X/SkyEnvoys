package me.zoon20x.skyenvoys.Containers;

import org.bukkit.Location;

import java.util.ArrayList;

public class EnvoyContainer implements EnvoysSetup{

    private String name;
    private ArrayList<Location> locations;

    public EnvoyContainer(String name, ArrayList<Location> locations){
        this.name = name;
        this.locations = locations;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ArrayList<Location> getLocations() {
        return locations;
    }
}
