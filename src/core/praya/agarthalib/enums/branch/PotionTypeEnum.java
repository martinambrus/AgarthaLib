// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.enums.branch;

import com.praya.agarthalib.utility.PotionUtil;
import org.bukkit.potion.PotionType;
import org.bukkit.Color;

public enum PotionTypeEnum
{
    AWKWARD("AWKWARD", 0, 44, 74, 157), 
    FIRE_RESISTANCE("FIRE_RESISTANCE", 1, 181, 122, 46), 
    INSTANT_DAMAGE("INSTANT_DAMAGE", 2, 53, 8, 7), 
    INSTANT_HEAL("INSTANT_HEAL", 3, 196, 29, 28), 
    INVISIBILITY("INVISIBILITY", 4, 104, 108, 120), 
    JUMP("JUMP", 5, 27, 202, 60), 
    LUCK("LUCK", 6, 40, 121, 0), 
    MUNDANE("MUNDANE", 7, 44, 74, 157), 
    NIGHT_VISION("NIGHT_VISION", 8, 25, 25, 132), 
    POISON("POISON", 9, 62, 116, 39), 
    REGEN("REGEN", 10, 198, 80, 228), 
    SLOWNESS("SLOWNESS", 11, 71, 86, 102), 
    SPEED("SPEED", 12, 98, 139, 157), 
    STRENGTH("STRENGTH", 13, 116, 29, 28), 
    THICK("THICK", 14, 44, 74, 157), 
    UNCRAFTABLE("UNCRAFTABLE", 15, 198, 0, 198), 
    WATER("WATER", 16, 44, 74, 157), 
    WATER_BREATHING("WATER_BREATHING", 17, 38, 67, 126), 
    WEAKNESS("WEAKNESS", 18, 57, 61, 57);
    
    private final Color color;
    
    private PotionTypeEnum(final String name, final int ordinal, final int red, final int green, final int blue) {
        final Color color = Color.fromRGB(red, green, blue);
        this.color = color;
    }
    
    private PotionTypeEnum(final String name, final int ordinal, final Color color) {
        this.color = color;
    }
    
    public final Color getColor() {
        return this.color;
    }
    
    public final PotionType getPotionType() {
        return PotionUtil.getPotionTypeByOriginalName(this.toString());
    }
    
    @Deprecated
    public final boolean isExists() {
        return this.getPotionType() != null;
    }
}
