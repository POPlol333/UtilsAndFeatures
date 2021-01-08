package fr.cardi.mainPackage.gui.preload;

import fr.cardi.mainPackage.itemBuilderAndAssignation.ItemAssignation;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GuiClickListener implements Listener {


    @EventHandler
    public void onClick(InventoryClickEvent e) {

        Inventory inv = e.getInventory();
        Player player = (Player) e.getWhoClicked();
        ItemStack current = e.getCurrentItem();

        if(current == null) return;

        if(inv.getName().equalsIgnoreCase("§5§lAdminMainInventory")) {
            if(current.getType() != Material.GOLDEN_APPLE) e.setCancelled(true);

            if(current.getType()== Material.POTION) {
                player.getInventory().addItem(ItemAssignation.EnergyDrink);

            }

            if(current.getType()== Material.FEATHER){
                player.closeInventory();
                PreloadMenu.AdminSpeedInventory(player);

            }

            if(current.getType()== Material.DIAMOND) {
                player.closeInventory();
                PreloadMenu.AdminProtectionInventory(player);

            }

        }

    }


}
