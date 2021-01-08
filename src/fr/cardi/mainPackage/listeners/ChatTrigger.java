package fr.cardi.mainPackage.listeners;

import fr.cardi.mainPackage.listeners.consequence.ReleaseClass;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class ChatTrigger implements Listener {

    @EventHandler
    public void chatCheck(PlayerChatEvent e) {

        e.setCancelled(true);

        String message = e.getMessage();

        Player player = e.getPlayer();
        String pName = player.getName();


        if(message.contains("Release")){
            ReleaseClass.Release(player);

        } else {
            Bukkit.broadcastMessage("§l"+pName + " §r§b>> §r" +message.replace("&", "§"));
        }
    }

}
