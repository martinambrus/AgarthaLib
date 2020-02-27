// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.packet.sounds;

import java.util.Iterator;
import org.bukkit.Sound;
import core.praya.agarthalib.enums.branch.SoundEnum;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import java.util.Collection;
import com.praya.agarthalib.AgarthaLib;
import core.praya.agarthalib.builder.bridge.SoundTools;
import com.praya.agarthalib.handler.HandlerPacket;

public class PacketSounds_1_7 extends HandlerPacket implements SoundTools
{
    public PacketSounds_1_7(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @Override
    public void playSoundEffect(final Collection<Player> players, final Location loc, final SoundEnum sound, final float volume, final float pitch) {
        if (players != null && loc != null && sound != null) {
            Sound soundEnum = null;
            try {
                switch (sound) {
                    case AMBIENT_CAVE: {
                        soundEnum = Sound.valueOf("AMBIENCE_CAVE");
                        break;
                    }
                    case BLOCK_ANVIL_BREAK: {
                        soundEnum = Sound.valueOf("ANVIL_BREAK");
                        break;
                    }
                    case BLOCK_ANVIL_DESTROY: {
                        soundEnum = Sound.valueOf("ANVIL_BREAK");
                        break;
                    }
                    case BLOCK_ANVIL_FALL: {
                        soundEnum = Sound.valueOf("ANVIL_LAND");
                        break;
                    }
                    case BLOCK_ANVIL_HIT: {
                        soundEnum = Sound.valueOf("ANVIL_LAND");
                        break;
                    }
                    case BLOCK_ANVIL_LAND: {
                        soundEnum = Sound.valueOf("ANVIL_LAND");
                        break;
                    }
                    case BLOCK_ANVIL_PLACE: {
                        soundEnum = Sound.valueOf("ANVIL_LAND");
                        break;
                    }
                    case BLOCK_ANVIL_STEP: {
                        soundEnum = Sound.valueOf("ANVIL_LAND");
                        break;
                    }
                    case BLOCK_ANVIL_USE: {
                        soundEnum = Sound.valueOf("ANVIL_USE");
                        break;
                    }
                    case BLOCK_CHEST_CLOSE: {
                        soundEnum = Sound.valueOf("CHEST_CLOSE");
                        break;
                    }
                    case BLOCK_CHEST_LOCKED: {
                        soundEnum = Sound.valueOf("CHEST_CLOSE");
                        break;
                    }
                    case BLOCK_CHEST_OPEN: {
                        soundEnum = Sound.valueOf("CHEST_OPEN");
                        break;
                    }
                    case BLOCK_COMPARATOR_CLICK: {
                        soundEnum = Sound.valueOf("CLICK");
                        break;
                    }
                    case BLOCK_ENDERCHEST_CLOSE: {
                        soundEnum = Sound.valueOf("CHEST_CLOSE");
                        break;
                    }
                    case BLOCK_ENDERCHEST_OPEN: {
                        soundEnum = Sound.valueOf("CHEST_OPEN");
                        break;
                    }
                    case BLOCK_FIRE_AMBIENT: {
                        soundEnum = Sound.valueOf("FIRE");
                        break;
                    }
                    case BLOCK_GLASS_BREAK: {
                        soundEnum = Sound.valueOf("GLASS");
                        break;
                    }
                    case BLOCK_GLASS_FALL: {
                        soundEnum = Sound.valueOf("GLASS");
                        break;
                    }
                    case BLOCK_GLASS_HIT: {
                        soundEnum = Sound.valueOf("GLASS");
                        break;
                    }
                    case BLOCK_GLASS_PLACE: {
                        soundEnum = Sound.valueOf("GLASS");
                        break;
                    }
                    case BLOCK_GLASS_STEP: {
                        soundEnum = Sound.valueOf("GLASS");
                        break;
                    }
                    case BLOCK_GRASS_BREAK: {
                        soundEnum = Sound.valueOf("DIG_GRASS");
                        break;
                    }
                    case BLOCK_GRASS_FALL: {
                        soundEnum = Sound.valueOf("DIG_GRASS");
                        break;
                    }
                    case BLOCK_GRASS_HIT: {
                        soundEnum = Sound.valueOf("DIG_GRASS");
                        break;
                    }
                    case BLOCK_GRASS_PLACE: {
                        soundEnum = Sound.valueOf("DIG_GRASS");
                        break;
                    }
                    case BLOCK_GRASS_STEP: {
                        soundEnum = Sound.valueOf("STEP_GRASS");
                        break;
                    }
                    case BLOCK_GRAVEL_BREAK: {
                        soundEnum = Sound.valueOf("DIG_GRAVEL");
                        break;
                    }
                    case BLOCK_GRAVEL_FALL: {
                        soundEnum = Sound.valueOf("DIG_GRAVEL");
                        break;
                    }
                    case BLOCK_GRAVEL_HIT: {
                        soundEnum = Sound.valueOf("DIG_GRAVEL");
                        break;
                    }
                    case BLOCK_GRAVEL_PLACE: {
                        soundEnum = Sound.valueOf("DIG_GRAVEL");
                        break;
                    }
                    case BLOCK_GRAVEL_STEP: {
                        soundEnum = Sound.valueOf("STEP_GRAVEL");
                        break;
                    }
                    case BLOCK_IRON_DOOR_CLOSE: {
                        soundEnum = Sound.valueOf("DOOR_CLOSE");
                        break;
                    }
                    case BLOCK_IRON_DOOR_OPEN: {
                        soundEnum = Sound.valueOf("DOOR_OPEN");
                        break;
                    }
                    case BLOCK_IRON_TRAPDOOR_CLOSE: {
                        soundEnum = Sound.valueOf("DOOR_CLOSE");
                        break;
                    }
                    case BLOCK_IRON_TRAPDOOR_OPEN: {
                        soundEnum = Sound.valueOf("DOOR_OPEN");
                        break;
                    }
                    case BLOCK_LADDER_BREAK: {
                        soundEnum = Sound.valueOf("ITEM_BREAK");
                        break;
                    }
                    case BLOCK_LADDER_STEP: {
                        soundEnum = Sound.valueOf("STEP_LADDER");
                        break;
                    }
                    case BLOCK_LAVA_AMBIENT: {
                        soundEnum = Sound.valueOf("LAVA");
                        break;
                    }
                    case BLOCK_LAVA_POP: {
                        soundEnum = Sound.valueOf("LAVA_POP");
                        break;
                    }
                    case BLOCK_LEVER_CLICK: {
                        soundEnum = Sound.valueOf("CLICK");
                        break;
                    }
                    case BLOCK_METAL_PRESSUREPLATE_CLICK_OFF: {
                        soundEnum = Sound.valueOf("CLICK");
                        break;
                    }
                    case BLOCK_METAL_PRESSUREPLATE_CLICK_ON: {
                        soundEnum = Sound.valueOf("CLICK");
                        break;
                    }
                    case BLOCK_NOTE_BASEDRUM: {
                        soundEnum = Sound.valueOf("NOTE_BASS_DRUM");
                        break;
                    }
                    case BLOCK_NOTE_BASS: {
                        soundEnum = Sound.valueOf("NOTE_BASS");
                        break;
                    }
                    case BLOCK_NOTE_HARP: {
                        soundEnum = Sound.valueOf("NOTE_BASS_GUITAR");
                        break;
                    }
                    case BLOCK_NOTE_HAT: {
                        soundEnum = Sound.valueOf("NOTE_STICKS");
                        break;
                    }
                    case BLOCK_NOTE_PLING: {
                        soundEnum = Sound.valueOf("NOTE_PLING");
                        break;
                    }
                    case BLOCK_NOTE_SNARE: {
                        soundEnum = Sound.valueOf("NOTE_SNARE_DRUM");
                        break;
                    }
                    case BLOCK_PISTON_CONTRACT: {
                        soundEnum = Sound.valueOf("PISTON_RETRACT");
                        break;
                    }
                    case BLOCK_PISTON_EXTEND: {
                        soundEnum = Sound.valueOf("PISTON_EXTEND");
                        break;
                    }
                    case BLOCK_PORTAL_AMBIENT: {
                        soundEnum = Sound.valueOf("PORTAL");
                        break;
                    }
                    case BLOCK_PORTAL_TRAVEL: {
                        soundEnum = Sound.valueOf("PORTAL_TRAVEL");
                        break;
                    }
                    case BLOCK_PORTAL_TRIGGER: {
                        soundEnum = Sound.valueOf("PORTAL_TRIGGER");
                        break;
                    }
                    case BLOCK_SAND_BREAK: {
                        soundEnum = Sound.valueOf("DIG_SAND");
                        break;
                    }
                    case BLOCK_SAND_FALL: {
                        soundEnum = Sound.valueOf("DIG_SAND");
                        break;
                    }
                    case BLOCK_SAND_HIT: {
                        soundEnum = Sound.valueOf("DIG_SAND");
                        break;
                    }
                    case BLOCK_SAND_PLACE: {
                        soundEnum = Sound.valueOf("DIG_SAND");
                        break;
                    }
                    case BLOCK_SAND_STEP: {
                        soundEnum = Sound.valueOf("STEP_SAND");
                        break;
                    }
                    case BLOCK_SNOW_BREAK: {
                        soundEnum = Sound.valueOf("DIG_SNOW");
                        break;
                    }
                    case BLOCK_SNOW_FALL: {
                        soundEnum = Sound.valueOf("DIG_SNOW");
                        break;
                    }
                    case BLOCK_SNOW_HIT: {
                        soundEnum = Sound.valueOf("DIG_SNOW");
                        break;
                    }
                    case BLOCK_SNOW_PLACE: {
                        soundEnum = Sound.valueOf("DIG_SNOW");
                        break;
                    }
                    case BLOCK_SNOW_STEP: {
                        soundEnum = Sound.valueOf("STEP_SNOW");
                        break;
                    }
                    case BLOCK_STONE_BUTTON_CLICK_OFF: {
                        soundEnum = Sound.valueOf("CLICK");
                        break;
                    }
                    case BLOCK_STONE_BUTTON_CLICK_ON: {
                        soundEnum = Sound.valueOf("CLICK");
                        break;
                    }
                    case BLOCK_STONE_FALL: {
                        soundEnum = Sound.valueOf("DIG_STONE");
                        break;
                    }
                    case BLOCK_STONE_HIT: {
                        soundEnum = Sound.valueOf("DIG_STONE");
                        break;
                    }
                    case BLOCK_STONE_PLACE: {
                        soundEnum = Sound.valueOf("DIG_STONE");
                        break;
                    }
                    case BLOCK_STONE_PRESSUREPLATE_CLICK_OFF: {
                        soundEnum = Sound.valueOf("CLICK");
                        break;
                    }
                    case BLOCK_STONE_PRESSUREPLATE_CLICK_ON: {
                        soundEnum = Sound.valueOf("CLICK");
                        break;
                    }
                    case BLOCK_STONE_STEP: {
                        soundEnum = Sound.valueOf("STEP_STONE");
                        break;
                    }
                    case BLOCK_TRIPWIRE_CLICK_OFF: {
                        soundEnum = Sound.valueOf("CLICK");
                        break;
                    }
                    case BLOCK_TRIPWIRE_CLICK_ON: {
                        soundEnum = Sound.valueOf("CLICK");
                        break;
                    }
                    case BLOCK_WATER_AMBIENT: {
                        soundEnum = Sound.valueOf("WATER");
                        break;
                    }
                    case BLOCK_WOOD_BREAK: {
                        soundEnum = Sound.valueOf("ZOMBIE_WOODBREAK");
                        break;
                    }
                    case BLOCK_WOOD_BUTTON_CLICK_OFF: {
                        soundEnum = Sound.valueOf("WOOD_CLICK");
                        break;
                    }
                    case BLOCK_WOOD_BUTTON_CLICK_ON: {
                        soundEnum = Sound.valueOf("WOOD_CLICK");
                        break;
                    }
                    case BLOCK_WOOD_FALL: {
                        soundEnum = Sound.valueOf("DIG_WOOD");
                        break;
                    }
                    case BLOCK_WOOD_HIT: {
                        soundEnum = Sound.valueOf("DIG_WOOD");
                        break;
                    }
                    case BLOCK_WOOD_PLACE: {
                        soundEnum = Sound.valueOf("DIG_WOOD");
                        break;
                    }
                    case BLOCK_WOOD_PRESSUREPLATE_CLICK_OFF: {
                        soundEnum = Sound.valueOf("CLICK");
                        break;
                    }
                    case BLOCK_WOOD_PRESSUREPLATE_CLICK_ON: {
                        soundEnum = Sound.valueOf("CLICK");
                        break;
                    }
                    case BLOCK_WOOD_STEP: {
                        soundEnum = Sound.valueOf("STEP_WOOD");
                        break;
                    }
                    case BLOCK_WOODEN_DOOR_CLOSE: {
                        soundEnum = Sound.valueOf("DOOR_CLOSE");
                        break;
                    }
                    case BLOCK_WOODEN_DOOR_OPEN: {
                        soundEnum = Sound.valueOf("DOOR_OPEN");
                        break;
                    }
                    case BLOCK_WOODEN_TRAPDOOR_CLOSE: {
                        soundEnum = Sound.valueOf("DOOR_CLOSE");
                        break;
                    }
                    case BLOCK_WOODEN_TRAPDOOR_OPEN: {
                        soundEnum = Sound.valueOf("DOOR_OPEN");
                        break;
                    }
                    case ENTITY_ARMORSTAND_BREAK: {
                        soundEnum = Sound.valueOf("ITEM_BREAK");
                        break;
                    }
                    case ENTITY_ARMORSTAND_FALL: {
                        soundEnum = Sound.valueOf("ITEM_BREAK");
                        break;
                    }
                    case ENTITY_ARMORSTAND_HIT: {
                        soundEnum = Sound.valueOf("ITEM_BREAK");
                        break;
                    }
                    case ENTITY_ARMORSTAND_PLACE: {
                        soundEnum = Sound.valueOf("ITEM_BREAK");
                        break;
                    }
                    case ENTITY_ARROW_HIT: {
                        soundEnum = Sound.valueOf("ARROW_HIT");
                        break;
                    }
                    case ENTITY_ARROW_HIT_PLAYER: {
                        soundEnum = Sound.valueOf("ARROW_HIT");
                        break;
                    }
                    case ENTITY_ARROW_SHOOT: {
                        soundEnum = Sound.valueOf("SHOOT_ARROW");
                        break;
                    }
                    case ENTITY_BAT_AMBIENT: {
                        soundEnum = Sound.valueOf("BAT_IDLE");
                        break;
                    }
                    case ENTITY_BAT_DEATH: {
                        soundEnum = Sound.valueOf("BAT_DEATH");
                        break;
                    }
                    case ENTITY_BAT_HURT: {
                        soundEnum = Sound.valueOf("BAT_HURT");
                        break;
                    }
                    case ENTITY_BAT_LOOP: {
                        soundEnum = Sound.valueOf("BAT_LOOP");
                        break;
                    }
                    case ENTITY_BAT_TAKEOFF: {
                        soundEnum = Sound.valueOf("BAT_TAKEOFF");
                        break;
                    }
                    case ENTITY_BLAZE_AMBIENT: {
                        soundEnum = Sound.valueOf("BLAZE_BREATH");
                        break;
                    }
                    case ENTITY_BLAZE_BURN: {
                        soundEnum = Sound.valueOf("BLAZE_BREATH");
                        break;
                    }
                    case ENTITY_BLAZE_DEATH: {
                        soundEnum = Sound.valueOf("BLAZE_DEATH");
                        break;
                    }
                    case ENTITY_BLAZE_HURT: {
                        soundEnum = Sound.valueOf("BLAZE_HIT");
                        break;
                    }
                    case ENTITY_BLAZE_SHOOT: {
                        soundEnum = Sound.valueOf("BLAZE_BREATH");
                        break;
                    }
                    case ENTITY_CAT_AMBIENT: {
                        soundEnum = Sound.valueOf("CAT_MEOW");
                        break;
                    }
                    case ENTITY_CAT_DEATH: {
                        soundEnum = Sound.valueOf("CAT_HIT");
                        break;
                    }
                    case ENTITY_CAT_HISS: {
                        soundEnum = Sound.valueOf("CAT_HISS");
                        break;
                    }
                    case ENTITY_CAT_HURT: {
                        soundEnum = Sound.valueOf("CAT_HIT");
                        break;
                    }
                    case ENTITY_CAT_PURR: {
                        soundEnum = Sound.valueOf("CAT_PURR");
                        break;
                    }
                    case ENTITY_CAT_PURREOW: {
                        soundEnum = Sound.valueOf("CAT_PURREOW");
                        break;
                    }
                    case ENTITY_CHICKEN_AMBIENT: {
                        soundEnum = Sound.valueOf("CHICKEN_IDLE");
                        break;
                    }
                    case ENTITY_CHICKEN_DEATH: {
                        soundEnum = Sound.valueOf("CHICKEN_HURT");
                        break;
                    }
                    case ENTITY_CHICKEN_EGG: {
                        soundEnum = Sound.valueOf("CHICKEN_EGG_POP");
                        break;
                    }
                    case ENTITY_CHICKEN_HURT: {
                        soundEnum = Sound.valueOf("CHICKEN_HURT");
                        break;
                    }
                    case ENTITY_CHICKEN_STEP: {
                        soundEnum = Sound.valueOf("CHICKEN_WALK");
                        break;
                    }
                    case ENTITY_COW_AMBIENT: {
                        soundEnum = Sound.valueOf("COW_IDLE");
                        break;
                    }
                    case ENTITY_COW_DEATH: {
                        soundEnum = Sound.valueOf("COW_HURT");
                        break;
                    }
                    case ENTITY_COW_HURT: {
                        soundEnum = Sound.valueOf("COW_HURT");
                        break;
                    }
                    case ENTITY_COW_STEP: {
                        soundEnum = Sound.valueOf("COW_WALK");
                        break;
                    }
                    case ENTITY_CREEPER_DEATH: {
                        soundEnum = Sound.valueOf("CREEPER_DEATH");
                        break;
                    }
                    case ENTITY_CREEPER_HURT: {
                        soundEnum = Sound.valueOf("CREEPER_DEATH");
                        break;
                    }
                    case ENTITY_CREEPER_PRIMED: {
                        soundEnum = Sound.valueOf("CREEPER_HISS");
                        break;
                    }
                    case ENTITY_DONKEY_AMBIENT: {
                        soundEnum = Sound.valueOf("DONKEY_IDLE");
                        break;
                    }
                    case ENTITY_DONKEY_ANGRY: {
                        soundEnum = Sound.valueOf("DONKEY_ANGRY");
                        break;
                    }
                    case ENTITY_DONKEY_CHEST: {
                        soundEnum = Sound.valueOf("CHEST_OPEN");
                        break;
                    }
                    case ENTITY_DONKEY_DEATH: {
                        soundEnum = Sound.valueOf("DONKEY_DEATH");
                        break;
                    }
                    case ENTITY_DONKEY_HURT: {
                        soundEnum = Sound.valueOf("DONKEY_HIT");
                        break;
                    }
                    case ENTITY_ENDERDRAGON_DEATH: {
                        soundEnum = Sound.valueOf("ENDERDRAGON_DEATH");
                        break;
                    }
                    case ENTITY_ENDERDRAGON_FIREBALL_EXPLODE: {
                        soundEnum = Sound.valueOf("EXPLODE");
                        break;
                    }
                    case ENTITY_ENDERDRAGON_FLAP: {
                        soundEnum = Sound.valueOf("ENDERDRAGON_WINGS");
                        break;
                    }
                    case ENTITY_ENDERDRAGON_GROWL: {
                        soundEnum = Sound.valueOf("ENDERDRAGON_GROWL");
                        break;
                    }
                    case ENTITY_ENDERDRAGON_HURT: {
                        soundEnum = Sound.valueOf("ENDERDRAGON_HIT");
                        break;
                    }
                    case ENTITY_ENDERDRAGON_SHOOT: {
                        soundEnum = Sound.valueOf("WITHER_SHOOT");
                        break;
                    }
                    case ENTITY_ENDERMEN_AMBIENT: {
                        soundEnum = Sound.valueOf("ENDERMAN_IDLE");
                        break;
                    }
                    case ENTITY_ENDERMEN_DEATH: {
                        soundEnum = Sound.valueOf("ENDERMAN_DEATH");
                        break;
                    }
                    case ENTITY_ENDERMEN_HURT: {
                        soundEnum = Sound.valueOf("ENDERMAN_HIT");
                        break;
                    }
                    case ENTITY_ENDERMEN_SCREAM: {
                        soundEnum = Sound.valueOf("ENDERMAN_SCREAM");
                        break;
                    }
                    case ENTITY_ENDERMEN_STARE: {
                        soundEnum = Sound.valueOf("ENDERMAN_STARE");
                        break;
                    }
                    case ENTITY_ENDERMEN_TELEPORT: {
                        soundEnum = Sound.valueOf("ENDERMAN_TELEPORT");
                        break;
                    }
                    case ENTITY_EXPERIENCE_ORB_PICKUP: {
                        soundEnum = Sound.valueOf("ORB_PICKUP");
                        break;
                    }
                    case ENTITY_EXPERIENCE_ORB_TOUCH: {
                        soundEnum = Sound.valueOf("ORB_PICKUP");
                        break;
                    }
                    case ENTITY_FIREWORK_BLAST: {
                        soundEnum = Sound.valueOf("FIREWORK_BLAST");
                        break;
                    }
                    case ENTITY_FIREWORK_LARGE_BLAST: {
                        soundEnum = Sound.valueOf("FIREWORK_LARGE_BLAST");
                        break;
                    }
                    case ENTITY_FIREWORK_LARGE_BLAST_FAR: {
                        soundEnum = Sound.valueOf("FIREWORK_LARGE_BLAST2");
                        break;
                    }
                    case ENTITY_FIREWORK_LAUNCH: {
                        soundEnum = Sound.valueOf("FIREWORK_LAUNCH");
                        break;
                    }
                    case ENTITY_FIREWORK_SHOOT: {
                        soundEnum = Sound.valueOf("FIREWORK_LAUNCH");
                        break;
                    }
                    case ENTITY_FIREWORK_TWINKLE: {
                        soundEnum = Sound.valueOf("FIREWORK_TWINKLE");
                        break;
                    }
                    case ENTITY_FIREWORK_TWINKLE_FAR: {
                        soundEnum = Sound.valueOf("FIREWORK_TWINKLE2");
                        break;
                    }
                    case ENTITY_GENERIC_BIG_FALL: {
                        soundEnum = Sound.valueOf("FALL_BIG");
                        break;
                    }
                    case ENTITY_GENERIC_DRINK: {
                        soundEnum = Sound.valueOf("DRINK");
                        break;
                    }
                    case ENTITY_GENERIC_EAT: {
                        soundEnum = Sound.valueOf("EAT");
                        break;
                    }
                    case ENTITY_GENERIC_EXPLODE: {
                        soundEnum = Sound.valueOf("EXPLODE");
                        break;
                    }
                    case ENTITY_GENERIC_HURT: {
                        soundEnum = Sound.valueOf("HURT_FLESH");
                        break;
                    }
                    case ENTITY_GENERIC_SMALL_FALL: {
                        soundEnum = Sound.valueOf("FALL_SMALL");
                        break;
                    }
                    case ENTITY_GENERIC_SPLASH: {
                        soundEnum = Sound.valueOf("SPLASH");
                        break;
                    }
                    case ENTITY_GENERIC_SWIM: {
                        soundEnum = Sound.valueOf("SWIM");
                        break;
                    }
                    case ENTITY_GHAST_AMBIENT: {
                        soundEnum = Sound.valueOf("GHAST_MOAN");
                        break;
                    }
                    case ENTITY_GHAST_DEATH: {
                        soundEnum = Sound.valueOf("GHAST_DEATH");
                        break;
                    }
                    case ENTITY_GHAST_HURT: {
                        soundEnum = Sound.valueOf("GHAST_DEATH");
                        break;
                    }
                    case ENTITY_GHAST_SCREAM: {
                        soundEnum = Sound.valueOf("GHAST_SCREAM");
                        break;
                    }
                    case ENTITY_GHAST_SHOOT: {
                        soundEnum = Sound.valueOf("GHAST_FIREBALL");
                        break;
                    }
                    case ENTITY_GHAST_WARN: {
                        soundEnum = Sound.valueOf("GHAST_SCREAM2");
                        break;
                    }
                    case ENTITY_HORSE_AMBIENT: {
                        soundEnum = Sound.valueOf("HORSE_IDLE");
                        break;
                    }
                    case ENTITY_HORSE_ANGRY: {
                        soundEnum = Sound.valueOf("HORSE_ANGRY");
                        break;
                    }
                    case ENTITY_HORSE_ARMOR: {
                        soundEnum = Sound.valueOf("HORSE_ARMOR");
                        break;
                    }
                    case ENTITY_HORSE_BREATHE: {
                        soundEnum = Sound.valueOf("HORSE_BREATHE");
                        break;
                    }
                    case ENTITY_HORSE_DEATH: {
                        soundEnum = Sound.valueOf("HORSE_DEATH");
                        break;
                    }
                    case ENTITY_HORSE_GALLOP: {
                        soundEnum = Sound.valueOf("HORSE_GALLOP");
                        break;
                    }
                    case ENTITY_HORSE_HURT: {
                        soundEnum = Sound.valueOf("HORSE_HIT");
                        break;
                    }
                    case ENTITY_HORSE_JUMP: {
                        soundEnum = Sound.valueOf("HORSE_JUMP");
                        break;
                    }
                    case ENTITY_HORSE_LAND: {
                        soundEnum = Sound.valueOf("HORSE_LAND");
                        break;
                    }
                    case ENTITY_HORSE_SADDLE: {
                        soundEnum = Sound.valueOf("HORSE_SADDLE");
                        break;
                    }
                    case ENTITY_HOSTILE_BIG_FALL: {
                        soundEnum = Sound.valueOf("FALL_BIG");
                        break;
                    }
                    case ENTITY_IRONGOLEM_ATTACK: {
                        soundEnum = Sound.valueOf("IRONGOLEM_THROW");
                        break;
                    }
                    case ENTITY_IRONGOLEM_DEATH: {
                        soundEnum = Sound.valueOf("IRONGOLEM_DEATH");
                        break;
                    }
                    case ENTITY_IRONGOLEM_HURT: {
                        soundEnum = Sound.valueOf("IRONGOLEM_HIT");
                        break;
                    }
                    case ENTITY_IRONGOLEM_STEP: {
                        soundEnum = Sound.valueOf("IRONGOLEM_WALK");
                        break;
                    }
                    case ENTITY_ITEM_BREAK: {
                        soundEnum = Sound.valueOf("ITEM_BREAK");
                        break;
                    }
                    case ENTITY_ITEM_PICKUP: {
                        soundEnum = Sound.valueOf("ITEM_PICKUP");
                        break;
                    }
                    case ENTITY_LIGHTNING_IMPACT: {
                        soundEnum = Sound.valueOf("AMBIENCE_THUNDER");
                        break;
                    }
                    case ENTITY_LIGHTNING_THUNDER: {
                        soundEnum = Sound.valueOf("AMBIENCE_THUNDER");
                        break;
                    }
                    case ENTITY_MAGMACUBE_HURT: {
                        soundEnum = Sound.valueOf("HURT_FLESH");
                        break;
                    }
                    case ENTITY_MAGMACUBE_JUMP: {
                        soundEnum = Sound.valueOf("MAGMACUBE_JUMP");
                        break;
                    }
                    case ENTITY_MAGMACUBE_SQUISH: {
                        soundEnum = Sound.valueOf("MAGMACUBE_WALK");
                        break;
                    }
                    case ENTITY_MINECART_INSIDE: {
                        soundEnum = Sound.valueOf("MINECART_INSIDE");
                        break;
                    }
                    case ENTITY_MINECART_RIDING: {
                        soundEnum = Sound.valueOf("MINECART_BASE");
                        break;
                    }
                    case ENTITY_MOOSHROOM_SHEAR: {
                        soundEnum = Sound.valueOf("SHEEP_SHEAR");
                        break;
                    }
                    case ENTITY_PIG_AMBIENT: {
                        soundEnum = Sound.valueOf("PIG_IDLE");
                        break;
                    }
                    case ENTITY_PIG_DEATH: {
                        soundEnum = Sound.valueOf("PIG_DEATH");
                        break;
                    }
                    case ENTITY_PIG_SADDLE: {
                        soundEnum = Sound.valueOf("HORSE_SADDLE");
                        break;
                    }
                    case ENTITY_PIG_STEP: {
                        soundEnum = Sound.valueOf("PIG_WALK");
                        break;
                    }
                    case ENTITY_PLAYER_BIG_FALL: {
                        soundEnum = Sound.valueOf("FALL_BIG");
                        break;
                    }
                    case ENTITY_PLAYER_BURP: {
                        soundEnum = Sound.valueOf("BURP");
                        break;
                    }
                    case ENTITY_PLAYER_HURT: {
                        soundEnum = Sound.valueOf("HURT_FLESH");
                        break;
                    }
                    case ENTITY_PLAYER_LEVELUP: {
                        soundEnum = Sound.valueOf("LEVEL_UP");
                        break;
                    }
                    case ENTITY_PLAYER_SMALL_FALL: {
                        soundEnum = Sound.valueOf("FALL_SMALL");
                        break;
                    }
                    case ENTITY_PLAYER_SPLASH: {
                        soundEnum = Sound.valueOf("SPLASH2");
                        break;
                    }
                    case ENTITY_PLAYER_SWIM: {
                        soundEnum = Sound.valueOf("SWIM");
                        break;
                    }
                    case ENTITY_SHEEP_AMBIENT: {
                        soundEnum = Sound.valueOf("SHEEP_IDLE");
                        break;
                    }
                    case ENTITY_SHEEP_SHEAR: {
                        soundEnum = Sound.valueOf("SHEEP_SHEAR");
                        break;
                    }
                    case ENTITY_SHEEP_STEP: {
                        soundEnum = Sound.valueOf("SHEEP_WALK");
                        break;
                    }
                    case ENTITY_SILVERFISH_AMBIENT: {
                        soundEnum = Sound.valueOf("SILVERFISH_IDLE");
                        break;
                    }
                    case ENTITY_SILVERFISH_DEATH: {
                        soundEnum = Sound.valueOf("SILVERFISH_KILL");
                        break;
                    }
                    case ENTITY_SILVERFISH_HURT: {
                        soundEnum = Sound.valueOf("SILVERFISH_HIT");
                        break;
                    }
                    case ENTITY_SILVERFISH_STEP: {
                        soundEnum = Sound.valueOf("SILVERFISH_WALK");
                        break;
                    }
                    case ENTITY_SKELETON_AMBIENT: {
                        soundEnum = Sound.valueOf("SKELETON_IDLE");
                        break;
                    }
                    case ENTITY_SKELETON_DEATH: {
                        soundEnum = Sound.valueOf("SKELETON_DEATH");
                        break;
                    }
                    case ENTITY_SKELETON_HORSE_AMBIENT: {
                        soundEnum = Sound.valueOf("HORSE_SKELETON_IDLE");
                        break;
                    }
                    case ENTITY_SKELETON_HORSE_DEATH: {
                        soundEnum = Sound.valueOf("HORSE_SKELETON_DEATH");
                        break;
                    }
                    case ENTITY_SKELETON_HORSE_HURT: {
                        soundEnum = Sound.valueOf("HORSE_SKELETON_HIT");
                        break;
                    }
                    case ENTITY_SKELETON_HURT: {
                        soundEnum = Sound.valueOf("HORSE_SKELETON_HIT");
                        break;
                    }
                    case ENTITY_SKELETON_SHOOT: {
                        soundEnum = Sound.valueOf("SHOOT_ARROW");
                        break;
                    }
                    case ENTITY_SKELETON_STEP: {
                        soundEnum = Sound.valueOf("SKELETON_WALK");
                        break;
                    }
                    case ENTITY_SLIME_ATTACK: {
                        soundEnum = Sound.valueOf("SLIME_ATTACK");
                        break;
                    }
                    case ENTITY_SLIME_JUMP: {
                        soundEnum = Sound.valueOf("SLIME_WALK");
                        break;
                    }
                    case ENTITY_SMALL_MAGMACUBE_SQUISH: {
                        soundEnum = Sound.valueOf("MAGMACUBE_WALK2");
                        break;
                    }
                    case ENTITY_SMALL_SLIME_JUMP: {
                        soundEnum = Sound.valueOf("SLIME_WALK");
                        break;
                    }
                    case ENTITY_SMALL_SLIME_SQUISH: {
                        soundEnum = Sound.valueOf("SLIME_WALK2");
                        break;
                    }
                    case ENTITY_SPIDER_AMBIENT: {
                        soundEnum = Sound.valueOf("SPIDER_IDLE");
                        break;
                    }
                    case ENTITY_SPIDER_DEATH: {
                        soundEnum = Sound.valueOf("SPIDER_DEATH");
                        break;
                    }
                    case ENTITY_SPIDER_STEP: {
                        soundEnum = Sound.valueOf("SPIDER_WALK");
                        break;
                    }
                    case ENTITY_SPLASH_POTION_BREAK: {
                        soundEnum = Sound.valueOf("SPLASH");
                        break;
                    }
                    case ENTITY_SPLASH_POTION_THROW: {
                        soundEnum = Sound.valueOf("SPLASH");
                        break;
                    }
                    case ENTITY_VILLAGER_AMBIENT: {
                        soundEnum = Sound.valueOf("VILLAGER_IDLE");
                        break;
                    }
                    case ENTITY_VILLAGER_DEATH: {
                        soundEnum = Sound.valueOf("VILLAGER_DEATH");
                        break;
                    }
                    case ENTITY_VILLAGER_HURT: {
                        soundEnum = Sound.valueOf("VILLAGER_HIT");
                        break;
                    }
                    case ENTITY_VILLAGER_NO: {
                        soundEnum = Sound.valueOf("VILLAGER_NO");
                        break;
                    }
                    case ENTITY_VILLAGER_TRADING: {
                        soundEnum = Sound.valueOf("VILLAGER_HAGGLE");
                        break;
                    }
                    case ENTITY_VILLAGER_YES: {
                        soundEnum = Sound.valueOf("VILLAGER_YES");
                        break;
                    }
                    case ENTITY_WITHER_AMBIENT: {
                        soundEnum = Sound.valueOf("WITHER_IDLE");
                        break;
                    }
                    case ENTITY_WITHER_DEATH: {
                        soundEnum = Sound.valueOf("WITHER_DEATH");
                        break;
                    }
                    case ENTITY_WITHER_HURT: {
                        soundEnum = Sound.valueOf("WITHER_HURT");
                        break;
                    }
                    case ENTITY_WITHER_SHOOT: {
                        soundEnum = Sound.valueOf("WITHER_SHOOT");
                        break;
                    }
                    case ENTITY_WITHER_SPAWN: {
                        soundEnum = Sound.valueOf("WITHER_SPAWN");
                        break;
                    }
                    case ENTITY_WOLF_AMBIENT: {
                        soundEnum = Sound.valueOf("WOLF_BARK");
                        break;
                    }
                    case ENTITY_WOLF_DEATH: {
                        soundEnum = Sound.valueOf("WOLF_DEATH");
                        break;
                    }
                    case ENTITY_WOLF_GROWL: {
                        soundEnum = Sound.valueOf("WOLF_GROWL");
                        break;
                    }
                    case ENTITY_WOLF_HOWL: {
                        soundEnum = Sound.valueOf("WOLF_HOWL");
                        break;
                    }
                    case ENTITY_WOLF_HURT: {
                        soundEnum = Sound.valueOf("WOLF_HURT");
                        break;
                    }
                    case ENTITY_WOLF_PANT: {
                        soundEnum = Sound.valueOf("WOLF_PANT");
                        break;
                    }
                    case ENTITY_WOLF_SHAKE: {
                        soundEnum = Sound.valueOf("WOLF_SHAKE");
                        break;
                    }
                    case ENTITY_WOLF_STEP: {
                        soundEnum = Sound.valueOf("WOLF_WALK");
                        break;
                    }
                    case ENTITY_WOLF_WHINE: {
                        soundEnum = Sound.valueOf("WOLF_WHINE");
                        break;
                    }
                    case ENTITY_ZOMBIE_AMBIENT: {
                        soundEnum = Sound.valueOf("ZOMBIE_IDLE");
                        break;
                    }
                    case ENTITY_ZOMBIE_ATTACK_DOOR_WOOD: {
                        soundEnum = Sound.valueOf("ZOMBIE_WOOD");
                        break;
                    }
                    case ENTITY_ZOMBIE_ATTACK_IRON_DOOR: {
                        soundEnum = Sound.valueOf("ZOMBIE_METAL");
                        break;
                    }
                    case ENTITY_ZOMBIE_BREAK_DOOR_WOOD: {
                        soundEnum = Sound.valueOf("ZOMBIE_WOODBREAK");
                        break;
                    }
                    case ENTITY_ZOMBIE_DEATH: {
                        soundEnum = Sound.valueOf("ZOMBIE_DEATH");
                        break;
                    }
                    case ENTITY_ZOMBIE_HORSE_AMBIENT: {
                        soundEnum = Sound.valueOf("HORSE_ZOMBIE_IDLE");
                        break;
                    }
                    case ENTITY_ZOMBIE_HORSE_DEATH: {
                        soundEnum = Sound.valueOf("HORSE_ZOMBIE_DEATH");
                        break;
                    }
                    case ENTITY_ZOMBIE_HORSE_HURT: {
                        soundEnum = Sound.valueOf("HORSE_ZOMBIE_HIT");
                        break;
                    }
                    case ENTITY_ZOMBIE_HURT: {
                        soundEnum = Sound.valueOf("ZOMBIE_HURT");
                        break;
                    }
                    case ENTITY_ZOMBIE_INFECT: {
                        soundEnum = Sound.valueOf("ZOMBIE_INFECT");
                        break;
                    }
                    case ENTITY_ZOMBIE_PIG_AMBIENT: {
                        soundEnum = Sound.valueOf("ZOMBIE_PIG_IDLE");
                        break;
                    }
                    case ENTITY_ZOMBIE_PIG_ANGRY: {
                        soundEnum = Sound.valueOf("ZOMBIE_PIG_ANGRY");
                        break;
                    }
                    case ENTITY_ZOMBIE_PIG_DEATH: {
                        soundEnum = Sound.valueOf("ZOMBIE_PIG_DEATH");
                        break;
                    }
                    case ENTITY_ZOMBIE_PIG_HURT: {
                        soundEnum = Sound.valueOf("ZOMBIE_PIG_HURT");
                        break;
                    }
                    case ENTITY_ZOMBIE_STEP: {
                        soundEnum = Sound.valueOf("ZOMBIE_WALK");
                        break;
                    }
                    case ENTITY_ZOMBIE_VILLAGER_AMBIENT: {
                        soundEnum = Sound.valueOf("ZOMBIE_IDLE");
                        break;
                    }
                    case ENTITY_ZOMBIE_VILLAGER_CONVERTED: {
                        soundEnum = Sound.valueOf("ZOMBIE_REMEDY");
                        break;
                    }
                    case ENTITY_ZOMBIE_VILLAGER_CURE: {
                        soundEnum = Sound.valueOf("ZOMBIE_UNFECT");
                        break;
                    }
                    case ENTITY_ZOMBIE_VILLAGER_DEATH: {
                        soundEnum = Sound.valueOf("ZOMBIE_DEATH");
                        break;
                    }
                    case ENTITY_ZOMBIE_VILLAGER_HURT: {
                        soundEnum = Sound.valueOf("ZOMBIE_HURT");
                        break;
                    }
                    case ENTITY_ZOMBIE_VILLAGER_STEP: {
                        soundEnum = Sound.valueOf("ZOMBIE_WALK");
                        break;
                    }
                    case ITEM_FIRECHARGE_USE: {
                        soundEnum = Sound.valueOf("FIREWORK_LAUNCH");
                        break;
                    }
                    case ITEM_FLINTANDSTEEL_USE: {
                        soundEnum = Sound.valueOf("FIRE_IGNITE");
                        break;
                    }
                    case UI_BUTTON_CLICK: {
                        soundEnum = Sound.valueOf("CLICK");
                        break;
                    }
                    case WEATHER_RAIN: {
                        soundEnum = Sound.valueOf("AMBIENCE_RAIN");
                        break;
                    }
                    case WEATHER_RAIN_ABOVE: {
                        soundEnum = Sound.valueOf("AMBIENCE_RAIN");
                        break;
                    }
                    default: {
                        return;
                    }
                }
            }
            catch (IllegalArgumentException e) {
                return;
            }
            for (final Player player : players) {
                player.playSound(loc, soundEnum, volume, pitch);
            }
        }
    }
}
