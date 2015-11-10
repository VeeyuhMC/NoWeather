package com.colt.noweather;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class NoWeather extends JavaPlugin implements Listener {
	
	List<String> disabledWorlds = getConfig().getStringList("worlds");
	
	public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
		saveDefaultConfig();
	}
    
	@EventHandler
	public void weatherChange(WeatherChangeEvent event) {
		if(event.toWeatherState() == true) {
			for(String world : disabledWorlds) {
				if(Bukkit.getWorld(world) != null) {
					World finalWorld = Bukkit.getWorld(world);
					if(event.getWorld() == finalWorld) {
						event.setCancelled(true);
						finalWorld.setStorm(false);
						finalWorld.setThundering(false);
						finalWorld.setWeatherDuration(0);
					}
				} else {
					return;
				}
			}
		}
	}
}
