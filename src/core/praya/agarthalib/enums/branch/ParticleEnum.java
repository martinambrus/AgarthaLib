// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.enums.branch;

import org.bukkit.Color;
import java.util.Iterator;
import org.bukkit.Particle;
import org.bukkit.inventory.ItemStack;
import java.util.Arrays;
import java.util.List;

public enum ParticleEnum
{
    BARRIER("barrier", "barrier", Arrays.asList("Barricade")), 
    BLOCK_CRACK("block", "blockcrack", Arrays.asList("Crack_Block", "CrackBlock"), (Class<?>)MaterialEnum.class), 
    BLOCK_DUST("block", "blockdust", Arrays.asList("Dust_Block", "DustBlock"), (Class<?>)MaterialEnum.class), 
    BUBBLE_COLUMN_UP("bubble_column_up", (String)null, "WATER_BUBBLE", Arrays.asList("Bubble_Column", "BubbleColumn")), 
    BUBBLE_POP("bubble_pop", (String)null, "WATER_BUBBLE", Arrays.asList("BubblePop")), 
    CLOUD("cloud", "cloud", Arrays.asList("Fog", "Mist")), 
    CRIT("crit", "crit", Arrays.asList("Critical")), 
    CRIT_MAGIC("enchanted_hit", "magicCrit", Arrays.asList("Critical_Magic", "CriticalMagic", "Magic_Critical", "MagicCritical")), 
    CURRENT_DOWN("current_down", (String)null, "WATER_BUBBLE", Arrays.asList("Current", "Stream", "Wirlpool", "Vortex")), 
    DAMAGE_INDICATOR("damage_indicator", (String)null, "HEART", Arrays.asList("Damage", "Indicator")), 
    DOLPHIN("dolphin", (String)null, "WATER_DROP", Arrays.asList("Dolphin_Trails", "DolphinTrails", "Beluga")), 
    DRAGON_BREATH("dragon_breath", (String)null, "FLAME", Arrays.asList("DragonBreath", "Fire_Breath", "FireBreath")), 
    DRIP_LAVA("dripping_lava", "dripLava", Arrays.asList("Lava_Drip", "LavaDrip")), 
    DRIP_WATER("dripping_water", "dripWater", Arrays.asList("Water_Drip", "WaterDrip")), 
    ENCHANTMENT_TABLE("enchant", "enchantmenttable", Arrays.asList("Enchantment", "Rune")), 
    END_ROD("end_rod", (String)null, "FIREWORKS_SPARK", Arrays.asList("EndRod")), 
    EXPLOSION_HUGE("explosion_emitter", "hugeexplosion", Arrays.asList("ExplosionHuge")), 
    EXPLOSION_LARGE("explosion", "largeexplode", Arrays.asList("ExplosionLarge")), 
    EXPLOSION_NORMAL("poof", "explode", Arrays.asList("ExplosionNormal", "Explosion")), 
    FALLING_DUST("falling_dust", (String)null, "BLOCK_DUST", Arrays.asList("FallingDust"), (Class<?>)MaterialEnum.class), 
    FIREWORKS_SPARK("firework", "fireworksSpark", Arrays.asList("Spark")), 
    FLAME("flame", "flame", Arrays.asList("Fire")), 
    FOOTSTEP("cloud", "footstep", Arrays.asList("Step")), 
    HEART("heart", "heart", Arrays.asList("Love")), 
    ITEM_CRACK("item", "iconcrack", Arrays.asList("ItemCrack"), (Class<?>)ItemStack.class), 
    ITEM_TAKE("item", "take", Arrays.asList("ItemTake")), 
    LAVA("lava", "lava", Arrays.asList("Magma")), 
    MOB_APPEARANCE("elder_guardian", "mobappearance", Arrays.asList("Guardian", "Mob")), 
    NAUTILUS("nautilus", (String)null, Arrays.asList("Shell")), 
    NOTE("note", "note", Arrays.asList("Record", "Tone")), 
    PORTAL("portal", "portal", Arrays.asList("Gate")), 
    REDSTONE("dust", "reddust", Arrays.asList("Red_Stone", "RedDust"), (Class<?>)DustOptions.class), 
    SLIME("item_slime", "slime", Arrays.asList("Mucus", "Sludge")), 
    SMOKE_LARGE("large_smoke", "largesmoke", Arrays.asList("SmokeLarge")), 
    SMOKE_NORMAL("smoke", "smoke", Arrays.asList("SmokeNormal")), 
    SNOW_SHOVEL("item_snowball", "snowshovel", Arrays.asList("Shovel_Snow", "ShovelSnow")), 
    SNOWBALL("item_snowball", "snowballpoof", Arrays.asList("Snow_Ball")), 
    SPELL("effect", "spell", Arrays.asList("Magic", "Incantation")), 
    SPELL_INSTANT("instant_effect", "instantSpell", Arrays.asList("SpellInstant")), 
    SPELL_MOB("entity_effect", "mobSpell", Arrays.asList("SpellMob")), 
    SPELL_MOB_AMBIENT("ambient_entity_effect", "mobSpellAmbient", Arrays.asList("SpellMobAmbient")), 
    SPELL_WITCH("witch", "witchMagic", Arrays.asList("SpellWitch")), 
    SPIT("spit", (String)null, Arrays.asList("Sputter")), 
    SQUID_INK("squid_ink", (String)null, Arrays.asList("SquidInk", "Ink")), 
    SUSPENDED("underwater", "suspended", Arrays.asList("Suspend")), 
    SUSPENDED_DEPTH("underwater", "depthsuspend", Arrays.asList("SuspendedDepth", "SuspendDepth")), 
    SWEEP_ATTACK("sweep_attack", (String)null, Arrays.asList("SweepAttack", "Sweep")), 
    TOTEM("totem_of_undying", (String)null, Arrays.asList("Emblem")), 
    TOWN_AURA("mycelium", "townaura", Arrays.asList("Aura")), 
    VILLAGER_ANGRY("angry_villager", "angryVillager", Arrays.asList("VillagerAngry", "Angry_Villager")), 
    VILLAGER_HAPPY("happy_villager", "happyVillager", Arrays.asList("VillagerHappy", "Happy_Villager")), 
    WATER_BUBBLE("bubble", "bubble", Arrays.asList("WaterBubble")), 
    WATER_DROP("rain", "droplet", Arrays.asList("WaterDrop", "Water_Droplet", "WaterDroplet")), 
    WATER_SPLASH("splash", "splash", Arrays.asList("WaterSplash")), 
    WATER_WAKE("fishing", "wake", Arrays.asList("WaterWake"));
    
