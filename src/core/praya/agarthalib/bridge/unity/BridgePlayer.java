// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.bridge.unity;

import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.AgarthaLibConfig;
import com.praya.agarthalib.handler.HandlerBridge;
import com.praya.agarthalib.handler.HandlerPacket;
import com.praya.agarthalib.packet.player.*;
import com.praya.agarthalib.utility.ServerUtil;
import core.praya.agarthalib.enums.main.VersionNMS;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collection;

public class BridgePlayer extends HandlerBridge
{
    private final HandlerPacket handler;
    
    protected BridgePlayer(final AgarthaLib plugin, final HandlerPacket handler) {
        super(plugin);
        this.handler = handler;
    }
    
    public static final BridgePlayer getInstance() {
        return BridgePlayerSingleton.instance;
    }
    
    public final HandlerPacket getHandler() {
        return this.handler;
    }
    
    public final boolean isSet() {
        return this.getHandler() != null;
    }
    
    public final PacketPlayerProperties getPacketPlayerProperties() {
        return (this.isSet() && this.getHandler() instanceof PacketPlayerProperties) ? ((PacketPlayerProperties)this.getHandler()) : null;
    }
    
    public final PacketPlayerVisibility getPacketPlayerVisibility() {
        return (this.isSet() && this.getHandler() instanceof PacketPlayerVisibility) ? ((PacketPlayerVisibility)this.getHandler()) : null;
    }
    
    public final PacketPlayerAbsorption getPacketPlayerAbsorption() {
        return (this.isSet() && this.getHandler() instanceof PacketPlayerAbsorption) ? ((PacketPlayerAbsorption)this.getHandler()) : null;
    }
    
    public final PacketPlayerCombat getPacketPlayerCombat() {
        return (this.isSet() && this.getHandler() instanceof PacketPlayerCombat) ? ((PacketPlayerCombat)this.getHandler()) : null;
    }
    
    public final String getLocale(final Player player) {
        final PacketPlayerProperties packetPlayerProperties = this.getPacketPlayerProperties();
        final AgarthaLibConfig mainConfig = this.plugin.getMainConfig();
        return (packetPlayerProperties != null) ? packetPlayerProperties.getLocale(player) : mainConfig.getGeneralLocale();
    }
    
    public final void hideEntity(final Player player, final Entity entity) {
        final PacketPlayerVisibility packetPlayerVisibility = this.getPacketPlayerVisibility();
        if (packetPlayerVisibility != null) {
            packetPlayerVisibility.hideEntity(player, entity);
        }
    }
    
    public final void hideEntity(final Collection<Player> players, final Entity entity) {
        final PacketPlayerVisibility packetPlayerVisibility = this.getPacketPlayerVisibility();
        if (packetPlayerVisibility != null) {
            packetPlayerVisibility.hideEntity(players, entity);
        }
    }
    
    public final float getAbsorptionHearts(final Player player) {
        final PacketPlayerAbsorption packetPlayerAbsorption = this.getPacketPlayerAbsorption();
        return (packetPlayerAbsorption != null) ? packetPlayerAbsorption.getAbsorptionHearts(player) : 0.0f;
    }
    
    public final void setAbsorptionHearts(final Player player, final float absorptionHearts) {
        final PacketPlayerAbsorption packetPlayerAbsorption = this.getPacketPlayerAbsorption();
        if (packetPlayerAbsorption != null) {
            packetPlayerAbsorption.setAbsorptionHearts(player, absorptionHearts);
        }
    }
    
    public final void playSwingMainHand(final Player player) {
        final PacketPlayerCombat packetPlayerCombat = this.getPacketPlayerCombat();
        if (packetPlayerCombat != null) {
            packetPlayerCombat.playSwingMainHand(player);
        }
    }
    
    public final float getSwingDuration(final Player player) {
        final PacketPlayerCombat packetPlayerCombat = this.getPacketPlayerCombat();
        if (packetPlayerCombat != null && packetPlayerCombat instanceof PacketPlayerCombatPresent) {
            final PacketPlayerCombatPresent packetPlayerCombatPresent = (PacketPlayerCombatPresent)packetPlayerCombat;
            return packetPlayerCombatPresent.getSwingDuration(player);
        }
        return 0.0f;
    }
    
    public final float getSwingProgress(final Player player) {
        final PacketPlayerCombat packetPlayerCombat = this.getPacketPlayerCombat();
        if (packetPlayerCombat != null && packetPlayerCombat instanceof PacketPlayerCombatPresent) {
            final PacketPlayerCombatPresent packetPlayerCombatPresent = (PacketPlayerCombatPresent)packetPlayerCombat;
            return packetPlayerCombatPresent.getSwingProgress(player);
        }
        return 0.0f;
    }
    
    public final void playSwingOffHand(final Player player) {
        final PacketPlayerCombat packetPlayerCombat = this.getPacketPlayerCombat();
        if (packetPlayerCombat != null && packetPlayerCombat instanceof PacketPlayerCombatPresent) {
            final PacketPlayerCombatPresent packetPlayerCombatPresent = (PacketPlayerCombatPresent)packetPlayerCombat;
            packetPlayerCombatPresent.playSwingOffHand(player);
        }
    }
    
    private static class BridgePlayerSingleton
    {
        private static final BridgePlayer instance;
        
        static {
            final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
            final VersionNMS version = ServerUtil.getVersionNMS();
            HandlerPacket handler = null;
            switch (version) {
                case V1_7_R4: {
                    handler = new PacketPlayer_1_7_R4(plugin);
                    break;
                }
                case V1_8_R3: {
                    handler = new PacketPlayer_1_8_R3(plugin);
                    break;
                }
                case V1_9_R2: {
                    handler = new PacketPlayer_1_9_R2(plugin);
                    break;
                }
                case V1_10_R1: {
                    handler = new PacketPlayer_1_10_R1(plugin);
                    break;
                }
                case V1_11_R1: {
                    handler = new PacketPlayer_1_11_R1(plugin);
                    break;
                }
                case V1_12_R1: {
                    handler = new PacketPlayer_1_12_R1(plugin);
                    break;
                }
                case V1_13_R2: {
                    handler = new PacketPlayer_1_13_R2(plugin);
                    break;
                }
                case V1_14_R1: {
                    handler = new PacketPlayer_1_14_R1(plugin);
                    break;
                }
                case V1_15_R1: {
                    handler = new PacketPlayer_1_15_R1(plugin);
                    break;
                }
                default: {
                    handler = null;
                    break;
                }
            }
            instance = new BridgePlayer(plugin, handler);
        }
    }
}
