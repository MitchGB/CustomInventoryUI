package com.buby.custominventoryui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomInventoryUI extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }


    //Obviously change this out
    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        String title = CharRepo.getNeg(8) + "&f" + CharRepo.MENU_CONTAINER_27 +CharRepo.getNeg(176) + CharRepo.getPos(8)+ CharRepo.MENU_BUTTON;
        Inventory inventory = Bukkit.createInventory(null, 27, ChatColor.translateAlternateColorCodes('&', title));
        event.getPlayer().openInventory(inventory);
    }
}
