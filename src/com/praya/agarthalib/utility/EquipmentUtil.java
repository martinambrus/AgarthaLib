// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import com.praya.agarthalib.event.ItemLoresChangeEvent;
import core.praya.agarthalib.bridge.unity.Bridge;
import core.praya.agarthalib.enums.branch.FlagEnum;
import core.praya.agarthalib.enums.branch.MaterialEnum;
import core.praya.agarthalib.enums.main.SkullHead;
import core.praya.agarthalib.enums.main.Slot;
import core.praya.agarthalib.enums.main.VersionNMS;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EquipmentUtil
{
    public static final Slot getEquipmentSlot(final LivingEntity livingEntity, final ItemStack item) {
        if (livingEntity != null && isSolid(item)) {
            Slot[] values;
            for (int length = (values = Slot.values()).length, i = 0; i < length; ++i) {
                final Slot slot = values[i];
                final ItemStack check = Bridge.getBridgeEquipment().getEquipment(livingEntity, slot);
                if (isSolid(check) && check.equals((Object)item)) {
                    return slot;
                }
            }
        }
        return null;
    }
    
    public static final ItemStack getClone(final ItemStack item) {
        return getClone(item, false);
    }
    
    public static final ItemStack getClone(final ItemStack item, final boolean single) {
        final ItemStack clone = item.clone();
        if (single) {
            setAmount(clone, 1);
        }
        return clone;
    }
    
    public static final ItemStack createItem(final MaterialEnum materialEnum) {
        return createItem(materialEnum, null, 1);
    }
    
    public static final ItemStack createItem(final MaterialEnum materialEnum, final int amount) {
        return createItem(materialEnum, null, amount);
    }
    
    public static final ItemStack createItem(final MaterialEnum materialEnum, final int amount, final String... lores) {
        return createItem(materialEnum, null, amount, lores);
    }
    
    public static final ItemStack createItem(final MaterialEnum materialEnum, final String name) {
        return createItem(materialEnum, name, 1);
    }
    
    public static final ItemStack createItem(final MaterialEnum materialEnum, final String name, final int amount) {
        return createItem(materialEnum, name, amount, new String[0]);
    }
    
    public static final ItemStack createItem(final MaterialEnum materialEnum, final String name, final int amount, final String... lores) {
        final List<String> listLores = SortUtil.toList(lores);
        return createItem(materialEnum, name, amount, listLores);
    }
    
    public static final ItemStack createItem(final MaterialEnum materialEnum, final String name, final int amount, final List<String> lores) {
        return createItem(materialEnum, name, amount, 0, lores);
    }
    
    public static final ItemStack createItem(final MaterialEnum materialEnum, final String name, final int amount, final int damage) {
        return createItem(materialEnum, name, amount, damage, new String[0]);
    }
    
    public static final ItemStack createItem(final MaterialEnum materialEnum, final String name, final int amount, final int damage, final String... lores) {
        final List<String> listLores = SortUtil.toList(lores);
        return createItem(materialEnum, name, amount, damage, listLores);
    }
    
    public static final ItemStack createItem(final MaterialEnum materialEnum, final String name, final int amount, final int damage, final List<String> lores) {
        if (materialEnum != null) {
            final ItemStack item = materialEnum.toItemStack();
            if (item != null) {
                if (materialEnum.isDamageable()) {
                    if (ServerUtil.isLegacy()) {
                        item.setDurability((short)damage);
                    }
                    else {
                        final ItemMeta itemMeta = item.getItemMeta();
                        if (itemMeta != null && itemMeta instanceof Damageable) {
                            final Damageable damageable = (Damageable)itemMeta;
                            damageable.setDamage(damage);
                            item.setItemMeta(itemMeta);
                        }
                    }
                }
                setDisplayName(item, name);
                setLores(item, lores);
                return item;
            }
        }
        return null;
    }
    
    public static final ItemStack createPlayerHead(final String playerName) {
        return createPlayerHead(playerName, null);
    }
    
    public static final ItemStack createPlayerHead(final String playerName, final String name) {
        return createPlayerHead(playerName, name, new String[0]);
    }
    
    public static final ItemStack createPlayerHead(final String playerName, final String name, final String... lores) {
        final List<String> listLores = SortUtil.toList(lores);
        return createPlayerHead(playerName, name, listLores);
    }
    
    public static final ItemStack createPlayerHead(final String playerName, final String name, final List<String> lores) {
        final ItemStack item = createItem(MaterialEnum.PLAYER_HEAD);
        setSkullOwner(item, playerName);
        setDisplayName(item, name);
        setLores(item, lores);
        return item;
    }
    
    public static final ItemStack createCustomHead(final SkullHead skullHead) {
        return createCustomHead(skullHead, true, null);
    }
    
    public static final ItemStack createCustomHead(final SkullHead skullHead, final boolean original) {
        return createCustomHead(skullHead, original, null);
    }
    
    public static final ItemStack createCustomHead(final SkullHead skullHead, final boolean original, final String name) {
        return createCustomHead(skullHead, original, name, new String[0]);
    }
    
    public static final ItemStack createCustomHead(final SkullHead skullHead, final boolean original, final String name, final String... lores) {
        final List<String> listLores = SortUtil.toList(lores);
        return createCustomHead(skullHead, original, name, listLores);
    }
    
    public static final ItemStack createCustomHead(final SkullHead skullHead, final boolean original, final String name, final List<String> lores) {
        if (skullHead == null) {
            return null;
        }
        final int typeID = original ? skullHead.getTypeID() : 2;
        if (typeID == 2) {
            final String skullName = skullHead.getName();
            return createPlayerHead(skullName, name, lores);
        }
        final MaterialEnum materialEnum = MaterialEnum.getMaterialEnum("SKULL_ITEM", typeID);
        return createItem(materialEnum, name, 1, lores);
    }
    
    public static final void setSkullOwner(final ItemStack item, final String playerName) {
        if (item != null && playerName != null) {
            final ItemMeta meta = item.getItemMeta();
            if (meta != null && meta instanceof SkullMeta) {
                final SkullMeta skullMeta = (SkullMeta)item.getItemMeta();
                if (ServerUtil.isLegacy()) {
                    skullMeta.setOwner(playerName);
                }
                else {
                    final OfflinePlayer player = PlayerUtil.getPlayer(playerName);
                    if (player != null) {
                        skullMeta.setOwningPlayer(player);
                    }
                }
                item.setItemMeta((ItemMeta)skullMeta);
            }
        }
    }
    
    public static final void setColor(final ItemStack item, final Color color) {
        if (item != null && color != null) {
            final ItemMeta itemMeta = item.getItemMeta();
            if (itemMeta instanceof PotionMeta) {
                final PotionMeta potionMeta = (PotionMeta)itemMeta;
                potionMeta.setColor(color);
                item.setItemMeta((ItemMeta)potionMeta);
            }
            else if (itemMeta instanceof LeatherArmorMeta) {
                final LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta)itemMeta;
                leatherArmorMeta.setColor(color);
                item.setItemMeta((ItemMeta)leatherArmorMeta);
            }
        }
    }
    
    public static final void colorful(final ItemStack item) {
        if (item != null) {
            final ItemMeta meta = item.getItemMeta();
            final String name = meta.getDisplayName();
            final List<String> lores = TextUtil.colorful(getLores(item));
            if (name != null) {
                meta.setDisplayName(TextUtil.colorful(name));
            }
            meta.setLore((List)lores);
            item.setItemMeta(meta);
        }
    }
    
    public static final void hookPlaceholderAPI(final ItemStack item) {
        hookPlaceholderAPI(item, null);
    }
    
    public static final void hookPlaceholderAPI(final ItemStack item, final Player player) {
        if (item != null) {
            if (hasDisplayName(item)) {
                final String name = getDisplayName(item);
                final String nameEdit = TextUtil.hookPlaceholderAPI(player, name);
                setDisplayName(item, nameEdit);
            }
            if (hasLore(item)) {
                final String divider = "\n";
                final List<String> lores = getLores(item);
                final String lineLoresRaw = TextUtil.convertListToString(lores, "\n");
                final String lineLoresEdit = TextUtil.hookPlaceholderAPI(player, lineLoresRaw);
                final String[] loresEdit = lineLoresEdit.split("\n");
                setLores(item, loresEdit);
            }
        }
    }
    
    public static final void placeholder(final ItemStack item, final HashMap<String, String> map) {
        if (item != null && map != null) {
            if (hasDisplayName(item)) {
                final String nameRaw = getDisplayName(item);
                final String nameEdit = TextUtil.placeholder(map, nameRaw);
                setDisplayName(item, nameEdit);
            }
            if (hasLore(item)) {
                final String divider = "\n";
                final List<String> lores = getLores(item);
                final String lineLoresRaw = TextUtil.convertListToString(lores, "\n");
                final String lineLoresEdit = TextUtil.placeholder(map, lineLoresRaw);
                final String[] loresEdit = lineLoresEdit.split("\n");
                setLores(item, loresEdit);
            }
        }
    }
    
    public static final boolean hasItemMeta(final ItemStack item) {
        return item != null && item.hasItemMeta();
    }
    
    public static final boolean hasDisplayName(final ItemStack item) {
        return hasItemMeta(item) && item.getItemMeta().hasDisplayName();
    }
    
    public static final String getDisplayName(final ItemStack item) {
        if (item == null) {
            return null;
        }
        final ItemMeta itemMeta = item.getItemMeta();
        final MaterialEnum materialEnum = MaterialEnum.getMaterialEnum(item);
        if (itemMeta != null && itemMeta.hasDisplayName()) {
            final String displayName = itemMeta.getDisplayName();
            final String nameLegacy = materialEnum.getNameLegacy();
            if (ServerUtil.isLegacy() && nameLegacy != null) {
                final String formatLegacy = TextUtil.toTitleCase(nameLegacy.replace("_", " "));
                if (displayName.equalsIgnoreCase(formatLegacy)) {
                    final String format = TextUtil.toTitleCase(materialEnum.toString().replace("_", " "));
                    return format;
                }
            }
            return displayName;
        }
        final String format2 = TextUtil.toTitleCase(materialEnum.toString().replace("_", " "));
        return format2;
    }
    
    public static final int getAmount(final ItemStack item) {
        return (item != null) ? item.getAmount() : -1;
    }
    
    public static final short getData(final ItemStack item) {
        if (item != null) {
            if (ServerUtil.isLegacy()) {
                return item.getDurability();
            }
            final Material material = item.getType();
            final MaterialEnum materialEnum = MaterialEnum.getMaterialEnum(material);
            if (!materialEnum.isDamageable()) {
                return (short)materialEnum.getDataLegacy();
            }
            final ItemMeta itemMeta = item.getItemMeta();
            if (itemMeta != null && itemMeta instanceof Damageable) {
                final Damageable damageable = (Damageable)itemMeta;
                return (short)damageable.getDamage();
            }
        }
        return 0;
    }
    
    public static final Material getMaterial(final ItemStack item) {
        return (item != null) ? item.getType() : null;
    }
    
    public static final boolean isSimilar(final ItemStack firstItem, final ItemStack secondItem) {
        return firstItem != null && secondItem != null && firstItem.isSimilar(secondItem);
    }
    
    public static final void setAmount(final ItemStack item, int amount) {
        if (item != null) {
            amount = MathUtil.limitInteger(amount, 0, amount);
            item.setAmount(amount);
        }
    }
    
    public static final void setData(final ItemStack item, short data) {
        if (item != null) {
            data = MathUtil.limitShort(data, (short)0, data);
            if (ServerUtil.isLegacy()) {
                item.setDurability(data);
            }
            else {
                final MaterialEnum materialEnum = MaterialEnum.getMaterialEnum(item);
                if (materialEnum.isDamageable()) {
                    final ItemMeta itemMeta = item.getItemMeta();
                    if (itemMeta != null && itemMeta instanceof Damageable) {
                        final Damageable damageable = (Damageable)itemMeta;
                        damageable.setDamage((int)data);
                        item.setItemMeta(itemMeta);
                    }
                }
                else {
                    final String materialNameLegacy = materialEnum.getNameLegacy();
                    final MaterialEnum materialEnumNew = MaterialEnum.getMaterialEnum(materialNameLegacy, data);
                    setMaterial(item, materialEnumNew);
                }
            }
        }
    }
    
    public static final void setMaterial(final ItemStack item, final MaterialEnum materialEnum) {
        if (materialEnum != null) {
            final Material material = materialEnum.getMaterial();
            if (ServerUtil.isLegacy() && !materialEnum.isDamageable()) {
                final int dataLegacy = materialEnum.getDataLegacy();
                setData(item, (short)dataLegacy);
            }
            setMaterial(item, material);
        }
    }
    
    public static final void setMaterial(final ItemStack item, final String material) {
        final Material materialEnum = MaterialUtil.getMaterial(material);
        setMaterial(item, materialEnum);
    }
    
    public static final void setMaterial(final ItemStack item, final Material material) {
        if (item != null && material != null) {
            item.setType(material);
        }
    }
    
    public static final boolean loreCheck(final ItemStack item) {
        return isSolid(item) && hasLore(item);
    }
    
    public static final boolean isSolid(final ItemStack item) {
        return item != null && item.getType() != Material.AIR;
    }
    
    public static final void setDisplayName(final ItemStack item, final String name) {
        setDisplayName(item, name, false);
    }
    
    public static final void setDisplayName(final ItemStack item, String name, final boolean hookPlaceholder) {
        if (item != null && name != null) {
            final ItemMeta itemMeta = item.getItemMeta();
            if (itemMeta != null) {
                name = (hookPlaceholder ? TextUtil.hookPlaceholderAPI(null, name) : name);
                name = TextUtil.colorful(name);
                itemMeta.setDisplayName(name);
                item.setItemMeta(itemMeta);
            }
        }
    }
    
    public static final void clearDisplayName(final ItemStack item) {
        if (item != null) {
            final ItemMeta itemMeta = item.getItemMeta();
            if (itemMeta != null) {
                itemMeta.setDisplayName((String)null);
                item.setItemMeta(itemMeta);
            }
        }
    }
    
    public static final List<String> getLores(final ItemStack item) {
        if (item != null) {
            final ItemMeta itemMeta = item.getItemMeta();
            if (itemMeta != null) {
                final List<String> lores = (List<String>)itemMeta.getLore();
                if (lores != null) {
                    return lores;
                }
            }
        }
        return new ArrayList<String>();
    }
    
    public static final boolean hasLore(final ItemStack item) {
        return !getLores(item).isEmpty();
    }
    
    public static final boolean loreContainsKey(final ItemStack item, final String key) {
        return loreGetLineKey(item, key) != -1;
    }
    
    public static final int loreGetLineKey(final ItemStack item, final String key) {
        final List<String> lores = getLores(item);
        for (int i = 0; i < lores.size(); ++i) {
            if (lores.get(i).contains(key)) {
                return i + 1;
            }
        }
        return -1;
    }
    
    public static final void setLores(final ItemStack item, final String... lores) {
        setLores(item, SortUtil.toList(lores));
    }
    
    public static final void setLores(final ItemStack item, List<String> lores) {
        if (item != null && lores != null) {
            final ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                lores = TextUtil.colorful(lores);
                final ItemLoresChangeEvent itemLoresChangeEvent = new ItemLoresChangeEvent(item, lores);
                ServerEventUtil.callEvent(itemLoresChangeEvent);
                if (!itemLoresChangeEvent.isCancelled()) {
                    meta.setLore((List)lores);
                    item.setItemMeta(meta);
                }
            }
        }
    }
    
    public static final void setLore(final ItemStack item, final int line, final String lore) {
        if (item != null && lore != null) {
            final int index = line - 1;
            final List<String> sources = getLores(item);
            final List<String> lores = SortUtil.addListComponent(sources, index, lore, true);
            setLores(item, lores);
        }
    }
    
    public static final void insertLore(final ItemStack item, final int line, final String lore) {
        if (item != null && lore != null) {
            final int index = line - 1;
            final List<String> sources = getLores(item);
            final List<String> lores = SortUtil.addListComponent(sources, index, lore, false);
            setLores(item, lores);
        }
    }
    
    public static final void addLore(final ItemStack item, final String lore) {
        if (item != null && lore != null) {
            final List<String> sources = getLores(item);
            final List<String> lores = SortUtil.addListComponent(sources, lore);
            setLores(item, lores);
        }
    }
    
    public static final void removeLore(final ItemStack item, final int line) {
        if (item != null) {
            final int index = line - 1;
            final List<String> sources = getLores(item);
            final List<String> lores = SortUtil.removeListComponent(sources, index);
            setLores(item, lores);
        }
    }
    
    public static final void removeLastLore(final ItemStack item, final int line) {
        if (item != null) {
            final int lastLine = getLores(item).size();
            removeLore(item, lastLine);
        }
    }
    
    public static final void clearLore(final ItemStack item) {
        if (item != null) {
            final List<String> lores = new ArrayList<String>();
            setLores(item, lores);
        }
    }
    
    public static final void fixLore(final ItemStack item) {
        if (item != null) {
            final ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                fixLore(meta);
                item.setItemMeta(meta);
            }
        }
    }
    
    public static final ItemMeta fixLore(final ItemMeta meta) {
        if (meta != null && meta.hasLore()) {
            final List<String> lores = new ArrayList<String>();
            int lastLore = -1;
            for (int i = 0; i < meta.getLore().size(); ++i) {
                if (!meta.getLore().get(i).equalsIgnoreCase("")) {
                    lastLore = i;
                }
            }
            for (int i = 0; i <= lastLore; ++i) {
                lores.add(meta.getLore().get(i));
            }
            meta.setLore((List)lores);
        }
        return meta;
    }
    
    public static final void addEnchantment(final ItemStack item, final Enchantment enchantment, final int grade) {
        if (item != null && enchantment != null) {
            item.addUnsafeEnchantment(enchantment, grade);
        }
    }
    
    public static final void removeEnchantment(final ItemStack item, final Enchantment enchantment) {
        if (item != null && enchantment != null) {
            item.removeEnchantment(enchantment);
        }
    }
    
    public static final void clearEnchantment(final ItemStack item) {
        if (item != null) {
            Enchantment[] values;
            for (int length = (values = Enchantment.values()).length, i = 0; i < length; ++i) {
                final Enchantment enchantment = values[i];
                removeEnchantment(item, enchantment);
            }
        }
    }
    
    public static final void addFlag(final ItemStack item, final String... flags) {
        if (ServerUtil.isCompatible(VersionNMS.V1_8_R3)) {
            ItemFlagUtil.addFlag(item, flags);
        }
    }
    
    public static final void addFlag(final ItemStack item, final FlagEnum... flags) {
        if (ServerUtil.isCompatible(VersionNMS.V1_8_R3)) {
            ItemFlagUtil.addFlag(item, flags);
        }
    }
    
    public static final void removeFlag(final ItemStack item, final String... flags) {
        if (ServerUtil.isCompatible(VersionNMS.V1_8_R3)) {
            ItemFlagUtil.removeFlag(item, flags);
        }
    }
    
    public static final void removeFlag(final ItemStack item, final FlagEnum... flags) {
        if (ServerUtil.isCompatible(VersionNMS.V1_8_R3)) {
            ItemFlagUtil.removeFlag(item, flags);
        }
    }
    
    public static final void clearFlag(final ItemStack item) {
        if (ServerUtil.isCompatible(VersionNMS.V1_8_R3)) {
            ItemFlagUtil.clearFlag(item);
        }
    }
    
    public static final boolean holdBow(final LivingEntity livingEntity) {
        return getActiveSlotBow(livingEntity) != null;
    }
    
    public static final Slot getActiveSlotBow(final LivingEntity livingEntity) {
        if (livingEntity != null) {
            final ItemStack mainHand = Bridge.getBridgeEquipment().getEquipment(livingEntity, Slot.MAINHAND);
            final ItemStack offHand = Bridge.getBridgeEquipment().getEquipment(livingEntity, Slot.OFFHAND);
            if (isSolid(mainHand) && mainHand.getType().equals((Object)Material.BOW)) {
                return Slot.MAINHAND;
            }
            if (isSolid(offHand) && offHand.getType().equals((Object)Material.BOW)) {
                return Slot.OFFHAND;
            }
        }
        return null;
    }
    
    public static final void shiny(final ItemStack item) {
        if (item != null) {
            final ItemMeta meta = item.getItemMeta();
            if (meta != null && !meta.hasEnchants()) {
                addEnchantment(item, Enchantment.DURABILITY, 7);
                if (ServerUtil.isCompatible(VersionNMS.V1_8_R3)) {
                    ItemFlagUtil.addFlag(item, "HIDE_ENCHANTS");
                }
            }
        }
    }
    
    @Deprecated
    public static final ItemStack createItem(final Material material) {
        return createItem(material, null, 1, (short)0);
    }
    
    @Deprecated
    public static final ItemStack createItem(final Material material, final int amount) {
        return createItem(material, null, amount, (short)0);
    }
    
    @Deprecated
    public static final ItemStack createItem(final Material material, final int amount, final short data) {
        return createItem(material, null, amount, data);
    }
    
    @Deprecated
    public static final ItemStack createItem(final Material material, final int amount, final short data, final String... lores) {
        return createItem(material, null, amount, data, lores);
    }
    
    @Deprecated
    public static final ItemStack createItem(final Material material, final String name) {
        return createItem(material, name, 1, (short)0);
    }
    
    @Deprecated
    public static final ItemStack createItem(final Material material, final String name, final int amount) {
        return createItem(material, name, amount, (short)0);
    }
    
    @Deprecated
    public static final ItemStack createItem(final Material material, final String name, final int amount, final short data) {
        return createItem(material, name, amount, data, new String[0]);
    }
    
    @Deprecated
    public static final ItemStack createItem(final Material material, final String name, final int amount, final short data, final String... lores) {
        final List<String> listLores = SortUtil.toList(lores);
        return createItem(material, name, amount, data, listLores);
    }
    
    @Deprecated
    public static final ItemStack createItem(final Material material, final String name, final int amount, final short data, final List<String> lores) {
        if (material == null) {
            return null;
        }
        final ItemStack item = new ItemStack(material, amount, data);
        setDisplayName(item, name);
        setLores(item, lores);
        return item;
    }
    
    @Deprecated
    public static final ItemStack createMobHead(final SkullHead skullHead, final boolean original) {
        return createMobHead(skullHead, original, null);
    }
    
    @Deprecated
    public static final ItemStack createMobHead(final SkullHead skullHead, final boolean original, final String name) {
        return createMobHead(skullHead, original, name, new String[0]);
    }
    
    @Deprecated
    public static final ItemStack createMobHead(final SkullHead skullHead, final boolean original, final String name, final List<String> lores) {
        final String[] arrayLores = (lores != null) ? TextUtil.convertListToString(lores).split("\n") : new String[0];
        return createMobHead(skullHead, original, name, arrayLores);
    }
    
    @Deprecated
    public static final ItemStack createMobHead(final SkullHead skullHead, final boolean original, final String name, final String... lores) {
        return createCustomHead(skullHead, original, name, lores);
    }
    
    @Deprecated
    public static final void placeholder(final ItemStack item) {
        hookPlaceholderAPI(item, null);
    }
    
    @Deprecated
    public static final void placeholder(final ItemStack item, final Player player) {
        hookPlaceholderAPI(item, player);
    }
    
    @Deprecated
    public static final boolean hasCustomName(final ItemStack item) {
        return hasDisplayName(item);
    }
    
    @Deprecated
    public static final void setName(final ItemStack item, final String name) {
        setDisplayName(item, name);
    }
    
    @Deprecated
    public static final void setName(final ItemStack item, final String name, final boolean hookPlaceholder) {
        setDisplayName(item, name, hookPlaceholder);
    }
    
    @Deprecated
    public static final List<String> getLore(final ItemStack item) {
        return getLores(item);
    }
    
    @Deprecated
    public static final void AddEnchantment(final ItemStack item, final Enchantment enchantment, final int grade) {
        if (item != null && enchantment != null) {
            item.addUnsafeEnchantment(enchantment, grade);
        }
    }
    
    @Deprecated
    public static final void RemoveEnchantment(final ItemStack item, final Enchantment enchantment) {
        if (item != null && enchantment != null) {
            item.removeEnchantment(enchantment);
        }
    }
    
    @Deprecated
    public static final void ClearEnchantment(final ItemStack item) {
        if (item != null) {
            Enchantment[] values;
            for (int length = (values = Enchantment.values()).length, i = 0; i < length; ++i) {
                final Enchantment enchantment = values[i];
                item.removeEnchantment(enchantment);
            }
        }
    }
}
