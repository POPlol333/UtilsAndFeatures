package fr.cardi.MainPackage.Listeners;

import fr.cardi.MainPackage.Listeners.Consequence.ReleaseClass;
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

        Bukkit.broadcastMessage("§l"+pName + " §r§b>> §r" +message.replace("&", "§"));

        if(message.contains("Release")){
            ReleaseClass.Release(player);
        }


    }

}
