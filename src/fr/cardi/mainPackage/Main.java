package fr.cardi.mainPackage;

import fr.cardi.mainPackage.gui.AdminMenu;
import fr.cardi.mainPackage.gui.preload.GuiClickListener;
import fr.cardi.mainPackage.itemBuilderAndAssignation.ItemAssignation;
import fr.cardi.mainPackage.listeners.ChatTrigger;
import fr.cardi.mainPackage.listeners.consequence.ReleaseClass;
import fr.cardi.mainPackage.listeners.PlayerRelative;
import fr.cardi.mainPackage.usualCommands.Broadcast;
import fr.cardi.mainPackage.usualCommands.head;
import fr.cardi.mainPackage.usualCommands.healthAndFood.Feed;
import fr.cardi.mainPackage.usualCommands.healthAndFood.Heal;
import fr.cardi.mainPackage.usualCommands.healthAndFood.SetHealth;
import fr.cardi.mainPackage.usualCommands.Invsee;
import fr.cardi.mainPackage.usualCommands.SetUnbreakable;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {

        public static Main plugin;

        private Logger logger = Logger.getLogger("Minecraft");

        @Override
        public void onEnable(){


            logger.warning("[UtilsAndFeatures a bien démarré]");

            getServer().getPluginManager().registerEvents(new PlayerRelative(), this);
            getServer().getPluginManager().registerEvents(new ChatTrigger(), this);
            getServer().getPluginManager().registerEvents(new GuiClickListener(), this);
            getServer().getPluginManager().registerEvents(new ReleaseClass(), this);


            getCommand("admin-gui").setExecutor(new AdminMenu());
            getCommand("setHealth").setExecutor(new SetHealth());
            getCommand("heal").setExecutor(new Heal());
            getCommand("feed").setExecutor(new Feed());
            getCommand("setUnbreakable").setExecutor(new SetUnbreakable());
            getCommand("invsee").setExecutor(new Invsee());
            getCommand("broadcast").setExecutor(new Broadcast());
            getCommand("head").setExecutor(new head());


            Bukkit.addRecipe(SpeedRecipe());
            Bukkit.addRecipe(ProtectionRecipe());
            Bukkit.addRecipe(lifeAppleRecipe());
            Bukkit.addRecipe(energyDrinkRecipe());

        }

        @Override
        public void onDisable(){
            logger.info("s'est éteint");

        }

        public ShapedRecipe SpeedRecipe() {

            ShapedRecipe recipe = new ShapedRecipe(ItemAssignation.AmuletteSpeedTier2);

            recipe.shape("SDS","SPS","SDS");
            recipe.setIngredient('D', Material.DIAMOND);
            recipe.setIngredient('P', Material.FEATHER);
            recipe.setIngredient('S', Material.SUGAR);

            return recipe;
        }

        public ShapedRecipe ProtectionRecipe() {

            ShapedRecipe recipe = new ShapedRecipe(ItemAssignation.TalismanProtection2);
            recipe.shape("GGG","EDE","GGG");

            recipe.setIngredient('G', Material.GOLD_INGOT);
            recipe.setIngredient('E', Material.ENCHANTED_BOOK);
            recipe.setIngredient('D', Material.DIAMOND_CHESTPLATE);

            return recipe;
        }

        public ShapedRecipe lifeAppleRecipe() {

            ShapedRecipe recipe = new ShapedRecipe(ItemAssignation.PommeDeVie);
            recipe.shape("GGG","GPG","GGG");

            recipe.setIngredient('G', Material.GOLD_BLOCK);
            recipe.setIngredient('P', Material.GOLDEN_APPLE, 1);

            return recipe;
        }

        public ShapedRecipe energyDrinkRecipe() {

            ShapedRecipe recipe = new ShapedRecipe(ItemAssignation.EnergyDrink);
            recipe.shape("SBS","PNF","SBS");

            recipe.setIngredient('S', Material.SUGAR);
            recipe.setIngredient('B', Material.BLAZE_POWDER);
            recipe.setIngredient('P', Material.DIAMOND_PICKAXE);
            recipe.setIngredient('N', Material.NETHER_STAR);
            recipe.setIngredient('F', Material.RABBIT_FOOT);

            return recipe;
        }

}


