package fr.cardi.mainPackage.gui.preload;

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

            e.setCancelled(true);

            switch (current.getType()) {
                case FEATHER:
                    player.closeInventory();
                    PreloadMenu.AdminSpeedInventory(player);
                    break;
                case DIAMOND:
                    player.closeInventory();
                    PreloadMenu.AdminProtectionInventory(player);
                    break;
                case NETHER_STAR:
                    player.closeInventory();
                    PreloadMenu.OtherGui(player);
                    break;
            }

        }

    }


}
