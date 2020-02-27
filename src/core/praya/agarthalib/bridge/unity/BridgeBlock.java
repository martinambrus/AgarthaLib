// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.bridge.unity;

import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerBridge;
import com.praya.agarthalib.handler.HandlerPacket;
import com.praya.agarthalib.packet.block.*;
import com.praya.agarthalib.utility.ServerUtil;
import core.praya.agarthalib.enums.main.VersionNMS;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Collection;

public class BridgeBlock extends HandlerBridge
{
    private final HandlerPacket handler;
    
    protected BridgeBlock(final AgarthaLib plugin, final HandlerPacket handler) {
        super(plugin);
        this.handler = handler;
    }
    
    protected static final BridgeBlock getInstance() {
        return BridgeBlockHelper.instance;
    }
    
    public final HandlerPacket getHandler() {
        return this.handler;
    }
    
    public final boolean isSet() {
        return this.getHandler() != null;
    }
    
    public final PacketBlockAnimation getBlockAnimation() {
        return (this.isSet() && this.getHandler() instanceof PacketBlockAnimation) ? ((PacketBlockAnimation)this.getHandler()) : null;
    }
    
    public final boolean isImplementBlockAnimation() {
        return this.getBlockAnimation() != null;
    }
    
    public final void blockBreakAnimation(final Entity entity, final Player player, final Location location, final int stage) {
        if (location != null) {
            final int x = location.getBlockX();
            final int y = location.getBlockY();
            final int z = location.getBlockZ();
            this.blockBreakAnimation(entity, player, x, y, z, stage);
        }
    }
    
    public final void blockBreakAnimation(final Entity entity, final Player player, final int x, final int y, final int z, final int stage) {
        if (player != null) {
            final Collection<Player> players = new ArrayList<Player>();
            players.add(player);
            this.blockBreakAnimation(entity, players, x, y, z, stage);
        }
    }
    
    public final void blockBreakAnimation(final Entity entity, final Collection<Player> players, final Location location, final int stage) {
        if (location != null) {
            final int x = location.getBlockX();
            final int y = location.getBlockY();
            final int z = location.getBlockZ();
            this.blockBreakAnimation(entity, players, x, y, z, stage);
        }
    }
    
    public final void blockBreakAnimation(final Entity entity, final Collection<Player> players, final int x, final int y, final int z, final int stage) {
        if (entity != null) {
            final int id = entity.getEntityId();
            this.blockBreakAnimation(id, players, x, y, z, stage);
        }
    }
    
    public final void blockBreakAnimation(final int id, final Player player, final Location location, final int stage) {
        if (location != null) {
            final int x = location.getBlockX();
            final int y = location.getBlockY();
            final int z = location.getBlockZ();
            this.blockBreakAnimation(id, player, x, y, z, stage);
        }
    }
    
    public final void blockBreakAnimation(final int id, final Player player, final int x, final int y, final int z, final int stage) {
        if (player != null) {
            final Collection<Player> players = new ArrayList<Player>();
            players.add(player);
            this.blockBreakAnimation(id, players, x, y, z, stage);
        }
    }
    
    public final void blockBreakAnimation(final int id, final Collection<Player> players, final Location location, final int stage) {
        if (location != null) {
            final int x = location.getBlockX();
            final int y = location.getBlockY();
            final int z = location.getBlockZ();
            this.blockBreakAnimation(id, players, x, y, z, stage);
        }
    }
    
    public final void blockBreakAnimation(final int id, final Collection<Player> players, final int x, final int y, final int z, final int stage) {
        final PacketBlockAnimation blockAnimation = this.getBlockAnimation();
        if (blockAnimation != null) {
            blockAnimation.blockBreakAnimation(id, players, x, y, z, stage);
        }
    }
    
    @Deprecated
    public final void sendBlockBreakAnimation(final Entity entity, final Collection<Player> players, final Location location, final int stage) {
        if (location != null) {
            final int x = location.getBlockX();
            final int y = location.getBlockY();
            final int z = location.getBlockZ();
            this.blockBreakAnimation(entity, players, x, y, z, stage);
        }
    }
    
    private static class BridgeBlockHelper
    {
        private static final BridgeBlock instance;
        
        static {
            final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
            final VersionNMS version = ServerUtil.getVersionNMS();
            HandlerPacket handler = null;
            switch (version) {
                case V1_7_R4: {
                    handler = new PacketBlock_1_7_R4(plugin);
                    break;
                }
                case V1_8_R3: {
                    handler = new PacketBlock_1_8_R3(plugin);
                    break;
                }
                case V1_9_R2: {
                    handler = new PacketBlock_1_9_R2(plugin);
                    break;
                }
                case V1_10_R1: {
                    handler = new PacketBlock_1_10_R1(plugin);
                    break;
                }
                case V1_11_R1: {
                    handler = new PacketBlock_1_11_R1(plugin);
                    break;
                }
                case V1_12_R1: {
                    handler = new PacketBlock_1_12_R1(plugin);
                    break;
                }
                case V1_13_R2: {
                    handler = new PacketBlock_1_13_R2(plugin);
                    break;
                }
                case V1_14_R1: {
                    handler = new PacketBlock_1_14_R1(plugin);
                    break;
                }
                case V1_15_R1: {
                    handler = new PacketBlock_1_15_R1(plugin);
                    break;
                }
                default: {
                    handler = null;
                    break;
                }
            }
            instance = new BridgeBlock(plugin, handler);
        }
    }
}
