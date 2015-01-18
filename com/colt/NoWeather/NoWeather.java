package com.colt.NoWeather;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class NoWeather extends JavaPlugin implements Listener{
	
	public void onEnable() {
	saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void rain(WeatherChangeEvent e) {
	  List<String> worlds = getConfig().getStringList("worlds");
	  for(String w : worlds) {
		World world = Bukkit.getWorld(w);
		if(e.getWorld().equals(world)) {
	      e.setCancelled(true);
		  World ww = Bukkit.getServer().getWorld(w);
		  ww.setStorm(false);
		}
	  }
	}
}
