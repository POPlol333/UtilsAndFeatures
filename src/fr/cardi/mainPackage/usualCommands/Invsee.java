package fr.cardi.mainPackage.usualCommands;

import fr.cardi.mainPackage.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Invsee implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if(sender instanceof Player) {

         Player player = (Player) sender;

            if (cmd.getName().equalsIgnoreCase("invsee")) {

                if(args.length != 1) {
                    player.sendMessage("§7§lLa commande est /invsee <Player> ");
                } else {

                    String targetName = args[0];
                    if (Bukkit.getPlayer(targetName) != null) {

                        Player target = Bukkit.getPlayer(targetName);
                        player.openInventory(target.getInventory());

                    }
                }
            }

        }
        return false;
    }
}
