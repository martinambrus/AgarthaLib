// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.enums.main;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import java.util.Iterator;
import com.praya.agarthalib.manager.plugin.LanguageManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.praya.agarthalib.AgarthaLib;
import java.util.Arrays;
import java.util.List;

public enum SlotType
{
    WEAPON(Arrays.asList("Weapon")), 
    ARMOR(Arrays.asList("Armor")), 
    UNIVERSAL(Arrays.asList("Uni", "Universal", "All"));
    
    private final List<String> aliases;
    
    private SlotType(final List<String> aliases) {
        this.aliases = aliases;
    }
    
    public final List<String> getAliases() {
        return this.aliases;
    }
    
    public final String getName() {
        final AgarthaLib agarthaLib = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
        final LanguageManager lang = agarthaLib.getPluginManager().getLanguageManager();
        switch (this) {
            case ARMOR: {
                return lang.getText("Slot_Type_Armor");
            }
            case WEAPON: {
                return lang.getText("Slot_Type_Weapon");
            }
            case UNIVERSAL: {
                return lang.getText("Slot_Type_Universal");
            }
            default: {
                return null;
            }
        }
    }
    
    public static final SlotType getSlotType(final String type) {
        if (type != null) {
            SlotType[] values;
            for (int length = (values = values()).length, i = 0; i < length; ++i) {
                final SlotType key = values[i];
                for (final String aliases : key.getAliases()) {
                    if (aliases.equalsIgnoreCase(type)) {
                        return key;
                    }
                }
            }
        }
        return SlotType.WEAPON;
    }
    
    public static final SlotType getSlotType(final ItemStack item) {
        return getSlotType(item.getType());
    }
    
    public static final SlotType getSlotType(final Material material) {
        if (material != null) {
            final String string;
            switch (string = material.toString()) {
                case "IRON_CHESTPLATE": {
                    return SlotType.ARMOR;
                }
                case "DIAMOND_CHESTPLATE": {
                    return SlotType.ARMOR;
                }
                case "SHIELD": {
                    return SlotType.ARMOR;
                }
                case "LEATHER_CHESTPLATE": {
                    return SlotType.ARMOR;
                }
                case "DIAMOND_LEGGINGS": {
                    return SlotType.ARMOR;
                }
                case "DIAMOND_BOOTS": {
                    return SlotType.ARMOR;
                }
                case "LEATHER_LEGGINGS": {
                    return SlotType.ARMOR;
                }
                case "IRON_BOOTS": {
                    return SlotType.ARMOR;
                }
                case "DIAMOND_HELMET": {
                    return SlotType.ARMOR;
                }
                case "GOLD_BOOTS": {
                    return SlotType.ARMOR;
                }
                case "CHAINMAIL_HELMET": {
                    return SlotType.ARMOR;
                }
                case "GOLD_CHESTPLATE": {
                    return SlotType.ARMOR;
                }
                case "CHAINMAIL_LEGGINGS": {
                    return SlotType.ARMOR;
                }
                case "LEATHER_BOOTS": {
                    return SlotType.ARMOR;
                }
                case "LEATHER_HELMET": {
                    return SlotType.ARMOR;
                }
                case "GOLD_LEGGINGS": {
                    return SlotType.ARMOR;
                }
                case "IRON_HELMET": {
                    return SlotType.ARMOR;
                }
                case "CHAINMAIL_BOOTS": {
                    return SlotType.ARMOR;
                }
                case "CHAINMAIL_CHESTPLATE": {
                    return SlotType.ARMOR;
                }
                case "GOLD_HELMET": {
                    return SlotType.ARMOR;
                }
                case "IRON_LEGGINGS": {
                    return SlotType.ARMOR;
                }
                case "ELYTRA": {
                    return SlotType.ARMOR;
                }
                default:
                    break;
            }
        }
        return SlotType.WEAPON;
    }
}
