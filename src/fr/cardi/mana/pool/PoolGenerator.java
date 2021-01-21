package fr.cardi.mana.pool;

import com.connorlinfoot.actionbarapi.ActionBarAPI;
import fr.cardi.mainPackage.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PoolGenerator {

    private final Main main;

    public PoolGenerator(Main main) {
        this.main = main;
    }

    int i = 0;

    public void start() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(main, () -> {
            i++;
            for (Player p : Bukkit.getOnlinePlayers()) {
                Pool pool = PoolManager.getPool(p.getName());
                if (pool.getPool() < pool.getPoolMax()) pool.addPool(pool.getPoolMax()/120);
                if (i == 120) {
                    pool.addPoolMax(10);
                    i = 0;
                }
                update(p.getName());
                ActionBarAPI.sendActionBar(p, String.valueOf("§6§l"+main.getConfig().getInt("players." + p.getName() + ".pool")) + " / " + String.valueOf(main.getConfig().getInt("players." + p.getName() + ".poolmax")+ "  ☄"), 20*61);
            }
        }, 0L, 1200L);
    }

    public void update(String pseudo) {
        Pool pool = PoolManager.getPool(pseudo);

        main.getConfig().set("players." + pseudo + ".pool", pool.getPool());
        main.getConfig().set("players." + pseudo + ".poolmax", pool.getPoolMax());
        main.saveConfig();
    }
}
