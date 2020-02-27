// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.event;

import core.praya.agarthalib.builder.stats.StatsEntity;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageEvent extends api.praya.agarthalib.builder.event.DamageEvent
{
    public DamageEvent(final EntityDamageEvent.DamageCause cause, final Entity victims, final Entity attacker, final StatsEntity statsEntity, final double damage) {
        super(cause, victims, attacker, statsEntity, damage);
    }
}
