// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.enums.main;

import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import core.praya.agarthalib.enums.branch.MaterialEnum;
import java.util.Iterator;
import java.util.Arrays;
import java.util.List;

public enum Slot
{
    MAINHAND("mainhand", 0, SlotType.WEAPON, Arrays.asList("Main Hand", "MainHand", "Main_Hand", "Main", "Primary", "Primer", "Hand"), new String[0]), 
    OFFHAND("offhand", 1, SlotType.WEAPON, Arrays.asList("Off Hand", "OffHand", "Off_Hand", "Off", "Secondary", "Second"), new String[0]), 
    HELMET("head", 2, SlotType.ARMOR, Arrays.asList("Helmet", "Head"), new String[0]), 
    CHESTPLATE("chest", 3, SlotType.ARMOR, Arrays.asList("Chest", "Chestplate", "Armor", "Armour"), new String[0]), 
    LEGGINGS("legs", 4, SlotType.ARMOR, Arrays.asList("Leggings", "Legging", "Legs", "Leg", "Pants", "Pant"), new String[0]), 
    BOOTS("feet", 5, SlotType.ARMOR, Arrays.asList("Boots", "Feet", "Shoes"), new String[0]);
    
    private String name;
    private int id;
    private SlotType type;
    private List<String> aliases;
    
    private Slot(final String name, final int id, final SlotType type, final List<String> aliases, final String[] test) {
        this.name = name;
        this.id = id;
        this.aliases = aliases;
        this.type = type;
    }
    
    public final String getName() {
        return this.name;
    }
    
    public final int getID() {
        return this.id;
    }
    
    public final List<String> getAliases() {
        return this.aliases;
    }
    
    public final SlotType getType() {
        return this.type;
    }
    
    @Deprecated
    public final SlotType getSlotType() {
        switch (this) {
            case HELMET: {
                return SlotType.ARMOR;
            }
            case CHESTPLATE: {
                return SlotType.ARMOR;
            }
            case LEGGINGS: {
                return SlotType.ARMOR;
            }
            case BOOTS: {
                return SlotType.ARMOR;
            }
            case MAINHAND: {
                return SlotType.WEAPON;
            }
            case OFFHAND: {
                return SlotType.WEAPON;
            }
            default: {
                return SlotType.UNIVERSAL;
            }
        }
    }
    
    public static final Slot get(final String slot) {
        if (slot != null) {
            Slot[] values;
            for (int length = (values = values()).length, i = 0; i < length; ++i) {
                final Slot key = values[i];
                for (final String aliases : key.getAliases()) {
                    if (aliases.equalsIgnoreCase(slot)) {
                        return key;
                    }
                }
            }
        }
        return null;
    }
    
    public static final Slot get(final int id) {
        Slot[] values;
        for (int length = (values = values()).length, i = 0; i < length; ++i) {
            final Slot key = values[i];
            if (key.getID() == id) {
                return key;
            }
        }
        return null;
    }
    
    public static final Slot getDefault(final MaterialEnum materialEnum) {
        if (materialEnum == null) {
            return null;
        }
        switch (materialEnum) {
            case TURTLE_HELMET: {
                return Slot.HELMET;
            }
            case LEATHER_HELMET: {
                return Slot.HELMET;
            }
            case IRON_HELMET: {
                return Slot.HELMET;
            }
            case GOLDEN_HELMET: {
                return Slot.HELMET;
            }
            case CHAINMAIL_HELMET: {
                return Slot.HELMET;
            }
            case DIAMOND_HELMET: {
                return Slot.HELMET;
            }
            case ELYTRA: {
                return Slot.CHESTPLATE;
            }
            case LEATHER_CHESTPLATE: {
                return Slot.CHESTPLATE;
            }
            case IRON_CHESTPLATE: {
                return Slot.CHESTPLATE;
            }
            case GOLDEN_CHESTPLATE: {
                return Slot.CHESTPLATE;
            }
            case CHAINMAIL_CHESTPLATE: {
                return Slot.CHESTPLATE;
            }
            case DIAMOND_CHESTPLATE: {
                return Slot.CHESTPLATE;
            }
            case LEATHER_LEGGINGS: {
                return Slot.LEGGINGS;
            }
            case IRON_LEGGINGS: {
                return Slot.LEGGINGS;
            }
            case GOLDEN_LEGGINGS: {
                return Slot.LEGGINGS;
            }
            case CHAINMAIL_LEGGINGS: {
                return Slot.LEGGINGS;
            }
            case DIAMOND_LEGGINGS: {
                return Slot.LEGGINGS;
            }
            case LEATHER_BOOTS: {
                return Slot.BOOTS;
            }
            case IRON_BOOTS: {
                return Slot.BOOTS;
            }
            case GOLDEN_BOOTS: {
                return Slot.BOOTS;
            }
            case CHAINMAIL_BOOTS: {
                return Slot.BOOTS;
            }
            case DIAMOND_BOOTS: {
                return Slot.BOOTS;
            }
            case SHIELD: {
                return Slot.OFFHAND;
            }
            default: {
                return Slot.MAINHAND;
            }
        }
    }
    
    public static final Slot getDefault(final Material material) {
        if (material != null) {
            final MaterialEnum materialEnum = MaterialEnum.getMaterialEnum(material);
            return getDefault(materialEnum);
        }
        return null;
    }
    
    public static final Slot getDefault(final ItemStack item) {
        if (item != null) {
            final MaterialEnum materialEnum = MaterialEnum.getMaterialEnum(item);
            return getDefault(materialEnum);
        }
        return null;
    }
}
