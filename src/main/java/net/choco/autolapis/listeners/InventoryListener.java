package net.choco.autolapis.listeners;

import net.choco.autolapis.utility.ItemUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class InventoryListener implements Listener {

    @EventHandler
    public void onOpen(InventoryOpenEvent inventoryOpenEvent) {
        Inventory inventory = inventoryOpenEvent.getInventory();
        if (inventory == null) {
            return;
        }
        if (inventory.getType().equals(InventoryType.ENCHANTING)) {
                inventory.setItem(1, ItemUtils.getLapis());
            }
        }

    @EventHandler
    public void onClose(InventoryCloseEvent inventoryCloseEvent) {
        Inventory inventory = inventoryCloseEvent.getInventory();
        if (inventory == null) {
            return;
        }
        if (inventory.getType().equals(InventoryType.ENCHANTING)) {
                inventory.setItem(1, null);
            }
    }

    @EventHandler
    public void onClick(InventoryClickEvent inventoryClickEvent) {
        Inventory inventory = inventoryClickEvent.getClickedInventory();
        Player player = (Player)inventoryClickEvent.getWhoClicked();
        if (inventory == null) {
            return;
        }
        if (inventory.getType().equals(InventoryType.ENCHANTING) && inventoryClickEvent.getSlot() == 1) {
            inventoryClickEvent.setCancelled(true);
            player.updateInventory();
        }
    }
}
