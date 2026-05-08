package com.X03G.partyaddon;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class DuelListener implements Listener {
    private final PartyAddonPlugin plugin;

    public DuelListener(PartyAddonPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        // Validate it's our inventory
        if (e.getView().getTitle().startsWith("Select Kit: ")) {
            e.setCancelled(true); // Stop players from taking items 

            if (e.getCurrentItem() == null || !e.getCurrentItem().hasItemMeta()) return;

            Player p = (Player) e.getWhoClicked();
            // Strip colors to get the raw kit name (e.g., "MACE") [cite: 2]
            String kit = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName());
            String mode = e.getView().getTitle().split(": ")[1];

            p.closeInventory();
            p.sendMessage("§a[Party] Starting " + mode + " duel using kit: " + kit);

            // This links to com/X03G/ultimatepvp/system/MatchManager.class 
            try {
                if (plugin.getMatchManager() != null) {
                    // Logic to trigger the match in UltimatePvP
                    // plugin.getMatchManager().startPartyDuel(p, kit, mode);
                }
            } catch (Exception ex) {
                p.sendMessage("§cError connecting to UltimatePvP MatchManager.");
            }
        }
    }
}