package com.colt.NoWeather;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class NoWeather extends JavaPlugin implements Listener{
	
	public void onEnable() {
		saveConfig();
        	Bukkit.getPluginManager().registerEvents(this, this); // Register the event
	}
	
	@EventHandler
	public void rain(WeatherChangeEvent e) {
	  List<String> worlds = getConfig().getStringList("worlds");
	  for(String w : worlds) {
	    if(e.getWorld().equals(w)) {
	      e.setCancelled(true); // cancel the event, Meaning weather will not change
		  World ww = Bukkit.getServer().getWorld(w);
		  ww.setStorm(false);
	    }
	  }
	}
}
