package fr.cardi.MainPackage.Listeners;

import fr.cardi.MainPackage.GUI.AdminMenu;
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
        player.updateInventory();
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e)
    {
        Player player = e.getPlayer();

        e.setQuitMessage(ChatColor.GREEN +player.getName()+ " a quitté le serveur !");

    }




}
