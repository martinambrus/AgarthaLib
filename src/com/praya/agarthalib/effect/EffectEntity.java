// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.effect;

import org.bukkit.plugin.Plugin;
import java.util.Iterator;
import java.util.Collection;
import org.bukkit.entity.LivingEntity;
import java.util.HashMap;
import java.util.UUID;

public class EffectEntity
{
    private final UUID entityId;
    private final HashMap<String, Effect> mapEffect;
    
    protected EffectEntity(final LivingEntity entity) {
        this(entity, null);
    }
    
    protected EffectEntity(final LivingEntity entity, final HashMap<String, Effect> mapEffect) {
        if (entity == null) {
            throw new IllegalArgumentException();
        }
        final UUID entityId = entity.getUniqueId();
        this.entityId = entityId;
        this.mapEffect = ((mapEffect != null) ? mapEffect : new HashMap<String, Effect>());
    }
    
    public final UUID getEntityId() {
        return this.entityId;
    }
    
    public final Collection<String> getEffectIds() {
        return this.mapEffect.keySet();
    }
    
    public final Collection<Effect> getAllEffect() {
        return this.mapEffect.values();
    }
    
    public final Effect getEffect(final EffectType effectType) {
        if (effectType != null && effectType.isRegistered()) {
            final String id = effectType.getId();
            return this.getEffect(id);
        }
        return null;
    }
    
    public final Effect getEffect(final String id) {
        if (id != null) {
            for (final String key : this.getEffectIds()) {
                if (key.equalsIgnoreCase(id)) {
                    return this.mapEffect.get(key);
                }
            }
        }
        return null;
    }
    
    public final boolean hasEffect(final EffectType effectType) {
        return this.getEffect(effectType) != null;
    }
    
    public final boolean hasEffect(final String id) {
        return this.getEffect(id) != null;
    }
    
    public final boolean isEmpty() {
        return this.getAllEffect().isEmpty();
    }
    
    public final double getTotalEffectValue(final String id) {
        final Effect effect = this.getEffect(id);
        return (effect != null) ? effect.getTotalValue() : 0.0;
    }
    
    public final void setEffect(final Plugin plugin, final String id, final String key, final Double value) {
        this.setEffect(plugin, id, key, value, null);
    }
    
    public final void setEffect(final Plugin plugin, final String id, final String key, final Double value, final Integer duration) {
        if (id != null) {
            final EffectType effectType = EffectType.getEffectType(id);
            this.setEffect(plugin, effectType, key, value, duration);
        }
    }
    
    public final void setEffect(final Plugin plugin, final EffectType effectType, final String key, final Double value) {
        this.setEffect(plugin, effectType, key, value, null);
    }
    
    public final void setEffect(final Plugin plugin, final EffectType effectType, final String key, final Double value, final Integer duration) {
        if (plugin != null && effectType != null && effectType.isRegistered() && key != null) {
            final String id = effectType.getId();
            final Effect effect = this.getEffect(id);
            if (effect != null) {
                effect.setEffect(plugin, key, value, duration);
            }
            else {
                final Effect effectNew = new Effect(effectType);
                effectNew.setEffect(plugin, key, value, duration);
                this.mapEffect.put(id, effectNew);
            }
        }
    }
    
    public final void clearEffect() {
        this.mapEffect.clear();
    }
    
    public final boolean unregister() {
        final EffectEntityMemory effectEntityMemory = EffectEntityMemory.getInstance();
        return effectEntityMemory.unregister(this);
    }
    
    public final void removeEffect(final String id) {
        this.mapEffect.remove(id);
    }
    
    public static final EffectEntity getEffectEntity(final LivingEntity entity) {
        final EffectEntityMemory effectEntityMemory = EffectEntityMemory.getInstance();
        final EffectEntity effectEntity = effectEntityMemory.getEffectEntity(entity);
        return effectEntity;
    }
}
