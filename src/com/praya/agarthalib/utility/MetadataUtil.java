// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.metadata.MetadataValue;

public class MetadataUtil
{
    public static final MetadataValue createMetadata(final Object value) {
        final Plugin plugin = (Plugin)JavaPlugin.getProvidingPlugin((Class)AgarthaLib.class);
        return createMetadata(plugin, value);
    }
    
    public static final MetadataValue createMetadata(final Plugin plugin, final Object value) {
        return (MetadataValue)((plugin != null && value != null) ? new FixedMetadataValue(plugin, value) : null);
    }
    
    public static final MetadataValue getMetadata(final Entity entity, final String metadata) {
        return (entity != null && metadata != null) ? (hasMetadata(entity, metadata) ? entity.getMetadata(metadata).get(0) : null) : null;
    }
    
    public static final MetadataValue getMetadata(final Block block, final String metadata) {
        return (block != null && metadata != null) ? (hasMetadata(block, metadata) ? block.getMetadata(metadata).get(0) : null) : null;
    }
    
    public static final boolean hasMetadata(final Entity entity, final String metadata) {
        return entity != null && metadata != null && entity.hasMetadata(metadata);
    }
    
    public static final boolean hasMetadata(final Block block, final String metadata) {
        return block != null && metadata != null && block.hasMetadata(metadata);
    }
    
    public static final void removeMetadata(final Entity entity, final String metadata) {
        final Plugin plugin = (Plugin)JavaPlugin.getProvidingPlugin((Class)AgarthaLib.class);
        removeMetadata(plugin, entity, metadata);
    }
    
    public static final void removeMetadata(final Plugin plugin, final Entity entity, final String metadata) {
        if (plugin != null && entity != null && metadata != null) {
            entity.removeMetadata(metadata, plugin);
        }
    }
    
    public static final void removeMetadata(final Block block, final String metadata) {
        final Plugin plugin = (Plugin)JavaPlugin.getProvidingPlugin((Class)AgarthaLib.class);
        removeMetadata(plugin, block, metadata);
    }
    
    public static final void removeMetadata(final Plugin plugin, final Block block, final String metadata) {
        if (plugin != null && block != null && metadata != null) {
            block.removeMetadata(metadata, plugin);
        }
    }
    
    public static final boolean isCooldown(final Block block, final String metadata) {
        if (!hasMetadata(block, metadata)) {
            return false;
        }
        final long expired = getMetadata(block, metadata).asLong();
        final long time = System.currentTimeMillis();
        if (time < expired) {
            return true;
        }
        removeMetadata(block, metadata);
        return false;
    }
    
    public static final boolean isCooldown(final Entity entity, final String metadata) {
        if (!hasMetadata(entity, metadata)) {
            return false;
        }
        final long expired = getMetadata(entity, metadata).asLong();
        final long time = System.currentTimeMillis();
        if (time < expired) {
            return true;
        }
        removeMetadata(entity, metadata);
        return false;
    }
    
    public static final boolean isExpired(final Block block, final String metadata) {
        return !isCooldown(block, metadata);
    }
    
    public static final boolean isExpired(final Entity entity, final String metadata) {
        return !isCooldown(entity, metadata);
    }
    
    public static final void setCooldown(final Entity entity, final String metadata, final long cooldown) {
        final long expired = System.currentTimeMillis() + cooldown;
        if (entity != null && metadata != null) {
            entity.setMetadata(metadata, createMetadata(expired));
        }
    }
    
    public static final void setCooldown(final Block block, final String metadata, final long cooldown) {
        final long expired = System.currentTimeMillis() + cooldown;
        if (block != null && metadata != null) {
            block.setMetadata(metadata, createMetadata(expired));
        }
    }
    
    public static final double getTimeCooldown(final Entity entity, final String metadata) {
        final long time = System.currentTimeMillis();
        return (double)((entity != null && metadata != null) ? (isCooldown(entity, metadata) ? (getMetadata(entity, metadata).asLong() - time) : 0L) : 0L);
    }
}
