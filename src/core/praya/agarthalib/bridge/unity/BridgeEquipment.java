// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.bridge.unity;

import com.praya.agarthalib.packet.equipment.PacketEquipment_1_7;
import com.praya.agarthalib.packet.equipment.PacketEquipment_1_9;
import com.praya.agarthalib.utility.ServerUtil;
import core.praya.agarthalib.enums.main.VersionNMS;
import org.bukkit.plugin.java.JavaPlugin;
import core.praya.agarthalib.enums.main.Slot;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;
import core.praya.agarthalib.builder.bridge.EquipmentTools;
import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerPacket;
import com.praya.agarthalib.handler.HandlerBridge;

public class BridgeEquipment extends HandlerBridge
{
    private final HandlerPacket handler;
    
    protected BridgeEquipment(final AgarthaLib plugin, final HandlerPacket handler) {
        super(plugin);
        this.handler = handler;
    }
    
    protected static final BridgeEquipment getInstance() {
        return BridgeEquipmentHelper.instance;
    }
    
    public final HandlerPacket getHandler() {
        return this.handler;
    }
    
    public final boolean isSet() {
        return this.getHandler() != null;
    }
    
    public final EquipmentTools getEquipmentTools() {
        return (this.isSet() && this.getHandler() instanceof EquipmentTools) ? ((EquipmentTools)this.getHandler()) : null;
    }
    
    public final boolean isImplementEquipmentTools() {
        return this.getEquipmentTools() != null;
    }
    
    public final ItemStack getEquipment(final Player player, final int id) {
        return this.isImplementEquipmentTools() ? this.getEquipmentTools().getEquipment(player, id) : null;
    }
    
    public final ItemStack getEquipment(final LivingEntity livingEntity, final int id) {
        return this.isImplementEquipmentTools() ? this.getEquipmentTools().getEquipment(livingEntity, id) : null;
    }
    
    public final ItemStack getEquipment(final PlayerInventory inventory, final int id) {
        return this.isImplementEquipmentTools() ? this.getEquipmentTools().getEquipment(inventory, id) : null;
    }
    
    public final ItemStack getEquipment(final Player player, final Slot slot) {
        return this.isImplementEquipmentTools() ? this.getEquipmentTools().getEquipment(player, slot) : null;
    }
    
    public final ItemStack getEquipment(final LivingEntity livingEntity, final Slot slot) {
        return this.isImplementEquipmentTools() ? this.getEquipmentTools().getEquipment(livingEntity, slot) : null;
    }
    
    public final ItemStack getEquipment(final PlayerInventory inventory, final Slot slot) {
        return this.isImplementEquipmentTools() ? this.getEquipmentTools().getEquipment(inventory, slot) : null;
    }
    
    public final void setEquipment(final Player player, final ItemStack item, final int id) {
        final EquipmentTools equipmentTools = this.getEquipmentTools();
        if (equipmentTools != null) {
            equipmentTools.setEquipment(player, item, id);
        }
    }
    
    public final void setEquipment(final LivingEntity livingEntity, final ItemStack item, final int id) {
        final EquipmentTools equipmentTools = this.getEquipmentTools();
        if (equipmentTools != null) {
            equipmentTools.setEquipment(livingEntity, item, id);
        }
    }
    
    public final void setEquipment(final PlayerInventory inventory, final ItemStack item, final int id) {
        final EquipmentTools equipmentTools = this.getEquipmentTools();
        if (equipmentTools != null) {
            equipmentTools.setEquipment(inventory, item, id);
        }
    }
    
    public final void setEquipment(final Player player, final ItemStack item, final Slot slot) {
        final EquipmentTools equipmentTools = this.getEquipmentTools();
        if (equipmentTools != null) {
            equipmentTools.setEquipment(player, item, slot);
        }
    }
    
    public final void setEquipment(final LivingEntity livingEntity, final ItemStack item, final Slot slot) {
        final EquipmentTools equipmentTools = this.getEquipmentTools();
        if (equipmentTools != null) {
            equipmentTools.setEquipment(livingEntity, item, slot);
        }
    }
    
    public final void setEquipment(final PlayerInventory inventory, final ItemStack item, final Slot slot) {
        final EquipmentTools equipmentTools = this.getEquipmentTools();
        if (equipmentTools != null) {
            equipmentTools.setEquipment(inventory, item, slot);
        }
    }
    
    private static class BridgeEquipmentHelper
    {
        private static final BridgeEquipment instance;
        
        static {
            final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
            HandlerPacket handler;
            if (ServerUtil.isCompatible(VersionNMS.V1_9_R2)) {
                handler = new PacketEquipment_1_9(plugin);
            }
            else if (ServerUtil.isCompatible(VersionNMS.V1_7_R4)) {
                handler = new PacketEquipment_1_7(plugin);
            }
            else {
                handler = null;
            }
            instance = new BridgeEquipment(plugin, handler);
        }
    }
}
