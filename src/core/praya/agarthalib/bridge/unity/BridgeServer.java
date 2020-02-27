// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.bridge.unity;

import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerBridge;
import com.praya.agarthalib.handler.HandlerPacket;
import com.praya.agarthalib.packet.server.*;
import com.praya.agarthalib.utility.ServerUtil;
import core.praya.agarthalib.builder.bridge.ServerTools;
import core.praya.agarthalib.enums.main.VersionNMS;
import org.bukkit.plugin.java.JavaPlugin;

public class BridgeServer extends HandlerBridge
{
    final HandlerPacket handler;
    
    protected BridgeServer(final AgarthaLib plugin, final HandlerPacket handler) {
        super(plugin);
        this.handler = handler;
    }
    
    protected static final BridgeServer getInstance() {
        return BridgeServerHelper.instance;
    }
    
    public final HandlerPacket getHandler() {
        return this.handler;
    }
    
    public final boolean isSet() {
        return this.getHandler() != null;
    }
    
    public final ServerTools getServerTools() {
        return (this.isSet() && this.getHandler() instanceof ServerTools) ? ((ServerTools)this.getHandler()) : null;
    }
    
    public final boolean isImplementServerTools() {
        return this.getServerTools() != null;
    }
    
    public final double getTPS() {
        return this.isImplementServerTools() ? this.getServerTools().getTPS() : 20.0;
    }
    
    private static class BridgeServerHelper
    {
        private static final BridgeServer instance;
        
        static {
            final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
            final VersionNMS version = ServerUtil.getVersionNMS();
            HandlerPacket handler = null;
            switch (version) {
                case V1_7_R4: {
                    handler = new PacketServer_1_7_R4(plugin);
                    break;
                }
                case V1_8_R3: {
                    handler = new PacketServer_1_8_R3(plugin);
                    break;
                }
                case V1_9_R2: {
                    handler = new PacketServer_1_9_R2(plugin);
                    break;
                }
                case V1_10_R1: {
                    handler = new PacketServer_1_10_R1(plugin);
                    break;
                }
                case V1_11_R1: {
                    handler = new PacketServer_1_11_R1(plugin);
                    break;
                }
                case V1_12_R1: {
                    handler = new PacketServer_1_12_R1(plugin);
                    break;
                }
                case V1_13_R2: {
                    handler = new PacketServer_1_13_R2(plugin);
                    break;
                }
                case V1_14_R1: {
                    handler = new PacketServer_1_14_R1(plugin);
                    break;
                }
                case V1_15_R1: {
                    handler = new PacketServer_1_15_R1(plugin);
                    break;
                }
                default: {
                    handler = null;
                    break;
                }
            }
            instance = new BridgeServer(plugin, handler);
        }
    }
}
