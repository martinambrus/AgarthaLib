// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.packet.livingentity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Entity;
import com.praya.agarthalib.AgarthaLib;
import core.praya.agarthalib.builder.bridge.LivingEntityTools;
import com.praya.agarthalib.handler.HandlerPacket;

public class PacketLivingEntity_1_7 extends HandlerPacket implements LivingEntityTools
{
    public PacketLivingEntity_1_7(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @Override
    public boolean isLivingEntity(final Entity entity) {
        return entity instanceof LivingEntity && this.isLivingEntity(entity.getType());
    }
    
    @Override
    public boolean isLivingEntity(final EntityType type) {
        String simpleTypeClass = type.getClass().getSimpleName();
        if (
            simpleTypeClass.equals("ComplexEntityPart") ||
            simpleTypeClass.equals("Weather")
        ) {
            return false;
        }

        switch (type) {
            case ARROW: {
                return false;
            }
            case BOAT: {
                return false;
            }
            case DROPPED_ITEM: {
                return false;
            }
            case EGG: {
                return false;
            }
            case ENDER_CRYSTAL: {
                return false;
            }
            case ENDER_PEARL: {
                return false;
            }
            case ENDER_SIGNAL: {
                return false;
            }
            case EXPERIENCE_ORB: {
                return false;
            }
            case FALLING_BLOCK: {
                return false;
            }
            case FIREBALL: {
                return false;
            }
            case FIREWORK: {
                return false;
            }
            case FISHING_HOOK: {
                return false;
            }
            case ITEM_FRAME: {
                return false;
            }
            case LEASH_HITCH: {
                return false;
            }
            case LIGHTNING: {
                return false;
            }
            case MINECART: {
                return false;
            }
            case MINECART_CHEST: {
                return false;
            }
            case MINECART_COMMAND: {
                return false;
            }
            case MINECART_FURNACE: {
                return false;
            }
            case MINECART_HOPPER: {
                return false;
            }
            case MINECART_MOB_SPAWNER: {
                return false;
            }
            case MINECART_TNT: {
                return false;
            }
            case PAINTING: {
                return false;
            }
            case PRIMED_TNT: {
                return false;
            }
            case SMALL_FIREBALL: {
                return false;
            }
            case SNOWBALL: {
                return false;
            }
            case SPLASH_POTION: {
                return false;
            }
            case THROWN_EXP_BOTTLE: {
                return false;
            }
            case UNKNOWN: {
                return false;
            }
            case WITHER_SKULL: {
                return false;
            }
            default: {
                return true;
            }
        }
    }
}
