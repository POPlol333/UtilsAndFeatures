package fr.cardi.MainPackage;

import fr.cardi.MainPackage.GUI.AdminMenu;
import fr.cardi.MainPackage.GUI.preload.GUIClickListener;
import fr.cardi.MainPackage.Listeners.ChatTrigger;
import fr.cardi.MainPackage.Listeners.PlayerRelative;
import fr.cardi.MainPackage.UsualCommands.SetHealth;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class main extends JavaPlugin {

        private Logger logger = Logger.getLogger("Minecraft");


        public void onEnable(){


            logger.warning("Sa démarre");


            getServer().getPluginManager().registerEvents(new PlayerRelative(), this);
            getServer().getPluginManager().registerEvents(new ChatTrigger(), this);
            getServer().getPluginManager().registerEvents(new GUIClickListener(), this);

            getCommand("admin-gui").setExecutor(new AdminMenu());
            getCommand("manualSetHealth").setExecutor(new SetHealth());

        }

        public void onDisable(){
            logger.info("Sa s'éteint");

        }


}


