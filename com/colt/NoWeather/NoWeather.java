package com.colt.noweather;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class NoWeather extends JavaPlugin implements Listener {
	
	private List<String> disabledWorlds;
	
	public void onEnable() {
    	Bukkit.getPluginManager().registerEvents(this, this);
		saveDefaultConfig();
		
		disabledWorlds = getConfig().getStringList("worlds");
	}
    
	@EventHandler
	public void weatherChange(WeatherChangeEvent event) {
		if(event.toWeatherState()) {
			for(String w : disabledWorlds) {
				if(Bukkit.getWorlds().contains(w)) {
					World world = Bukkit.getWorld(w);
					if(event.getWorld() == world) {
						event.setCancelled(true);
						world.setStorm(false);
						world.setThundering(false);
						world.setWeatherDuration(0);
					}
				}
			}
		}
	}
}
