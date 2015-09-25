package com.colt.NoWeather;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class NoWeather extends JavaPlugin implements Listener{
	
	List<String> worlds = getConfig().getStringList("worlds");
	
	public void onEnable() {
        	Bukkit.getPluginManager().registerEvents(this, this);
		saveDefaultConfig();
	}
    
	@EventHandler
	public void rain(WeatherChangeEvent e) {
		if(e.toWeatherState() == true) {
			for(String w : worlds) {
				World world = Bukkit.getServer().getWorld(w);
				if(e.getWorld().equals(world)) {
					e.setCancelled(true);
					world.setStorm(false);
				}
			}
		}
	}
}
