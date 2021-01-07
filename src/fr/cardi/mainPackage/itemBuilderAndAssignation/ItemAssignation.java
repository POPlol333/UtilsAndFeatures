package fr.cardi.mainPackage.itemBuilderAndAssignation;


import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemAssignation {

    public static ItemStack AmuletteSpeedAdminGUI= ItemBuilder.customItemConfig(Material.FEATHER, "§f§lAmulettes de Vitesse", "catégorie regroupant les amulettes de vitesse");
    public static ItemStack AmuletteSpeedTier1= ItemBuilder.customItemConfig(Material.FEATHER, "§f§lAmulette de Vitesse Tier §f§l1", "Cette amulette augmente un peu votre vitesse");
    public static ItemStack AmuletteSpeedTier2= ItemBuilder.customItemConfig(Material.FEATHER, "§f§lAmulette de Vitesse Tier §f§l2", "Cette amulette augmente votre vitesse");
    public static ItemStack AmuletteSpeedTier3= ItemBuilder.customItemConfig(Material.FEATHER, "§f§lAmulette de Vitesse Tier §f§l3", "Cette amulette augmente grandement votre vitesse");

    public static ItemStack TalismanProtectionAdminGUI= ItemBuilder.customItemConfig(Material.DIAMOND, "§7§lTalismans de Protection", "catégorie regroupant les talismans de protection");
    public static ItemStack TalismanProtection1= ItemBuilder.customItemConfig(Material.DIAMOND, "§7§lTalisman Protecteur Tier §7§l1", "Ce talisman vous octroie un peu de protection");
    public static ItemStack TalismanProtection2= ItemBuilder.customItemConfig(Material.DIAMOND, "§7§lTalisman Protecteur Tier §7§l2", "Ce talisman vous octroie une protection");
    public static ItemStack TalismanProtection3= ItemBuilder.customItemConfig(Material.DIAMOND, "§7§lTalisman Protecteur Tier §7§l3", "Ce talisman vous octroie une grande protection");
    public static ItemStack TalismanProtection4= ItemBuilder.customItemConfig(Material.DIAMOND, "§7§lTalisman Protecteur Tier §7§l4", "Ce talisman vous octroie une très grande protection");

    public static ItemStack PommeDeVie= ItemBuilder.customItemConfig(Material.GOLDEN_APPLE, "§c§lPomme de vie", "Octroie 2 coeurs supplémentaires");

}
