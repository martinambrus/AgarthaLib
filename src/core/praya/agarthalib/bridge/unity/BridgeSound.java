// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.bridge.unity;

import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerBridge;
import com.praya.agarthalib.handler.HandlerPacket;
import com.praya.agarthalib.packet.sounds.PacketSounds_1_10;
import com.praya.agarthalib.packet.sounds.PacketSounds_1_7;
import com.praya.agarthalib.packet.sounds.PacketSounds_1_9;
import com.praya.agarthalib.utility.PlayerUtil;
import com.praya.agarthalib.utility.ServerUtil;
import core.praya.agarthalib.builder.bridge.SoundTools;
import core.praya.agarthalib.enums.branch.SoundEnum;
import core.praya.agarthalib.enums.main.VersionNMS;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collection;

public class BridgeSound extends HandlerBridge
{
    final HandlerPacket handler;
    
    protected BridgeSound(final AgarthaLib plugin, final HandlerPacket handler) {
        super(plugin);
        this.handler = handler;
    }
    
    protected static final BridgeSound getInstance() {
        return BridgeSoundHelper.instance;
    }
    
    public final HandlerPacket getHandler() {
        return this.handler;
    }
    
    public final boolean isSet() {
        return this.getHandler() != null;
    }
    
    public final SoundTools getSoundTools() {
        return (this.isSet() && this.getHandler() instanceof SoundTools) ? ((SoundTools)this.getHandler()) : null;
    }
    
    public final boolean isImplementSoundTools() {
        return this.getSoundTools() != null;
    }
    
    public final void playSound(final Player player, final Location loc, final String soundName, final float volume, final float pitch) {
        if (soundName != null) {
            final SoundEnum sound = SoundEnum.getSoundEnum(soundName);
            this.playSound(player, loc, sound, volume, pitch);
        }
    }
    
    public final void playSound(final Player player, final Location loc, final SoundEnum sound, final float volume, final float pitch) {
        if (player != null) {
            this.playSound(PlayerUtil.toCollection(player), loc, sound, volume, pitch);
        }
    }
    
    public final void playSound(final Collection<Player> players, final Location loc, final SoundEnum sound, final float volume, final float pitch) {
        final SoundTools soundTools = this.getSoundTools();
        if (soundTools != null) {
            soundTools.playSoundEffect(players, loc, sound, volume, pitch);
        }
    }
    
    private static class BridgeSoundHelper
    {
        private static final BridgeSound instance;
        
        static {
            final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
            HandlerPacket handler;
            if (ServerUtil.isCompatible(VersionNMS.V1_10_R1)) {
                handler = new PacketSounds_1_10(plugin);
            }
            else if (ServerUtil.isCompatible(VersionNMS.V1_9_R2)) {
                handler = new PacketSounds_1_9(plugin);
            }
            else if (ServerUtil.isCompatible(VersionNMS.V1_7_R4)) {
                handler = new PacketSounds_1_7(plugin);
            }
            else {
                handler = null;
            }
            instance = new BridgeSound(plugin, handler);
        }
    }
}
