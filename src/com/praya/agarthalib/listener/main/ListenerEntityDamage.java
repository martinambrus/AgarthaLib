// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.listener.main;

import com.praya.agarthalib.event.DamageFinalEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import core.praya.agarthalib.builder.stats.StatsEntity;
import org.bukkit.entity.Entity;
import com.praya.agarthalib.manager.game.StatsEntityManager;
import com.praya.agarthalib.manager.game.GameManager;
import org.bukkit.event.Event;
import com.praya.agarthalib.utility.ServerEventUtil;
import com.praya.agarthalib.event.DamageCalculationEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageEvent;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.event.Listener;
import com.praya.agarthalib.handler.HandlerListener;

public class ListenerEntityDamage extends HandlerListener implements Listener
{
    public ListenerEntityDamage(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @EventHandler(priority = EventPriority.LOWEST)
    public void statsEntityCalculate(final EntityDamageEvent event) {
        final GameManager gameManager = this.plugin.getGameManager();
        final StatsEntityManager statsEntityManager = gameManager.getStatsEntityManager();
        if (!event.isCancelled()) {
            final Entity entityVictims = event.getEntity();
            if (entityVictims instanceof LivingEntity) {
                final LivingEntity victims = (LivingEntity)entityVictims;
                final StatsEntity statsEntity = statsEntityManager.getStatsEntity(victims);
                if (statsEntity != null) {
                    final double damage = event.getDamage();
                    final EntityDamageEvent.DamageCause cause = event.getCause();
                    final Entity entityAttacker = (event instanceof EntityDamageByEntityEvent) ? ((EntityDamageByEntityEvent)event).getDamager() : null;
                    statsEntity.clearStats();
                    final DamageCalculationEvent damageCalculationEvent = new DamageCalculationEvent(cause, entityVictims, entityAttacker, statsEntity, damage);
                    ServerEventUtil.callEvent((Event)damageCalculationEvent);
                    if (damageCalculationEvent.isCancelled()) {
                        event.setCancelled(true);
                        statsEntity.unregister();
                    }
                    else {
                        final double calculationDamage = damageCalculationEvent.getCalculationDamage();
                        event.setDamage(calculationDamage);
                    }
                }
            }
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void statsEntityFinal(final EntityDamageEvent event) {
        final GameManager gameManager = this.plugin.getGameManager();
        final StatsEntityManager statsEntityManager = gameManager.getStatsEntityManager();
        if (!event.isCancelled()) {
            final Entity entityVictims = event.getEntity();
            if (entityVictims instanceof LivingEntity) {
                final LivingEntity victims = (LivingEntity)entityVictims;
                final StatsEntity statsEntity = statsEntityManager.getStatsEntity(victims);
                if (statsEntity != null) {
                    final double damage = event.getDamage();
                    final EntityDamageEvent.DamageCause cause = event.getCause();
                    final Entity entityAttacker = (event instanceof EntityDamageByEntityEvent) ? ((EntityDamageByEntityEvent)event).getDamager() : null;
                    final DamageFinalEvent damageFinalEvent = new DamageFinalEvent(cause, entityVictims, entityAttacker, statsEntity, damage);
                    ServerEventUtil.callEvent((Event)damageFinalEvent);
                    if (damageFinalEvent.isCancelled()) {
                        event.setCancelled(true);
                        statsEntity.unregister();
                    }
                    else {
                        final double finalDamage = damageFinalEvent.getFinalDamage();
                        event.setDamage(finalDamage);
                    }
                }
            }
        }
    }
}
