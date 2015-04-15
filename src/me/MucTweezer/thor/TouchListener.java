package me.MucTweezer.thor;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class TouchListener implements Listener{
	private Thor plugin;
	
	public TouchListener (Thor tempPlugin) {
		plugin = tempPlugin;
		
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void onClick(PlayerInteractEvent event) {
		if (plugin.thorIsEnabled(event.getPlayer())) {
			event.getPlayer().getWorld().strikeLightning(event.getPlayer().getLastTwoTargetBlocks(null, 100).get(1).getLocation());
		}
	}
}
