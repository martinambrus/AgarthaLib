// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.Location;
import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.World;
import java.util.UUID;
import org.bukkit.entity.EntityType;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import core.praya.agarthalib.bridge.unity.Bridge;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;

public class EntityUtil
{
    public static final boolean isArmorStand(final Entity entity) {
        return entity != null && entity instanceof ArmorStand;
    }
    
    public static final ArmorStand parseArmorStand(final Entity entity) {
        return (entity != null) ? ((ArmorStand)entity) : null;
    }
    
    public static final boolean isLivingEntity(final Entity entity) {
        return entity != null && Bridge.getBridgeLivingEntity().isLivingEntity(entity);
    }
    
    public static final boolean isPlayer(final Entity entity) {
        return (entity != null) ? Boolean.valueOf(entity instanceof Player) : null;
    }
    
    public static final LivingEntity parseLivingEntity(final Entity entity) {
        return (entity != null) ? ((LivingEntity)entity) : null;
    }
    
    public static final LivingEntity parseLivingEntity(final ProjectileSource entity) {
        return (entity != null) ? ((LivingEntity)entity) : null;
    }
    
    public static final Player parsePlayer(final Entity entity) {
        return (entity != null) ? ((Player)entity) : null;
    }
    
    public static final boolean isEntityTypeExists(final String entityType) {
        return getEntityType(entityType) != null;
    }
    
    public static final EntityType getEntityType(final String entityType) {
        if (entityType != null) {
            EntityType[] values;
            for (int length = (values = EntityType.values()).length, i = 0; i < length; ++i) {
                final EntityType key = values[i];
                if (key.name().equalsIgnoreCase(entityType)) {
                    return key;
                }
            }
        }
        return null;
    }
    
    public static final Entity getEntityByID(final UUID id) {
        return getEntityByID(id, null, null);
    }
    
    public static final Entity getEntityByID(final UUID id, final World world) {
        return getEntityByID(id, world, null);
    }
    
    public static final Entity getEntityByID(final UUID id, final World world, final Class clazz) {
        if (id != null) {
            for (final World loopWorld : Bukkit.getWorlds()) {
                if (world == null || loopWorld.equals(world)) {
                    for (final Entity entity : loopWorld.getEntities()) {
                        if (entity.getUniqueId().equals(id) && (clazz == null || clazz.isAssignableFrom(entity.getClass()))) {
                            return entity;
                        }
                    }
                }
            }
        }
        return null;
    }
    
    public static final Entity addEntity(final World world, final double x, final double y, final double z, final EntityType entityType) {
        if (world != null && entityType != null) {
            return addEntity(LocationUtil.createLocation(world, x, y, z), entityType);
        }
        return null;
    }
    
    public static final Entity addEntity(final Location loc, final EntityType entityType) {
        if (loc != null && entityType != null) {
            return loc.getWorld().spawnEntity(loc, entityType);
        }
        return null;
    }
    
    public static final void heal(final LivingEntity entity, final double heal) {
        if (entity != null) {
            final double health = entity.getHealth() + heal;
            setHealth(entity, health);
        }
    }
    
    public static final void setHealth(final LivingEntity entity, double health) {
        if (entity != null && !entity.isDead()) {
            final double maxHealth = entity.getMaxHealth();
            final double currentHealth = entity.getHealth();
            health = MathUtil.limitDouble(health, 0.0, maxHealth);
            if (health > currentHealth) {
                final double heal = health - currentHealth;
                final EntityRegainHealthEvent entityRegainHealthEvent = new EntityRegainHealthEvent((Entity)entity, heal, EntityRegainHealthEvent.RegainReason.CUSTOM);
                ServerEventUtil.callEvent((Event)entityRegainHealthEvent);
                if (entityRegainHealthEvent.isCancelled()) {
                    return;
                }
                final double finalHeal = entityRegainHealthEvent.getAmount();
                final double newHealth = currentHealth + finalHeal;
                health = MathUtil.limitDouble(newHealth, 0.0, maxHealth);
            }
            entity.setHealth(health);
        }
    }
    
    public static final void setMaxHealth(final LivingEntity entity, double maxHealth) {
        if (entity != null && !entity.isDead()) {
            final double health = entity.getHealth();
            maxHealth = Math.max(1.0, maxHealth);
            if (health > maxHealth) {
                entity.setHealth(maxHealth);
            }
            entity.setMaxHealth(maxHealth);
        }
    }
}
