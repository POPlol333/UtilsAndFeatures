package fr.cardi.mainPackage.usualCommands.healthAndFood;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (cmd.getName().equalsIgnoreCase("heal")) {

                if (args.length != 1) {
                    player.sendMessage("§7§lLa commande est /heal <Player>");
                } else {
                    String targetName = args[0];
                    if (Bukkit.getPlayer(targetName) != null) {
                        Player target = Bukkit.getPlayer(targetName);
                        target.setHealth(target.getMaxHealth());
                        target.sendMessage("§7§lVous avez été heal !");
                        player.sendMessage(String.format("§7§lVous avez heal %s !", targetName));
                    } else {
                        player.sendMessage(String.format("§7§lAucun joueur ne porte le pseudo %s", targetName));

                    }
                }
            }
        }
        return false;
    }
}
