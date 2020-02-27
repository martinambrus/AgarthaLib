// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.bridge.unity;

import core.praya.agarthalib.enums.main.VersionNMS;
import com.praya.agarthalib.packet.livingentity.PacketLivingEntity_1_12;
import com.praya.agarthalib.packet.livingentity.PacketLivingEntity_1_11;
import com.praya.agarthalib.packet.livingentity.PacketLivingEntity_1_10;
import com.praya.agarthalib.packet.livingentity.PacketLivingEntity_1_9;
import com.praya.agarthalib.packet.livingentity.PacketLivingEntity_1_8;
import com.praya.agarthalib.packet.livingentity.PacketLivingEntity_1_7;
import com.praya.agarthalib.utility.ServerUtil;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Entity;
import core.praya.agarthalib.builder.bridge.LivingEntityTools;
import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerPacket;
import com.praya.agarthalib.handler.HandlerBridge;

public class BridgeLivingEntity extends HandlerBridge
{
    final HandlerPacket handler;
    
    protected BridgeLivingEntity(final AgarthaLib plugin, final HandlerPacket handler) {
        super(plugin);
        this.handler = handler;
    }
    
    protected static final BridgeLivingEntity getInstance() {
        return BridgeLivingEntityHelper.instance;
    }
    
    public final HandlerPacket getHandler() {
        return this.handler;
    }
    
    public final boolean isSet() {
        return this.getHandler() != null;
    }
    
    public final LivingEntityTools getLivingEntityTools() {
        return (this.isSet() && this.getHandler() instanceof LivingEntityTools) ? ((LivingEntityTools)this.getHandler()) : null;
    }
    
    public final boolean isImplementLivingEntityTools() {
        return this.getLivingEntityTools() != null;
    }
    
    public final boolean isLivingEntity(final Entity entity) {
        return this.isImplementLivingEntityTools() && this.getLivingEntityTools().isLivingEntity(entity);
    }
    
    public final boolean isLivingEntity(final EntityType type) {
        return this.isImplementLivingEntityTools() && this.getLivingEntityTools().isLivingEntity(type);
    }
    
    private static class BridgeLivingEntityHelper
    {
        private static final BridgeLivingEntity instance;
        
        static {
            final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
            final VersionNMS version = ServerUtil.getVersionNMS();
            HandlerPacket handler = null;
            switch (version) {
                case V1_7_R4: {
                    handler = new PacketLivingEntity_1_7(plugin);
                    break;
                }
                case V1_8_R3: {
                    handler = new PacketLivingEntity_1_8(plugin);
                    break;
                }
                case V1_9_R2: {
                    handler = new PacketLivingEntity_1_9(plugin);
                    break;
                }
                case V1_10_R1: {
                    handler = new PacketLivingEntity_1_10(plugin);
                    break;
                }
                case V1_11_R1: {
                    handler = new PacketLivingEntity_1_11(plugin);
                    break;
                }
                case V1_12_R1: {
                    handler = new PacketLivingEntity_1_12(plugin);
                    break;
                }
                case V1_13_R2:
                case V1_14_R1:
                case V1_15_R1:{
                    handler = new PacketLivingEntity_1_12(plugin);
                    break;
                }
                default: {
                    handler = null;
                    break;
                }
            }
            instance = new BridgeLivingEntity(plugin, handler);
        }
    }
}
