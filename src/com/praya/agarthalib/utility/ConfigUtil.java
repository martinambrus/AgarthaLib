// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import core.praya.agarthalib.bridge.unity.Bridge;
import core.praya.agarthalib.enums.branch.MaterialEnum;
import org.bukkit.Color;
import core.praya.agarthalib.enums.branch.ColorEnum;
import java.util.Collection;
import org.bukkit.enchantments.Enchantment;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.configuration.ConfigurationSection;

public class ConfigUtil
{
    public static final ItemStack getItem(final ConfigurationSection section, final String id) {
        if (section != null && id != null) {
            for (final String key : section.getKeys(false)) {
                if (key.equalsIgnoreCase(id) && section.isItemStack(key)) {
                    return section.getItemStack(key);
                }
            }
        }
        return null;
    }
    
    public static final List<String> getStringList(final ConfigurationSection section, final String id) {
        if (section != null && id != null) {
            for (final String key : section.getKeys(false)) {
                if (key.equalsIgnoreCase(id) && section.isList(key)) {
                    return (List<String>)section.getStringList(key);
                }
            }
        }
        return new ArrayList<String>();
    }
    
    public static final boolean isSet(final ConfigurationSection section, final String id) {
        if (section != null && id != null) {
            for (final String key : section.getKeys(false)) {
                if (key.equalsIgnoreCase(id)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static final ItemStack getItemStack(final ConfigurationSection section) {
        if (section != null) {
            final List<String> lores = new ArrayList<String>();
            final List<String> flags = new ArrayList<String>();
            final HashMap<Enchantment, Integer> enchantments = new HashMap<Enchantment, Integer>();
            String itemName = null;
            String itemOwner = null;
            String itemMaterial = null;
            Color itemColor = null;
            int itemData = 0;
            boolean itemUnbreakable = false;
            boolean itemShiny = false;
            for (final String data : section.getKeys(false)) {
                if (data.equalsIgnoreCase("Name") || data.equalsIgnoreCase("Display_Name")) {
                    itemName = section.getString(data);
                }
                if (data.equalsIgnoreCase("Owner") || data.equalsIgnoreCase("Head_Owner")) {
                    itemOwner = section.getString(data);
                }
                else if (data.equalsIgnoreCase("Material")) {
                    itemMaterial = section.getString(data);
                }
                else if (data.equalsIgnoreCase("Data")) {
                    itemData = section.getInt(data);
                }
                else if (data.equalsIgnoreCase("Unbreakable")) {
                    itemUnbreakable = section.getBoolean(data);
                }
                else if (data.equalsIgnoreCase("Shiny")) {
                    itemShiny = section.getBoolean(data);
                }
                else if (data.equalsIgnoreCase("Flags") || data.equalsIgnoreCase("ItemFlags")) {
                    flags.addAll(section.getStringList(data));
                }
                else if (data.equalsIgnoreCase("Lores") || data.equalsIgnoreCase("ItemLores")) {
                    lores.addAll(section.getStringList(data));
                }
                else if (data.equalsIgnoreCase("Color")) {
                    final String[] parts = section.getString(data).replace(" ", "").split(",");
                    if (parts.length == 1) {
                        final ColorEnum colorEnum = ColorEnum.getColorEnum(parts[0]);
                        if (colorEnum == null) {
                            continue;
                        }
                        itemColor = colorEnum.getColor();
                    }
                    else {
                        if (parts.length != 3) {
                            continue;
                        }
                        final String textRed = parts[0];
                        final String textGreen = parts[1];
                        final String textBlue = parts[2];
                        if (!MathUtil.isNumber(textRed) || !MathUtil.isNumber(textGreen) || !MathUtil.isNumber(textBlue)) {
                            continue;
                        }
                        final int colorRed = MathUtil.limitInteger(MathUtil.parseInteger(textRed), 0, 255);
                        final int colorGreen = MathUtil.limitInteger(MathUtil.parseInteger(textGreen), 0, 255);
                        final int colorBlue = MathUtil.limitInteger(MathUtil.parseInteger(textBlue), 0, 255);
                        itemColor = Color.fromRGB(colorRed, colorGreen, colorBlue);
                    }
                }
                else {
                    if (!data.equalsIgnoreCase("Enchantments") && !data.equalsIgnoreCase("Enchantment")) {
                        continue;
                    }
                    for (final String lineEnchant : section.getStringList(data)) {
                        final String[] parts2 = lineEnchant.replace(" ", "").split(":");
                        int grade = 1;
                        if (parts2.length > 0) {
                            final String enchantName = parts2[0].toUpperCase();
                            final Enchantment enchantment = EnchantmentUtil.getEnchantment(enchantName);
                            if (enchantment == null) {
                                continue;
                            }
                            if (parts2.length > 1) {
                                final String textGrade = parts2[1];
                                if (MathUtil.isNumber(textGrade)) {
                                    grade = MathUtil.parseInteger(textGrade);
                                    grade = MathUtil.limitInteger(grade, 1, grade);
                                }
                            }
                            enchantments.put(enchantment, grade);
                        }
                    }
                }
            }
            if (itemMaterial != null) {
                final MaterialEnum materialEnum = MaterialEnum.getMaterialEnum(itemMaterial, itemData);
                if (materialEnum != null) {
                    final ItemStack item = materialEnum.equals(MaterialEnum.PLAYER_HEAD) ? EquipmentUtil.createPlayerHead(itemOwner, itemName, lores) : EquipmentUtil.createItem(materialEnum, itemName, 1, itemData, lores);
                    if (EquipmentUtil.isSolid(item)) {
                        EquipmentUtil.setColor(item, itemColor);
                        if (itemShiny) {
                            EquipmentUtil.shiny(item);
                        }
                        if (itemUnbreakable) {
                            Bridge.getBridgeTagsNBT().setUnbreakable(item, true);
                        }
                        if (!flags.isEmpty()) {
                            for (final String flag : flags) {
                                EquipmentUtil.addFlag(item, flag);
                            }
                        }
                        if (!enchantments.isEmpty()) {
                            for (final Enchantment enchantment2 : enchantments.keySet()) {
                                final int grade2 = enchantments.get(enchantment2);
                                EquipmentUtil.addEnchantment(item, enchantment2, grade2);
                            }
                        }
                        EquipmentUtil.hookPlaceholderAPI(item);
                        return item;
                    }
                }
            }
        }
        return null;
    }
}
