package fr.cardi.mainPackage;

import fr.cardi.mainPackage.gui.adminMenu;
import fr.cardi.mainPackage.gui.preload.guiClickListener;
import fr.cardi.mainPackage.itemBuilderAndAssignation.itemAssignation;
import fr.cardi.mainPackage.listeners.chatTrigger;
import fr.cardi.mainPackage.listeners.consequence.releaseClass;
import fr.cardi.mainPackage.listeners.playerRelative;
import fr.cardi.mainPackage.usualCommands.healthAndFood.feed;
import fr.cardi.mainPackage.usualCommands.healthAndFood.heal;
import fr.cardi.mainPackage.usualCommands.healthAndFood.setHealth;
import fr.cardi.mainPackage.usualCommands.invsee;
import fr.cardi.mainPackage.usualCommands.setUnbreakable;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class main extends JavaPlugin {

        private Logger logger = Logger.getLogger("Minecraft");

        @Override
        public void onEnable(){


            logger.warning("[UtilsAndFeatures a bien demarrer]");


            getServer().getPluginManager().registerEvents(new playerRelative(), this);
            getServer().getPluginManager().registerEvents(new chatTrigger(), this);
            getServer().getPluginManager().registerEvents(new guiClickListener(), this);
            getServer().getPluginManager().registerEvents(new releaseClass(), this);


            getCommand("admin-gui").setExecutor(new adminMenu());
            getCommand("setHealth").setExecutor(new setHealth());
            getCommand("heal").setExecutor(new heal());
            getCommand("feed").setExecutor(new feed());
            getCommand("setUnbreakable").setExecutor(new setUnbreakable());
            getCommand("invsee").setExecutor(new invsee());


            Bukkit.addRecipe(SpeedRecipe());
            Bukkit.addRecipe(ProtectionRecipe());
        }

        @Override
        public void onDisable(){
            logger.info("Sa s'eteint");

        }

        public ShapedRecipe SpeedRecipe() {

            ShapedRecipe recipe = new ShapedRecipe(itemAssignation.AmuletteSpeedTier2);

            recipe.shape("SDS","SPS","SDS");
            recipe.setIngredient('D', Material.DIAMOND);
            recipe.setIngredient('P', Material.FEATHER);
            recipe.setIngredient('S', Material.SUGAR);

            return recipe;
        }

        public ShapedRecipe ProtectionRecipe() {

            ShapedRecipe recipe = new ShapedRecipe(itemAssignation.TalismanProtection2);
            recipe.shape("GGG","EDE","GGG");

            recipe.setIngredient('G', Material.GOLD_INGOT);
            recipe.setIngredient('E', Material.ENCHANTED_BOOK);
            recipe.setIngredient('D', Material.DIAMOND_CHESTPLATE);

            return recipe;
        }
}


