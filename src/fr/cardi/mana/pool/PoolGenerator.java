package fr.cardi.mana.pool;

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
                if (pool.getPool() < pool.getPoolMax()) pool.addPool(2);
                if (i == 120) {
                    pool.addPoolMax(10);
                    i = 0;
                }
                update(p.getName());
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
