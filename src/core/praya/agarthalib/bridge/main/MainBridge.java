// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.bridge.main;

import core.praya.agarthalib.bridge.unity.BridgePlayer;
import core.praya.agarthalib.bridge.unity.BridgeTagsNBT;
import core.praya.agarthalib.bridge.unity.BridgeSound;
import core.praya.agarthalib.bridge.unity.BridgeServer;
import core.praya.agarthalib.bridge.unity.BridgeParticle;
import core.praya.agarthalib.bridge.unity.BridgeMessage;
import core.praya.agarthalib.bridge.unity.BridgeMaterial;
import core.praya.agarthalib.bridge.unity.BridgeLivingEntity;
import core.praya.agarthalib.bridge.unity.BridgeInventory;
import core.praya.agarthalib.bridge.unity.BridgeEquipment;
import core.praya.agarthalib.bridge.unity.BridgeBlock;
import core.praya.agarthalib.bridge.unity.Bridge;
import core.praya.agarthalib.bridge.unity.BridgeArrow;

@Deprecated
public class MainBridge
{
    public static final BridgeArrow getBridgeArrow() {
        return Bridge.getBridgeArrow();
    }
    
    public static final BridgeBlock getBridgeBlock() {
        return Bridge.getBridgeBlock();
    }
    
    public static final BridgeEquipment getBridgeEquipment() {
        return Bridge.getBridgeEquipment();
    }
    
    public static final BridgeInventory getBridgeInventory() {
        return Bridge.getBridgeInventory();
    }
    
    public static final BridgeLivingEntity getBridgeLivingEntity() {
        return Bridge.getBridgeLivingEntity();
    }
    
    public static final BridgeMaterial getBridgeMaterial() {
        return Bridge.getBridgeMaterial();
    }
    
    public static final BridgeMessage getBridgeMessage() {
        return Bridge.getBridgeMessage();
    }
    
    public static final BridgeParticle getBridgeParticle() {
        return Bridge.getBridgeParticle();
    }
    
    public static final BridgeServer getBridgeServer() {
        return Bridge.getBridgeServer();
    }
    
    public static final BridgeSound getBridgeSound() {
        return Bridge.getBridgeSound();
    }
    
    public static final BridgeTagsNBT getBridgeTagsNBT() {
        return Bridge.getBridgeTagsNBT();
    }
    
    public static final BridgePlayer getBridgePlayer() {
        return Bridge.getBridgePlayer();
    }
}
