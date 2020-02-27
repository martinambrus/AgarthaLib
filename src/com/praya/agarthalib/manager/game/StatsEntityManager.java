// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.manager.game;

import org.bukkit.entity.LivingEntity;
import core.praya.agarthalib.builder.stats.StatsEntity;
import java.util.UUID;
import java.util.Collection;
import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerManager;

public abstract class StatsEntityManager extends HandlerManager
{
    protected StatsEntityManager(final AgarthaLib plugin) {
        super(plugin);
    }
    
    public abstract Collection<UUID> getEntityIds();
    
    public abstract Collection<StatsEntity> getAllStatsEntity();
    
    public abstract StatsEntity getStatsEntity(final LivingEntity p0);
    
    public abstract StatsEntity getStatsEntity(final LivingEntity p0, final boolean p1);
    
    public final boolean isExists(final LivingEntity entity) {
        return this.getStatsEntity(entity) != null;
    }
}
