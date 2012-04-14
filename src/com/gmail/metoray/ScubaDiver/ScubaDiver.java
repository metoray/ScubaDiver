package com.gmail.metoray.ScubaDiver;

import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class ScubaDiver extends JavaPlugin {
	
	Logger log;
	
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
		log = this.getLogger();
		log.info("Scubadiver has been enabled! :)");
    }
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if(cmd.getName().equalsIgnoreCase("scuba")) {
    	if (sender instanceof Player) {
    		Player p = (Player) sender;
    		PlayerInventory inv = p.getInventory();
    		if(inv.contains(Material.GLASS)) {
    			if (inv.getHelmet() != null) {
    			p.getWorld().dropItem(p.getLocation(), inv.getHelmet());
    			}
    			ItemStack glass = new ItemStack(20, 1);
    			int invloc = inv.first(Material.GLASS);
    			int beginamount = inv.getItem(invloc).getAmount();
    			ItemStack endstack = new ItemStack(Material.GLASS, beginamount - 1);
    			if(beginamount > 1){
    			inv.setItem(invloc, endstack);
    			} else{
    				inv.clear(invloc);
    			}
    			inv.setHelmet(glass);
    			p.sendMessage("§bEnjoy your scuba-helmet!");
    		} else {
    			p.sendMessage("§4You don't have any glass.");
    		}
    		return true;
    	}
    	}
    	return false;
    }
}