package com.haralanov.poseidon_diskfix;

import com.haralanov.utilities.UpdateUtil;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginDescriptionFile;

import static org.bukkit.Bukkit.getLogger;

public class PoseidonDiskFix extends JavaPlugin {

    private static String NAME;
    private static String VERSION;
    private static String AUTHOR;
    private static String SOURCE;

    @Override
    public void onEnable() {
        final PluginDescriptionFile pdf = this.getDescription();
        VERSION = pdf.getVersion();
        NAME = pdf.getName();
        AUTHOR = pdf.getAuthors().get(0);
        SOURCE = pdf.getWebsite();

        UpdateUtil.checkForUpdates(NAME, VERSION, "https://api.github.com/repos/AleksandarHaralanov/Poseidon-DiskFix/releases/latest");

        getServer().getPluginManager().registerEvents(new EntityDeathListener(), this);

        final PoseidonDiskFixCommand pDiskFixCommand = new PoseidonDiskFixCommand(NAME, VERSION, AUTHOR, SOURCE);
        getCommand("pdf").setExecutor(pDiskFixCommand);

        getLogger().info(String.format("[%s] v%s Enabled.", NAME, VERSION));
    }

    @Override
    public void onDisable() {
        getLogger().info(String.format("[%s] v%s Disabled.", NAME, VERSION));
    }
}