    private final String minecraftKey;
    private final String nameLegacy;
    private final String replacement;
    private final List<String> aliases;
    private final Class<?> dataType;
    
    private ParticleEnum(final String minecraftKey, final String nameLegacy, final List<String> aliases) {
        this(minecraftKey, nameLegacy, aliases, Void.class);
    }
    
    private ParticleEnum(final String minecraftKey, final String nameLegacy, final List<String> aliases, final Class<?> dataType) {
        this(minecraftKey, nameLegacy, null, aliases, dataType);
    }
    
    private ParticleEnum(final String minecraftKey, final String nameLegacy, final String replacement, final List<String> aliases) {
        this(minecraftKey, nameLegacy, replacement, aliases, Void.class);
    }
    
    private ParticleEnum(final String minecraftKey, final String nameLegacy, final String replacement, final List<String> aliases, final Class<?> dataType) {
        this.minecraftKey = minecraftKey;
        this.nameLegacy = nameLegacy;
        this.replacement = replacement;
        this.aliases = aliases;
        this.dataType = dataType;
    }
    
    public final String getMinecraftKey() {
        return this.minecraftKey;
    }
    
    public final String getNameLegacy() {
        return this.nameLegacy;
    }
    
    public final String getReplacement() {
        return this.replacement;
    }
    
    public final List<String> getAliases() {
        return this.aliases;
    }
    
    public final Class<?> getDataType() {
        return this.dataType;
    }
    
    public final Particle getParticle() {
        final String name = this.toString();
        Particle[] values;
        for (int length = (values = Particle.values()).length, i = 0; i < length; ++i) {
            final Particle particle = values[i];
            if (particle.toString().equalsIgnoreCase(name)) {
                return particle;
            }
        }
        final String replacement = this.getReplacement();
        if (replacement != null) {
            final ParticleEnum replacementEnum = getParticleEnum(replacement);
            if (replacementEnum != null) {
                final String replacementName = replacementEnum.toString();
                Particle[] values2;
                for (int length2 = (values2 = Particle.values()).length, j = 0; j < length2; ++j) {
                    final Particle particle2 = values2[j];
                    if (particle2.toString().equalsIgnoreCase(replacementName)) {
                        return particle2;
                    }
                }
            }
        }
        return null;
    }
    
    public static final ParticleEnum getParticleEnum(final String particle) {
        if (particle != null) {
            ParticleEnum[] values;
            for (int length = (values = values()).length, i = 0; i < length; ++i) {
                final ParticleEnum key = values[i];
                if (key.toString().equalsIgnoreCase(particle)) {
                    return key;
                }
            }
            ParticleEnum[] values2;
            for (int length2 = (values2 = values()).length, j = 0; j < length2; ++j) {
                final ParticleEnum key = values2[j];
                final String nameLegacy = key.getNameLegacy();
                if (nameLegacy != null && nameLegacy.equalsIgnoreCase(particle)) {
                    return key;
                }
            }
            ParticleEnum[] values3;
            for (int length3 = (values3 = values()).length, k = 0; k < length3; ++k) {
                final ParticleEnum key = values3[k];
                for (final String aliases : key.getAliases()) {
                    if (aliases.equalsIgnoreCase(particle)) {
                        return key;
                    }
                }
            }
        }
        return null;
    }
    
    public static final boolean isParticleEnumExists(final String particle) {
        return getParticleEnum(particle) != null;
    }
    
    @Deprecated
    public static final ParticleEnum getParticle(final String particle) {
        return getParticleEnum(particle);
    }
    
    @Deprecated
    public static final boolean isExists(final String particle) {
        return getParticle(particle) != null;
    }
    
    public static class DustOptions
    {
        private final Color color;
        private final float size;
        
        public DustOptions(final int red, final int green, final int blue, final float size) {
            this.color = Color.fromRGB(red, green, blue);
            this.size = size;
        }
        
        public final Color getColor() {
            return this.color;
        }
        
        public final float getSize() {
            return this.size;
        }
    }
}
