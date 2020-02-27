// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import org.bukkit.entity.WitherSkull;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.SmallFireball;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Projectile;
import core.praya.agarthalib.enums.branch.ProjectileEnum;
import java.util.Iterator;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import core.praya.agarthalib.bridge.unity.Bridge;
import java.util.ArrayList;
import org.bukkit.entity.LivingEntity;
import java.util.Collection;
import org.bukkit.Location;

public class CombatUtil
{
    private static final String METADATA_SKILL_DAMAGE = "Skill_Damage";
    private static final String METADATA_AREA_DAMAGE = "Area_Damage";
    private static final String METADATA_INSTANT_DAMAGE = "Instant_Damage";
    
    public static final Collection<LivingEntity> getNearbyUnits(final Location location, final double range) {
        final Collection<LivingEntity> list = new ArrayList<LivingEntity>();
        if (location != null) {
            final World world = location.getWorld();
            for (final LivingEntity livingEntity : world.getLivingEntities()) {
                if (Bridge.getBridgeLivingEntity().isLivingEntity((Entity)livingEntity) && livingEntity.getWorld().equals(world) && location.distance(livingEntity.getLocation()) <= range) {
                    list.add(livingEntity);
                }
            }
        }
        return list;
    }
    
    public static final void strikeLightning(final Entity entity) {
        if (entity != null) {
            final Location location = entity.getLocation();
            strikeLightning(location);
        }
    }
    
    public static final void strikeLightning(final Location location) {
        if (location != null) {
            location.getWorld().strikeLightningEffect(location);
        }
    }
    
    public static final void damage(final LivingEntity victims, final double damage) {
        if (victims != null) {
            victims.damage(damage);
        }
    }
    
    public static final void damage(final LivingEntity attacker, final LivingEntity victims, final double damage) {
        if (attacker != null && victims != null) {
            victims.damage(damage, (Entity)attacker);
        }
    }
    
    public static final void instantDamage(final LivingEntity attacker, final LivingEntity victims, final double damage) {
        if (attacker != null && victims != null) {
            victims.setMetadata("Instant_Damage", MetadataUtil.createMetadata(true));
            victims.damage(damage, (Entity)attacker);
        }
    }
    
    public static final void skillDamage(final LivingEntity attacker, final LivingEntity victims, final double damage) {
        if (attacker != null && victims != null) {
            MetadataUtil.setCooldown((Entity)victims, "Skill_Damage", 50L);
            victims.damage(damage, (Entity)attacker);
        }
    }
    
    public static final void areaDamage(final LivingEntity attacker, final LivingEntity victims, final double damage) {
        if (attacker != null && victims != null) {
            MetadataUtil.setCooldown((Entity)victims, "Area_Damage", 50L);
            victims.damage(damage, (Entity)attacker);
        }
    }
    
    public static final void burn(final Entity entity, final int time) {
        if (entity != null) {
            entity.setFireTicks(time);
        }
    }
    
    public static final Projectile launchProjectile(final LivingEntity shooter, final ProjectileEnum projectile, final double speed) {
        return launchProjectile(shooter, projectile, speed, true, true);
    }
    
    public static final Projectile launchProjectile(final LivingEntity shooter, final ProjectileEnum projectile, final double speed, final boolean pickable, final boolean disappear) {
        if (shooter == null || projectile == null) {
            return null;
        }
        final Vector aim = shooter.getLocation().getDirection().multiply(speed);
        Projectile shoot;
        if (projectile.equals(ProjectileEnum.ARROW) || projectile.equals(ProjectileEnum.FLAME_ARROW)) {
            shoot = shooter.launchProjectile((Class)Arrow.class);
            if (projectile.equals(ProjectileEnum.FLAME_ARROW)) {
                burn((Entity)shoot, 100000);
            }
        }
        else if (projectile.equals(ProjectileEnum.SNOWBALL) || projectile.equals(ProjectileEnum.FLAME_BALL)) {
            shoot = shooter.launchProjectile((Class)Snowball.class);
            if (projectile.equals(ProjectileEnum.FLAME_BALL)) {
                burn((Entity)shoot, 100000);
            }
        }
        else if (projectile.equals(ProjectileEnum.EGG) || projectile.equals(ProjectileEnum.FLAME_EGG)) {
            shoot = shooter.launchProjectile((Class)Egg.class);
            if (projectile.equals(ProjectileEnum.FLAME_EGG)) {
                burn((Entity)shoot, 100000);
            }
        }
        else if (projectile.equals(ProjectileEnum.SMALL_FIREBALL)) {
            shoot = shooter.launchProjectile((Class)SmallFireball.class);
        }
        else if (projectile.equals(ProjectileEnum.LARGE_FIREBALL)) {
            shoot = shooter.launchProjectile((Class)Fireball.class);
        }
        else {
            if (!projectile.equals(ProjectileEnum.WITHER_SKULL)) {
                return null;
            }
            shoot = shooter.launchProjectile((Class)WitherSkull.class);
        }
        ProjectileUtil.setPickable((Entity)shoot, pickable);
        ProjectileUtil.setDisappear((Entity)shoot, disappear);
        shoot.setVelocity(aim);
        return shoot;
    }
    
    public static final void applyPotion(final Entity entity, final PotionEffectType potion, final int duration, final int grade) {
        if (entity != null && Bridge.getBridgeLivingEntity().isLivingEntity(entity)) {
            final LivingEntity living = (LivingEntity)entity;
            applyPotion(living, potion, duration, grade);
        }
    }
    
    public static final void applyPotion(final LivingEntity entity, final PotionEffectType potion, final int duration, final int grade) {
        applyPotion(entity, potion, duration, grade, false, false);
    }
    
    public static final void applyPotion(final LivingEntity entity, final PotionEffectType potion, final int duration, final int grade, final boolean ambient, final boolean particles) {
        if (entity != null && potion != null) {
            final PotionEffect effect = PotionUtil.createPotion(potion, duration, grade, ambient, particles);
            entity.addPotionEffect(effect);
        }
    }
    
    public static final boolean isSkillDamage(final LivingEntity victims) {
        return victims != null && !MetadataUtil.isExpired((Entity)victims, "Skill_Damage");
    }
    
    public static final boolean hasMetadataSkillDamage(final Entity entity) {
        return entity != null && MetadataUtil.hasMetadata(entity, "Skill_Damage");
    }
    
    public static final void removeMetadataSkillDamage(final Entity entity) {
        if (entity != null) {
            MetadataUtil.removeMetadata(entity, "Skill_Damage");
        }
    }
    
    public static final boolean isAreaDamage(final LivingEntity victims) {
        return victims != null && !MetadataUtil.isExpired((Entity)victims, "Area_Damage");
    }
    
    public static final boolean hasMetadataAreaDamage(final Entity entity) {
        return entity != null && MetadataUtil.hasMetadata(entity, "Area_Damage");
    }
    
    public static final void removeMetadataAreaDamage(final Entity entity) {
        if (entity != null) {
            MetadataUtil.removeMetadata(entity, "Area_Damage");
        }
    }
    
    public static final boolean hasMetadataInstantDamage(final Entity entity) {
        return entity != null && MetadataUtil.hasMetadata(entity, "Instant_Damage");
    }
    
    public static final void removeMetadataInstantDamage(final Entity entity) {
        if (entity != null) {
            MetadataUtil.removeMetadata(entity, "Instant_Damage");
        }
    }
    
    public static final boolean isNormalDamage(final LivingEntity victims) {
        return !isAreaDamage(victims) && !isSkillDamage(victims);
    }
}
