// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.manager.game;

import org.bukkit.entity.Player;
import org.bukkit.Location;
import org.bukkit.block.Block;
import core.praya.agarthalib.builder.block.BlockBreakData;
import java.util.Collection;
import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerManager;

public abstract class BlockBreakManager extends HandlerManager
{
    protected BlockBreakManager(final AgarthaLib plugin) {
        super(plugin);
    }
    
    public abstract Collection<Integer> getIds();
    
    public abstract Collection<? extends BlockBreakData> getAllBlockBreakData();
    
    public abstract BlockBreakData getBlockBreakData(final int p0);
    
    public abstract BlockBreakData getBlockBreakData(final Block p0);
    
    public abstract BlockBreakData getBlockBreakData(final Location p0);
    
    public abstract void blockBreakAnimation(final Collection<Player> p0, final Location p1, final int p2);
    
    public abstract void blockBreakAnimation(final Collection<Player> p0, final Location p1, final int p2, final int p3);
    
    public final boolean hasBlockBreakData(final int id) {
        return this.getBlockBreakData(id) != null;
    }
    
    public final boolean hasBlockBreakData(final Block block) {
        return this.getBlockBreakData(block) != null;
    }
    
    public final boolean hasBlockBreakData(final Location location) {
        return this.getBlockBreakData(location) != null;
    }
    
    public final Integer getBlockBreakId(final Block block) {
        final BlockBreakData blockBreakData = this.getBlockBreakData(block);
        return (blockBreakData != null) ? Integer.valueOf(blockBreakData.getID()) : null;
    }
    
    public final Integer getBlockBreakId(final Location location) {
        final BlockBreakData blockBreakData = this.getBlockBreakData(location);
        return (blockBreakData != null) ? Integer.valueOf(blockBreakData.getID()) : null;
    }
    
    public final boolean hasActiveBlockBreak(final int id) {
        final BlockBreakData blockBreakData = this.getBlockBreakData(id);
        return blockBreakData != null && blockBreakData.isActive();
    }
    
    public final boolean hasActiveBlockBreak(final Block block) {
        final BlockBreakData blockBreakData = this.getBlockBreakData(block);
        return blockBreakData != null && blockBreakData.isActive();
    }
    
    public final boolean hasActiveBlockBreak(final Location location) {
        final BlockBreakData blockBreakData = this.getBlockBreakData(location);
        return blockBreakData != null && blockBreakData.isActive();
    }
}
