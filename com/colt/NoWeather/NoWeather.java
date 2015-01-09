package com.colt.NoWeather;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class NoWeather extends JavaPlugin implements Listener{
	
	public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this); // Register the event
	}
	
	@EventHandler
	public void rain(WeatherChangeEvent e) {
		e.setCancelled(true); // cancel the event, Meaning weather will not change
		e.getWorld().setStorm(false); // To prevent a infinite rain storm or similar
	}
}
