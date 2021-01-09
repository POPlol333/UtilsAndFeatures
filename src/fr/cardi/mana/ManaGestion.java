package fr.cardi.mana;

import fr.cardi.mainPackage.Main;
import fr.cardi.mana.pool.Pool;
import fr.cardi.mana.pool.PoolManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

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
        } else {
            pool = new Pool(player.getName(), 300, 300);
        }

        PoolManager.addPool(player.getName(), pool);
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


}
