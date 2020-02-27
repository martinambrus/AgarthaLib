// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import core.praya.agarthalib.enums.branch.FlagEnum;
import org.bukkit.inventory.ItemFlag;

public class ItemFlagUtil
{
    public static final ItemFlag getFlag(final String flag) {
        final ItemFlag flagPrimary = getFlagByOriginalName(flag);
        if (flagPrimary != null) {
            return flagPrimary;
        }
        final FlagEnum flagEnum = FlagEnum.getFlagEnum(flag);
        return (flagEnum != null) ? flagEnum.getItemFlag() : null;
    }
    
    public static final ItemFlag getFlagByOriginalName(final String flag) {
        if (flag != null) {
            ItemFlag[] values;
            for (int length = (values = ItemFlag.values()).length, i = 0; i < length; ++i) {
                final ItemFlag key = values[i];
                if (key.name().equalsIgnoreCase(flag)) {
                    return key;
                }
            }
        }
        return null;
    }
    
    public static final boolean isExist(final String flag) {
        return getFlag(flag) != null;
    }
    
    public static final void hideAllAttributes(final ItemStack item) {
        if (item != null) {
            addFlag(item, ItemFlag.values());
        }
    }
    
    public static final void addFlag(final ItemStack item, final String... flags) {
        if (item != null && flags != null) {
            for (final String flag : flags) {
                final ItemFlag itemFlag = getFlag(flag);
                if (itemFlag != null) {
                    addFlag(item, itemFlag);
                }
            }
        }
    }
    
    public static final void addFlag(final ItemStack item, final FlagEnum... flags) {
        if (item != null && flags != null) {
            for (final FlagEnum flag : flags) {
                final ItemFlag itemFlag = flag.getItemFlag();
                addFlag(item, itemFlag);
            }
        }
    }
    
    public static final void addFlag(final ItemStack item, final ItemFlag... flags) {
        if (item != null && flags != null) {
            final ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                for (final ItemFlag flag : flags) {
                    meta.addItemFlags(new ItemFlag[] { flag });
                }
                item.setItemMeta(meta);
            }
        }
    }
    
    public static final void removeFlag(final ItemStack item, final String... flags) {
        if (item != null && flags != null) {
            for (final String flag : flags) {
                final ItemFlag itemFlag = getFlag(flag);
                if (itemFlag != null) {
                    removeFlag(item, itemFlag);
                }
            }
        }
    }
    
    public static final void removeFlag(final ItemStack item, final FlagEnum... flags) {
        if (item != null && flags != null) {
            for (final FlagEnum flag : flags) {
                final ItemFlag itemFlag = flag.getItemFlag();
                removeFlag(item, itemFlag);
            }
        }
    }
    
    public static final void removeFlag(final ItemStack item, final ItemFlag... flags) {
        if (item != null && flags != null) {
            final ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                for (final ItemFlag flag : flags) {
                    if (meta.hasItemFlag(flag)) {
                        meta.removeItemFlags(new ItemFlag[] { flag });
                    }
                }
                item.setItemMeta(meta);
            }
        }
    }
    
    public static final void clearFlag(final ItemStack item) {
        if (item != null) {
            final ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                ItemFlag[] values;
                for (int length = (values = ItemFlag.values()).length, i = 0; i < length; ++i) {
                    final ItemFlag flag = values[i];
                    if (meta.hasItemFlag(flag)) {
                        meta.removeItemFlags(new ItemFlag[] { flag });
                    }
                }
                item.setItemMeta(meta);
            }
        }
    }
    
    public static final boolean hasFlag(final ItemStack item, final ItemFlag flag) {
        if (item != null && flag != null) {
            final ItemMeta meta = item.getItemMeta();
            return meta != null && meta.hasItemFlag(flag);
        }
        return false;
    }
}
