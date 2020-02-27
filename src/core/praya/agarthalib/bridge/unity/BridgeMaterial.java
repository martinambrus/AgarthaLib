// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.bridge.unity;

import core.praya.agarthalib.enums.main.VersionNMS;
import com.praya.agarthalib.packet.material.PacketMaterial_1_12;
import com.praya.agarthalib.packet.material.PacketMaterial_1_11;
import com.praya.agarthalib.packet.material.PacketMaterial_1_10;
import com.praya.agarthalib.packet.material.PacketMaterial_1_9;
import com.praya.agarthalib.packet.material.PacketMaterial_1_8;
import com.praya.agarthalib.packet.material.PacketMaterial_1_7;
import com.praya.agarthalib.utility.ServerUtil;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Material;
import core.praya.agarthalib.builder.bridge.MaterialTools;
import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerPacket;
import com.praya.agarthalib.handler.HandlerBridge;

@Deprecated
public class BridgeMaterial extends HandlerBridge
{
    final HandlerPacket handler;
    
    protected BridgeMaterial(final AgarthaLib plugin, final HandlerPacket handler) {
        super(plugin);
        this.handler = handler;
    }
    
    protected static final BridgeMaterial getInstance() {
        return BridgeMaterialHelper.instance;
    }
    
    public final HandlerPacket getHandler() {
        return this.handler;
    }
    
    public final boolean isSet() {
        return this.getHandler() != null;
    }
    
    public final MaterialTools getMaterialTools() {
        return (this.isSet() && this.getHandler() instanceof MaterialTools) ? ((MaterialTools)this.getHandler()) : null;
    }
    
    public final boolean isImplementMaterialTools() {
        return this.getMaterialTools() != null;
    }
    
    public final boolean isSolid(final Material material) {
        return this.isImplementMaterialTools() && this.getMaterialTools().isSolid(material);
    }
    
    public final boolean isFluid(final Material material) {
        return this.isImplementMaterialTools() && this.getMaterialTools().isFluid(material);
    }
    
    private static class BridgeMaterialHelper
    {
        private static final BridgeMaterial instance;
        
        static {
            final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
            final VersionNMS version = ServerUtil.getVersionNMS();
            HandlerPacket handler = null;
            switch (version) {
                case V1_7_R4: {
                    handler = new PacketMaterial_1_7(plugin);
                    break;
                }
                case V1_8_R3: {
                    handler = new PacketMaterial_1_8(plugin);
                    break;
                }
                case V1_9_R2: {
                    handler = new PacketMaterial_1_9(plugin);
                    break;
                }
                case V1_10_R1: {
                    handler = new PacketMaterial_1_10(plugin);
                    break;
                }
                case V1_11_R1: {
                    handler = new PacketMaterial_1_11(plugin);
                    break;
                }
                case V1_12_R1: {
                    handler = new PacketMaterial_1_12(plugin);
                    break;
                }
                case V1_13_R2:
                case V1_14_R1:
                case V1_15_R1: {
                    handler = new PacketMaterial_1_12(plugin);
                    break;
                }
                default: {
                    handler = null;
                    break;
                }
            }
            instance = new BridgeMaterial(plugin, handler);
        }
    }
}
