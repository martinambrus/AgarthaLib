// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.listener.main;

import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import core.praya.agarthalib.builder.stats.StatsEntity;
import com.praya.agarthalib.effect.EffectEntity;
import org.bukkit.entity.Entity;
import com.praya.agarthalib.manager.game.StatsEntityManager;
import com.praya.agarthalib.manager.game.EffectEntityManager;
import com.praya.agarthalib.manager.game.GameManager;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDeathEvent;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.event.Listener;
import com.praya.agarthalib.handler.HandlerListener;

public class ListenerEntityDeath extends HandlerListener implements Listener
{
    public ListenerEntityDeath(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void entityDeathEvent(final EntityDeathEvent event) {
        final GameManager gameManager = this.plugin.getGameManager();
        final EffectEntityManager effectEntityManager = gameManager.getEffectEntityManager();
        final StatsEntityManager statsEntityManager = gameManager.getStatsEntityManager();
        final Entity entity = (Entity)event.getEntity();
        if (entity instanceof LivingEntity) {
            final LivingEntity victims = (LivingEntity)entity;
            final EffectEntity effectEntity = effectEntityManager.getEffectEntity(victims);
            final StatsEntity statsEntity = statsEntityManager.getStatsEntity(victims);
            if (effectEntity != null) {
                effectEntity.unregister();
            }
            if (statsEntity != null) {
                statsEntity.unregister();
            }
        }
    }
}
