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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.logging.Logger;

public class WaterSealing implements CommandExecutor {

    private java.util.logging.Logger logger = Logger.getLogger("Minecraft");

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        Server server = Bukkit.getServer();
        ConsoleCommandSender consoleSender = server.getConsoleSender();

        if(sender instanceof Player) {

            if (args.length == 1) {

                Player player = (Player) sender;

                Pool pool = PoolManager.getPool(player.getName());


                if(pool.getTechniqueList().contains("water-sealing")) {
                    if(pool.getHasInfiniteMana()) player.sendMessage("ok");
                    else player.sendMessage("non");
                    if (pool.getHasInfiniteMana() || pool.getPool() >= 200) {
                        String targetName = args[0];

                        if (Bukkit.getPlayer(targetName) != null) {
                            Player target = Bukkit.getPlayer(targetName);
                            target.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 1));
                            target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, Integer.MAX_VALUE, 10));

                            if(!pool.getHasInfiniteMana()) pool.removePool(200);

                            Bukkit.dispatchCommand(target, "/hsphere 95 7,7,7");
                            Bukkit.dispatchCommand(target, "/sphere 9 6,6,6");
                            logger.warning(String.format("%s A UTILISÉ WATER SEALING SUR %s, IL LUI RESTE %s UNITÉ DE MANA", pool.getPseudo(), target.getName(), pool.getPool()));
                        }
                    }
                    else {
                        player.sendMessage("§3§oJe n'ai pas assez de mana..");
                    }
                }
            }
        }


        return false;
    }

}
