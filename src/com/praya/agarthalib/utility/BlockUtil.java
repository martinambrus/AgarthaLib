// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.task.TaskBlockBreakAnimation;
import core.praya.agarthalib.bridge.main.MainBridge;
import com.praya.agarthalib.block.BlockChainStatus;
import org.bukkit.block.BlockFace;
import java.util.Set;
import org.bukkit.Material;
import java.util.HashSet;
import com.praya.agarthalib.block.BlockChain;
import com.praya.agarthalib.manager.game.BlockBreakManager;
import com.praya.agarthalib.manager.game.GameManager;
import java.util.Iterator;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import com.praya.agarthalib.AgarthaLibConfig;
import org.bukkit.plugin.java.JavaPlugin;
import com.praya.agarthalib.AgarthaLib;
import java.util.ArrayList;
import org.bukkit.Location;
import java.util.Collection;

public class BlockUtil
{
    private static final Collection<Location> dataLoc;
    
    static {
        dataLoc = new ArrayList<Location>();
    }
    
    public static final Collection<Location> getDataLoc() {
        return BlockUtil.dataLoc;
    }
    
    public static final void blockBreakAnimation(final Location location, final double radius) {
        blockBreakAnimation(location, radius, null);
    }
    
    public static final void blockBreakAnimation(final Location location, final double radius, final Integer stage) {
        final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
        final AgarthaLibConfig mainConfig = plugin.getMainConfig();
        if (location != null) {
            final double effectRange = mainConfig.getEffectRange();
            final Collection<Player> players = PlayerUtil.getNearbyPlayers(location, effectRange);
            blockBreakAnimation(players, location, radius, stage);
        }
    }
    
    public static final void blockBreakAnimation(final Collection<Player> players, final Location location, final double radius) {
        blockBreakAnimation(players, location, radius, null);
    }
    
    public static final void blockBreakAnimation(final Collection<Player> players, final Location location, final double radius, final Integer stage) {
        if (players != null && location != null) {
            for (final Block block : getAroundBlocks(location, radius)) {
                final Location blockLocation = block.getLocation();
                final double distance = location.distance(blockLocation);
                final int blockStage = (stage != null) ? stage : ((int)((radius - distance) / radius * 10.0));
                blockBreakAnimation(players, block, blockStage);
            }
        }
    }
    
    public static final void blockBreakAnimation(final Location location, final Integer stage) {
        final Collection<Player> players = PlayerUtil.getOnlinePlayers();
        blockBreakAnimation(players, location, stage);
    }
    
    public static final void blockBreakAnimation(final Block block, final Integer stage) {
        final Collection<Player> players = PlayerUtil.getOnlinePlayers();
        blockBreakAnimation(players, block, stage);
    }
    
    public static final void blockBreakAnimation(final Player player, final Location location, final Integer stage) {
        if (player != null) {
            blockBreakAnimation(PlayerUtil.toCollection(player), location, stage);
        }
    }
    
    public static final void blockBreakAnimation(final Player player, final Block block, final Integer stage) {
        if (player != null) {
            blockBreakAnimation(PlayerUtil.toCollection(player), block, stage);
        }
    }
    
    public static final void blockBreakAnimation(final Collection<Player> players, final Location location, final Integer stage) {
        if (location != null) {
            final Block block = location.getBlock();
            blockBreakAnimation(players, block, stage);
        }
    }
    
    public static final void blockBreakAnimation(final Collection<Player> players, final Block block, final Integer stage) {
        final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
        final GameManager gameManager = plugin.getGameManager();
        final BlockBreakManager blockBreakManager = gameManager.getBlockBreakManager();
        if (players != null && block != null) {
            final Location blockLocation = block.getLocation();
            final int blockStage = (stage != null) ? stage : 10;
            blockBreakManager.blockBreakAnimation(players, blockLocation, blockStage);
        }
    }
    
    public static final BlockChain getBlockChain(final Location location) {
        final Set<Material> materials = new HashSet<Material>();
        materials.add(Material.AIR);
        return getBlockChain(location, materials);
    }
    
    public static final BlockChain getBlockChain(final Location location, final Set<Material> materials) {
        return getBlockChain(location, materials, 10);
    }
    
    public static final BlockChain getBlockChain(final Location location, final Set<Material> materials, final int radius) {
        return getBlockChain(location, materials, radius, 10000);
    }
    
    public static final BlockChain getBlockChain(final Location location, final Set<Material> materials, final int radius, final int limit) {
        if (location != null && materials != null) {
            final BlockChain blockChain = new BlockChain();
            final Block block = location.getBlock();
            final Material blockMaterial = block.getType();
            if (materials.contains(blockMaterial)) {
                final BlockFace[] faces = { BlockFace.NORTH, BlockFace.SOUTH, BlockFace.WEST, BlockFace.EAST, BlockFace.UP, BlockFace.DOWN };
                final Set<Block> setBlockCheck = new HashSet<Block>();
                final Set<Block> setBlockMove = new HashSet<Block>();
                int movement = 0;
                int count = 0;
                setBlockCheck.add(block);
                blockChain.addBlockRelevant(block);
                while (movement < radius) {
                    for (final Block blockCheck : setBlockCheck) {
                        BlockFace[] array;
                        for (int length = (array = faces).length, i = 0; i < length; ++i) {
                            final BlockFace face = array[i];
                            final Block blockRelative = blockCheck.getRelative(face);
                            final Material blockRelativeMaterial = blockRelative.getType();
                            if (materials.contains(blockRelativeMaterial)) {
                                if (!blockChain.isBlockRelevant(blockRelative)) {
                                    setBlockMove.add(blockRelative);
                                    blockChain.addBlockRelevant(blockRelative);
                                    ++count;
                                }
                            }
                            else if (!blockChain.isBlockForeign(blockRelative)) {
                                blockChain.addBlockForeign(blockRelative);
                                ++count;
                            }
                            if (count > limit) {
                                blockChain.setStatus(BlockChainStatus.LIMIT);
                                return blockChain;
                            }
                        }
                    }
                    if (setBlockMove.size() == 0) {
                        blockChain.setStatus(BlockChainStatus.MATCH);
                        return blockChain;
                    }
                    setBlockCheck.clear();
                    setBlockCheck.addAll(setBlockMove);
                    setBlockMove.clear();
                    ++movement;
                }
                blockChain.setStatus(BlockChainStatus.LEAK);
            }
            return blockChain;
        }
        return null;
    }
    
