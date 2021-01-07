package fr.cardi.mainPackage.gui.preload;

import fr.cardi.mainPackage.itemBuilderAndAssignation.ItemAssignation;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class PreloadMenu {


    public static void AdminMainInventory(Player player){

        Inventory inv = Bukkit.createInventory(null, 9, "§5§lAdminMainInventory");

        inv.setItem(0, ItemAssignation.AmuletteSpeedAdminGUI);
        inv.setItem(1, ItemAssignation.TalismanProtectionAdminGUI);
        inv.setItem(2, ItemAssignation.PommeDeVie);


        player.openInventory(inv);

    }

    public static void AdminSpeedInventory(Player player){

        Inventory inv = Bukkit.createInventory(null, 9, "§5§lAdminSpeedInventory");

        inv.setItem(3, ItemAssignation.AmuletteSpeedTier1);
        inv.setItem(4, ItemAssignation.AmuletteSpeedTier2);
        inv.setItem(5, ItemAssignation.AmuletteSpeedTier3);

        player.openInventory(inv);

    }

    public static void AdminProtectionInventory(Player player) {

        Inventory inv = Bukkit.createInventory(null, 9, "§5§lAdminProtectionInventory");

        inv.setItem(0, ItemAssignation.TalismanProtection1);
        inv.setItem(1, ItemAssignation.TalismanProtection2);
        inv.setItem(2, ItemAssignation.TalismanProtection3);
        inv.setItem(3, ItemAssignation.TalismanProtection4);

        player.openInventory(inv);

    }

}
