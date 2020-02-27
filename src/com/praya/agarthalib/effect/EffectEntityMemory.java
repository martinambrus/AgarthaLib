// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.effect;

import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.manager.game.EffectEntityManager;
import org.bukkit.entity.LivingEntity;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class EffectEntityMemory extends EffectEntityManager
{
    private final HashMap<UUID, EffectEntity> mapEffectEntity;
    
    private EffectEntityMemory(final AgarthaLib plugin) {
        super(plugin);
        this.mapEffectEntity = new HashMap<UUID, EffectEntity>();
    }
    
    public static final EffectEntityMemory getInstance() {
        return EffectEntityMemorySingleton.instance;
    }
    
    @Override
    public final Collection<UUID> getEntityIds() {
        return this.mapEffectEntity.keySet();
    }
    
    @Override
    public final Collection<EffectEntity> getAllEffectEntity() {
        return this.mapEffectEntity.values();
    }
    
    @Override
    public final EffectEntity getEffectEntity(final LivingEntity entity) {
        return this.getEffectEntity(entity, false);
    }
    
    @Override
    public final EffectEntity getEffectEntity(final LivingEntity entity, final boolean generate) {
        if (entity != null) {
            final UUID entityId = entity.getUniqueId();
            if (!this.getEntityIds().contains(entityId) && generate) {
                final EffectEntity effectEntity = new EffectEntity(entity);
                this.mapEffectEntity.put(entityId, effectEntity);
            }
            return this.mapEffectEntity.get(entityId);
        }
        return null;
    }
    
    protected final boolean unregister(final EffectEntity effectEntity) {
        if (effectEntity != null && this.getAllEffectEntity().contains(effectEntity)) {
            final UUID entityId = effectEntity.getEntityId();
            this.mapEffectEntity.remove(entityId);
            return true;
        }
        return false;
    }
    
    private static class EffectEntityMemorySingleton
    {
        private static final EffectEntityMemory instance;
        
        static {
            final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
            instance = new EffectEntityMemory(plugin);
        }
    }
}
