package fr.cardi.mana.pool;

import fr.cardi.mainPackage.Main;

import java.util.HashMap;
import java.util.Map;

public class PoolManager {

    private static Map<String, Pool> pools = new HashMap<>();

    public static Map<String, Pool> getPools() {
        return pools;
    }

    public static void addPool(String pseudo, Pool pool) {
        pools.put(pseudo, pool);
    }

    public static void removePool(String pseudo) {
        pools.remove(pseudo);
    }

    public static Pool getPool(String pseudo) {
        return pools.get(pseudo);
    }
}
