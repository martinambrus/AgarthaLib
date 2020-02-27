// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.packet.item;

import net.minecraft.server.v1_12_R1.PlayerConnection;
import io.netty.buffer.ByteBuf;
import net.minecraft.server.v1_12_R1.Packet;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import net.minecraft.server.v1_12_R1.PacketPlayOutCustomPayload;
import net.minecraft.server.v1_12_R1.PacketDataSerializer;
import io.netty.buffer.Unpooled;
import core.praya.agarthalib.bridge.unity.Bridge;
import org.bukkit.entity.Player;
import com.praya.agarthalib.utility.JsonUtil;
import com.praya.agarthalib.utility.EquipmentUtil;
import core.praya.agarthalib.enums.branch.MaterialEnum;
import net.minecraft.server.v1_12_R1.NBTTagDouble;
import net.minecraft.server.v1_12_R1.NBTTagInt;
import com.praya.agarthalib.utility.MathUtil;
import java.util.regex.Pattern;
import core.praya.agarthalib.enums.main.Slot;
import core.praya.agarthalib.enums.main.TagsAttribute;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.server.v1_12_R1.NBTTagString;
import net.minecraft.server.v1_12_R1.NBTTagList;
import java.util.List;
import net.minecraft.server.v1_12_R1.NBTBase;
import net.minecraft.server.v1_12_R1.NBTTagCompound;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import com.praya.agarthalib.AgarthaLib;
import core.praya.agarthalib.builder.bridge.TagsNBTCustom;
import core.praya.agarthalib.builder.bridge.TagsNBTBooks;
import core.praya.agarthalib.builder.bridge.TagsNBTItem;
import com.praya.agarthalib.handler.HandlerPacket;

