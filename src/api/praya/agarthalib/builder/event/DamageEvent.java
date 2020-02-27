// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.event;

import core.praya.agarthalib.builder.stats.StatsEntity;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Cancellable;
import org.bukkit.event.entity.EntityEvent;

public class DamageEvent extends EntityEvent implements Cancellable
{
    private static final HandlerList handlers;
    private final EntityDamageEvent.DamageCause cause;
    private final Entity attacker;
    private final StatsEntity statsEntity;
    private boolean cancel;
    private double damage;
    
    static {
        handlers = new HandlerList();
    }
    
    public DamageEvent(final EntityDamageEvent.DamageCause cause, final Entity victims, final Entity attacker, final StatsEntity statsEntity, final double damage) {
        super(victims);
        this.cancel = false;
        this.cause = cause;
        this.attacker = attacker;
        this.statsEntity = statsEntity;
        this.setDamage(damage);
    }
    
    public final EntityDamageEvent.DamageCause getCause() {
        return this.cause;
    }
    
    public final Entity getAttacker() {
        return this.attacker;
    }
    
    public final StatsEntity getStatsEntity() {
        return this.statsEntity;
    }
    
    public final boolean hasAttacker() {
        return this.getAttacker() != null;
    }
    
    public final double getDamage() {
        return this.damage;
    }
    
    public final void setDamage(final double damage) {
        this.damage = damage;
    }
    
    public HandlerList getHandlers() {
        return DamageEvent.handlers;
    }
    
    public static HandlerList getHandlerList() {
        return DamageEvent.handlers;
    }
    
    public boolean isCancelled() {
        return this.cancel;
    }
    
    public void setCancelled(final boolean cancel) {
        this.cancel = cancel;
    }
}
