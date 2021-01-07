package fr.cardi.mainPackage.usualCommands.healthAndFood;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetHealth implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if(sender instanceof Player) {

            Player player = (Player) sender;


            if(cmd.getName().equalsIgnoreCase("setHealth")){

                if(args.length < 2 || args.length > 2) {
                    player.sendMessage("§7§lLa commande est /manualSetHealth <Player> <int>");
                }
                else if (args.length == 2) {

                    String targetName = args[0];
                    if(Bukkit.getPlayer(targetName) != null) {
                        Player target = Bukkit.getPlayer(targetName);
                        target.setMaxHealth(Integer.parseInt(args[1]));
                        target.sendMessage(String.format("§7§lVotre vie maximale a été fixée à %s HP !", args[1]));
                        player.sendMessage(String.format("§7§lLa vie de %s a été fixée à %s HP !", targetName, args[1]));
                    }
                    else {
                        player.sendMessage(String.format("§7§lAucun joueur ne porte le pseudo %s", targetName));
                    }
                }
            }

        }
        return false;
    }
}
