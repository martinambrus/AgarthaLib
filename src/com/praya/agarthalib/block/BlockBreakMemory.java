// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.block;

import org.bukkit.plugin.java.JavaPlugin;
import core.praya.agarthalib.bridge.unity.Bridge;
import org.bukkit.entity.Player;
import java.util.Iterator;
import org.bukkit.Location;
import org.bukkit.block.Block;
import java.util.Collection;
import com.praya.agarthalib.AgarthaLib;
import java.util.HashMap;
import com.praya.agarthalib.manager.game.BlockBreakManager;

public class BlockBreakMemory extends BlockBreakManager
{
    private final HashMap<Integer, BlockBreakData> mapBlockBreakData;
    
    private BlockBreakMemory(final AgarthaLib plugin) {
        super(plugin);
        this.mapBlockBreakData = new HashMap<Integer, BlockBreakData>();
    }
    
    public static final BlockBreakMemory getInstance() {
        return BlockBreakMemoryHelper.instance;
    }
    
    @Override
    public final Collection<Integer> getIds() {
        return this.mapBlockBreakData.keySet();
    }
    
    @Override
    public final Collection<BlockBreakData> getAllBlockBreakData() {
        return this.mapBlockBreakData.values();
    }
    
    @Override
    public final BlockBreakData getBlockBreakData(final int id) {
        return this.mapBlockBreakData.get(id);
    }
    
    @Override
    public final BlockBreakData getBlockBreakData(final Block block) {
        if (block != null) {
            final Location location = block.getLocation();
            return this.getBlockBreakData(location);
        }
        return null;
    }
    
    @Override
    public final BlockBreakData getBlockBreakData(final Location location) {
        if (location != null) {
            for (final BlockBreakData blockBreakData : this.getAllBlockBreakData()) {
                if (blockBreakData.getLocation().equals((Object)location)) {
                    return blockBreakData;
                }
            }
        }
        return null;
    }
    
    @Override
    public final void blockBreakAnimation(final Collection<Player> players, final Location location, final int stage) {
        this.blockBreakAnimation(players, location, stage, 200);
    }
    
    @Override
    public final void blockBreakAnimation(final Collection<Player> players, final Location location, final int stage, final int cooldown) {
        if (players != null && location != null) {
            final BlockBreakData blockBreakData = this.getBlockBreakData(location);
            final int id = (blockBreakData != null) ? blockBreakData.getId() : this.generateID();
            if (blockBreakData != null) {
                blockBreakData.setCooldown(cooldown);
            }
            else {
                final BlockBreakData newData = new BlockBreakData(id, location, cooldown);
                this.mapBlockBreakData.put(id, newData);
            }
            Bridge.getBridgeBlock().blockBreakAnimation(id, players, location, stage);
        }
    }
    
    public final void removeBlockBreakData(final Block block) {
        final Integer id = this.getBlockBreakId(block);
        if (id != null) {
            this.removeBlockBreakData(id);
        }
    }
    
    public final void removeBlockBreakData(final Location location) {
        final Integer id = this.getBlockBreakId(location);
        if (id != null) {
            this.removeBlockBreakData(id);
        }
    }
    
    public final void removeBlockBreakData(final int id) {
        this.mapBlockBreakData.remove(id);
    }
    
    private final int generateID() {
        int id = -1;
        while (true) {
            final BlockBreakData blockBreakData = this.getBlockBreakData(id);
            if (blockBreakData == null) {
                return id;
            }
            if (!blockBreakData.isActive()) {
                return id;
            }
            --id;
        }
    }
    
    private static class BlockBreakMemoryHelper
    {
        private static final BlockBreakMemory instance;
        
        static {
            final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
            instance = new BlockBreakMemory(plugin);
        }
    }
}
