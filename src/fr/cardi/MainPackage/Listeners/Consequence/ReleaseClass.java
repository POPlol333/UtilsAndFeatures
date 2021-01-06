package fr.cardi.MainPackage.Listeners.Consequence;

import fr.cardi.MainPackage.ItemBuilderAndAssignation.ItemAssignation;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class ReleaseClass {

    public static void Release(Player player) {

        String pName = player.getName();
        ItemStack it = player.getItemInHand();

        if (it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().contains("§f§lAmulette de Vitesse Tier")) {

            if (it.getItemMeta().getDisplayName().contains("§f§l1")) {
                UseArtefact(player, ItemAssignation.AmuletteSpeedTier1, "§f§lAmulette de Speed", 1, "SPEED");
            }
            if (it.getItemMeta().getDisplayName().contains("§f§l2")) {
                UseArtefact(player, ItemAssignation.AmuletteSpeedTier2, "§f§lAmulette de Speed", 2, "SPEED");
            }
            if (it.getItemMeta().getDisplayName().contains("§f§l3")) {
                UseArtefact(player, ItemAssignation.AmuletteSpeedTier3, "§f§lAmulette de Speed", 3, "SPEED");
            }
        } else if (it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().contains("§7§lTalisman Protecteur Tier")) {

            if (it.getItemMeta().getDisplayName().contains("§7§l1")) {
                UseArtefact(player, ItemAssignation.TalismanProtection1, "§7§lTalisman Protecteur", 1, "DAMAGE_RESISTANCE");
            }
            if (it.getItemMeta().getDisplayName().contains("§7§l2")) {
                UseArtefact(player, ItemAssignation.TalismanProtection2, "§7§lTalisman Protecteur", 2, "DAMAGE_RESISTANCE");
            }
            if (it.getItemMeta().getDisplayName().contains("§7§l3")) {
                UseArtefact(player, ItemAssignation.TalismanProtection3, "§7§lTalisman Protecteur", 3, "DAMAGE_RESISTANCE");
            }

            if (it.getItemMeta().getDisplayName().contains("§7§l4")) {
                UseArtefact(player, ItemAssignation.TalismanProtection4, "§7§lTalisman Protecteur", 4, "DAMAGE_RESISTANCE");
            }
        } else if (it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().contains("§c§lPommes de vie")) {
            if (player.getMaxHealth() >= 40) {
                Bukkit.broadcastMessage("§l" + pName + " §r§b>> §4§l<!> ARTEFACT TROP UTILISÉE ");
            } else {
                final int indexItem6 = player.getInventory().first(ItemAssignation.AmuletteSpeedTier1);
                try {
                    player.sendMessage("§6Vous venez d'utiliser une §c§lPommes de vie");
                    player.setMaxHealth(player.getMaxHealth() + 4);
                    player.sendMessage("§7§là noter que la vie maximale est de 40HP soit, deux barres entières !");
                    player.getInventory().clear(indexItem6);

                } catch (ArrayIndexOutOfBoundsException a) {
                    Bukkit.broadcastMessage("§l" + player.getName() + " §r§b>> §4§l<!> VEUILLEZ DESTACKEZ VOS ARTEFACTS !");
                }
            }
        } else {
            Bukkit.broadcastMessage("§l" + pName + " §r§b>> §4§l<!> AUCUN ARTEFACT EN MAIN");
        }
    }

    public static void UseArtefact(Player p, ItemStack it, String Type, Integer tier, String effectPotion) {
        final int indexItem = p.getInventory().first(it);
        try {
            p.removePotionEffect(PotionEffectType.getByName(effectPotion));
            p.getInventory().clear(indexItem);
            p.sendMessage(String.format("§6Vous venez d'utiliser votre  %s Tier %s", Type, tier.toString()));
            p.addPotionEffect(new PotionEffect(PotionEffectType.getByName(effectPotion), Integer.MAX_VALUE, tier-1));

        } catch (ArrayIndexOutOfBoundsException a) {
            Bukkit.broadcastMessage("§l" + p.getName() + " §r§b>> §4§l<!> VEUILLEZ DESTACKEZ VOS ARTEFACTS !");
        }
    }

}
