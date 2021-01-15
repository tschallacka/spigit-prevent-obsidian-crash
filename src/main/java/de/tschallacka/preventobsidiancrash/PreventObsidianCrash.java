package de.tschallacka.preventobsidiancrash;

import de.tschallacka.preventobsidiancrash.event.ObsidianLightedByDispenserListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class PreventObsidianCrash extends JavaPlugin {

    static PreventObsidianCrash plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getServer().getPluginManager().registerEvents(new ObsidianLightedByDispenserListener(), this);
        plugin = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        plugin = null;
    }

}
