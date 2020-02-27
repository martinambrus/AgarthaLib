// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffectType;
import core.praya.agarthalib.enums.branch.PotionTypeEnum;
import org.bukkit.Color;
import org.bukkit.potion.PotionType;

public class PotionUtil
{
    public static final PotionType getPotionTypeByOriginalName(final String potion) {
        if (potion != null) {
            PotionType[] values;
            for (int length = (values = PotionType.values()).length, i = 0; i < length; ++i) {
                final PotionType key = values[i];
                if (key.name().equalsIgnoreCase(potion)) {
                    return key;
                }
            }
        }
        return null;
    }
    
    public static final PotionType getPotionTypeByColor(final Color color) {
        if (color != null) {
            final int red = color.getRed();
            final int green = color.getGreen();
            final int blue = color.getBlue();
            PotionType potionType = PotionType.WATER;
            double lastDif = -1.0;
            PotionTypeEnum[] values;
            for (int length = (values = PotionTypeEnum.values()).length, i = 0; i < length; ++i) {
                final PotionTypeEnum key = values[i];
                final PotionType potion = key.getPotionType();
                if (potion != null) {
                    final Color keyColor = key.getColor();
                    final double difRed = Math.abs(red - keyColor.getRed());
                    final double difGreen = Math.abs(green - keyColor.getGreen());
                    final double difBlue = Math.abs(blue - keyColor.getBlue());
                    final double dif = difRed + difGreen + difBlue;
                    if (lastDif == -1.0 || dif < lastDif) {
                        potionType = potion;
                        lastDif = dif;
                    }
                }
            }
            return potionType;
        }
        return null;
    }
    
    public static final PotionEffectType getPotionEffectType(final String key) {
        if (key == null) {
            return null;
        }
        if (MathUtil.isNumber(key)) {
            final int id = Integer.valueOf(key);
            final PotionEffectType potion = PotionEffectType.getById(id);
            return potion;
        }
        final PotionEffectType potion2 = PotionEffectType.getByName(key.toUpperCase());
        return potion2;
    }
    
    public static final PotionEffectType getPoisonType(final LivingEntity victims) {
        if (victims == null) {
            return null;
        }
        switch (victims.getType()) {
            case ZOMBIE: {
                return PotionEffectType.WITHER;
            }
            case PIG_ZOMBIE: {
                return PotionEffectType.WITHER;
            }
            case WITHER_SKULL: {
                return PotionEffectType.WITHER;
            }
            case SKELETON: {
                return PotionEffectType.WITHER;
            }
            case SPIDER: {
                return PotionEffectType.WITHER;
            }
            case CAVE_SPIDER: {
                return PotionEffectType.WITHER;
            }
            default: {
                return PotionEffectType.POISON;
            }
        }
    }
    
    public static final PotionEffect createPotion(final PotionEffectType potion, final int duration) {
        return createPotion(potion, duration, 1, false, false);
    }
    
    public static final PotionEffect createPotion(final PotionEffectType potion, final int duration, final int grade) {
        return createPotion(potion, duration, grade, false, false);
    }
    
    public static final PotionEffect createPotion(final PotionEffectType potion, final int duration, final int grade, final boolean ambient, final boolean particles) {
        return (potion != null) ? (ServerUtil.isVersion_1_7() ? new PotionEffect(potion, duration, grade - 1) : new PotionEffect(potion, duration, grade - 1, ambient, particles)) : null;
    }
}
