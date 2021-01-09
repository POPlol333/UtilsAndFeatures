package fr.cardi.mainPackage.gui;


import fr.cardi.mainPackage.gui.preload.PreloadMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class AdminMenu implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(cmd.getName().equalsIgnoreCase("admin-gui")){

                PreloadMenu.AdminMainInventory(player);

            }

        }

        return false;
    }





}
