package com.X03G.partyaddon;

import com.X03G.ultimatepvp.UltimatePvP;
import com.X03G.ultimatepvp.system.PartyManager;
import com.X03G.ultimatepvp.system.MatchManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import java.lang.reflect.Field;

public class PartyAddonPlugin extends JavaPlugin {
    private PartyManager partyManager;
    private MatchManager matchManager;

    @Override
    public void onEnable() {
        if (Bukkit.getPluginManager().getPlugin("UltimatePvP") instanceof UltimatePvP) {
            setupHooks();
        }
        
        if (getCommand("party") != null) {
            getCommand("party").setExecutor(new PartyCommand(this));
        }
        
        getServer().getPluginManager().registerEvents(new DuelListener(this), this);
    }

    private void setupHooks() {
        try {
            UltimatePvP api = (UltimatePvP) Bukkit.getPluginManager().getPlugin("UltimatePvP");
            for (Field f : api.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.getType().equals(PartyManager.class)) this.partyManager = (PartyManager) f.get(api);
                if (f.getType().equals(MatchManager.class)) this.matchManager = (MatchManager) f.get(api);
            }
        } catch (Exception e) { 
            getLogger().severe("Could not hook into UltimatePvP systems!"); 
        }
    }

    public PartyManager getPartyManager() { return partyManager; }
    public MatchManager getMatchManager() { return matchManager; }
}