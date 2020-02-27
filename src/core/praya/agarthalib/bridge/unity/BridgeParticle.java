// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.bridge.unity;

import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerBridge;
import com.praya.agarthalib.handler.HandlerPacket;
import com.praya.agarthalib.packet.particle.*;
import com.praya.agarthalib.utility.PlayerUtil;
import com.praya.agarthalib.utility.ServerUtil;
import core.praya.agarthalib.builder.bridge.ParticleTools;
import core.praya.agarthalib.enums.branch.ParticleEnum;
import core.praya.agarthalib.enums.main.VersionNMS;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collection;

public class BridgeParticle extends HandlerBridge
{
    final HandlerPacket handler;
    
    protected BridgeParticle(final AgarthaLib plugin, final HandlerPacket handler) {
        super(plugin);
        this.handler = handler;
    }
    
    protected static final BridgeParticle getInstance() {
        return BridgeParticleHelper.instance;
    }
    
    public final HandlerPacket getHandler() {
        return this.handler;
    }
    
    public final boolean isSet() {
        return this.getHandler() != null;
    }
    
    public final ParticleTools getParticleTools() {
        return (this.isSet() && this.getHandler() instanceof ParticleTools) ? ((ParticleTools)this.getHandler()) : null;
    }
    
    public final boolean isImplementParticleTools() {
        return this.getParticleTools() != null;
    }
    
    public final void playParticle(final Player player, final String particleName, final Location location) {
        this.playParticle(player, particleName, location, 1);
    }
    
    public final void playParticle(final Player player, final String particleName, final Location location, final int count) {
        this.playParticle(player, particleName, location, count, 0.0, 0.0, 0.0);
    }
    
    public final void playParticle(final Player player, final String particleName, final Location location, final int count, final double offsetX, final double offsetY, final double offsetZ) {
        this.playParticle(player, particleName, location, count, offsetX, offsetY, offsetZ, 0.0);
    }
    
    public final void playParticle(final Player player, final String particleName, final Location location, final int count, final double offsetX, final double offsetY, final double offsetZ, final double extra) {
        this.playParticle(player, particleName, location, count, offsetX, offsetY, offsetZ, extra, null);
    }
    
    public final void playParticle(final Player player, final String particleName, final Location location, final int count, final double offsetX, final double offsetY, final double offsetZ, final double extra, final Object data) {
        if (particleName != null) {
            final ParticleEnum particleEnum = ParticleEnum.getParticleEnum(particleName);
            this.playParticle(player, particleEnum, location, count, offsetX, offsetY, offsetZ, extra, data);
        }
    }
    
    public final void playParticle(final Player player, final ParticleEnum particleEnum, final Location location) {
        this.playParticle(player, particleEnum, location, 1);
    }
    
    public final void playParticle(final Player player, final ParticleEnum particleEnum, final Location location, final int count) {
        this.playParticle(player, particleEnum, location, count, 0.0, 0.0, 0.0);
    }
    
    public final void playParticle(final Player player, final ParticleEnum particleEnum, final Location location, final int count, final double offsetX, final double offsetY, final double offsetZ) {
        this.playParticle(player, particleEnum, location, count, offsetX, offsetY, offsetZ, 0.0);
    }
    
    public final void playParticle(final Player player, final ParticleEnum particleEnum, final Location location, final int count, final double offsetX, final double offsetY, final double offsetZ, final double extra) {
        this.playParticle(player, particleEnum, location, count, offsetX, offsetY, offsetZ, extra, null);
    }
    
    public final void playParticle(final Player player, final ParticleEnum particleEnum, final Location location, final int count, final double offsetX, final double offsetY, final double offsetZ, final double extra, final Object data) {
        if (player != null) {
            this.playParticle(PlayerUtil.toCollection(player), particleEnum, location, count, offsetX, offsetY, offsetZ, extra, data);
        }
    }
    
    public final void playParticle(final Collection<Player> players, final String particleName, final Location location) {
        this.playParticle(players, particleName, location, 1);
    }
    
    public final void playParticle(final Collection<Player> players, final String particleName, final Location location, final int count) {
        this.playParticle(players, particleName, location, count, 0.0, 0.0, 0.0);
    }
    
    public final void playParticle(final Collection<Player> players, final String particleName, final Location location, final int count, final double offsetX, final double offsetY, final double offsetZ) {
        this.playParticle(players, particleName, location, count, offsetX, offsetY, offsetZ, 0.0);
    }
    
    public final void playParticle(final Collection<Player> players, final String particleName, final Location location, final int count, final double offsetX, final double offsetY, final double offsetZ, final double extra) {
        this.playParticle(players, particleName, location, count, offsetX, offsetY, offsetZ, extra, null);
    }
    
