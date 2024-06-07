package me.beezle.pdiskfix;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Arrow;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class EntityHandler implements Listener {

    private final Random random = new Random();

    @EventHandler
    public void onCreeperDeath(final EntityDeathEvent event) {
        Entity victim = event.getEntity();
        if (victim instanceof Creeper) {
            if (victim.getLastDamageCause() instanceof EntityDamageByEntityEvent) {
                EntityDamageByEntityEvent damage = (EntityDamageByEntityEvent) victim.getLastDamageCause();
                if (damage.getDamager() instanceof Arrow) {
                    Entity shooter = ((Arrow)damage.getDamager()).getShooter();
                    if (shooter instanceof Skeleton) {
                        Material diskType = random.nextBoolean() ? Material.GOLD_RECORD : Material.GREEN_RECORD;
                        victim.getLocation().getWorld().dropItemNaturally(victim.getLocation(), new ItemStack(diskType, 1));
                    }
                }
            }
        }
    }
}