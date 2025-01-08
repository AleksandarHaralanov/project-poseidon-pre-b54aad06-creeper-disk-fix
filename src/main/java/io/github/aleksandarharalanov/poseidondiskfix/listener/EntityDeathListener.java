package io.github.aleksandarharalanov.poseidondiskfix.listener;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class EntityDeathListener extends EntityListener {

    @Override
    public void onEntityDeath(EntityDeathEvent event) {
        Entity victim = event.getEntity();
        if (victim instanceof Creeper) {
            if (victim.getLastDamageCause() instanceof EntityDamageByEntityEvent) {
                EntityDamageByEntityEvent damage = (EntityDamageByEntityEvent) victim.getLastDamageCause();
                if (damage.getDamager() instanceof Arrow) {
                    Entity shooter = ((Arrow) damage.getDamager()).getShooter();
                    if (shooter instanceof Skeleton) {
                        Random random = new Random();
                        Material disk = random.nextBoolean() ? Material.GOLD_RECORD : Material.GREEN_RECORD;
                        victim.getWorld().dropItemNaturally(victim.getLocation(), new ItemStack(disk, 1));
                        event.getDrops().clear();
                    }
                }
            }
        }
    }
}
