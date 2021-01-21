package fr.cardi.mainPackage.usualCommands.playerRelative;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Injure implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if(args.length == 1) {
            String targetName = args[0];
            if(Bukkit.getPlayer(targetName) != null) {
                Player target =  Bukkit.getPlayer(targetName);
                target.setHealth(1);
            } else sender.sendMessage("§4§lCe joueur n'existe pas");
        } else  sender.sendMessage("§4§lLa commande est /injure <player>");
        return false;
    }
}
