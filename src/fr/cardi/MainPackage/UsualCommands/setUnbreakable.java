package fr.cardi.MainPackage.UsualCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class setUnbreakable implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player player = (Player) sender;

        if(sender instanceof Player) {
            if (cmd.getName().equalsIgnoreCase("setUnbreakable")) {
                ItemStack item = player.getItemInHand();

                    if (item.getItemMeta().spigot().isUnbreakable() == false) {
                        player.sendMessage("§7§lL'effet Unbreakable a bien été appliqué !");
                        Unbreak(item, true);
                    } else if (item.getItemMeta().spigot().isUnbreakable() == true) {
                        player.sendMessage("§7§lL'effet Unbreakable a bien été enlevé !");
                        Unbreak(item, false);
                    } else sender.sendMessage("§7§l La commande est /setUnbreakable");
                }
            }
        return false;
    }

    public static ItemStack Unbreak(ItemStack item, Boolean bool) {
        ItemMeta meta = item.getItemMeta();
        meta.spigot().setUnbreakable(bool);
        item.setItemMeta(meta);
        return item;
    }
}
