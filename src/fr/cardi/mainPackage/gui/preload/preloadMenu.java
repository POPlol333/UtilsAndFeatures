package fr.cardi.mainPackage.gui.preload;

import fr.cardi.mainPackage.itemBuilderAndAssignation.itemAssignation;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class preloadMenu {


    public static void AdminMainInventory(Player player){

        Inventory inv = Bukkit.createInventory(null, 9, "§5§lAdminMainInventory");

        inv.setItem(0, itemAssignation.AmuletteSpeedAdminGUI);
        inv.setItem(1, itemAssignation.TalismanProtectionAdminGUI);
        inv.setItem(2, itemAssignation.PommeDeVie);


        player.openInventory(inv);

    }

    public static void AdminSpeedInventory(Player player){

        Inventory inv = Bukkit.createInventory(null, 9, "§5§lAdminSpeedInventory");

        inv.setItem(3, itemAssignation.AmuletteSpeedTier1);
        inv.setItem(4, itemAssignation.AmuletteSpeedTier2);
        inv.setItem(5, itemAssignation.AmuletteSpeedTier3);

        player.openInventory(inv);

    }

    public static void AdminProtectionInventory(Player player) {

        Inventory inv = Bukkit.createInventory(null, 9, "§5§lAdminProtectionInventory");

        inv.setItem(0, itemAssignation.TalismanProtection1);
        inv.setItem(1, itemAssignation.TalismanProtection2);
        inv.setItem(2, itemAssignation.TalismanProtection3);
        inv.setItem(3, itemAssignation.TalismanProtection4);

        player.openInventory(inv);

    }

}