    public final void playParticle(final Collection<Player> players, final String particleName, final Location location, final int count, final double offsetX, final double offsetY, final double offsetZ, final double extra, final Object data) {
        if (particleName != null) {
            final ParticleEnum particleEnum = ParticleEnum.getParticleEnum(particleName);
            this.playParticle(players, particleEnum, location, count, offsetX, offsetY, offsetZ, extra, data);
        }
    }
    
    public final void playParticle(final Collection<Player> players, final ParticleEnum particleEnum, final Location location) {
        this.playParticle(players, particleEnum, location, 1);
    }
    
    public final void playParticle(final Collection<Player> players, final ParticleEnum particleEnum, final Location location, final int count) {
        this.playParticle(players, particleEnum, location, count, 0.0, 0.0, 0.0);
    }
    
    public final void playParticle(final Collection<Player> players, final ParticleEnum particleEnum, final Location location, final int count, final double offsetX, final double offsetY, final double offsetZ) {
        this.playParticle(players, particleEnum, location, count, offsetX, offsetY, offsetZ, 0.0);
    }
    
    public final void playParticle(final Collection<Player> players, final ParticleEnum particleEnum, final Location location, final int count, final double offsetX, final double offsetY, final double offsetZ, final double extra) {
        this.playParticle(players, particleEnum, location, count, offsetX, offsetY, offsetZ, extra, null);
    }
    
    public final void playParticle(final Collection<Player> players, final ParticleEnum particleEnum, final Location location, final int count, final double offsetX, final double offsetY, final double offsetZ, final double extra, final Object data) {
        final ParticleTools particleTools = this.getParticleTools();
        if (particleTools != null) {
            particleTools.packetPlayParticle(players, particleEnum, location, count, (float)offsetX, (float)offsetY, (float)offsetZ, (float)extra, data);
        }
    }
    
    @Deprecated
    public final void playParticle(final Player player, final String particleName, final Location location, final int count, final double offsetX, final double offsetY, final double offsetZ, final int id, final float data) {
        if (particleName != null) {
            final ParticleEnum particleEnum = ParticleEnum.getParticleEnum(particleName);
            this.playParticle(player, particleEnum, location, count, offsetX, offsetY, offsetZ, id, data);
        }
    }
    
    @Deprecated
    public final void playParticle(final Player player, final ParticleEnum particleEnum, final Location location, final int count, final double offsetX, final double offsetY, final double offsetZ, final int id, final float data) {
        if (player != null) {
            this.playParticle(PlayerUtil.toCollection(player), particleEnum, location, count, offsetX, offsetY, offsetZ, id, data);
        }
    }
    
    @Deprecated
    public final void playParticle(final Collection<Player> players, final String particleName, final Location location, final int count, final double offsetX, final double offsetY, final double offsetZ, final int id, final float data) {
        if (particleName != null) {
            final ParticleEnum particleEnum = ParticleEnum.getParticleEnum(particleName);
            this.playParticle(players, particleEnum, location, count, offsetX, offsetY, offsetZ, id, data);
        }
    }
    
    @Deprecated
    public final void playParticle(final Collection<Player> players, final ParticleEnum particleEnum, final Location location, final int count, final double offsetX, final double offsetY, final double offsetZ, final int id, final float data) {
        final ParticleTools particleTools = this.getParticleTools();
        if (particleTools != null) {
            particleTools.packetPlayParticle(players, particleEnum, location, count, offsetX, offsetY, offsetZ, id, data);
        }
    }
    
    private static class BridgeParticleHelper
    {
        private static final BridgeParticle instance;
        
        static {
            final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
            final VersionNMS version = ServerUtil.getVersionNMS();
            HandlerPacket handler = null;
            switch (version) {
                case V1_7_R4: {
                    handler = new PacketParticle_1_7_R4(plugin);
                    break;
                }
                case V1_8_R3: {
                    handler = new PacketParticle_1_8_R3(plugin);
                    break;
                }
                case V1_9_R2: {
                    handler = new PacketParticle_1_9_R2(plugin);
                    break;
                }
                case V1_10_R1: {
                    handler = new PacketParticle_1_10_R1(plugin);
                    break;
                }
                case V1_11_R1: {
                    handler = new PacketParticle_1_11_R1(plugin);
                    break;
                }
                case V1_12_R1: {
                    handler = new PacketParticle_1_12_R1(plugin);
                    break;
                }
                case V1_13_R2: {
                    handler = new PacketParticle_1_13_R2(plugin);
                    break;
                }
                case V1_14_R1: {
                    handler = new PacketParticle_1_14_R1(plugin);
                    break;
                }
                case V1_15_R1: {
                    handler = new PacketParticle_1_15_R1(plugin);
                    break;
                }
                default: {
                    handler = null;
                    break;
                }
            }
            instance = new BridgeParticle(plugin, handler);
        }
    }
}
