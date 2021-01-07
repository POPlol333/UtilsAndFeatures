package fr.cardi.MainPackage.UsualCommands.HealthAndFood;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (cmd.getName().equalsIgnoreCase("feed")) {

                if (args.length < 1 || args.length > 1) {
                    player.sendMessage("§7§lLa commande est /feed <Player>");
                } else if (args.length == 1) {

                    String targetName = args[0];
                    if (Bukkit.getPlayer(targetName) != null) {
                        Player target = Bukkit.getPlayer(targetName);
                        target.setFoodLevel(20);
                        target.sendMessage("§7§lVotre barre de nourriture a été remplie !");
                        player.sendMessage(String.format("§7§lVous rempli la barre de nourriture de %s !", targetName));
                    } else {
                        player.sendMessage(String.format("§7§lAucun joueur ne porte le pseudo %s", targetName));

                    }
                }
            }
        }
        return false;
    }
}