package fr.cardi.mainPackage.listeners.consequence;

import fr.cardi.mainPackage.itemBuilderAndAssignation.itemAssignation;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class releaseClass implements Listener {

    public static void Release(Player player) {

        String pName = player.getName();
        ItemStack it = player.getItemInHand();

        if (it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().contains("§f§lAmulette de Vitesse Tier")) {

            if (it.getItemMeta().getDisplayName().contains("§f§l1")) {
                UseArtefact(player, itemAssignation.AmuletteSpeedTier1, "§f§lAmulette de Vitesse", 1, "SPEED");
            }
            if (it.getItemMeta().getDisplayName().contains("§f§l2")) {
                UseArtefact(player, itemAssignation.AmuletteSpeedTier2, "§f§lAmulette de Vitesse", 2, "SPEED");
            }
            if (it.getItemMeta().getDisplayName().contains("§f§l3")) {
                UseArtefact(player, itemAssignation.AmuletteSpeedTier3, "§f§lAmulette de Vitesse", 3, "SPEED");
            }
        } else if (it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().contains("§7§lTalisman Protecteur Tier")) {

            if (it.getItemMeta().getDisplayName().contains("§7§l1")) {
                UseArtefact(player, itemAssignation.TalismanProtection1, "§7§lTalisman Protecteur", 1, "DAMAGE_RESISTANCE");
            }
            if (it.getItemMeta().getDisplayName().contains("§7§l2")) {
                UseArtefact(player, itemAssignation.TalismanProtection2, "§7§lTalisman Protecteur", 2, "DAMAGE_RESISTANCE");
            }
            if (it.getItemMeta().getDisplayName().contains("§7§l3")) {
                UseArtefact(player, itemAssignation.TalismanProtection3, "§7§lTalisman Protecteur", 3, "DAMAGE_RESISTANCE");
            }

            if (it.getItemMeta().getDisplayName().contains("§7§l4")) {
                UseArtefact(player, itemAssignation.TalismanProtection4, "§7§lTalisman Protecteur", 4, "DAMAGE_RESISTANCE");
            }
        }
        else {
            Bukkit.broadcastMessage("§l" + pName + " §r§b>> §4§l<!> AUCUN ARTEFACT EN MAIN");
        }
    }

    public static void UseArtefact(Player p, ItemStack it, String Type, Integer tier, String effectPotion) {
        final int indexItem = p.getInventory().first(it);
        try {
            p.removePotionEffect(PotionEffectType.getByName(effectPotion));
            p.getInventory().clear(indexItem);
            p.sendMessage(String.format("§6Vous venez d'utiliser votre  %s Tier %s", Type, tier.toString()));
            p.addPotionEffect(new PotionEffect(PotionEffectType.getByName(effectPotion), Integer.MAX_VALUE, tier - 1));

        } catch (ArrayIndexOutOfBoundsException a) {
            Bukkit.broadcastMessage("§l" + p.getName() + " §r§b>> §4§l<!> VEUILLEZ DESTACKER VOS ARTEFACTS !");
        }
    }

    @EventHandler
    public void onEat(PlayerItemConsumeEvent e) {

        Player player = e.getPlayer();
        ItemStack it = e.getItem();

        if (it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().contains("§c§lPomme de vie")) {

            if (player.getMaxHealth() >= 40) {
                Bukkit.broadcastMessage("§l" + player.getName() + " §r§b>> §4§l<!> ARTEFACT TROP UTILISÉE ");
            } else {
                final int indexItem = player.getInventory().first(itemAssignation.PommeDeVie);
                player.sendMessage("§6Vous venez d'utiliser une §c§lPomme de vie");
                player.setMaxHealth(player.getMaxHealth() + 4);
                player.sendMessage("§7§lVotre vie viens d'augmenter de 2 coeurs ! !");
                player.sendMessage("§7§là noter que la vie maximal atteignable avec ces pommes est de 40HP, deux barres entire !");
                player.getInventory().clear(indexItem);
            }
        }

    }

}
