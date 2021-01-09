package fr.cardi.mainPackage.listeners.consequence;

import fr.cardi.mainPackage.itemBuilderAndAssignation.Items;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.logging.Logger;


public class ReleaseClass implements Listener {

    private static Logger logger = Logger.getLogger("Minecraft");

    public static void Release(Player player) {

        String pName = player.getName();
        ItemStack it = player.getItemInHand();

        if (!it.hasItemMeta()) player.sendMessage("§4§l<!> AUCUN ARTEFACT EN MAIN");;
        if (!it.getItemMeta().hasDisplayName()) player.sendMessage("§4§l<!> AUCUN ARTEFACT EN MAIN");;

        if (it.getItemMeta().getDisplayName().contains("§f§lAmulette de Vitesse Tier")) {

            if (it.getItemMeta().getDisplayName().contains("§f§l1")) {
                UseArtefact(player, Items.AMU_SPEED_T1.getItem(), "§f§lAmulette de Vitesse", 1, "SPEED");
            }
            if (it.getItemMeta().getDisplayName().contains("§f§l2")) {
                UseArtefact(player, Items.AMU_SPEED_T2.getItem(), "§f§lAmulette de Vitesse", 2, "SPEED");
            }
            if (it.getItemMeta().getDisplayName().contains("§f§l3")) {
                UseArtefact(player, Items.AMU_SPEED_T3.getItem(), "§f§lAmulette de Vitesse", 3, "SPEED");
            }
        } else if (it.getItemMeta().getDisplayName().contains("§7§lTalisman Protecteur Tier")) {

            if (it.getItemMeta().getDisplayName().contains("§7§l1")) {
                UseArtefact(player, Items.TAL_PROTEC_T1.getItem(), "§7§lTalisman Protecteur", 1, "DAMAGE_RESISTANCE");
            }
            if (it.getItemMeta().getDisplayName().contains("§7§l2")) {
                UseArtefact(player, Items.TAL_PROTEC_T2.getItem(), "§7§lTalisman Protecteur", 2, "DAMAGE_RESISTANCE");
            }
            if (it.getItemMeta().getDisplayName().contains("§7§l3")) {
                UseArtefact(player, Items.TAL_PROTEC_T3.getItem(), "§7§lTalisman Protecteur", 3, "DAMAGE_RESISTANCE");
            }

            if (it.getItemMeta().getDisplayName().contains("§7§l4")) {
                UseArtefact(player, Items.TAL_PROTEC_T4.getItem(), "§7§lTalisman Protecteur", 4, "DAMAGE_RESISTANCE");
            }
        }
        else {
            player.sendMessage("§4§l<!> AUCUN ARTEFACT EN MAIN");
        }
    }

    public static void UseArtefact(Player p, ItemStack it, String Type, Integer tier, String effectPotion) {
        final int indexItem = p.getInventory().first(it);
        try {
            p.getInventory().clear(indexItem);
            p.removePotionEffect(PotionEffectType.getByName(effectPotion));
            p.sendMessage(String.format("§6Vous venez d'utiliser votre  %s Tier %s", Type, tier.toString()));
            p.addPotionEffect(new PotionEffect(PotionEffectType.getByName(effectPotion), Integer.MAX_VALUE, tier - 1));
            Bukkit.broadcastMessage("§l"+p.getName() + " §r§b>> §5§lאני משחרר את כוחו של החפץ הזה");
            logger.warning(String.format("%s A UTILISÉ UN %s de Tier %s", p.getName(), Type, tier.toString()));

        } catch (ArrayIndexOutOfBoundsException a) {
            p.sendMessage("§4§l<!> VEUILLEZ DESTACKER VOS ARTEFACTS !");
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
                //final int indexItem = player.getInventory().first(ItemAssignation.PommeDeVie);
                player.sendMessage("§6Vous venez de manger une §c§lPomme de vie");
                player.setMaxHealth(player.getMaxHealth() + 4);
                player.sendMessage("§7§lVotre vie viens d'augmenter de 2 coeurs ! !");
                player.sendMessage("§7§là noter que la vie maximal atteignable avec ces pommes est de 40HP, deux barres entire !");
                //player.getInventory().clear(indexItem);
            }
        }
        if (it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().contains("§2§lEnergy §e§lDrink")) {

            player.sendMessage("§6Vous venez de boire une §2§lEnergy §e§lDrink");
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION , Integer.MAX_VALUE,  2));
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE , Integer.MAX_VALUE,  1));
            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP , Integer.MAX_VALUE,  3));
            player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING , Integer.MAX_VALUE,  3));
        }

    }

}
