package fr.cardi.mana.pool;

import java.util.ArrayList;
import java.util.List;

public class Pool {

    private final String pseudo;

    private int pool, poolMax;


    public Pool(String pseudo, int pool, int poolMax) {
        this.pseudo = pseudo;
        this.pool = pool;
        this.poolMax = poolMax;
    }


    public String getPseudo() {
        return pseudo;
    }

    public int getPool() {
        return pool;
    }

    public void setPool(int pool) {
        this.pool = pool;
    }

    public void addPool(int i) {
        this.pool += i;
    }

    public void removePool(int i) {
        this.pool -= i;
    }

    public int getPoolMax() {
        return poolMax;
    }

    public void addPoolMax(int i) {
        this.poolMax += i;
    }

    public void removePoolMax(int i) {
        this.poolMax -= i;
    }

    public void setPoolMax(int poolMax) {
        this.poolMax = poolMax;
    }
}