public class PacketItem_1_12_R1 extends HandlerPacket implements TagsNBTItem, TagsNBTBooks, TagsNBTCustom
{
    public PacketItem_1_12_R1(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @Override
    public final void setString(final String key, final String parent, final ItemStack item, final String value) {
        final net.minecraft.server.v1_12_R1.ItemStack itemNMS = CraftItemStack.asNMSCopy(item);
        final NBTTagCompound compound = itemNMS.hasTag() ? itemNMS.getTag() : new NBTTagCompound();
        if (parent != null) {
            final NBTTagCompound attribute = compound.hasKey(parent) ? compound.getCompound(parent) : new NBTTagCompound();
            attribute.setString(key, value);
            compound.set(parent, (NBTBase)attribute);
        }
        else {
            compound.setString(key, value);
        }
        itemNMS.setTag(compound);
        item.setItemMeta(CraftItemStack.asBukkitCopy(itemNMS).getItemMeta());
    }
    
    @Override
    public final void setInt(final String key, final String parent, final ItemStack item, final int value) {
        final net.minecraft.server.v1_12_R1.ItemStack itemNMS = CraftItemStack.asNMSCopy(item);
        final NBTTagCompound compound = itemNMS.hasTag() ? itemNMS.getTag() : new NBTTagCompound();
        if (parent != null) {
            final NBTTagCompound attribute = compound.hasKey(parent) ? compound.getCompound(parent) : new NBTTagCompound();
            attribute.setInt(key, value);
            compound.set(parent, (NBTBase)attribute);
        }
        else {
            compound.setInt(key, value);
        }
        itemNMS.setTag(compound);
        item.setItemMeta(CraftItemStack.asBukkitCopy(itemNMS).getItemMeta());
    }
    
    @Override
    public final void setDouble(final String key, final String parent, final ItemStack item, final double value) {
        final net.minecraft.server.v1_12_R1.ItemStack itemNMS = CraftItemStack.asNMSCopy(item);
        final NBTTagCompound compound = itemNMS.hasTag() ? itemNMS.getTag() : new NBTTagCompound();
        if (parent != null) {
            final NBTTagCompound attribute = compound.hasKey(parent) ? compound.getCompound(parent) : new NBTTagCompound();
            attribute.setDouble(key, value);
            compound.set(parent, (NBTBase)attribute);
        }
        else {
            compound.setDouble(key, value);
        }
        itemNMS.setTag(compound);
        item.setItemMeta(CraftItemStack.asBukkitCopy(itemNMS).getItemMeta());
    }
    
    @Override
    public final void setLong(final String key, final String parent, final ItemStack item, final long value) {
        final net.minecraft.server.v1_12_R1.ItemStack itemNMS = CraftItemStack.asNMSCopy(item);
        final NBTTagCompound compound = itemNMS.hasTag() ? itemNMS.getTag() : new NBTTagCompound();
        if (parent != null) {
            final NBTTagCompound attribute = compound.hasKey(parent) ? compound.getCompound(parent) : new NBTTagCompound();
            attribute.setLong(key, value);
            compound.set(parent, (NBTBase)attribute);
        }
        else {
            compound.setLong(key, value);
        }
        itemNMS.setTag(compound);
        item.setItemMeta(CraftItemStack.asBukkitCopy(itemNMS).getItemMeta());
    }
    
    @Override
    public final void setBoolean(final String key, final String parent, final ItemStack item, final boolean value) {
        final net.minecraft.server.v1_12_R1.ItemStack itemNMS = CraftItemStack.asNMSCopy(item);
        final NBTTagCompound compound = itemNMS.hasTag() ? itemNMS.getTag() : new NBTTagCompound();
        if (parent != null) {
            final NBTTagCompound attribute = compound.hasKey(parent) ? compound.getCompound(parent) : new NBTTagCompound();
            attribute.setBoolean(key, value);
            compound.set(parent, (NBTBase)attribute);
        }
        else {
            compound.setBoolean(key, value);
        }
        itemNMS.setTag(compound);
        item.setItemMeta(CraftItemStack.asBukkitCopy(itemNMS).getItemMeta());
    }
    
    @Override
    public final void setListString(final String key, final String parent, final ItemStack item, final List<String> list) {
        final net.minecraft.server.v1_12_R1.ItemStack itemNMS = CraftItemStack.asNMSCopy(item);
        final NBTTagCompound compound = itemNMS.hasTag() ? itemNMS.getTag() : new NBTTagCompound();
        final NBTTagList tagList = new NBTTagList();
        for (final String part : list) {
            tagList.add((NBTBase)new NBTTagString(part));
        }
        if (parent != null) {
            final NBTTagCompound attribute = compound.hasKey(parent) ? compound.getCompound(parent) : new NBTTagCompound();
            attribute.set(key, (NBTBase)tagList);
            compound.set(parent, (NBTBase)attribute);
        }
        else {
            compound.set(key, (NBTBase)tagList);
        }
        itemNMS.setTag(compound);
        item.setItemMeta(CraftItemStack.asBukkitCopy(itemNMS).getItemMeta());
    }
    
    @Override
    public final String getString(final String key, final String parent, final ItemStack item) {
        final net.minecraft.server.v1_12_R1.ItemStack itemNMS = CraftItemStack.asNMSCopy(item);
        if (itemNMS.hasTag()) {
            final NBTTagCompound compound = itemNMS.getTag();
            if (parent == null) {
                return compound.getString(key);
            }
            if (compound.hasKey(parent)) {
                return compound.getCompound(parent).getString(key);
            }
        }
        return null;
    }
    
    @Override
    public final int getInt(final String key, final String parent, final ItemStack item) {
        final net.minecraft.server.v1_12_R1.ItemStack itemNMS = CraftItemStack.asNMSCopy(item);
        if (itemNMS.hasTag()) {
            final NBTTagCompound compound = itemNMS.getTag();
            if (parent == null) {
                return compound.getInt(key);
            }
            if (compound.hasKey(parent)) {
                return compound.getCompound(parent).getInt(key);
            }
        }
        return 0;
    }
    
    @Override
    public final double getDouble(final String key, final String parent, final ItemStack item) {
        final net.minecraft.server.v1_12_R1.ItemStack itemNMS = CraftItemStack.asNMSCopy(item);
        if (itemNMS.hasTag()) {
            final NBTTagCompound compound = itemNMS.getTag();
            if (parent == null) {
                return compound.getDouble(key);
            }
            if (compound.hasKey(parent)) {
                return compound.getCompound(parent).getDouble(key);
            }
        }
        return 0.0;
    }
    
    @Override
    public final long getLong(final String key, final String parent, final ItemStack item) {
        final net.minecraft.server.v1_12_R1.ItemStack itemNMS = CraftItemStack.asNMSCopy(item);
        if (itemNMS.hasTag()) {
            final NBTTagCompound compound = itemNMS.getTag();
            if (parent == null) {
                return compound.getLong(key);
            }
            if (compound.hasKey(parent)) {
                return compound.getCompound(parent).getLong(key);
            }
        }
        return 0L;
    }
    
    @Override
    public final boolean getBoolean(final String key, final String parent, final ItemStack item) {
        final net.minecraft.server.v1_12_R1.ItemStack itemNMS = CraftItemStack.asNMSCopy(item);
        if (itemNMS.hasTag()) {
            final NBTTagCompound compound = itemNMS.getTag();
            if (parent == null) {
                return compound.getBoolean(key);
            }
            if (compound.hasKey(parent)) {
                return compound.getCompound(parent).getBoolean(key);
            }
        }
        return false;
    }
    
    @Override
    public final List<String> getListString(final String key, final String parent, final ItemStack item) {
        final net.minecraft.server.v1_12_R1.ItemStack itemNMS = CraftItemStack.asNMSCopy(item);
        final List<String> list = new ArrayList<String>();
        if (itemNMS.hasTag()) {
            final NBTTagCompound compound = itemNMS.getTag();
            if (parent != null) {
                if (compound.hasKey(parent)) {
                    final NBTTagList tagList = compound.getCompound(parent).getList(key, 8);
                    for (int t = 0; t < tagList.size(); ++t) {
                        list.add(tagList.getString(t));
                    }
                }
            }
            else {
                final NBTTagList tagList = compound.getList(key, 8);
                for (int t = 0; t < tagList.size(); ++t) {
                    list.add(tagList.getString(t));
                }
            }
        }
        return list;
    }
    
    @Override
    public final void remove(final String key, final String parent, final ItemStack item) {
        final net.minecraft.server.v1_12_R1.ItemStack itemNMS = CraftItemStack.asNMSCopy(item);
        final NBTTagCompound compound = itemNMS.hasTag() ? itemNMS.getTag() : new NBTTagCompound();
        if (parent != null) {
            if (compound.hasKey(parent)) {
                final NBTTagCompound attribute = compound.getCompound(parent);
                attribute.remove(key);
            }
        }
        else {
            compound.remove(key);
        }
        itemNMS.setTag(compound);
        item.setItemMeta(CraftItemStack.asBukkitCopy(itemNMS).getItemMeta());
    }
    
    @Override
    public final void addNBT(final ItemStack item, final TagsAttribute tags, double value, final Slot slot) {
        final net.minecraft.server.v1_12_R1.ItemStack itemNMS = CraftItemStack.asNMSCopy(item);
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
        final net.minecraft.server.v1_12_R1.ItemStack itemNMS = CraftItemStack.asNMSCopy(item);
        final NBTTagCompound compound = itemNMS.hasTag() ? itemNMS.getTag() : new NBTTagCompound();
        final NBTTagList tagList = new NBTTagList();
        compound.set("AttributeModifiers", (NBTBase)tagList);
        itemNMS.setTag(compound);
        item.setItemMeta(CraftItemStack.asBukkitCopy(itemNMS).getItemMeta());
    }
    
    @Override
    public final void setUnbreakable(final ItemStack item, final boolean unbreakable) {
        final net.minecraft.server.v1_12_R1.ItemStack itemNMS = CraftItemStack.asNMSCopy(item);
        final NBTTagCompound compound = itemNMS.hasTag() ? itemNMS.getTag() : new NBTTagCompound();
        compound.setInt("Unbreakable", (int)(unbreakable ? 1 : 0));
        itemNMS.setTag(compound);
        item.setItemMeta(CraftItemStack.asBukkitCopy(itemNMS).getItemMeta());
    }
    
    @Override
    public final boolean isUnbreakable(final ItemStack item) {
        final net.minecraft.server.v1_12_R1.ItemStack itemNMS = CraftItemStack.asNMSCopy(item);
        final NBTTagCompound compound = itemNMS.hasTag() ? itemNMS.getTag() : new NBTTagCompound();
        return compound.hasKey("Unbreakable") && compound.getInt("Unbreakable") == 1;
    }
    
    @Override
    public final ItemStack createBook(final String name, final int amount, final String title, final String author, final String... pages) {
        final ItemStack book = EquipmentUtil.createItem(MaterialEnum.WRITTEN_BOOK, name, amount);
        final net.minecraft.server.v1_12_R1.ItemStack cloneBook = CraftItemStack.asNMSCopy(book);
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
        final PacketPlayOutCustomPayload packet = new PacketPlayOutCustomPayload("MC|BOpen", new PacketDataSerializer(buf));
        final CraftPlayer craftPlayer = (CraftPlayer)player;
        final PlayerConnection playerConnection = craftPlayer.getHandle().playerConnection;
        playerConnection.sendPacket((Packet)packet);
        Bridge.getBridgeEquipment().setEquipment(player, item, Slot.MAINHAND);
    }
}