    @Deprecated
    public static final void blockBreakAnimation(final Block block, final int stage, final int thickness) {
        blockBreakAnimation(block, stage, thickness, 0);
    }
    
    @Deprecated
    public static final void blockBreakAnimation(final Block block, final int stage, final int thickness, final int period) {
        blockBreakAnimation(block.getLocation(), stage, thickness, period);
    }
    
    @Deprecated
    public static final void blockBreakAnimation(final Location loc, final int stage) {
        blockBreakAnimation(loc, stage, 1, 0);
    }
    
    @Deprecated
    public static final void blockBreakAnimation(final Location loc, final int stage, final int thickness) {
        blockBreakAnimation(loc, stage, thickness, 0);
    }
    
    @Deprecated
    public static final void blockBreakAnimation(final Location loc, final int stage, final int thickness, final int period) {
        final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
        if (loc != null) {
            final Block block = loc.getBlock();
            final Material material = block.getType();
            if (MainBridge.getBridgeMaterial().isSolid(material) && isSeen(block)) {
                final TaskBlockBreakAnimation taskBlockBreakAnimation = new TaskBlockBreakAnimation(loc, stage, thickness);
                taskBlockBreakAnimation.runTaskTimer((Plugin)plugin, 0L, (long)period);
            }
        }
    }
    
    public static final boolean isSeen(final Block block) {
        if (block != null) {
            if (block.getRelative(BlockFace.UP).getType().equals((Object)Material.AIR)) {
                return true;
            }
            if (block.getRelative(BlockFace.DOWN).getType().equals((Object)Material.AIR)) {
                return true;
            }
            if (block.getRelative(BlockFace.NORTH).getType().equals((Object)Material.AIR)) {
                return true;
            }
            if (block.getRelative(BlockFace.SOUTH).getType().equals((Object)Material.AIR)) {
                return true;
            }
            if (block.getRelative(BlockFace.WEST).getType().equals((Object)Material.AIR)) {
                return true;
            }
            if (block.getRelative(BlockFace.EAST).getType().equals((Object)Material.AIR)) {
                return true;
            }
        }
        return false;
    }
    
    public static final boolean isSet(final Location loc) {
        return loc != null && isSet(loc.getBlock());
    }
    
    public static final boolean isSet(final Block block) {
        return block != null && BlockUtil.dataLoc.contains(block.getLocation());
    }
    
    public static final void remove(final Location loc) {
        if (loc != null) {
            final Block block = loc.getBlock();
            remove(block);
        }
    }
    
    public static final void remove(final Block block) {
        if (block != null) {
            final Location blockLoc = block.getLocation();
            if (BlockUtil.dataLoc.contains(blockLoc)) {
                BlockUtil.dataLoc.remove(blockLoc);
            }
        }
    }
    
    public static final void set(final Location loc) {
        if (loc != null) {
            final Block block = loc.getBlock();
            set(block);
        }
    }
    
    public static final void set(final Block block) {
        if (block != null) {
            final Location blockLoc = block.getLocation();
            BlockUtil.dataLoc.add(blockLoc);
        }
    }
    
    public static final Collection<Block> getRegionBlocks(final World world, final Location loc1, final Location loc2) {
        final Collection<Block> blocks = new ArrayList<Block>();
        if (loc1 != null && loc2 != null) {
            final double limitX = Math.max(loc1.getX(), loc2.getX());
            final double limitY = Math.max(loc1.getY(), loc2.getY());
            final double limitZ = Math.max(loc1.getZ(), loc2.getZ());
            for (double x = Math.min(loc1.getX(), loc2.getX()); x <= limitX; ++x) {
                for (double y = Math.min(loc1.getY(), loc2.getY()); y <= limitY; ++y) {
                    for (double z = Math.min(loc1.getZ(), loc2.getZ()); z <= limitZ; ++z) {
                        final Location loc3 = LocationUtil.createLocation(world, x, y, z);
                        blocks.add(loc3.getBlock());
                    }
                }
            }
        }
        return blocks;
    }
    
    public static final Collection<Block> getAroundBlocks(final Location loc, final double radius) {
        final Collection<Block> blocks = new ArrayList<Block>();
        if (loc != null) {
            final World world = loc.getWorld();
            final double baseX = loc.getX();
            final double baseY = loc.getY();
            final double baseZ = loc.getZ();
            for (int mathRadius = (int)Math.ceil(radius), x = -mathRadius; x <= mathRadius; ++x) {
                for (int y = -mathRadius; y <= mathRadius; ++y) {
                    for (int z = -mathRadius; z <= mathRadius; ++z) {
                        final Location loopLoc = LocationUtil.createLocation(world, baseX + x, baseY + y, baseZ + z);
                        if (loopLoc.distance(loc) <= radius) {
                            blocks.add(loopLoc.getBlock());
                        }
                    }
                }
            }
        }
        return blocks;
    }
}
