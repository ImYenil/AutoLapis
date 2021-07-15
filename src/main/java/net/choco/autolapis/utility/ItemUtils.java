package net.choco.autolapis.utility;

import net.choco.autolapis.utility.compatbridge.model.CompMaterial;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtils {

    public static ItemStack getLapis() {
        ItemStack item = new ItemStack(CompMaterial.BLUE_DYE.getMaterial(), 3, (short) CompMaterial.BLUE_DYE.getData());
        ItemMeta itemMeta = item.getItemMeta();
        item.setItemMeta(itemMeta);
        return item;
    }
}
