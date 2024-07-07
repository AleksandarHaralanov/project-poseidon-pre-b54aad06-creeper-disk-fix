package com.haralanov.poseidon_diskfix;

import java.util.Random;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Creeper;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Skeleton;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class EntityDeathListener implements Listener {

    @EventHandler
    public void onCreeperDeath(final EntityDeathEvent event) {
        final Entity victim = event.getEntity();

        if (victim instanceof Creeper) {
            if (victim.getLastDamageCause() instanceof EntityDamageByEntityEvent) {
                final EntityDamageByEntityEvent damage = (EntityDamageByEntityEvent) victim.getLastDamageCause();

                if (damage.getDamager() instanceof Arrow) {
                    final Entity shooter = ((Arrow)damage.getDamager()).getShooter();

                    if (shooter instanceof Skeleton) {
                        final Random random = new Random();
                        final Material diskType = random.nextBoolean() ? Material.GOLD_RECORD : Material.GREEN_RECORD;

                        victim.getLocation().getWorld().dropItemNaturally(victim.getLocation(), new ItemStack(diskType, 1));
                    }
                }
            }
        }
    }
}