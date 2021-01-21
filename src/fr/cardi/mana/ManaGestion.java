package fr.cardi.mana;

import com.connorlinfoot.actionbarapi.ActionBarAPI;
import fr.cardi.mainPackage.Main;
import fr.cardi.mana.pool.Pool;
import fr.cardi.mana.pool.PoolManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.Random;


public class ManaGestion implements Listener {

    private final Main main;

    public ManaGestion(Main main) {
        this.main = main;
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();
        Pool pool;


        if (main.getConfig().get("players." + player.getName() + ".pool") != null) {
            pool = new Pool(player.getName(),
                    main.getConfig().getInt("players." + player.getName() + ".pool"),
                    main.getConfig().getInt("players." + player.getName() + ".poolmax"));
                    main.saveConfig();
        } else {
            final Random newComer = new Random();
            int newComerMoovePool = getRandomNumberInRange(200, 800);
            pool = new Pool(player.getName(), newComerMoovePool, newComerMoovePool);
        }
        PoolManager.addPool(player.getName(), pool);

        ActionBarAPI.sendActionBar(player, String.valueOf("§6§l"+main.getConfig().getInt("players." + player.getName() + ".pool")) + " / " + String.valueOf(main.getConfig().getInt("players." + player.getName() + ".poolmax")+ "  ☄"), 20*61);
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();

        Pool pool = PoolManager.getPool(player.getName());

        main.getConfig().set("players." + player.getName() + ".pool", pool.getPool());
        main.getConfig().set("players." + player.getName() + ".poolmax", pool.getPoolMax());
        main.saveConfig();

        PoolManager.removePool(player.getName());
    }


    private static int getRandomNumberInRange(int min, int max) {

        Random r = new Random();
        return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();

    }

}
