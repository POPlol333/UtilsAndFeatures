package fr.cardi.mainPackage.gui.preload;

import fr.cardi.mainPackage.itemBuilderAndAssignation.Items;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class PreloadMenu {


    public static void AdminMainInventory(Player player){

        Inventory inv = Bukkit.createInventory(null, 27, "§5§lAdminMainInventory");

        inv.setItem(0, Items.AMU_SPEED_GUI.getItem());
        inv.setItem(1, Items.TAL_PROTEC_GUI.getItem());
        inv.setItem(26, Items.OTHER_GUI.getItem());


        player.openInventory(inv);

    }

    public static void AdminSpeedInventory(Player player){

        Inventory inv = Bukkit.createInventory(null, 9, "§5§lAdminSpeedInventory");

        inv.setItem(3, Items.AMU_SPEED_T1.getItem());
        inv.setItem(4, Items.AMU_SPEED_T2.getItem());
        inv.setItem(5, Items.AMU_SPEED_T3.getItem());

        player.openInventory(inv);

    }

    public static void AdminProtectionInventory(Player player) {

        Inventory inv = Bukkit.createInventory(null, 9, "§5§lAdminProtectionInventory");

        inv.setItem(0, Items.TAL_PROTEC_T1.getItem());
        inv.setItem(1, Items.TAL_PROTEC_T2.getItem());
        inv.setItem(2, Items.TAL_PROTEC_T3.getItem());
        inv.setItem(3, Items.TAL_PROTEC_T4.getItem());


        player.openInventory(inv);

    }

    public static void OtherGui(Player player) {

        Inventory inv = Bukkit.createInventory(null, 9, "§5§lOtherGUI");

        inv.setItem(2, Items.POMME_DE_VIE.getItem());
        inv.setItem(3, Items.ENERGY_DRINK.getItem());
        inv.setItem(4, Items.PETIT_BANDAGE.getItem());

        player.openInventory(inv);
    }

}
