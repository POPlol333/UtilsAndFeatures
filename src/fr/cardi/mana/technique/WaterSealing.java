package fr.cardi.mana.technique;

import fr.cardi.mana.pool.Pool;
import fr.cardi.mana.pool.PoolManager;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

public class WaterSealing implements CommandExecutor {

    private java.util.logging.Logger logger = Logger.getLogger("Minecraft");

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        Server server = Bukkit.getServer();
        ConsoleCommandSender consoleSender = server.getConsoleSender();

        if(sender instanceof Player) {

            Player player = (Player) sender;

            Pool pool = PoolManager.getPool(player.getName());

            if(pool.getPool() >= 200) {

                Bukkit.dispatchCommand(player, "/hsphere 95 7,7,7");
                Bukkit.dispatchCommand(player, "/sphere 9 6,6,6");
                pool.removePool(200);
                logger.warning(String.format("%s A UTILISÉ WATER SEALING, IL LUI RESTE %s UNITÉ DE MANA", pool.getPseudo(), pool.getPool()));
            } else {
                player.sendMessage("Tu n'as pas assez de mana");
            }
        }


        return false;
    }

}
