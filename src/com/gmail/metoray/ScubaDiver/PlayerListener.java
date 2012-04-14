package com.gmail.metoray.ScubaDiver;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.PlayerInventory;

public class PlayerListener implements Listener {
	@EventHandler
	public void onPlayerDamage(EntityDamageEvent event){
		if((event.getEntity() instanceof Player)) {
			if(event.getCause().equals(EntityDamageEvent.DamageCause.DROWNING)){
				Player p = (Player) event.getEntity();
	            PlayerInventory inv = p.getInventory();
	            Material helmet = inv.getHelmet().getType(); 
	             	if(helmet.equals(Material.GLASS)) {
	              		event.setDamage(0);
	              		event.setCancelled(true);
	              	}
			}
		}
	}
}
