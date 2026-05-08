package com.X03G.partyaddon;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PartyCommand implements CommandExecutor {
    private final PartyAddonPlugin plugin;

    public PartyCommand(PartyAddonPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player p)) return true;

        if (args.length == 0) {
            p.sendMessage(ChatColor.AQUA + "/party duel <1v1|2v2|3v3>");
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "duel" -> {
                if (args.length < 2) p.sendMessage(ChatColor.RED + "Usage: /party duel <1v1|2v2|3v3>");
                else KitSelector.openKitMenu(p, args[1]);
            }
            case "invite" -> p.sendMessage(ChatColor.GREEN + "Party invite sent!");
            case "kick" -> p.sendMessage(ChatColor.RED + "Player kicked.");
            case "disband" -> p.sendMessage(ChatColor.YELLOW + "Party disbanded.");
        }
        return true;
    }
}