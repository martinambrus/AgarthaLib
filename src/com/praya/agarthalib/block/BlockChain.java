// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.block;

import org.bukkit.block.Block;
import java.util.HashSet;

public class BlockChain
{
    private final HashSet<Block> blockRelevant;
    private final HashSet<Block> blockForeign;
    private BlockChainStatus status;
    
    public BlockChain() {
        this(null, null);
    }
    
    public BlockChain(final HashSet<Block> blockRelevant, final HashSet<Block> blockForeign) {
        this(blockRelevant, blockForeign, BlockChainStatus.NOT_MATCH);
    }
    
    public BlockChain(final HashSet<Block> blockRelevant, final HashSet<Block> blockForeign, final BlockChainStatus status) {
        this.blockRelevant = ((blockRelevant != null) ? blockRelevant : new HashSet<Block>());
        this.blockForeign = ((blockForeign != null) ? blockForeign : new HashSet<Block>());
        this.status = status;
    }
    
    public final HashSet<Block> getBlockRelevant() {
        return this.blockRelevant;
    }
    
    public final HashSet<Block> getBlockForeign() {
        return this.blockForeign;
    }
    
    public final BlockChainStatus getStatus() {
        return this.status;
    }
    
    public final boolean isBlockRelevant(final Block block) {
        return block != null && this.getBlockRelevant().contains(block);
    }
    
    public final boolean isBlockForeign(final Block block) {
        return block != null && this.getBlockForeign().contains(block);
    }
    
    public final void addBlockRelevant(final Block block) {
        if (block != null) {
            this.blockRelevant.add(block);
        }
    }
    
    public final void addBlockForeign(final Block block) {
        if (block != null) {
            this.blockForeign.add(block);
        }
    }
    
    public final void removeBlockRelevant(final Block block) {
        if (block != null) {
            this.blockRelevant.remove(block);
        }
    }
    
    public final void removeBlockForeign(final Block block) {
        if (block != null) {
            this.blockForeign.remove(block);
        }
    }
    
    public final void clearBlockRelevant() {
        this.blockRelevant.clear();
    }
    
    public final void clearBlockForeign() {
        this.blockForeign.clear();
    }
    
    public final void setStatus(final BlockChainStatus status) {
        if (status != null) {
            this.status = status;
        }
    }
}
