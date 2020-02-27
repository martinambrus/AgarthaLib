// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import org.bukkit.NamespacedKey;
import core.praya.agarthalib.enums.branch.EnchantmentEnum;
import org.bukkit.enchantments.Enchantment;

public class EnchantmentUtil
{
    public static final Enchantment getEnchantment(final String enchantment) {
        final Enchantment enchantmentPrimary = getEnchantmentByOriginalName(enchantment);
        if (enchantmentPrimary != null) {
            return enchantmentPrimary;
        }
        final EnchantmentEnum enchantmentEnum = EnchantmentEnum.getEnchantmentEnum(enchantment);
        return (enchantmentEnum != null) ? enchantmentEnum.getEnchantment() : null;
    }
    
    public static final Enchantment getEnchantmentByOriginalName(final String enchantment) {
        if (enchantment != null) {
            Enchantment[] values;
            for (int length = (values = Enchantment.values()).length, i = 0; i < length; ++i) {
                final Enchantment key = values[i];
                if (key != null) {
                    if (ServerUtil.isLegacy()) {
                        if (key.getName().equalsIgnoreCase(enchantment)) {
                            return key;
                        }
                    }
                    else {
                        final NamespacedKey namespacedKey = key.getKey();
                        if (namespacedKey.getKey().equalsIgnoreCase(enchantment)) {
                            return key;
                        }
                    }
                }
            }
        }
        return null;
    }
    
    public static final boolean isEnchantmentExists(final String enchantment) {
        return getEnchantment(enchantment) != null;
    }
}
