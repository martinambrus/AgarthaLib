// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.enums.branch;

import java.util.Iterator;
import com.praya.agarthalib.utility.ItemFlagUtil;
import org.bukkit.inventory.ItemFlag;
import java.util.Arrays;
import java.util.List;

public enum FlagEnum
{
    HIDE_ENCHANTS(Arrays.asList("Hide Enchants", "Hide_Enchants", "HideEnchants", "Hide Enchant", "Hide_Enchant", "HideEnchant")), 
    HIDE_ATTRIBUTES(Arrays.asList("Hide Attributes", "Hide_Attributes", "HideAttributes", "Hide Attribute", "Hide_Attribute", "HideAttribute")), 
    HIDE_UNBREAKABLE(Arrays.asList("Hide Unbreakable", "Hide_Unbreakable", "HideUnbreakable", "Unbreakable")), 
    HIDE_DESTROYS(Arrays.asList("Hide Destroys", "Hide_Destroys", "HideDestroys", "Hide Destroy", "Hide_Destroy", "HideDestroy")), 
    HIDE_PLACED_ON(Arrays.asList("Hide Placed On", "Hide_Placed_On", "HidePlacedOn", "Hide Place", "Hide_Place", "HidePlace")), 
    HIDE_POTION_EFFECTS(Arrays.asList("Hide Potion Effects", "Hide_Potion_Effects", "HidePotionEffects", "Hide Potion", "Hide_Potion", "HidePotion"));
    
    private final List<String> aliases;
    
    private FlagEnum(final List<String> aliases) {
        this.aliases = aliases;
    }
    
    public final ItemFlag getItemFlag() {
        return ItemFlagUtil.getFlagByOriginalName(this.name());
    }
    
    public final List<String> getAliases() {
        return this.aliases;
    }
    
    public final String getName() {
        return this.getAliases().get(0);
    }
    
    public static final FlagEnum getFlagEnum(final String flag) {
        if (flag != null) {
            FlagEnum[] values;
            for (int length = (values = values()).length, i = 0; i < length; ++i) {
                final FlagEnum key = values[i];
                for (final String aliase : key.getAliases()) {
                    if (aliase.equalsIgnoreCase(flag)) {
                        return key;
                    }
                }
            }
        }
        return null;
    }
    
    public static final boolean isFlagEnumExists(final String flag) {
        return getFlagEnum(flag) != null;
    }
    
    @Deprecated
    public static final FlagEnum getFlagEnumByAliases(final String aliases) {
        return getFlagEnum(aliases);
    }
    
    @Deprecated
    public static final ItemFlag getItemFlagByAliases(final String aliases) {
        final FlagEnum flag = (aliases != null) ? getFlagEnumByAliases(aliases) : null;
        return (flag != null) ? flag.getItemFlag() : null;
    }
    
    @Deprecated
    public static final boolean isExists(final String flag) {
        return getFlagEnumByAliases(flag) != null;
    }
}
