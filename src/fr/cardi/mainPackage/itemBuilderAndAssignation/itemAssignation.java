package fr.cardi.mainPackage.itemBuilderAndAssignation;


import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class itemAssignation {

    public static ItemStack AmuletteSpeedAdminGUI= itemBuilder.customItemConfig(Material.FEATHER, "§f§lAmulettes de Vitesse", "catégorie regroupant les amulettes de vitesse");
    public static ItemStack AmuletteSpeedTier1= itemBuilder.customItemConfig(Material.FEATHER, "§f§lAmulette de Vitesse Tier §f§l1", "Cette amulette augmente un peu votre vitesse");
    public static ItemStack AmuletteSpeedTier2= itemBuilder.customItemConfig(Material.FEATHER, "§f§lAmulette de Vitesse Tier §f§l2", "Cette amulette augmente votre vitesse");
    public static ItemStack AmuletteSpeedTier3= itemBuilder.customItemConfig(Material.FEATHER, "§f§lAmulette de Vitesse Tier §f§l3", "Cette amulette augmente grandement votre vitesse");

    public static ItemStack TalismanProtectionAdminGUI= itemBuilder.customItemConfig(Material.DIAMOND, "§7§lTalismans de Protection", "catégorie regroupant les talismans de protection");
    public static ItemStack TalismanProtection1= itemBuilder.customItemConfig(Material.DIAMOND, "§7§lTalisman Protecteur Tier §7§l1", "Ce talisman vous octroie un peu de protection");
    public static ItemStack TalismanProtection2= itemBuilder.customItemConfig(Material.DIAMOND, "§7§lTalisman Protecteur Tier §7§l2", "Ce talisman vous octroie une protection");
    public static ItemStack TalismanProtection3= itemBuilder.customItemConfig(Material.DIAMOND, "§7§lTalisman Protecteur Tier §7§l3", "Ce talisman vous octroie une grande protection");
    public static ItemStack TalismanProtection4= itemBuilder.customItemConfig(Material.DIAMOND, "§7§lTalisman Protecteur Tier §7§l4", "Ce talisman vous octroie une très grande protection");

    public static ItemStack PommeDeVie= itemBuilder.customItemConfig(Material.GOLDEN_APPLE, "§c§lPomme de vie", "Octroie 2 coeurs supplémentaires");

}
