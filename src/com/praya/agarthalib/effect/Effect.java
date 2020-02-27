// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.effect;

import java.util.Iterator;
import org.bukkit.plugin.Plugin;
import java.util.Collection;
import java.util.HashMap;

public class Effect
{
    private final EffectType effectType;
    private final HashMap<String, EffectPlugin> mapEffectPlugin;
    
    protected Effect(final EffectType effectType) {
        this(effectType, null);
    }
    
    protected Effect(final EffectType effectType, final HashMap<String, EffectPlugin> mapEffectPlugin) {
        if (effectType == null) {
            throw new IllegalArgumentException();
        }
        this.effectType = effectType;
        this.mapEffectPlugin = ((mapEffectPlugin != null) ? mapEffectPlugin : new HashMap<String, EffectPlugin>());
    }
    
    public final EffectType getEffectType() {
        return this.effectType;
    }
    
    public final Collection<String> getRegisteredPlugin() {
        return this.mapEffectPlugin.keySet();
    }
    
    public final Collection<EffectPlugin> getAllEffectPlugin() {
        return this.mapEffectPlugin.values();
    }
    
    public final EffectPlugin getEffectPlugin(final Plugin plugin) {
        if (plugin != null) {
            final String pluginName = plugin.getName();
            return this.getEffectPlugin(pluginName);
        }
        return null;
    }
    
    public final EffectPlugin getEffectPlugin(final String plugin) {
        if (plugin != null) {
            for (final String key : this.getRegisteredPlugin()) {
                if (key.equalsIgnoreCase(plugin)) {
                    return this.mapEffectPlugin.get(key);
                }
            }
        }
        return null;
    }
    
    public final boolean isExists(final Plugin plugin) {
        return this.getEffectPlugin(plugin) != null;
    }
    
    public final boolean isExists(final String plugin) {
        return this.getEffectPlugin(plugin) != null;
    }
    
    public final boolean isEmpty() {
        return this.getAllEffectPlugin().isEmpty();
    }
    
    public final double getTotalValue() {
        double totalValue = 0.0;
        for (final EffectPlugin effectPlugin : this.getAllEffectPlugin()) {
            final double value = effectPlugin.getTotalValue();
            totalValue += value;
        }
        return totalValue;
    }
    
    public final void setEffect(final Plugin plugin, final String key, final Double value, final Integer duration) {
        if (plugin != null && key != null) {
            if (this.isExists(plugin)) {
                final EffectPlugin effectPlugin = this.getEffectPlugin(plugin);
                effectPlugin.setEffect(key, value, duration);
            }
            else {
                final String pluginName = plugin.getName();
                final EffectPlugin effectPlugin2 = new EffectPlugin(plugin);
                effectPlugin2.setEffect(key, value, duration);
                this.mapEffectPlugin.put(pluginName, effectPlugin2);
            }
        }
    }
    
    public final void removeEffect(final Plugin plugin) {
        if (plugin != null) {
            final String pluginName = plugin.getName();
            this.removeEffect(pluginName);
        }
    }
    
    public final void removeEffect(final String plugin) {
        this.mapEffectPlugin.remove(plugin);
    }
}
