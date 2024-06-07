package me.beezle.pdiskfix;

import org.bukkit.plugin.java.JavaPlugin;

public class pDiskFix extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EntityHandler(), this);
        System.out.print("[pDiskFix v1.0.0] Enabled.");
    }

    @Override
    public void onDisable() {
        System.out.print("[pDiskFix v1.0.0] Disabled.");
    }
}
