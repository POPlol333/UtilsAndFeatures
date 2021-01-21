package fr.cardi.mainPackage.itemBuilderAndAssignation;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum Items {

    AMU_SPEED_GUI(ItemBuilder.customItemConfig(Material.FEATHER, "§f§lAmulettes de Vitesse", "catégorie regroupant les amulettes de vitesse")),
    AMU_SPEED_T1(ItemBuilder.customItemConfig(Material.FEATHER, "§f§lAmulette de Vitesse Tier §f§l1", "Cette amulette augmente un peu votre vitesse")),
    AMU_SPEED_T2(ItemBuilder.customItemConfig(Material.FEATHER, "§f§lAmulette de Vitesse Tier §f§l2", "Cette amulette augmente votre vitesse")),
    AMU_SPEED_T3(ItemBuilder.customItemConfig(Material.FEATHER, "§f§lAmulette de Vitesse Tier §f§l3", "Cette amulette augmente grandement votre vitesse")),

    TAL_PROTEC_GUI(ItemBuilder.customItemConfig(Material.DIAMOND, "§7§lTalismans de Protection", "catégorie regroupant les talismans de protection")),
    TAL_PROTEC_T1(ItemBuilder.customItemConfig(Material.DIAMOND, "§7§lTalisman Protecteur Tier §7§l1", "Ce talisman vous octroie un peu de protection")),
    TAL_PROTEC_T2(ItemBuilder.customItemConfig(Material.DIAMOND, "§7§lTalisman Protecteur Tier §7§l2", "Ce talisman vous octroie de la protection")),
    TAL_PROTEC_T3(ItemBuilder.customItemConfig(Material.DIAMOND, "§7§lTalisman Protecteur Tier §7§l3", "Ce talisman vous octroie une grande protection")),
    TAL_PROTEC_T4(ItemBuilder.customItemConfig(Material.DIAMOND, "§7§lTalisman Protecteur Tier §7§l4", "Ce talisman vous octroie une très grande protection")),

    OTHER_GUI(ItemBuilder.customItemConfig(Material.NETHER_STAR, "§6§lAutres", "Items sans tier")),
    POMME_DE_VIE(ItemBuilder.customItemConfig(Material.GOLDEN_APPLE, "§c§lPomme de vie", "Octroie 2 coeurs supplémentaires")),
    ENERGY_DRINK(ItemBuilder.customItemConfig(Material.POTION, "§2§lEnergy §e§lDrink", "Boost vos capacités physiques !")),
    PETIT_BANDAGE(ItemBuilder.customItemConfig(Material.PAPER, "§f§lBandage de qualité moyenne", "Regen 5 HP")),

    ARGENT(ItemBuilder.customItemConfig(Material.EMERALD, "§a§lVarys", "De l'argent"));



    private final ItemStack item;
    
    Items(ItemStack item) {
        this.item = item;
    }

    public ItemStack getItem() {
        return item;
    }

    
    public boolean isEquals(ItemStack item) {
        return getItem().getItemMeta().getDisplayName().equals(item.getItemMeta().getDisplayName());
    }
}
