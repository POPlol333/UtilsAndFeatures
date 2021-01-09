package fr.cardi.mana.pool;

import java.util.ArrayList;
import java.util.List;

public class Pool {

    private final String pseudo;
    private boolean hasInfiniteMana;
    private int pool, poolMax;
    private ArrayList<String> techniqueList;

    public Pool(String pseudo, int pool, int poolMax, boolean hasInfiniteMana, ArrayList<String> techniqueList) {
        this.pseudo = pseudo;
        this.pool = pool;
        this.poolMax = poolMax;
        this.hasInfiniteMana = hasInfiniteMana;
        this.techniqueList = techniqueList;
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

    public boolean getHasInfiniteMana() {
        return this.hasInfiniteMana;
    }
    public void setHasInfinitMana(boolean bool) {
        this.hasInfiniteMana = bool;
    }

    public void addTechniqueList(String args) {
        this.techniqueList.add(args);

    }

    public void removeTechniqueList(String args) {
        this.techniqueList.remove(args);

    }

    public List<String> getTechniqueList() {
        return this.techniqueList;
    }
}