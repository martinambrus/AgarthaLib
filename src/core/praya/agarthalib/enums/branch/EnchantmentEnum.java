// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.enums.branch;

import java.util.Iterator;
import com.praya.agarthalib.utility.MathUtil;
import org.bukkit.enchantments.Enchantment;
import java.util.Arrays;
import java.util.List;

public enum EnchantmentEnum
{
    ARROW_DAMAGE(48, Arrays.asList("Power")), 
    ARROW_FIRE(50, Arrays.asList("Flame")), 
    ARROW_INFINITE(51, Arrays.asList("Infinite", "Infinity")), 
    ARROW_KNOCKBACK(49, Arrays.asList("Punch")), 
    BINDING_CURSE(10, Arrays.asList("Curse_Of_Binding")), 
    CHANNELING(68, Arrays.asList("Channel")), 
    DAMAGE_ALL(16, Arrays.asList("Sharpness")), 
    DAMAGE_ARTHROPODS(18, Arrays.asList("Bane_of_Arthropods")), 
    DAMAGE_UNDEAD(17, Arrays.asList("Smite")), 
    DEPTH_STRIDER(8, Arrays.asList("Depth", "Depth_Walk")), 
    DIG_SPEED(32, Arrays.asList("Efficiency")), 
    DURABILITY(34, Arrays.asList("Unbreaking", "Unbreak", "Unbreakable")), 
    FIRE_ASPECT(20, Arrays.asList("Fire", "Fire_Sword", "Flame_Sword")), 
    FROST_WALKER(9, Arrays.asList("Frost", "Frost_Walk")), 
    IMPALING(66, Arrays.asList("Impale")), 
    KNOCKBACK(19, Arrays.asList("Push")), 
    LOOT_BONUS_BLOCKS(35, Arrays.asList("Fortune")), 
    LOOT_BONUS_MOBS(21, Arrays.asList("Looting", "Loot")), 
    LOYALTY(65, Arrays.asList("Loyal")), 
    LUCK(61, Arrays.asList("Luck_Of_The_Sea")), 
    LURE(62, Arrays.asList("Fishing_Lure", "Fishing_Speed", "Fishing_Boost")), 
    MENDING(70, Arrays.asList("Repair")), 
    OXYGEN(5, Arrays.asList("Respiration")), 
    PROTECTION_ENVIRONMENTAL(0, Arrays.asList("Protection")), 
    PROTECTION_EXPLOSIONS(1, Arrays.asList("Blast_Protection")), 
    PROTECTION_FALL(2, Arrays.asList("Feather_Falling")), 
    PROTECTION_FIRE(3, Arrays.asList("Fire_Protection")), 
    PROTECTION_PROJECTILE(4, Arrays.asList("Projectile_Protection")), 
    RIPTIDE(67, Arrays.asList("Tide")), 
    SILK_TOUCH(33, Arrays.asList("Silk")), 
    SWEEPING_EDGE(22, Arrays.asList("Sweeping", "Sweep", "Edge")), 
    THORNS(7, Arrays.asList("Thorn")), 
    VANISHING_CURSE(71, Arrays.asList("Curse_Of_Vanishing", "Curse_Of_Vanish")), 
    WATER_WORKER(6, Arrays.asList("Aqua_Affinity"));
    
    private final int id;
    private final List<String> aliases;
    
    private EnchantmentEnum(final int id, final List<String> aliases) {
        this.id = id;
        this.aliases = aliases;
    }
    
    public final int getID() {
        return this.id;
    }
    
    @Deprecated
    public final String getKey() {
        return this.toString();
    }
    
    public final List<String> getAliases() {
        return this.aliases;
    }
    
    public final String getName() {
        return this.getAliases().get(0);
    }
    
    public final Enchantment getEnchantment() {
        final String name = this.toString();
        Enchantment[] values;
        for (int length = (values = Enchantment.values()).length, i = 0; i < length; ++i) {
            final Enchantment enchantment = values[i];
            if (enchantment != null && enchantment.getName().equalsIgnoreCase(name)) {
                return enchantment;
            }
        }
        return null;
    }
    
    public final boolean isEnchantmentExists() {
        return this.getEnchantment() != null;
    }
    
    public static final EnchantmentEnum getEnchantmentEnum(final String name) {
        if (name != null) {
            if (MathUtil.isNumber(name)) {
                final int id = MathUtil.parseInteger(name);
                final EnchantmentEnum enchantmentEnum = getEnchantmentEnum(id);
                if (enchantmentEnum != null) {
                    return enchantmentEnum;
                }
            }
            EnchantmentEnum[] values;
            for (int length = (values = values()).length, i = 0; i < length; ++i) {
                final EnchantmentEnum key = values[i];
                if (key.toString().equalsIgnoreCase(name)) {
                    return key;
                }
            }
            EnchantmentEnum[] values2;
            for (int length2 = (values2 = values()).length, j = 0; j < length2; ++j) {
                final EnchantmentEnum key = values2[j];
                for (final String aliases : key.getAliases()) {
                    if (aliases.equalsIgnoreCase(name)) {
                        return key;
                    }
                }
            }
        }
        return null;
    }
    
    public static final EnchantmentEnum getEnchantmentEnum(final int id) {
        EnchantmentEnum[] values;
        for (int length = (values = values()).length, i = 0; i < length; ++i) {
            final EnchantmentEnum key = values[i];
            if (key.getID() == id) {
                return key;
            }
        }
        return null;
    }
    
    public static final boolean isEnchantmentEnumExists(final String name) {
        return getEnchantmentEnum(name) != null;
    }
    
    public static final boolean isEnchantmentEnumExists(final int id) {
        return getEnchantmentEnum(id) != null;
    }
    
    @Deprecated
    public static final EnchantmentEnum getEnchantmentEnumByID(final int id) {
        return getEnchantmentEnum(id);
    }
    
    @Deprecated
    public static final EnchantmentEnum getEnchantmentEnumByAliases(final String aliases) {
        return getEnchantmentEnum(aliases);
    }
}
