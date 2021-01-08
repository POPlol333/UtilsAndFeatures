package fr.cardi.mainPackage.usualCommands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Broadcast implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (cmd.getName().equalsIgnoreCase("broadcast")) {

            if(args.length ==0) sender.sendMessage("§7§lLa commande est /broadcast <message>");
            else {

                StringBuilder bc = new StringBuilder();
                for(String part : args) {
                    bc.append(part+ " ");
                }
                Bukkit.broadcastMessage("§8§l[§6§lBroadcast§8§l] §r" + bc.toString().replace("&", "§"));
            }
        }
        return false;
    }
}
