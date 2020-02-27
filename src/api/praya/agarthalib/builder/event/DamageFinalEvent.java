// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.event;

import com.praya.agarthalib.AgarthaLibConfig;
import core.praya.agarthalib.builder.stats.StatsType;
import core.praya.agarthalib.bridge.unity.Bridge;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import com.praya.agarthalib.AgarthaLib;
import core.praya.agarthalib.builder.stats.StatsEntity;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.HandlerList;
import com.praya.agarthalib.event.DamageEvent;

public class DamageFinalEvent extends DamageEvent
{
    private static final HandlerList handlers;
    
    static {
        handlers = new HandlerList();
    }
    
    public DamageFinalEvent(final EntityDamageEvent.DamageCause cause, final Entity victims, final Entity attacker, final StatsEntity statsEntity, final double damage) {
        super(cause, victims, attacker, statsEntity, damage);
    }
    
    public final double getFinalDamage() {
        final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
        final AgarthaLibConfig mainConfig = plugin.getMainConfig();
        final StatsEntity statsEntity = this.getStatsEntity();
        final double damage = this.getDamage();
        final double minDamage = mainConfig.getDamageMinValue();
        final double scaleDamageSwing = (this.hasAttacker() && this.getAttacker() instanceof Player) ? Bridge.getBridgePlayer().getSwingProgress((Player)this.getAttacker()) : 1.0f;
        final double instantAdditionalDamage = statsEntity.getTotalValue(StatsType.INSTANT_ADDITIONAL_DAMAGE) * scaleDamageSwing;
        final double instantAdditionalDefense = statsEntity.getTotalValue(StatsType.INSTANT_ADDITIONAL_DEFENSE);
        final double instantPercentDamage = statsEntity.getTotalValue(StatsType.INSTANT_PERCENT_DAMAGE);
        final double instantPercentDefense = statsEntity.getTotalValue(StatsType.INSTANT_PERCENT_DEFENSE);
        final double finalMultiplier = statsEntity.getTotalValue(StatsType.FINAL_MULTIPLIER);
        final double instantDamage = instantAdditionalDamage * ((100.0 + instantPercentDamage) / 100.0);
        final double instantDefense = instantAdditionalDefense * ((100.0 + instantPercentDefense) / 100.0);
        final double finalDamage = Math.max(minDamage, damage * finalMultiplier + instantDamage - instantDefense);
        return finalDamage;
    }
    
    @Override
    public HandlerList getHandlers() {
        return DamageFinalEvent.handlers;
    }
    
    public static HandlerList getHandlerList() {
        return DamageFinalEvent.handlers;
    }
}
