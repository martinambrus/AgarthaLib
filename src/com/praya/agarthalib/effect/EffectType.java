// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.effect;

import java.util.Collection;
import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public abstract class EffectType
{
    private final Plugin plugin;
    private final String id;
    
    protected EffectType(final Plugin plugin, final String id) {
        if (plugin == null || id == null) {
            throw new IllegalArgumentException();
        }
        this.plugin = plugin;
        this.id = id;
    }
    
    public abstract String getName(final Player p0);
    
    public abstract List<String> getDescription(final Player p0);
    
    public final Plugin getPlugin() {
        return this.plugin;
    }
    
    public final String getId() {
        return this.id;
    }
    
    public final boolean isRegistered() {
        final EffectTypeMemory effectTypeMemory = EffectTypeMemory.getInstance();
        return effectTypeMemory.isRegistered(this);
    }
    
    public final boolean register() {
        final EffectTypeMemory effectTypeMemory = EffectTypeMemory.getInstance();
        return effectTypeMemory.register(this);
    }
    
    public final boolean unregister() {
        final EffectTypeMemory effectTypeMemory = EffectTypeMemory.getInstance();
        return effectTypeMemory.unregister(this);
    }
    
    public static final EffectType[] values() {
        final EffectTypeMemory effectTypeMemory = EffectTypeMemory.getInstance();
        final Collection<EffectType> allEffectType = effectTypeMemory.getAllEffectType();
        final int size = allEffectType.size();
        return allEffectType.toArray(new EffectType[size]);
    }
    
    public static final EffectType getEffectType(final String id) {
        final EffectTypeMemory effectTypeMemory = EffectTypeMemory.getInstance();
        return effectTypeMemory.getEffectType(id);
    }
}
