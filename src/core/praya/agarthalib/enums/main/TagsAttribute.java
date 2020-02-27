// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.enums.main;

import java.util.Iterator;
import java.util.Arrays;
import java.util.List;

public enum TagsAttribute
{
    HEALTH(TagsType.ALL, "generic.maxHealth", "Integer", 20.0, -10.0, 100.0, Arrays.asList("Max Health", "Max_Health", "MaxHealth", "Health")), 
    FOLLOW_RANGE(TagsType.ALL, "generic.followRange", "Double", 32.0, -2048.0, 2048.0, Arrays.asList("Follow Range", "Follow_Range", "FollowRange", "Follow", "Range")), 
    KNOCKBACK_RESISTANCE(TagsType.ALL, "generic.knockbackResistance", "Double", 0.0, -1.0, 1.0, Arrays.asList("Knockback Resistance", "Knockback_Resistance", "KnockbackResistance", "Knockback")), 
    SPEED(TagsType.ALL, "generic.movementSpeed", "Double", 0.1, -1024.0, 1024.0, Arrays.asList("Movement Speed", "Movement_Speed", "MovementSpeed", "Movement", "Speed", "Move")), 
    ATTACK_DAMAGE(TagsType.ALL, "generic.attackDamage", "Integer", 2.0, -2048.0, 2048.0, Arrays.asList("Attack Damage", "Attack_Damage", "AttackDamage", "Attack", "Damage")), 
    DEFENSE(TagsType.ALL, "generic.armor", "Integer", 0.0, -30.0, 30.0, Arrays.asList("Defense", "Armor", "Armour")), 
    SHIELD(TagsType.ALL, "generic.armorToughness", "Integer", 0.0, -20.0, 20.0, Arrays.asList("Armor Toughness", "Armor_Toughness", "ArmorToughness", "Shield")), 
    ATTACK_RATE(TagsType.ALL, "generic.attackSpeed", "Double", 4.0, -1024.0, 1024.0, Arrays.asList("Attack Rate", "Attack_Rate", "AttackRate", "Attack Speed", "Attack_Speed", "AttackSpeed")), 
    LUCK(TagsType.ALL, "generic.luck", "Integer", 0.0, -1024.0, 1024.0, Arrays.asList("Luck", "Luckily", "Fortune", "Loot")), 
    HORSE_JUMP(TagsType.HORSE, "horse.jumpStrength", "Double", 0.7, -2.0, 2.0, Arrays.asList("Horse Jump", "Horse_Jump", "HorseJump", "Horse")), 
    FLYING_SPEED(TagsType.PARROT, "generic.flyingSpeed", "Double", 0.4, -1024.0, 1024.0, Arrays.asList("Flying Speed", "Flying_Speed", "FlyingSpeed", "Flying")), 
    ZOMBIE_REINFORCEMENT(TagsType.ZOMBIE, "zombie.spawnReinforcements", "Double", 0.0, -1.0, 1.0, Arrays.asList("Zombie Reinforcement", "Zombie_Reinforcement", "ZombieReinforcement", "Reinforcement"));
    
    private final TagsType typeTags;
    private final String name;
    private String typeValue;
    private List<String> aliases;
    private double defaultValue;
    private double minValue;
    private double maxValue;
    
    private TagsAttribute(final TagsType typeTags, final String name, final String typeValue, final double defaultValue, final double minValue, final double maxValue, final List<String> aliases) {
        this.typeTags = typeTags;
        this.name = name;
        this.typeValue = typeValue;
        this.aliases = aliases;
        this.defaultValue = defaultValue;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
    
    public final TagsType getTagsType() {
        return this.typeTags;
    }
    
    public final String getName() {
        return this.name;
    }
    
    public final String getValueType() {
        return this.typeValue;
    }
    
    public final List<String> getAliases() {
        return this.aliases;
    }
    
    public final double getDefaultValue() {
        return this.defaultValue;
    }
    
    public final double getMinValue() {
        return this.minValue;
    }
    
    public final double getMaxValue() {
        return this.maxValue;
    }
    
    public static final TagsAttribute getTagsAttribute(final String tags) {
        if (tags != null) {
            TagsAttribute[] values;
            for (int length = (values = values()).length, i = 0; i < length; ++i) {
                final TagsAttribute key = values[i];
                for (final String aliases : key.getAliases()) {
                    if (aliases.equalsIgnoreCase(tags)) {
                        return key;
                    }
                }
            }
        }
        return null;
    }
    
    public static final boolean isTagsAttributeExists(final String tags) {
        return getTagsAttribute(tags) != null;
    }
    
    @Deprecated
    public static final TagsAttribute get(final String tags) {
        return getTagsAttribute(tags);
    }
    
    @Deprecated
    public final String getType() {
        return this.getValueType();
    }
}
