// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.bridge.unity;

import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerBridge;
import com.praya.agarthalib.handler.HandlerPacket;
import com.praya.agarthalib.packet.item.*;
import com.praya.agarthalib.utility.ServerUtil;
import core.praya.agarthalib.builder.bridge.TagsNBTBooks;
import core.praya.agarthalib.builder.bridge.TagsNBTCustom;
import core.praya.agarthalib.builder.bridge.TagsNBTItem;
import core.praya.agarthalib.enums.main.Slot;
import core.praya.agarthalib.enums.main.TagsAttribute;
import core.praya.agarthalib.enums.main.VersionNMS;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class BridgeTagsNBT extends HandlerBridge
{
    final HandlerPacket handler;
    
    protected BridgeTagsNBT(final AgarthaLib plugin, final HandlerPacket handler) {
        super(plugin);
        this.handler = handler;
    }
    
    public static final BridgeTagsNBT getInstance() {
        return BridgeTagsNBTHelper.instance;
    }
    
    public final HandlerPacket getHandler() {
        return this.handler;
    }
    
    private final boolean isSet() {
        return this.getHandler() != null;
    }
    
    private final TagsNBTItem getTagsNBTItem() {
        return (this.isSet() && this.getHandler() instanceof TagsNBTItem) ? ((TagsNBTItem)this.getHandler()) : null;
    }
    
    private final TagsNBTBooks getTagsNBTBooks() {
        return (this.isSet() && this.getHandler() instanceof TagsNBTBooks) ? ((TagsNBTBooks)this.getHandler()) : null;
    }
    
    private final TagsNBTCustom getTagsNBTCustom() {
        return (this.isSet() && this.getHandler() instanceof TagsNBTCustom) ? ((TagsNBTCustom)this.getHandler()) : null;
    }
    
    private final boolean isImplementTagsNBTItem() {
        return this.getTagsNBTItem() != null;
    }
    
    private final boolean isImplementTagsNBTBooks() {
        return this.getTagsNBTBooks() != null;
    }
    
    private final boolean isImplementTagsNBTCustom() {
        return this.getTagsNBTCustom() != null;
    }
    
    public final void setString(final String key, final ItemStack item, final String value) {
        this.setString(key, null, item, value);
    }
    
    public final void setInt(final String key, final ItemStack item, final int value) {
        this.setInt(key, null, item, value);
    }
    
    public final void setDouble(final String key, final ItemStack item, final double value) {
        this.setDouble(key, null, item, value);
    }
    
    public final void setLong(final String key, final ItemStack item, final long value) {
        this.setLong(key, null, item, value);
    }
    
    public final void setBoolean(final String key, final ItemStack item, final boolean value) {
        this.setBoolean(key, null, item, value);
    }
    
    public final void setListString(final String key, final ItemStack item, final List<String> list) {
        this.setListString(key, null, item, list);
    }
    
    public final String getString(final String key, final ItemStack item) {
        return this.getString(key, null, item);
    }
    
    public final int getInt(final String key, final ItemStack item) {
        return this.getInt(key, null, item);
    }
    
    public final double getDouble(final String key, final ItemStack item) {
        return this.getDouble(key, null, item);
    }
    
    public final long getLong(final String key, final ItemStack item) {
        return this.getLong(key, null, item);
    }
    
    public final boolean getBoolean(final String key, final ItemStack item) {
        return this.getBoolean(key, null, item);
    }
    
    public final List<String> getListString(final String key, final ItemStack item) {
        return this.getListString(key, null, item);
    }
    
    public final void setString(final String key, final String parent, final ItemStack item, final String value) {
        final TagsNBTCustom tagsNBTCustom = this.getTagsNBTCustom();
        if (tagsNBTCustom != null) {
            tagsNBTCustom.setString(key, parent, item, value);
        }
    }
    
    public final void setInt(final String key, final String parent, final ItemStack item, final int value) {
        final TagsNBTCustom tagsNBTCustom = this.getTagsNBTCustom();
        if (tagsNBTCustom != null) {
            tagsNBTCustom.setInt(key, parent, item, value);
        }
    }
    
    public final void setDouble(final String key, final String parent, final ItemStack item, final double value) {
        final TagsNBTCustom tagsNBTCustom = this.getTagsNBTCustom();
        if (tagsNBTCustom != null) {
            tagsNBTCustom.setDouble(key, parent, item, value);
        }
    }
    
    public final void setLong(final String key, final String parent, final ItemStack item, final long value) {
        final TagsNBTCustom tagsNBTCustom = this.getTagsNBTCustom();
        if (tagsNBTCustom != null) {
            tagsNBTCustom.setLong(key, parent, item, value);
        }
    }
    
    public final void setBoolean(final String key, final String parent, final ItemStack item, final boolean value) {
        final TagsNBTCustom tagsNBTCustom = this.getTagsNBTCustom();
        if (tagsNBTCustom != null) {
            tagsNBTCustom.setBoolean(key, parent, item, value);
        }
    }
    
    public final void setListString(final String key, final String parent, final ItemStack item, final List<String> list) {
        final TagsNBTCustom tagsNBTCustom = this.getTagsNBTCustom();
        if (tagsNBTCustom != null) {
            tagsNBTCustom.setListString(key, parent, item, list);
        }
    }
    
    public final void remove(final String key, final ItemStack item) {
        this.remove(key, null, item);
    }
    
    public final void remove(final String key, final String parent, final ItemStack item) {
        final TagsNBTCustom tagsNBTCustom = this.getTagsNBTCustom();
        if (tagsNBTCustom != null) {
            tagsNBTCustom.remove(key, parent, item);
        }
    }
    
    public final String getString(final String key, final String parent, final ItemStack item) {
        return this.isImplementTagsNBTCustom() ? this.getTagsNBTCustom().getString(key, parent, item) : null;
    }
    
    public final int getInt(final String key, final String parent, final ItemStack item) {
        return this.isImplementTagsNBTCustom() ? this.getTagsNBTCustom().getInt(key, parent, item) : 0;
    }
    
    public final double getDouble(final String key, final String parent, final ItemStack item) {
        return this.isImplementTagsNBTCustom() ? this.getTagsNBTCustom().getDouble(key, parent, item) : 0.0;
    }
    
    public final long getLong(final String key, final String parent, final ItemStack item) {
        return this.isImplementTagsNBTCustom() ? this.getTagsNBTCustom().getLong(key, parent, item) : 0L;
    }
    
    public final boolean getBoolean(final String key, final String parent, final ItemStack item) {
        return this.isImplementTagsNBTCustom() && this.getTagsNBTCustom().getBoolean(key, parent, item);
    }
    
    public final List<String> getListString(final String key, final String parent, final ItemStack item) {
        return this.isImplementTagsNBTCustom() ? this.getTagsNBTCustom().getListString(key, parent, item) : new ArrayList<String>();
    }
    
    public final void addNBT(final Player player, final Slot slot, final TagsAttribute tags, final double value) {
        this.addNBT(player, slot, tags, value, Slot.MAINHAND);
    }
    
    public final void addNBT(final Player player, final Slot slot, final TagsAttribute tags, final double value, final Slot slotTags) {
        if (player != null && slot != null) {
            final ItemStack item = Bridge.getBridgeEquipment().getEquipment(player, slot);
            this.addNBT(item, tags, value, slotTags);
        }
    }
    
    public final void addNBT(final ItemStack item, final TagsAttribute tags, final double value, final Slot slotTags) {
        final TagsNBTItem tagsNBTItem = this.getTagsNBTItem();
        if (tagsNBTItem != null) {
            tagsNBTItem.addNBT(item, tags, value, slotTags);
        }
    }
    
    public final void clearNBT(final Player player, final Slot slot) {
        if (player != null && slot != null) {
            final ItemStack item = Bridge.getBridgeEquipment().getEquipment(player, slot);
            this.clearNBT(item);
        }
    }
    
    public final void clearNBT(final ItemStack item) {
        final TagsNBTItem tagsNBTItem = this.getTagsNBTItem();
        if (tagsNBTItem != null) {
            tagsNBTItem.clearNBT(item);
        }
    }
    
    public final void setUnbreakable(final ItemStack item, final boolean unbreakable) {
        final TagsNBTItem tagsNBTItem = this.getTagsNBTItem();
        if (tagsNBTItem != null) {
            tagsNBTItem.setUnbreakable(item, unbreakable);
        }
    }
    
    public final boolean isUnbreakable(final ItemStack item) {
        return this.isImplementTagsNBTItem() && this.getTagsNBTItem().isUnbreakable(item);
    }
    
    public final ItemStack createBook(final String name, final int amount, final String title, final String author, final String... pages) {
        return this.isImplementTagsNBTBooks() ? this.getTagsNBTBooks().createBook(name, amount, title, author, pages) : null;
    }
    
    public final void openBook(final ItemStack book, final Player player) {
        final TagsNBTBooks tagsNBTBooks = this.getTagsNBTBooks();
        if (tagsNBTBooks != null) {
            tagsNBTBooks.openBook(book, player);
        }
    }
    
    private static class BridgeTagsNBTHelper
    {
        private static final BridgeTagsNBT instance;
        
        static {
            final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
            final VersionNMS version = ServerUtil.getVersionNMS();
            HandlerPacket handler = null;
            switch (version) {
                case V1_7_R4: {
                    handler = new PacketItem_1_7_R4(plugin);
                    break;
                }
                case V1_8_R3: {
                    handler = new PacketItem_1_8_R3(plugin);
                    break;
                }
                case V1_9_R2: {
                    handler = new PacketItem_1_9_R2(plugin);
                    break;
                }
                case V1_10_R1: {
                    handler = new PacketItem_1_10_R1(plugin);
                    break;
                }
                case V1_11_R1: {
                    handler = new PacketItem_1_11_R1(plugin);
                    break;
                }
                case V1_12_R1: {
                    handler = new PacketItem_1_12_R1(plugin);
                    break;
                }
                case V1_13_R2: {
                    handler = new PacketItem_1_13_R2(plugin);
                    break;
                }
                case V1_14_R1: {
                    handler = new PacketItem_1_14_R1(plugin);
                    break;
                }
                case V1_15_R1: {
                    handler = new PacketItem_1_15_R1(plugin);
                    break;
                }
                default: {
                    handler = null;
                    break;
                }
            }
            instance = new BridgeTagsNBT(plugin, handler);
        }
    }
}
