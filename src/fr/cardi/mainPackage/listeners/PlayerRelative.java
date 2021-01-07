package fr.cardi.mainPackage.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;


public class PlayerRelative implements Listener {



    @EventHandler
    public void onJoin(PlayerJoinEvent e)
    {
        Player player = e.getPlayer();
        e.setJoinMessage(ChatColor.GREEN+player.getName()+ " a rejoint le serveur !");
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e)
    {
        Player player = e.getPlayer();
        e.setQuitMessage(ChatColor.GREEN +player.getName()+ " a quitté le serveur !");

    }




}
