// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.event;

import com.praya.agarthalib.AgarthaLibConfig;
import com.praya.agarthalib.manager.player.PlayerSwingManager;
import com.praya.agarthalib.manager.player.PlayerManager;
import core.praya.agarthalib.builder.stats.StatsType;
import com.praya.agarthalib.utility.CombatUtil;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import com.praya.agarthalib.AgarthaLib;
import core.praya.agarthalib.builder.stats.StatsEntity;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.HandlerList;
import com.praya.agarthalib.event.DamageEvent;

public class DamageCalculationEvent extends DamageEvent
{
    private static final HandlerList handlers;
    
    static {
        handlers = new HandlerList();
    }
    
    public DamageCalculationEvent(final EntityDamageEvent.DamageCause cause, final Entity victims, final Entity attacker, final StatsEntity statsEntity, final double damage) {
        super(cause, victims, attacker, statsEntity, damage);
    }
    
    public final double getCalculationDamage() {
        final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
        final PlayerManager playerManager = plugin.getPlayerManager();
        final PlayerSwingManager playerSwingManager = playerManager.getPlayerSwingManager();
        final AgarthaLibConfig mainConfig = plugin.getMainConfig();
        final StatsEntity statsEntity = this.getStatsEntity();
        final Entity entityVictims = this.getEntity();
        final Entity entityAttacker = this.getAttacker();
        final Player player = (entityAttacker != null && entityAttacker instanceof Player) ? ((Player)entityAttacker) : null;
        final LivingEntity victims = (entityVictims instanceof LivingEntity) ? (LivingEntity) entityVictims : null;
        final boolean enableFormula = mainConfig.isDamageEnableFormula();
        final double multiplierDamageSwing = CombatUtil.isNormalDamage(victims) ? playerSwingManager.getPlayerSwing(player) : 1.0f;
        final double baseAdditionalDamage = statsEntity.getTotalValue(StatsType.BASE_ADDITIONAL_DAMAGE) * multiplierDamageSwing;
        final double baseAdditionalDefense = statsEntity.getTotalValue(StatsType.BASE_ADDITIONAL_DEFENSE);
        final double basePercentDamage = statsEntity.getTotalValue(StatsType.BASE_PERCENT_DAMAGE);
        final double basePercentDefense = statsEntity.getTotalValue(StatsType.BASE_PERCENT_DEFENSE);
        final double statsDamage = (this.getDamage() + baseAdditionalDamage) * ((100.0 + basePercentDamage) / 100.0);
        final double statsDefense = baseAdditionalDefense * ((100.0 + basePercentDefense) / 100.0);
        double calculationDamage;
        if (enableFormula) {
            final double scaleDefense = mainConfig.getDamageScaleDefense();
            calculationDamage = statsDamage * (1.0 - Math.min(1.0, statsDefense * scaleDefense / statsDamage));
        }
        else {
            calculationDamage = statsDamage - statsDefense;
        }
        return calculationDamage;
    }
    
    @Override
    public HandlerList getHandlers() {
        return DamageCalculationEvent.handlers;
    }
    
    public static HandlerList getHandlerList() {
        return DamageCalculationEvent.handlers;
    }
}
