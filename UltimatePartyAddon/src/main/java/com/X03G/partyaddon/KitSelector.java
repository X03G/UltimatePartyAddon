package com.X03G.partyaddon;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitSelector {

    public static void openKitMenu(Player p, String type) {
        // Expanded to 18 slots to fit 8 kits comfortably
        Inventory inv = Bukkit.createInventory(null, 18, "Select Kit: " + type);

        // Mapping your specific kits to icons
        inv.setItem(0, createItem(Material.DIAMOND_SWORD, "§bSword"));
        inv.setItem(1, createItem(Material.DIAMOND_AXE, "§eAxe"));
        inv.setItem(2, createItem(Material.GOLDEN_APPLE, "§6UHC"));
        inv.setItem(3, createItem(Material.GRASS_BLOCK, "§aSMP"));
        inv.setItem(4, createItem(Material.IRON_CHESTPLATE, "§fVanilla"));
        inv.setItem(5, createItem(Material.POTION, "§dPot"));
        inv.setItem(6, createItem(Material.NETHERITE_CHESTPLATE, "§5Nethpot"));
        inv.setItem(7, createItem(Material.MACE, "§cMACE"));

        p.openInventory(inv);
    }

    private static ItemStack createItem(Material m, String name) {
        ItemStack i = new ItemStack(m);
        ItemMeta meta = i.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(name);
            i.setItemMeta(meta);
        }
        return i;
    }
}