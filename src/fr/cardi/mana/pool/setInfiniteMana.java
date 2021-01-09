package fr.cardi.mana.pool;

import fr.cardi.mainPackage.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class setInfiniteMana implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {


        if(cmd.getName().equalsIgnoreCase("setInfiniteMana")) {

            if (args.length == 1) {

                String targetName = args[0];
                Pool pool = PoolManager.getPool(targetName);

                if (pool.getHasInfiniteMana()) {
                    pool.setHasInfinitMana(false);
                    System.out.println(pool.getHasInfiniteMana());
                } else {
                    pool.setHasInfinitMana(true);
                    System.out.println(pool.getHasInfiniteMana());
                }


            }
        }

        return false;
    }
}
