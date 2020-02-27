// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.enums.branch;

import java.util.Iterator;
import java.util.Arrays;
import java.util.List;

public enum ProjectileEnum
{
    ARROW(Arrays.asList("Arrow")), 
    SNOWBALL(Arrays.asList("Snowball", "Ball")), 
    EGG(Arrays.asList("Egg")), 
    FLAME_ARROW(Arrays.asList("Flame Arrow", "Flame_Arrow", "FlameArrow", "FireArrow", "Fire_Arrow")), 
    FLAME_BALL(Arrays.asList("Flame Ball", "Flame_Ball", "FlameBall")), 
    FLAME_EGG(Arrays.asList("Flame Egg", "Flame_Egg", "FlameEgg", "FireEgg", "Fire_Egg")), 
    SMALL_FIREBALL(Arrays.asList("Small Fireball", "Small_Fireball", "SmallFireball", "Fireball", "Fire_Ball")), 
    LARGE_FIREBALL(Arrays.asList("Large Fireball", "Large_Fireball", "LargeFireball")), 
    WITHER_SKULL(Arrays.asList("Wither Skull", "WitherSkull", "Wither_Skull", "Wither"));
    
    private final List<String> aliases;
    
    private ProjectileEnum(final List<String> aliases) {
        this.aliases = aliases;
    }
    
    public final List<String> getAliases() {
        return this.aliases;
    }
    
    public static final ProjectileEnum getProjectileEnum(final String projectile) {
        if (projectile != null) {
            ProjectileEnum[] values;
            for (int length = (values = values()).length, i = 0; i < length; ++i) {
                final ProjectileEnum key = values[i];
                for (final String aliases : key.getAliases()) {
                    if (aliases.equalsIgnoreCase(projectile)) {
                        return key;
                    }
                }
            }
        }
        return null;
    }
    
    public static final boolean isProjectileEnumExists(final String projectile) {
        return getProjectileEnum(projectile) != null;
    }
    
    @Deprecated
    public static final ProjectileEnum get(final String projectile) {
        return getProjectileEnum(projectile);
    }
}
