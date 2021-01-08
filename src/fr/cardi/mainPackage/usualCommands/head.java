package fr.cardi.mainPackage.usualCommands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class head implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(sender instanceof Player) {

            Player player = (Player) sender;

            if(cmd.getName().equalsIgnoreCase("head")) {

                if(args.length != 1) player.sendMessage("§7§lLa commande est /head <player>");
                else {

                    String targetName = args[0];
                    OfflinePlayer target = Bukkit.getOfflinePlayer(targetName);

                    player.sendMessage(String.format("§7§lVous vous êtes donné la tête de §6§l%s", targetName));
                    ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
                    SkullMeta meta = (SkullMeta) head.getItemMeta();
                    meta.setOwner(target.getName());
                    meta.setDisplayName(String.format("§6§lTête de %s", target.getName()));
                    List<String> Lores = new ArrayList<String>();
                    Lores.add("§7Cette tête a été give");
                    meta.setLore(Lores);
                    head.setItemMeta(meta);

                    player.getInventory().addItem(head);

                }
            }
        }
        return false;
    }
}
