package fr.cardi.mainPackage.listeners;

import fr.cardi.mainPackage.itemBuilderAndAssignation.Items;
import org.bukkit.*;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class PlayerRelative implements Listener {

    private Logger logger = Logger.getLogger("Minecraft");

    Server server = Bukkit.getServer();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        e.setJoinMessage(ChatColor.GREEN + player.getName() + " a rejoint le serveur !");
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        e.setQuitMessage(ChatColor.GREEN + player.getName() + " a quitté le serveur !");

    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {

        Player victim = e.getEntity();
        Player killer = victim.getKiller();

        if (killer == null) return;

        Player tueur = victim.getKiller();

        e.setDeathMessage(String.format("§8§l[§6§lBroadcast§8§l] §4§l%s §ra tué §c%s", tueur.getName(), victim.getName()));

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

    @EventHandler
    public void onChangeWorld(PlayerChangedWorldEvent e) {

        Player player = e.getPlayer();

        World world = e.getPlayer().getWorld();

        if(world.getEnvironment() == World.Environment.THE_END) {
            logger.warning(String.format(ChatColor.GOLD+"%s EST ENTRÉ DANS L'END", player.getName()));

        } else if (world.getEnvironment() == World.Environment.NETHER ){
            logger.warning(String.format(ChatColor.GOLD+"%s EST ENTRÉ DANS LE NETHER", player.getName()));
        } else if (world.getEnvironment() == World.Environment.NORMAL ) {
            logger.warning(String.format(ChatColor.GOLD+"%s EST ENTRÉ DANS L'OVERWORLD", player.getName()));
        }
    }


    @EventHandler
    public void onInterract(PlayerInteractEvent e) {

        Player player = e.getPlayer();
        Action act = e.getAction();


        if(e.getItem()== null) return;
        if(!player.getItemInHand().hasItemMeta()) return;


        if((act == Action.RIGHT_CLICK_AIR || act == Action.RIGHT_CLICK_BLOCK) && e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lBandage de qualité moyenne")) {
            if(player.getMaxHealth()==player.getHealth()) {

                player.sendMessage("§7§lTu es déjà full vie");
            } else {
                final int indexItem = player.getInventory().first(Items.PETIT_BANDAGE.getItem());
                try {
                    player.getInventory().clear(indexItem);
                    player.sendMessage("§6Vous venez d'utiliser votre §f§lbandage de moyenne qualitée ! ");
                    if(player.getHealth()+5 > player.getMaxHealth()) player.setHealth(player.getMaxHealth());
                    else player.setHealth(player.getHealth()+5);
                } catch (ArrayIndexOutOfBoundsException a) {
                    player.sendMessage("§4§l<!> VEUILLEZ DESTACKER VOS BANDAGES !");
                }
            }
        }
    }




    static ArrayList listParticipantDragon = new ArrayList();

    @EventHandler
    public void DragonPlayerParticipant(EntityDamageByEntityEvent e){

        if(e.getEntity() instanceof EnderDragon || e.getEntity() instanceof EnderCrystal){

            if(e.getDamager() instanceof Player) {
                if(listParticipantDragon.contains(e.getDamager().getName())) {
                    logger.warning(String.format("%s est déjà dans listParticipantDragon", e.getDamager().getName()));
                } else {
                    listParticipantDragon.add(e.getDamager().getName());
                    logger.warning(String.format("%s a rejoint listParticipantDragon", e.getDamager().getName()));
                }
            }
        }
    }

    @EventHandler
    public void DragonDeath(EntityDeathEvent e) {

        if(e.getEntity() instanceof EnderDragon) {

            server.dispatchCommand(server.getConsoleSender(), "broadcast §5§lLe dragon est mort, voici la liste des participants :");

            for(int i = 0; i < listParticipantDragon.size(); i++) {
                server.dispatchCommand(server.getConsoleSender(), String.format("broadcast §5§l-%s", listParticipantDragon.get(i)));
                logger.warning("Indice de rang "+ i + " " +listParticipantDragon.get(i));
            }
            listParticipantDragon.clear();
            logger.warning("La liste listParticipantDragon a bien été reset !");
        }
    }

}
