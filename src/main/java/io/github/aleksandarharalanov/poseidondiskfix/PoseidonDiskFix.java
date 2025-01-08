package io.github.aleksandarharalanov.poseidondiskfix;

import io.github.aleksandarharalanov.poseidondiskfix.listener.EntityDeathListener;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import static io.github.aleksandarharalanov.poseidondiskfix.util.LoggerUtil.logInfo;
import static io.github.aleksandarharalanov.poseidondiskfix.util.UpdateUtil.checkForUpdates;

public class PoseidonDiskFix extends JavaPlugin {

    @Override
    public void onEnable() {
        checkForUpdates(this, "https://api.github.com/repos/AleksandarHaralanov/project-poseidon-pre-b54aad06-creeper-disk-fix/releases/latest");

        PluginManager pluginManager = getServer().getPluginManager();
        final EntityDeathListener entityDeathListener = new EntityDeathListener();
        pluginManager.registerEvent(Event.Type.ENTITY_DEATH, entityDeathListener, Event.Priority.Normal, this);

        logInfo(String.format("[%s] v%s Enabled.", getDescription().getName(), getDescription().getVersion()));
    }

    @Override
    public void onDisable() {
        logInfo(String.format("[%s] v%s Disabled.", getDescription().getName(), getDescription().getVersion()));
    }
}