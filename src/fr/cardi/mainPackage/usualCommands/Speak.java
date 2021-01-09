package fr.cardi.mainPackage.usualCommands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Speak implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (args.length < 2) {

            sender.sendMessage("§7§lLa commande est /speak <player> <message>");

        } else {
            StringBuilder bc = new StringBuilder();
            for (int i = 1; i < args.length; i++) {
                bc.append(args[i] + " ");
            }
            Bukkit.broadcastMessage("§l"+ args[0] + " §r§b>> §r" + bc.toString().replace("&", "§"));
        }
        return false;
    }
}
