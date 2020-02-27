// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.effect;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.Iterator;
import java.util.Collection;
import com.praya.agarthalib.AgarthaLib;
import java.util.HashMap;
import com.praya.agarthalib.manager.game.EffectTypeManager;

public class EffectTypeMemory extends EffectTypeManager
{
    private final HashMap<String, EffectType> mapEffectType;
    
    private EffectTypeMemory(final AgarthaLib plugin) {
        super(plugin);
        this.mapEffectType = new HashMap<String, EffectType>();
    }
    
    public static final EffectTypeMemory getInstance() {
        return EffectCustomMemoryHelper.instance;
    }
    
    @Override
    public final Collection<String> getEffectTypeIds() {
        return this.mapEffectType.keySet();
    }
    
    @Override
    public final Collection<EffectType> getAllEffectType() {
        return this.mapEffectType.values();
    }
    
    @Override
    public final EffectType getEffectType(final String id) {
        if (id != null) {
            for (final String key : this.getEffectTypeIds()) {
                if (key.equalsIgnoreCase(id)) {
                    return this.mapEffectType.get(key);
                }
            }
        }
        return null;
    }
    
    @Override
    public final boolean isRegistered(final EffectType effectType) {
        return effectType != null && this.getAllEffectType().contains(effectType);
    }
    
    protected final boolean register(final EffectType effectType) {
        if (effectType != null) {
            final String id = effectType.getId();
            if (!this.isExists(id)) {
                this.mapEffectType.put(id, effectType);
                return true;
            }
        }
        return false;
    }
    
    protected final boolean unregister(final EffectType customEffectType) {
        if (customEffectType != null && this.getAllEffectType().contains(customEffectType)) {
            final String id = customEffectType.getId();
            this.mapEffectType.remove(id);
            return true;
        }
        return false;
    }
    
    private static class EffectCustomMemoryHelper
    {
        private static final EffectTypeMemory instance;
        
        static {
            final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
            instance = new EffectTypeMemory(plugin);
        }
    }
}
