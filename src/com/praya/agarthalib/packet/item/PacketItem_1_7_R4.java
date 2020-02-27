// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.packet.item;

import net.minecraft.server.v1_7_R4.PlayerConnection;
import net.minecraft.server.v1_7_R4.Packet;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import net.minecraft.util.io.netty.buffer.ByteBuf;
import net.minecraft.server.v1_7_R4.PacketPlayOutCustomPayload;
import net.minecraft.server.v1_7_R4.PacketDataSerializer;
import net.minecraft.util.io.netty.buffer.Unpooled;
import core.praya.agarthalib.bridge.unity.Bridge;
import org.bukkit.entity.Player;
import com.praya.agarthalib.utility.JsonUtil;
import com.praya.agarthalib.utility.EquipmentUtil;
import core.praya.agarthalib.enums.branch.MaterialEnum;
import net.minecraft.server.v1_7_R4.NBTTagDouble;
import net.minecraft.server.v1_7_R4.NBTTagInt;
import net.minecraft.server.v1_7_R4.NBTTagString;
import com.praya.agarthalib.utility.MathUtil;
import net.minecraft.server.v1_7_R4.NBTBase;
import java.util.regex.Pattern;
import net.minecraft.server.v1_7_R4.NBTTagList;
import net.minecraft.server.v1_7_R4.NBTTagCompound;
import org.bukkit.craftbukkit.v1_7_R4.inventory.CraftItemStack;
import core.praya.agarthalib.enums.main.Slot;
import core.praya.agarthalib.enums.main.TagsAttribute;
import org.bukkit.inventory.ItemStack;
import com.praya.agarthalib.AgarthaLib;
import core.praya.agarthalib.builder.bridge.TagsNBTBooks;
import core.praya.agarthalib.builder.bridge.TagsNBTItem;
import com.praya.agarthalib.handler.HandlerPacket;

public class PacketItem_1_7_R4 extends HandlerPacket implements TagsNBTItem, TagsNBTBooks
{
    public PacketItem_1_7_R4(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @Override
    public final void addNBT(final ItemStack item, final TagsAttribute tags, double value, final Slot slot) {
        final net.minecraft.server.v1_7_R4.ItemStack itemNMS = CraftItemStack.asNMSCopy(item);
        final NBTTagCompound compound = itemNMS.hasTag() ? itemNMS.getTag() : new NBTTagCompound();
        final NBTTagCompound attribute = new NBTTagCompound();
        final NBTTagList baseList = compound.getList("AttributeModifiers", 10);
        final NBTTagList tagList = new NBTTagList();
        final String nameSlot = slot.getName();
        final String name = tags.getName();
        final String type = tags.getValueType();
        final double minValue = tags.getMinValue();
        final double maxValue = tags.getMaxValue();
        for (int t = 0; t < baseList.size(); ++t) {
            final NBTTagCompound element = baseList.get(t);
            final String elementName = String.valueOf(element.get("AttributeName")).replaceAll(Pattern.quote("\""), "");
            final String elementSlot = String.valueOf(element.get("Slot")).replaceAll(Pattern.quote("\""), "");
            if (!name.equalsIgnoreCase(elementName) || !nameSlot.equalsIgnoreCase(elementSlot)) {
                tagList.add((NBTBase)element);
            }
        }
        value = MathUtil.limitDouble(value, minValue, maxValue);
        attribute.set("AttributeName", (NBTBase)new NBTTagString(name));
        attribute.set("Name", (NBTBase)new NBTTagString(name));
        attribute.set("Operation", (NBTBase)new NBTTagInt(0));
        attribute.set("UUIDLeast", (NBTBase)new NBTTagInt(894654));
        attribute.set("UUIDMost", (NBTBase)new NBTTagInt(2872));
        attribute.set("Slot", (NBTBase)new NBTTagString(nameSlot));
        attribute.set("Amount", (NBTBase)(type.equalsIgnoreCase("Double") ? new NBTTagDouble(value) : new NBTTagInt((int)value)));
        tagList.add((NBTBase)attribute);
        compound.set("AttributeModifiers", (NBTBase)tagList);
        itemNMS.setTag(compound);
        item.setItemMeta(CraftItemStack.asBukkitCopy(itemNMS).getItemMeta());
    }
    
    @Override
    public final void clearNBT(final ItemStack item) {
        final net.minecraft.server.v1_7_R4.ItemStack itemNMS = CraftItemStack.asNMSCopy(item);
        final NBTTagCompound compound = itemNMS.hasTag() ? itemNMS.getTag() : new NBTTagCompound();
        final NBTTagList tagList = new NBTTagList();
        compound.set("AttributeModifiers", (NBTBase)tagList);
        itemNMS.setTag(compound);
        item.setItemMeta(CraftItemStack.asBukkitCopy(itemNMS).getItemMeta());
    }
    
    @Override
    public final void setUnbreakable(final ItemStack item, final boolean unbreakable) {
        final net.minecraft.server.v1_7_R4.ItemStack itemNMS = CraftItemStack.asNMSCopy(item);
        final NBTTagCompound compound = itemNMS.hasTag() ? itemNMS.getTag() : new NBTTagCompound();
        compound.setInt("Unbreakable", (int)(unbreakable ? 1 : 0));
        itemNMS.setTag(compound);
        item.setItemMeta(CraftItemStack.asBukkitCopy(itemNMS).getItemMeta());
    }
    
    @Override
    public final boolean isUnbreakable(final ItemStack item) {
        final net.minecraft.server.v1_7_R4.ItemStack itemNMS = CraftItemStack.asNMSCopy(item);
        final NBTTagCompound compound = itemNMS.hasTag() ? itemNMS.getTag() : new NBTTagCompound();
        return compound.hasKey("Unbreakable") && compound.getInt("Unbreakable") == 1;
    }
    
    @Override
    public final ItemStack createBook(final String name, final int amount, final String title, final String author, final String... pages) {
        final ItemStack book = EquipmentUtil.createItem(MaterialEnum.WRITTEN_BOOK, name, amount);
        final net.minecraft.server.v1_7_R4.ItemStack cloneBook = CraftItemStack.asNMSCopy(book);
        final NBTTagCompound compound = new NBTTagCompound();
        final NBTTagList tagList = new NBTTagList();
        compound.setString("title", title);
        compound.setString("author", author);
        for (final String textPage : pages) {
            tagList.add((NBTBase)new NBTTagString(JsonUtil.getJsonText(textPage)));
        }
        compound.set("pages", (NBTBase)tagList);
        cloneBook.setTag(compound);
        return CraftItemStack.asBukkitCopy(cloneBook);
    }
    
    @Override
    public final void openBook(final ItemStack book, final Player player) {
        final ItemStack item = Bridge.getBridgeEquipment().getEquipment(player, Slot.MAINHAND);
        final ByteBuf buf = Unpooled.buffer(256);
        Bridge.getBridgeEquipment().setEquipment(player, book, Slot.MAINHAND);
        buf.setByte(0, 0);
        buf.writerIndex(1);
        final PacketPlayOutCustomPayload packet = new PacketPlayOutCustomPayload("MC|BOpen", (ByteBuf)new PacketDataSerializer(buf));
        final CraftPlayer craftPlayer = (CraftPlayer)player;
        final PlayerConnection playerConnection = craftPlayer.getHandle().playerConnection;
        playerConnection.sendPacket((Packet)packet);
        Bridge.getBridgeEquipment().setEquipment(player, item, Slot.MAINHAND);
    }
}
