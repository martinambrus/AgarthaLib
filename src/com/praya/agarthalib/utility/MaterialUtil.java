// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import core.praya.agarthalib.enums.branch.MaterialEnum;
import org.bukkit.Material;

public class MaterialUtil
{
    public static final Material getMaterial(final String key) {
        if (key != null) {
            final MaterialEnum materialEnum = MaterialEnum.getMaterialEnum(key);
            if (materialEnum != null) {
                return materialEnum.getMaterial();
            }
        }
        return null;
    }
    
    public static final boolean isExist(final String material) {
        return getMaterial(material) != null;
    }
    
    public static final List<Material> getSolidMaterials() {
        final List<Material> materials = new ArrayList<Material>();
        Material[] values;
        for (int length = (values = Material.values()).length, i = 0; i < length; ++i) {
            final Material material = values[i];
            if (material.isSolid()) {
                materials.add(material);
            }
        }
        return materials;
    }
    
    public static final List<Material> getTransparentMaterials() {
        final List<Material> materials = new ArrayList<Material>();
        Material[] values;
        for (int length = (values = Material.values()).length, i = 0; i < length; ++i) {
            final Material material = values[i];
            if (material.isTransparent()) {
                materials.add(material);
            }
        }
        return materials;
    }
    
    public static final List<Material> getOccludingMaterials() {
        final List<Material> materials = new ArrayList<Material>();
        Material[] values;
        for (int length = (values = Material.values()).length, i = 0; i < length; ++i) {
            final Material material = values[i];
            if (material.isOccluding()) {
                materials.add(material);
            }
        }
        return materials;
    }
    
    public static final List<Material> getFlammableMaterials() {
        final List<Material> materials = new ArrayList<Material>();
        Material[] values;
        for (int length = (values = Material.values()).length, i = 0; i < length; ++i) {
            final Material material = values[i];
            if (material.isFlammable()) {
                materials.add(material);
            }
        }
        return materials;
    }
    
    public static final List<Material> sortSeen(final List<Material> materials) {
        final List<Material> newMaterials = new ArrayList<Material>();
        for (final Material material : materials) {
            if (isSeenIcon(material)) {
                newMaterials.add(material);
            }
        }
        return newMaterials;
    }
    
    public static final boolean isSeenIcon(final Material material) {
        if (material == null) {
            return false;
        }
        final String string;
        switch (string = material.toString()) {
            case "PISTON_EXTENSION": {
                return false;
            }
            case "BURNING_FURNACE": {
                return false;
            }
            case "WALL_BANNER": {
                return false;
            }
            case "DARK_OAK_DOOR": {
                return false;
            }
            case "GLOWING_REDSTONE_ORE": {
                return false;
            }
            case "BIRCH_DOOR": {
                return false;
            }
            case "STRUCTURE_VOID": {
                return false;
            }
            case "SIGN_POST": {
                return false;
            }
            case "CAKE_BLOCK": {
                return false;
            }
            case "SPRUCE_DOOR": {
                return false;
            }
            case "BED_BLOCK": {
                return false;
            }
            case "PURPUR_DOUBLE_SLAB": {
                return false;
            }
            case "WALL_SIGN": {
                return false;
            }
            case "DOUBLE_STONE_SLAB2": {
                return false;
            }
            case "ACACIA_DOOR": {
                return false;
            }
            case "PISTON_MOVING_PIECE": {
                return false;
            }
            case "DOUBLE_STEP": {
                return false;
            }
            case "WOODEN_DOOR": {
                return false;
            }
            case "DAYLIGHT_DETECTOR_INVERTED": {
                return false;
            }
            case "CAULDRON": {
                return false;
            }
            case "FROSTED_ICE": {
                return false;
            }
            case "JUNGLE_DOOR": {
                return false;
            }
            case "BREWING_STAND": {
                return false;
            }
            case "REDSTONE_LAMP_ON": {
                return false;
            }
            case "STANDING_BANNER": {
                return false;
            }
            case "WOOD_DOUBLE_STEP": {
                return false;
            }
            case "IRON_DOOR_BLOCK": {
                return false;
            }
            default:
                break;
        }
        return true;
    }
}
