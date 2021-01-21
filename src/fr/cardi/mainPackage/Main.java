package fr.cardi.mainPackage;

import fr.cardi.mainPackage.gui.AdminMenu;
import fr.cardi.mainPackage.gui.preload.GuiClickListener;
import fr.cardi.mainPackage.itemBuilderAndAssignation.Items;
import fr.cardi.mainPackage.listeners.ChatTrigger;
import fr.cardi.mainPackage.listeners.consequence.ReleaseClass;
import fr.cardi.mainPackage.listeners.PlayerRelative;
import fr.cardi.mainPackage.usualCommands.*;
import fr.cardi.mainPackage.usualCommands.healthAndFood.Feed;
import fr.cardi.mainPackage.usualCommands.healthAndFood.Heal;
import fr.cardi.mainPackage.usualCommands.healthAndFood.SetHealth;
import fr.cardi.mainPackage.usualCommands.playerRelative.Injure;
import fr.cardi.mainPackage.usualCommands.playerRelative.Invsee;
import fr.cardi.mainPackage.usualCommands.playerRelative.Speak;
import fr.cardi.mainPackage.usualCommands.playerRelative.head;
import fr.cardi.mana.ManaGestion;
import fr.cardi.mana.pool.PoolGenerator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {

        public static Main plugin;

        private Logger logger = Logger.getLogger("Minecraft");


        @Override
        public void onEnable(){

            saveDefaultConfig();

            logger.warning("[UtilsAndFeatures a bien démarré]");

            registerEvents();

            getCommand("admin-gui").setExecutor(new AdminMenu());
            getCommand("setHealth").setExecutor(new SetHealth());
            getCommand("heal").setExecutor(new Heal());
            getCommand("feed").setExecutor(new Feed());
            getCommand("setUnbreakable").setExecutor(new SetUnbreakable());
            getCommand("invsee").setExecutor(new Invsee());
            getCommand("broadcast").setExecutor(new Broadcast());
            getCommand("head").setExecutor(new head());
            getCommand("speak").setExecutor(new Speak());
            getCommand("injure").setExecutor(new Injure());

            Bukkit.addRecipe(SpeedRecipe());
            Bukkit.addRecipe(ProtectionRecipe());
            Bukkit.addRecipe(lifeAppleRecipe());
            Bukkit.addRecipe(energyDrinkRecipe());

            new PoolGenerator(this).start();
        }

        @Override
        public void onDisable(){
            saveConfig();
            logger.info("s'est éteint");

        }

        public void registerEvents() {
            PluginManager pm = Bukkit.getPluginManager();

            pm.registerEvents(new PlayerRelative(), this);
            pm.registerEvents(new ChatTrigger(), this);
            pm.registerEvents(new GuiClickListener(), this);
            pm.registerEvents(new ReleaseClass(), this);
            pm.registerEvents(new ManaGestion(this), this);
        }

        public ShapedRecipe SpeedRecipe() {

            ShapedRecipe recipe = new ShapedRecipe(Items.AMU_SPEED_T2.getItem());

            recipe.shape("SDS","SPS","SDS");
            recipe.setIngredient('D', Items.AMU_SPEED_T1.getItem().getData());
            recipe.setIngredient('P', Material.FEATHER);
            recipe.setIngredient('S', Material.SUGAR);

            return recipe;
        }

        public ShapedRecipe ProtectionRecipe() {

            ShapedRecipe recipe = new ShapedRecipe(Items.TAL_PROTEC_T2.getItem());
            recipe.shape("GGG","EDE","GGG");

            recipe.setIngredient('G', Material.GOLD_INGOT);
            recipe.setIngredient('E', Material.ENCHANTED_BOOK);
            recipe.setIngredient('D', Material.DIAMOND_CHESTPLATE);

            return recipe;
        }

        public ShapedRecipe lifeAppleRecipe() {

            ShapedRecipe recipe = new ShapedRecipe(Items.POMME_DE_VIE.getItem());
            recipe.shape("GGG","GPG","GGG");

            recipe.setIngredient('G', Material.GOLD_BLOCK);
            recipe.setIngredient('P', Material.GOLDEN_APPLE, 1);

            return recipe;
        }

        public ShapedRecipe energyDrinkRecipe() {

            ShapedRecipe recipe = new ShapedRecipe(Items.ENERGY_DRINK.getItem());
            recipe.shape("SBS","PNF","SBS");

            recipe.setIngredient('S', Material.SUGAR);
            recipe.setIngredient('B', Material.BLAZE_POWDER);
            recipe.setIngredient('P', Material.DIAMOND_PICKAXE);
            recipe.setIngredient('N', Material.NETHER_STAR);
            recipe.setIngredient('F', Material.RABBIT_FOOT);

            return recipe;
        }

    public static Main getInstance() {
        return plugin;
    }
}


