package fr.cardi.MainPackage.ItemBuilderAndAssignation;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {

    public static ItemStack customItemConfig(Material material, String Name, String desc) {

        // Préparation à la modification de l'Item
        ItemStack It = new ItemStack(material, 1);
        ItemMeta ItM= It.getItemMeta();


        //Effet brillant
        ItM.addEnchant(Enchantment.DIG_SPEED, 1, true);
        ItM.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        //Changer le nom
        ItM.setDisplayName(Name);

        //Description modifié (désolé de l'opti)
        List<String> Lores = new ArrayList<String>(); // Liste des différentes lignes constituants le lore de l'item

        Lores.add("§8§l§m==========§r§8§l[§r §lDescription§r §8§l]§r§8§l§m==========");
        if(desc != null)
        {
            Lores.add("§7§l"+desc);
            Lores.add("§c§lUtilisation unique !");
        }
        else {

            Lores.add("§7§lDésolé mais la description de cet Item a été oublié,");
            Lores.add("§7§lsignale le !");
        }
        Lores.add("§8§l§m=================================");

        ItM.setLore(Lores);

        It.setItemMeta(ItM);

        return It;
    }
}
