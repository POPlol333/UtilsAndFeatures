package fr.cardi.mainPackage.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;


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

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {

        Player victim = e.getEntity();

        if(victim.getKiller() instanceof Player) {

            Player tueur = victim.getKiller();

            e.setDeathMessage(String.format("§8§l[§6§lBroadcast§8§l] §r%s a tué %s", tueur.getName(), victim.getName()));

            ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
            SkullMeta meta = (SkullMeta) head.getItemMeta();
            meta.setOwner(victim.getName());
            meta.setDisplayName(String.format("§6§lTête de %s", victim.getName()));
            List<String> Lores = new ArrayList<String>();
            Lores.add(String.format("§6§l%s §7a obtenu cette tête par la force !", tueur.getName()));
            meta.setLore(Lores);
            head.setItemMeta(meta);

            e.getDrops().add(head);

        }

    }




}
