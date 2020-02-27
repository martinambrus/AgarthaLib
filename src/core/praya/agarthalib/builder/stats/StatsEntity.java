// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.stats;

import com.praya.agarthalib.manager.game.StatsEntityManager;
import com.praya.agarthalib.manager.game.GameManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.plugin.Plugin;
import java.util.Collection;
import org.bukkit.entity.LivingEntity;
import java.util.HashMap;
import java.util.UUID;

public class StatsEntity
{
    private final UUID entityId;
    private final HashMap<StatsType, Stats> mapStats;
    
    protected StatsEntity(final LivingEntity entity) {
        this(entity, null);
    }
    
    protected StatsEntity(final LivingEntity entity, final HashMap<StatsType, Stats> mapStats) {
        if (entity == null) {
            throw new IllegalArgumentException();
        }
        final UUID entityId = entity.getUniqueId();
        this.entityId = entityId;
        this.mapStats = ((mapStats != null) ? mapStats : new HashMap<StatsType, Stats>());
    }
    
    public final UUID getEntityId() {
        return this.entityId;
    }
    
    public final Collection<StatsType> getAllStatsType() {
        return this.mapStats.keySet();
    }
    
    public final Collection<Stats> getAllStats() {
        return this.mapStats.values();
    }
    
    public final Stats getStats(final StatsType type) {
        return this.mapStats.get(type);
    }
    
    public final boolean hasStats(final StatsType type) {
        return this.getStats(type) != null;
    }
    
    public final double getValue(final StatsType type, final Plugin plugin) {
        return this.getValue(type, plugin, null);
    }
    
    public final double getValue(final StatsType type, final Plugin plugin, final String id) {
        if (type != null) {
            final Stats stats = this.getStats(type);
            return (stats != null) ? stats.getValue(plugin, id) : type.getValue();
        }
        return 0.0;
    }
    
    public final double getTotalValueByPlugin(final StatsType type, final Plugin plugin) {
        if (type != null) {
            final Stats stats = this.getStats(type);
            return (stats != null) ? stats.getTotalValueByPlugin(plugin) : type.getValue();
        }
        return 0.0;
    }
    
    public final double getTotalValueByPlugin(final StatsType type, final String plugin) {
        if (type != null) {
            final Stats stats = this.getStats(type);
            return (stats != null) ? stats.getTotalValueByPlugin(plugin) : type.getValue();
        }
        return 0.0;
    }
    
    public final double getTotalValueByID(final StatsType type, final String id) {
        if (type != null) {
            final Stats stats = this.getStats(type);
            return (stats != null) ? stats.getTotalValueByID(id) : type.getValue();
        }
        return 0.0;
    }
    
    public final double getTotalValue(final StatsType type) {
        if (type != null) {
            final Stats stats = this.getStats(type);
            return (stats != null) ? stats.getTotalValue() : type.getValue();
        }
        return 0.0;
    }
    
    public final void setValue(final StatsType type, final Plugin plugin, final String id, final double value) {
        if (type != null && plugin != null && id != null) {
            final Stats stats = this.getStats(type);
            if (stats != null) {
                stats.setValue(plugin, id, value);
            }
            else {
                final Stats statsNew = new Stats(type);
                statsNew.setValue(plugin, id, value);
                this.mapStats.put(type, statsNew);
            }
        }
    }
    
    public final void clearStats() {
        this.mapStats.clear();
    }
    
    public final boolean unregister() {
        final StatsEntityMemory statsEntityMemory = StatsEntityMemory.getInstance();
        return statsEntityMemory.unregister(this);
    }
    
    public static final StatsEntity getStatsEntity(final LivingEntity entity) {
        final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
        final GameManager gameManager = plugin.getGameManager();
        final StatsEntityManager statsEntityManager = gameManager.getStatsEntityManager();
        final StatsEntity statsEntity = statsEntityManager.getStatsEntity(entity);
        return statsEntity;
    }
}
