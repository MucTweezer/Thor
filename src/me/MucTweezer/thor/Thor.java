package me.MucTweezer.thor;

import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Thor extends JavaPlugin{
	private HashMap<Player, Boolean> pluginEnabled;
	private Logger log;
	
	public void onEnable() {
		pluginEnabled = new HashMap<Player, Boolean>();
		log = this.getLogger();
		new TouchListener(this);
		
		log.info("Thor has been activated.");
	}
	public void onDisable() {
		log.info("Thor has been disabled.");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (sender instanceof Player && args.length == 0) {
			togglePlugin((Player)sender);
			return true;
		} else {
			return false;
		}
	}
	public void togglePlugin(Player tempPlayer) {
		if(pluginEnabled.containsKey(tempPlayer)){
	        if(pluginEnabled.get(tempPlayer)){
	            pluginEnabled.put(tempPlayer, false);
	            tempPlayer.sendMessage("Thor disabled");
	        } else {
	            pluginEnabled.put(tempPlayer, true);
	            tempPlayer.sendMessage("Thor enabled");
	        }
	    } else {
	        pluginEnabled.put(tempPlayer, true);
	        tempPlayer.sendMessage("Thor enabled");
	    }
	}
	
	public boolean thorIsEnabled(Player tempPlayer) {
		if (pluginEnabled.get(tempPlayer) == null) {
			return false;
		} else {
			return pluginEnabled.get(tempPlayer);
		}
	}
}
