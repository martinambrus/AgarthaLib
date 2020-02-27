// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.packet.arrow;

import com.praya.agarthalib.utility.MathUtil;
import com.praya.agarthalib.utility.ItemFlagUtil;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.Color;
import com.praya.agarthalib.utility.EquipmentUtil;
import core.praya.agarthalib.enums.branch.MaterialEnum;
import org.bukkit.inventory.ItemStack;
import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerPacket;

public class PacketArrow_1_11 extends HandlerPacket implements PacketArrowNormal, PacketArrowModification
{
    public PacketArrow_1_11(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @Override
    public ItemStack createNormalArrow() {
        return EquipmentUtil.createItem(MaterialEnum.ARROW);
    }
    
    @Override
    public ItemStack createTippedArrow(final Color color) {
        final ItemStack arrow = EquipmentUtil.createItem(MaterialEnum.TIPPED_ARROW);
        final PotionMeta meta = (PotionMeta)arrow.getItemMeta();
        meta.clearCustomEffects();
        meta.setColor(color);
        arrow.setItemMeta((ItemMeta)meta);
        ItemFlagUtil.addFlag(arrow, ItemFlag.HIDE_POTION_EFFECTS);
        return arrow;
    }
    
    @Override
    public ItemStack createTippedArrow(int red, int green, int blue) {
        red = MathUtil.limitInteger(red, 0, 255);
        green = MathUtil.limitInteger(green, 0, 255);
        blue = MathUtil.limitInteger(blue, 0, 255);
        final Color color = Color.fromRGB(red, green, blue);
        return this.createTippedArrow(color);
    }
    
    @Override
    public ItemStack createSpectralArrow() {
        return EquipmentUtil.createItem(MaterialEnum.SPECTRAL_ARROW);
    }
}
