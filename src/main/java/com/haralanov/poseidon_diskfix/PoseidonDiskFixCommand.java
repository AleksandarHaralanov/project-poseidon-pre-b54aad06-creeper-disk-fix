package com.haralanov.poseidon_diskfix;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

import static org.bukkit.Bukkit.getLogger;

public class PoseidonDiskFixCommand implements CommandExecutor {

    private final String NAME;
    private final String VERSION;
    private final String AUTHOR;
    private final String SOURCE;

    public PoseidonDiskFixCommand(final String NAME, final String VERSION, final String AUTHOR, final String SOURCE) {
        this.NAME = NAME;
        this.VERSION = VERSION;
        this.AUTHOR = AUTHOR;
        this.SOURCE = SOURCE;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {
        final Player player = (commandSender instanceof Player) ? (Player) commandSender : null;

        if (player != null) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    String.format("&e%s v%s &bby &e%s", NAME, VERSION, AUTHOR)));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    String.format("&bSource: &e%s", SOURCE)));
        } else {
            getLogger().info(String.format("%s v%s by %s", NAME, VERSION, AUTHOR));
            getLogger().info(String.format("Source: %s", SOURCE));
        }

        return true;
    }
}