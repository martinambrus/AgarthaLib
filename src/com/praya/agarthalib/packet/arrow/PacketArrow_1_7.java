// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.packet.arrow;

import com.praya.agarthalib.utility.EquipmentUtil;
import core.praya.agarthalib.enums.branch.MaterialEnum;
import org.bukkit.inventory.ItemStack;
import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerPacket;

public class PacketArrow_1_7 extends HandlerPacket implements PacketArrowNormal
{
    public PacketArrow_1_7(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @Override
    public ItemStack createNormalArrow() {
        return EquipmentUtil.createItem(MaterialEnum.ARROW);
    }
}
