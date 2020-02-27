// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.stats;

import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.manager.game.StatsEntityManager;
import org.bukkit.entity.LivingEntity;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class StatsEntityMemory extends StatsEntityManager
{
    private final HashMap<UUID, StatsEntity> mapStatsEntity;
    
    private StatsEntityMemory(final AgarthaLib plugin) {
        super(plugin);
        this.mapStatsEntity = new HashMap<UUID, StatsEntity>();
    }
    
    public static final StatsEntityMemory getInstance() {
        return StatsEntityMemorySingleton.instance;
    }
    
    @Override
    public final Collection<UUID> getEntityIds() {
        return this.mapStatsEntity.keySet();
    }
    
    @Override
    public final Collection<StatsEntity> getAllStatsEntity() {
        return this.mapStatsEntity.values();
    }
    
    @Override
    public final StatsEntity getStatsEntity(final LivingEntity entity) {
        return this.getStatsEntity(entity, false);
    }
    
    @Override
    public final StatsEntity getStatsEntity(final LivingEntity entity, final boolean generate) {
        if (entity != null) {
            final UUID entityId = entity.getUniqueId();
            if (!this.getEntityIds().contains(entityId) && generate) {
                final StatsEntity statsEntity = new StatsEntity(entity);
                this.mapStatsEntity.put(entityId, statsEntity);
            }
            return this.mapStatsEntity.get(entityId);
        }
        return null;
    }
    
    protected final boolean unregister(final StatsEntity statsEntity) {
        if (statsEntity != null && this.getAllStatsEntity().contains(statsEntity)) {
            final UUID entityId = statsEntity.getEntityId();
            this.mapStatsEntity.remove(entityId);
            return true;
        }
        return false;
    }
    
    private static class StatsEntityMemorySingleton
    {
        private static final StatsEntityMemory instance;
        
        static {
            final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
            instance = new StatsEntityMemory(plugin);
        }
    }
}
