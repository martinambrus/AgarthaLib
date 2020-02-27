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

public class PacketSounds_1_10 extends HandlerPacket implements SoundTools
{
    public PacketSounds_1_10(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @Override
    public void playSoundEffect(final Collection<Player> players, final Location loc, final SoundEnum sound, final float volume, final float pitch) {
        if (players != null && loc != null && sound != null) {
            Sound soundEnum = null;
            try {
                switch (sound) {
                    case AMBIENT_CAVE: {
                        soundEnum = Sound.valueOf("AMBIENT_CAVE");
                        break;
                    }
                    case BLOCK_ANVIL_BREAK: {
                        soundEnum = Sound.valueOf("BLOCK_ANVIL_BREAK");
                        break;
                    }
                    case BLOCK_ANVIL_DESTROY: {
                        soundEnum = Sound.valueOf("BLOCK_ANVIL_DESTROY");
                        break;
                    }
                    case BLOCK_ANVIL_FALL: {
                        soundEnum = Sound.valueOf("BLOCK_ANVIL_FALL");
                        break;
                    }
                    case BLOCK_ANVIL_HIT: {
                        soundEnum = Sound.valueOf("BLOCK_ANVIL_HIT");
                        break;
                    }
                    case BLOCK_ANVIL_LAND: {
                        soundEnum = Sound.valueOf("BLOCK_ANVIL_LAND");
                        break;
                    }
                    case BLOCK_ANVIL_PLACE: {
                        soundEnum = Sound.valueOf("BLOCK_ANVIL_PLACE");
                        break;
                    }
                    case BLOCK_ANVIL_STEP: {
                        soundEnum = Sound.valueOf("BLOCK_ANVIL_STEP");
                        break;
                    }
                    case BLOCK_ANVIL_USE: {
                        soundEnum = Sound.valueOf("BLOCK_ANVIL_USE");
                        break;
                    }
                    case BLOCK_BREWING_STAND_BREW: {
                        soundEnum = Sound.valueOf("BLOCK_BREWING_STAND_BREW");
                        break;
                    }
                    case BLOCK_CHEST_CLOSE: {
                        soundEnum = Sound.valueOf("BLOCK_CHEST_CLOSE");
                        break;
                    }
                    case BLOCK_CHEST_LOCKED: {
                        soundEnum = Sound.valueOf("BLOCK_CHEST_LOCKED");
                        break;
                    }
                    case BLOCK_CHEST_OPEN: {
                        soundEnum = Sound.valueOf("BLOCK_CHEST_OPEN");
                        break;
                    }
                    case BLOCK_CHORUS_FLOWER_DEATH: {
                        soundEnum = Sound.valueOf("BLOCK_CHORUS_FLOWER_DEATH");
                        break;
                    }
                    case BLOCK_CHORUS_FLOWER_GROW: {
                        soundEnum = Sound.valueOf("BLOCK_CHORUS_FLOWER_GROW");
                        break;
                    }
                    case BLOCK_CLOTH_BREAK: {
                        soundEnum = Sound.valueOf("BLOCK_CLOTH_BREAK");
                        break;
                    }
                    case BLOCK_CLOTH_FALL: {
                        soundEnum = Sound.valueOf("BLOCK_CLOTH_FALL");
                        break;
                    }
                    case BLOCK_CLOTH_HIT: {
                        soundEnum = Sound.valueOf("BLOCK_CLOTH_HIT");
                        break;
                    }
                    case BLOCK_CLOTH_PLACE: {
                        soundEnum = Sound.valueOf("BLOCK_CLOTH_PLACE");
                        break;
                    }
                    case BLOCK_CLOTH_STEP: {
                        soundEnum = Sound.valueOf("BLOCK_CLOTH_STEP");
                        break;
                    }
                    case BLOCK_COMPARATOR_CLICK: {
                        soundEnum = Sound.valueOf("BLOCK_COMPARATOR_CLICK");
                        break;
                    }
                    case BLOCK_DISPENSER_DISPENSE: {
                        soundEnum = Sound.valueOf("BLOCK_DISPENSER_DISPENSE");
                        break;
                    }
                    case BLOCK_DISPENSER_FAIL: {
                        soundEnum = Sound.valueOf("BLOCK_DISPENSER_FAIL");
                        break;
                    }
                    case BLOCK_DISPENSER_LAUNCH: {
                        soundEnum = Sound.valueOf("BLOCK_DISPENSER_LAUNCH");
                        break;
                    }
                    case BLOCK_ENCHANTMENT_TABLE_USE: {
                        soundEnum = Sound.valueOf("BLOCK_ENCHANTMENT_TABLE_USE");
                        break;
                    }
                    case BLOCK_END_GATEWAY_SPAWN: {
                        soundEnum = Sound.valueOf("BLOCK_END_GATEWAY_SPAWN");
                        break;
                    }
                    case BLOCK_ENDERCHEST_CLOSE: {
                        soundEnum = Sound.valueOf("BLOCK_ENDERCHEST_CLOSE");
                        break;
                    }
                    case BLOCK_ENDERCHEST_OPEN: {
                        soundEnum = Sound.valueOf("BLOCK_ENDERCHEST_OPEN");
                        break;
                    }
                    case BLOCK_FENCE_GATE_CLOSE: {
                        soundEnum = Sound.valueOf("BLOCK_FENCE_GATE_CLOSE");
                        break;
                    }
                    case BLOCK_FENCE_GATE_OPEN: {
                        soundEnum = Sound.valueOf("BLOCK_FENCE_GATE_OPEN");
                        break;
                    }
                    case BLOCK_FIRE_AMBIENT: {
                        soundEnum = Sound.valueOf("BLOCK_FIRE_AMBIENT");
                        break;
                    }
                    case BLOCK_FIRE_EXTINGUISH: {
                        soundEnum = Sound.valueOf("BLOCK_FIRE_EXTINGUISH");
                        break;
                    }
                    case BLOCK_FURNACE_FIRE_CRACKLE: {
                        soundEnum = Sound.valueOf("BLOCK_FURNACE_FIRE_CRACKLE");
                        break;
                    }
                    case BLOCK_GLASS_BREAK: {
                        soundEnum = Sound.valueOf("BLOCK_GLASS_BREAK");
                        break;
                    }
                    case BLOCK_GLASS_FALL: {
                        soundEnum = Sound.valueOf("BLOCK_GLASS_FALL");
                        break;
                    }
                    case BLOCK_GLASS_HIT: {
                        soundEnum = Sound.valueOf("BLOCK_GLASS_HIT");
                        break;
                    }
                    case BLOCK_GLASS_PLACE: {
                        soundEnum = Sound.valueOf("BLOCK_GLASS_PLACE");
                        break;
                    }
                    case BLOCK_GLASS_STEP: {
                        soundEnum = Sound.valueOf("BLOCK_GLASS_STEP");
                        break;
                    }
                    case BLOCK_GRASS_BREAK: {
                        soundEnum = Sound.valueOf("BLOCK_GRASS_BREAK");
                        break;
                    }
                    case BLOCK_GRASS_FALL: {
                        soundEnum = Sound.valueOf("BLOCK_GRASS_FALL");
                        break;
                    }
                    case BLOCK_GRASS_HIT: {
                        soundEnum = Sound.valueOf("BLOCK_GRASS_HIT");
                        break;
                    }
                    case BLOCK_GRASS_PLACE: {
                        soundEnum = Sound.valueOf("BLOCK_GRASS_PLACE");
                        break;
                    }
                    case BLOCK_GRASS_STEP: {
                        soundEnum = Sound.valueOf("BLOCK_GRASS_STEP");
                        break;
                    }
                    case BLOCK_GRAVEL_BREAK: {
                        soundEnum = Sound.valueOf("BLOCK_GRAVEL_BREAK");
                        break;
                    }
                    case BLOCK_GRAVEL_FALL: {
                        soundEnum = Sound.valueOf("BLOCK_GRAVEL_FALL");
                        break;
                    }
                    case BLOCK_GRAVEL_HIT: {
                        soundEnum = Sound.valueOf("BLOCK_GRAVEL_HIT");
                        break;
                    }
                    case BLOCK_GRAVEL_PLACE: {
                        soundEnum = Sound.valueOf("BLOCK_GRAVEL_PLACE");
                        break;
                    }
                    case BLOCK_GRAVEL_STEP: {
                        soundEnum = Sound.valueOf("BLOCK_GRAVEL_STEP");
                        break;
                    }
                    case BLOCK_IRON_DOOR_CLOSE: {
                        soundEnum = Sound.valueOf("BLOCK_IRON_DOOR_CLOSE");
                        break;
                    }
                    case BLOCK_IRON_DOOR_OPEN: {
                        soundEnum = Sound.valueOf("BLOCK_IRON_DOOR_OPEN");
                        break;
                    }
                    case BLOCK_IRON_TRAPDOOR_CLOSE: {
                        soundEnum = Sound.valueOf("BLOCK_IRON_TRAPDOOR_CLOSE");
                        break;
                    }
                    case BLOCK_IRON_TRAPDOOR_OPEN: {
                        soundEnum = Sound.valueOf("BLOCK_IRON_TRAPDOOR_OPEN");
                        break;
                    }
                    case BLOCK_LADDER_BREAK: {
                        soundEnum = Sound.valueOf("BLOCK_LADDER_BREAK");
                        break;
                    }
                    case BLOCK_LADDER_FALL: {
                        soundEnum = Sound.valueOf("BLOCK_LADDER_FALL");
                        break;
                    }
                    case BLOCK_LADDER_HIT: {
                        soundEnum = Sound.valueOf("BLOCK_LADDER_HIT");
                        break;
                    }
                    case BLOCK_LADDER_PLACE: {
                        soundEnum = Sound.valueOf("BLOCK_LADDER_PLACE");
                        break;
                    }
                    case BLOCK_LADDER_STEP: {
                        soundEnum = Sound.valueOf("BLOCK_LADDER_STEP");
                        break;
                    }
                    case BLOCK_LAVA_AMBIENT: {
                        soundEnum = Sound.valueOf("BLOCK_LAVA_AMBIENT");
                        break;
                    }
                    case BLOCK_LAVA_EXTINGUISH: {
                        soundEnum = Sound.valueOf("BLOCK_LAVA_EXTINGUISH");
                        break;
                    }
                    case BLOCK_LAVA_POP: {
                        soundEnum = Sound.valueOf("BLOCK_LAVA_POP");
                        break;
                    }
                    case BLOCK_LEVER_CLICK: {
                        soundEnum = Sound.valueOf("BLOCK_LEVER_CLICK");
                        break;
                    }
                    case BLOCK_METAL_BREAK: {
                        soundEnum = Sound.valueOf("BLOCK_METAL_BREAK");
                        break;
                    }
                    case BLOCK_METAL_FALL: {
                        soundEnum = Sound.valueOf("BLOCK_METAL_FALL");
                        break;
                    }
                    case BLOCK_METAL_HIT: {
                        soundEnum = Sound.valueOf("BLOCK_METAL_HIT");
                        break;
                    }
                    case BLOCK_METAL_PLACE: {
                        soundEnum = Sound.valueOf("BLOCK_METAL_PLACE");
                        break;
                    }
                    case BLOCK_METAL_PRESSUREPLATE_CLICK_OFF: {
                        soundEnum = Sound.valueOf("BLOCK_METAL_PRESSUREPLATE_CLICK_OFF");
                        break;
                    }
                    case BLOCK_METAL_PRESSUREPLATE_CLICK_ON: {
                        soundEnum = Sound.valueOf("BLOCK_METAL_PRESSUREPLATE_CLICK_ON");
                        break;
                    }
                    case BLOCK_METAL_STEP: {
                        soundEnum = Sound.valueOf("BLOCK_METAL_STEP");
                        break;
                    }
                    case BLOCK_NOTE_BASEDRUM: {
                        soundEnum = Sound.valueOf("BLOCK_NOTE_BASEDRUM");
                        break;
                    }
                    case BLOCK_NOTE_BASS: {
                        soundEnum = Sound.valueOf("BLOCK_NOTE_BASS");
                        break;
                    }
                    case BLOCK_NOTE_HARP: {
                        soundEnum = Sound.valueOf("BLOCK_NOTE_HARP");
                        break;
                    }
                    case BLOCK_NOTE_HAT: {
                        soundEnum = Sound.valueOf("BLOCK_NOTE_HAT");
                        break;
                    }
                    case BLOCK_NOTE_PLING: {
                        soundEnum = Sound.valueOf("BLOCK_NOTE_PLING");
                        break;
                    }
                    case BLOCK_NOTE_SNARE: {
                        soundEnum = Sound.valueOf("BLOCK_NOTE_SNARE");
                        break;
                    }
                    case BLOCK_PISTON_CONTRACT: {
                        soundEnum = Sound.valueOf("BLOCK_PISTON_CONTRACT");
                        break;
                    }
                    case BLOCK_PISTON_EXTEND: {
                        soundEnum = Sound.valueOf("BLOCK_PISTON_EXTEND");
                        break;
                    }
                    case BLOCK_PORTAL_AMBIENT: {
                        soundEnum = Sound.valueOf("BLOCK_PORTAL_AMBIENT");
                        break;
                    }
                    case BLOCK_PORTAL_TRAVEL: {
                        soundEnum = Sound.valueOf("BLOCK_PORTAL_TRAVEL");
                        break;
                    }
                    case BLOCK_PORTAL_TRIGGER: {
                        soundEnum = Sound.valueOf("BLOCK_PORTAL_TRIGGER");
                        break;
                    }
                    case BLOCK_REDSTONE_TORCH_BURNOUT: {
                        soundEnum = Sound.valueOf("BLOCK_REDSTONE_TORCH_BURNOUT");
                        break;
                    }
                    case BLOCK_SAND_BREAK: {
                        soundEnum = Sound.valueOf("BLOCK_SAND_BREAK");
                        break;
                    }
                    case BLOCK_SAND_FALL: {
                        soundEnum = Sound.valueOf("BLOCK_SAND_FALL");
                        break;
                    }
                    case BLOCK_SAND_HIT: {
                        soundEnum = Sound.valueOf("BLOCK_SAND_HIT");
                        break;
                    }
                    case BLOCK_SAND_PLACE: {
                        soundEnum = Sound.valueOf("BLOCK_SAND_PLACE");
                        break;
                    }
                    case BLOCK_SAND_STEP: {
                        soundEnum = Sound.valueOf("BLOCK_SAND_STEP");
                        break;
                    }
                    case BLOCK_SLIME_BREAK: {
                        soundEnum = Sound.valueOf("BLOCK_SLIME_BREAK");
                        break;
                    }
                    case BLOCK_SLIME_FALL: {
                        soundEnum = Sound.valueOf("BLOCK_SLIME_FALL");
                        break;
                    }
                    case BLOCK_SLIME_HIT: {
                        soundEnum = Sound.valueOf("BLOCK_SLIME_HIT");
                        break;
                    }
                    case BLOCK_SLIME_PLACE: {
                        soundEnum = Sound.valueOf("BLOCK_SLIME_PLACE");
                        break;
                    }
                    case BLOCK_SLIME_STEP: {
                        soundEnum = Sound.valueOf("BLOCK_SLIME_STEP");
                        break;
                    }
                    case BLOCK_SNOW_BREAK: {
                        soundEnum = Sound.valueOf("BLOCK_SNOW_BREAK");
                        break;
                    }
                    case BLOCK_SNOW_FALL: {
                        soundEnum = Sound.valueOf("BLOCK_SNOW_FALL");
                        break;
                    }
                    case BLOCK_SNOW_HIT: {
                        soundEnum = Sound.valueOf("BLOCK_SNOW_HIT");
                        break;
                    }
                    case BLOCK_SNOW_PLACE: {
                        soundEnum = Sound.valueOf("BLOCK_SNOW_PLACE");
                        break;
                    }
                    case BLOCK_SNOW_STEP: {
                        soundEnum = Sound.valueOf("BLOCK_SNOW_STEP");
                        break;
                    }
                    case BLOCK_STONE_BREAK: {
                        soundEnum = Sound.valueOf("BLOCK_STONE_BREAK");
                        break;
                    }
                    case BLOCK_STONE_BUTTON_CLICK_OFF: {
                        soundEnum = Sound.valueOf("BLOCK_STONE_BUTTON_CLICK_OFF");
                        break;
                    }
                    case BLOCK_STONE_BUTTON_CLICK_ON: {
                        soundEnum = Sound.valueOf("BLOCK_STONE_BUTTON_CLICK_ON");
                        break;
                    }
                    case BLOCK_STONE_FALL: {
                        soundEnum = Sound.valueOf("BLOCK_STONE_FALL");
                        break;
                    }
                    case BLOCK_STONE_HIT: {
                        soundEnum = Sound.valueOf("BLOCK_STONE_HIT");
                        break;
                    }
                    case BLOCK_STONE_PLACE: {
                        soundEnum = Sound.valueOf("BLOCK_STONE_PLACE");
                        break;
                    }
                    case BLOCK_STONE_PRESSUREPLATE_CLICK_OFF: {
                        soundEnum = Sound.valueOf("BLOCK_STONE_PRESSUREPLATE_CLICK_OFF");
                        break;
                    }
                    case BLOCK_STONE_PRESSUREPLATE_CLICK_ON: {
                        soundEnum = Sound.valueOf("BLOCK_STONE_PRESSUREPLATE_CLICK_ON");
                        break;
                    }
                    case BLOCK_STONE_STEP: {
                        soundEnum = Sound.valueOf("BLOCK_STONE_STEP");
                        break;
                    }
                    case BLOCK_TRIPWIRE_ATTACH: {
                        soundEnum = Sound.valueOf("BLOCK_TRIPWIRE_ATTACH");
                        break;
                    }
                    case BLOCK_TRIPWIRE_CLICK_OFF: {
                        soundEnum = Sound.valueOf("BLOCK_TRIPWIRE_CLICK_OFF");
                        break;
                    }
                    case BLOCK_TRIPWIRE_CLICK_ON: {
                        soundEnum = Sound.valueOf("BLOCK_TRIPWIRE_CLICK_ON");
                        break;
                    }
                    case BLOCK_TRIPWIRE_DETACH: {
                        soundEnum = Sound.valueOf("BLOCK_TRIPWIRE_DETACH");
                        break;
                    }
                    case BLOCK_WATER_AMBIENT: {
                        soundEnum = Sound.valueOf("BLOCK_WATER_AMBIENT");
                        break;
                    }
                    case BLOCK_WATERLILY_PLACE: {
                        soundEnum = Sound.valueOf("BLOCK_WATERLILY_PLACE");
                        break;
                    }
                    case BLOCK_WOOD_BREAK: {
                        soundEnum = Sound.valueOf("BLOCK_WOOD_BREAK");
                        break;
                    }
                    case BLOCK_WOOD_BUTTON_CLICK_OFF: {
                        soundEnum = Sound.valueOf("BLOCK_WOOD_BUTTON_CLICK_OFF");
                        break;
                    }
                    case BLOCK_WOOD_BUTTON_CLICK_ON: {
                        soundEnum = Sound.valueOf("BLOCK_WOOD_BUTTON_CLICK_ON");
                        break;
                    }
                    case BLOCK_WOOD_FALL: {
                        soundEnum = Sound.valueOf("BLOCK_WOOD_FALL");
                        break;
                    }
                    case BLOCK_WOOD_HIT: {
                        soundEnum = Sound.valueOf("BLOCK_WOOD_HIT");
                        break;
                    }
                    case BLOCK_WOOD_PLACE: {
                        soundEnum = Sound.valueOf("BLOCK_WOOD_PLACE");
                        break;
                    }
                    case BLOCK_WOOD_PRESSUREPLATE_CLICK_OFF: {
                        soundEnum = Sound.valueOf("BLOCK_WOOD_PRESSUREPLATE_CLICK_OFF");
                        break;
                    }
                    case BLOCK_WOOD_PRESSUREPLATE_CLICK_ON: {
                        soundEnum = Sound.valueOf("BLOCK_WOOD_PRESSUREPLATE_CLICK_ON");
                        break;
                    }
                    case BLOCK_WOOD_STEP: {
                        soundEnum = Sound.valueOf("BLOCK_WOOD_STEP");
                        break;
                    }
                    case BLOCK_WOODEN_DOOR_CLOSE: {
                        soundEnum = Sound.valueOf("BLOCK_WOODEN_DOOR_CLOSE");
                        break;
                    }
                    case BLOCK_WOODEN_DOOR_OPEN: {
                        soundEnum = Sound.valueOf("BLOCK_WOODEN_DOOR_OPEN");
                        break;
                    }
                    case BLOCK_WOODEN_TRAPDOOR_CLOSE: {
                        soundEnum = Sound.valueOf("BLOCK_WOODEN_TRAPDOOR_CLOSE");
                        break;
                    }
                    case BLOCK_WOODEN_TRAPDOOR_OPEN: {
                        soundEnum = Sound.valueOf("BLOCK_WOODEN_TRAPDOOR_OPEN");
                        break;
                    }
                    case ENCHANT_THORNS_HIT: {
                        soundEnum = Sound.valueOf("ENCHANT_THORNS_HIT");
                        break;
                    }
                    case ENTITY_ARMORSTAND_BREAK: {
                        soundEnum = Sound.valueOf("ENTITY_ARMORSTAND_BREAK");
                        break;
                    }
                    case ENTITY_ARMORSTAND_FALL: {
                        soundEnum = Sound.valueOf("ENTITY_ARMORSTAND_FALL");
                        break;
                    }
                    case ENTITY_ARMORSTAND_HIT: {
                        soundEnum = Sound.valueOf("ENTITY_ARMORSTAND_HIT");
                        break;
                    }
                    case ENTITY_ARMORSTAND_PLACE: {
                        soundEnum = Sound.valueOf("ENTITY_ARMORSTAND_PLACE");
                        break;
                    }
                    case ENTITY_ARROW_HIT: {
                        soundEnum = Sound.valueOf("ENTITY_ARROW_HIT");
                        break;
                    }
                    case ENTITY_ARROW_HIT_PLAYER: {
                        soundEnum = Sound.valueOf("ENTITY_ARROW_HIT_PLAYER");
                        break;
                    }
                    case ENTITY_ARROW_SHOOT: {
                        soundEnum = Sound.valueOf("ENTITY_ARROW_SHOOT");
                        break;
                    }
                    case ENTITY_BAT_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_BAT_AMBIENT");
                        break;
                    }
                    case ENTITY_BAT_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_BAT_DEATH");
                        break;
                    }
                    case ENTITY_BAT_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_BAT_HURT");
                        break;
                    }
                    case ENTITY_BAT_LOOP: {
                        soundEnum = Sound.valueOf("ENTITY_BAT_LOOP");
                        break;
                    }
                    case ENTITY_BAT_TAKEOFF: {
                        soundEnum = Sound.valueOf("ENTITY_BAT_TAKEOFF");
                        break;
                    }
                    case ENTITY_BLAZE_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_BLAZE_AMBIENT");
                        break;
                    }
                    case ENTITY_BLAZE_BURN: {
                        soundEnum = Sound.valueOf("ENTITY_BLAZE_BURN");
                        break;
                    }
                    case ENTITY_BLAZE_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_BLAZE_DEATH");
                        break;
                    }
                    case ENTITY_BLAZE_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_BLAZE_HURT");
                        break;
                    }
                    case ENTITY_BLAZE_SHOOT: {
                        soundEnum = Sound.valueOf("ENTITY_BLAZE_SHOOT");
                        break;
                    }
                    case ENTITY_BOBBER_SPLASH: {
                        soundEnum = Sound.valueOf("ENTITY_BOBBER_SPLASH");
                        break;
                    }
                    case ENTITY_BOBBER_THROW: {
                        soundEnum = Sound.valueOf("ENTITY_BOBBER_THROW");
                        break;
                    }
                    case ENTITY_CAT_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_CAT_AMBIENT");
                        break;
                    }
                    case ENTITY_CAT_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_CAT_DEATH");
                        break;
                    }
                    case ENTITY_CAT_HISS: {
                        soundEnum = Sound.valueOf("ENTITY_CAT_HISS");
                        break;
                    }
                    case ENTITY_CAT_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_CAT_HURT");
                        break;
                    }
                    case ENTITY_CAT_PURR: {
                        soundEnum = Sound.valueOf("ENTITY_CAT_PURR");
                        break;
                    }
                    case ENTITY_CAT_PURREOW: {
                        soundEnum = Sound.valueOf("ENTITY_CAT_PURREOW");
                        break;
                    }
                    case ENTITY_CHICKEN_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_CHICKEN_AMBIENT");
                        break;
                    }
                    case ENTITY_CHICKEN_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_CHICKEN_DEATH");
                        break;
                    }
                    case ENTITY_CHICKEN_EGG: {
                        soundEnum = Sound.valueOf("ENTITY_CHICKEN_EGG");
                        break;
                    }
                    case ENTITY_CHICKEN_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_CHICKEN_HURT");
                        break;
                    }
                    case ENTITY_CHICKEN_STEP: {
                        soundEnum = Sound.valueOf("ENTITY_CHICKEN_STEP");
                        break;
                    }
                    case ENTITY_COW_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_COW_AMBIENT");
                        break;
                    }
                    case ENTITY_COW_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_COW_DEATH");
                        break;
                    }
                    case ENTITY_COW_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_COW_HURT");
                        break;
                    }
                    case ENTITY_COW_MILK: {
                        soundEnum = Sound.valueOf("ENTITY_COW_MILK");
                        break;
                    }
                    case ENTITY_COW_STEP: {
                        soundEnum = Sound.valueOf("ENTITY_COW_STEP");
                        break;
                    }
                    case ENTITY_CREEPER_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_CREEPER_DEATH");
                        break;
                    }
                    case ENTITY_CREEPER_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_CREEPER_HURT");
                        break;
                    }
                    case ENTITY_CREEPER_PRIMED: {
                        soundEnum = Sound.valueOf("ENTITY_CREEPER_PRIMED");
                        break;
                    }
                    case ENTITY_DONKEY_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_DONKEY_AMBIENT");
                        break;
                    }
                    case ENTITY_DONKEY_ANGRY: {
                        soundEnum = Sound.valueOf("ENTITY_DONKEY_ANGRY");
                        break;
                    }
                    case ENTITY_DONKEY_CHEST: {
                        soundEnum = Sound.valueOf("ENTITY_DONKEY_CHEST");
                        break;
                    }
                    case ENTITY_DONKEY_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_DONKEY_DEATH");
                        break;
                    }
                    case ENTITY_DONKEY_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_DONKEY_HURT");
                        break;
                    }
                    case ENTITY_EGG_THROW: {
                        soundEnum = Sound.valueOf("ENTITY_EGG_THROW");
                        break;
                    }
                    case ENTITY_ELDER_GUARDIAN_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_ELDER_GUARDIAN_AMBIENT");
                        break;
                    }
                    case ENTITY_ELDER_GUARDIAN_AMBIENT_LAND: {
                        soundEnum = Sound.valueOf("ENTITY_ELDER_GUARDIAN_AMBIENT_LAND");
                        break;
                    }
                    case ENTITY_ELDER_GUARDIAN_CURSE: {
                        soundEnum = Sound.valueOf("ENTITY_ELDER_GUARDIAN_CURSE");
                        break;
                    }
                    case ENTITY_ELDER_GUARDIAN_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_ELDER_GUARDIAN_DEATH");
                        break;
                    }
                    case ENTITY_ELDER_GUARDIAN_DEATH_LAND: {
                        soundEnum = Sound.valueOf("ENTITY_ELDER_GUARDIAN_DEATH_LAND");
                        break;
                    }
                    case ENTITY_ELDER_GUARDIAN_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_ELDER_GUARDIAN_HURT");
                        break;
                    }
                    case ENTITY_ELDER_GUARDIAN_HURT_LAND: {
                        soundEnum = Sound.valueOf("ENTITY_ELDER_GUARDIAN_HURT_LAND");
                        break;
                    }
                    case ENTITY_ENDERDRAGON_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_ENDERDRAGON_AMBIENT");
                        break;
                    }
                    case ENTITY_ENDERDRAGON_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_ENDERDRAGON_DEATH");
                        break;
                    }
                    case ENTITY_ENDERDRAGON_FIREBALL_EXPLODE: {
                        soundEnum = Sound.valueOf("ENTITY_ENDERDRAGON_FIREBALL_EXPLODE");
                        break;
                    }
                    case ENTITY_ENDERDRAGON_FLAP: {
                        soundEnum = Sound.valueOf("ENTITY_ENDERDRAGON_FLAP");
                        break;
                    }
                    case ENTITY_ENDERDRAGON_GROWL: {
                        soundEnum = Sound.valueOf("ENTITY_ENDERDRAGON_GROWL");
                        break;
                    }
                    case ENTITY_ENDERDRAGON_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_ENDERDRAGON_HURT");
                        break;
                    }
                    case ENTITY_ENDERDRAGON_SHOOT: {
                        soundEnum = Sound.valueOf("ENTITY_ENDERDRAGON_SHOOT");
                        break;
                    }
                    case ENTITY_ENDEREYE_LAUNCH: {
                        soundEnum = Sound.valueOf("ENTITY_ENDEREYE_LAUNCH");
                        break;
                    }
                    case ENTITY_ENDERMEN_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_ENDERMEN_AMBIENT");
                        break;
                    }
                    case ENTITY_ENDERMEN_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_ENDERMEN_DEATH");
                        break;
                    }
                    case ENTITY_ENDERMEN_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_ENDERMEN_HURT");
                        break;
                    }
                    case ENTITY_ENDERMEN_SCREAM: {
                        soundEnum = Sound.valueOf("ENTITY_ENDERMEN_SCREAM");
                        break;
                    }
                    case ENTITY_ENDERMEN_STARE: {
                        soundEnum = Sound.valueOf("ENTITY_ENDERMEN_STARE");
                        break;
                    }
                    case ENTITY_ENDERMEN_TELEPORT: {
                        soundEnum = Sound.valueOf("ENTITY_ENDERMEN_TELEPORT");
                        break;
                    }
                    case ENTITY_ENDERMITE_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_ENDERMITE_AMBIENT");
                        break;
                    }
                    case ENTITY_ENDERMITE_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_ENDERMITE_DEATH");
                        break;
                    }
                    case ENTITY_ENDERMITE_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_ENDERMITE_HURT");
                        break;
                    }
                    case ENTITY_ENDERMITE_STEP: {
                        soundEnum = Sound.valueOf("ENTITY_ENDERMITE_STEP");
                        break;
                    }
                    case ENTITY_ENDERPEARL_THROW: {
                        soundEnum = Sound.valueOf("ENTITY_ENDERPEARL_THROW");
                        break;
                    }
                    case ENTITY_EXPERIENCE_BOTTLE_THROW: {
                        soundEnum = Sound.valueOf("ENTITY_EXPERIENCE_BOTTLE_THROW");
                        break;
                    }
                    case ENTITY_EXPERIENCE_ORB_PICKUP: {
                        soundEnum = Sound.valueOf("ENTITY_EXPERIENCE_ORB_PICKUP");
                        break;
                    }
                    case ENTITY_EXPERIENCE_ORB_TOUCH: {
                        soundEnum = Sound.valueOf("ENTITY_EXPERIENCE_ORB_TOUCH");
                        break;
                    }
                    case ENTITY_FIREWORK_BLAST: {
                        soundEnum = Sound.valueOf("ENTITY_FIREWORK_BLAST");
                        break;
                    }
                    case ENTITY_FIREWORK_LARGE_BLAST: {
                        soundEnum = Sound.valueOf("ENTITY_FIREWORK_LARGE_BLAST");
                        break;
                    }
                    case ENTITY_FIREWORK_LARGE_BLAST_FAR: {
                        soundEnum = Sound.valueOf("ENTITY_FIREWORK_LARGE_BLAST_FAR");
                        break;
                    }
                    case ENTITY_FIREWORK_LAUNCH: {
                        soundEnum = Sound.valueOf("ENTITY_FIREWORK_LAUNCH");
                        break;
                    }
                    case ENTITY_FIREWORK_SHOOT: {
                        soundEnum = Sound.valueOf("ENTITY_FIREWORK_SHOOT");
                        break;
                    }
                    case ENTITY_FIREWORK_TWINKLE: {
                        soundEnum = Sound.valueOf("ENTITY_FIREWORK_TWINKLE");
                        break;
                    }
                    case ENTITY_FIREWORK_TWINKLE_FAR: {
                        soundEnum = Sound.valueOf("ENTITY_FIREWORK_TWINKLE_FAR");
                        break;
                    }
                    case ENTITY_GENERIC_BIG_FALL: {
                        soundEnum = Sound.valueOf("ENTITY_GENERIC_BIG_FALL");
                        break;
                    }
                    case ENTITY_GENERIC_BURN: {
                        soundEnum = Sound.valueOf("ENTITY_GENERIC_BURN");
                        break;
                    }
                    case ENTITY_GENERIC_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_GENERIC_DEATH");
                        break;
                    }
                    case ENTITY_GENERIC_DRINK: {
                        soundEnum = Sound.valueOf("ENTITY_GENERIC_DRINK");
                        break;
                    }
                    case ENTITY_GENERIC_EAT: {
                        soundEnum = Sound.valueOf("ENTITY_GENERIC_EAT");
                        break;
                    }
                    case ENTITY_GENERIC_EXPLODE: {
                        soundEnum = Sound.valueOf("ENTITY_GENERIC_EXPLODE");
                        break;
                    }
                    case ENTITY_GENERIC_EXTINGUISH_FIRE: {
                        soundEnum = Sound.valueOf("ENTITY_GENERIC_EXTINGUISH_FIRE");
                        break;
                    }
                    case ENTITY_GENERIC_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_GENERIC_HURT");
                        break;
                    }
                    case ENTITY_GENERIC_SMALL_FALL: {
                        soundEnum = Sound.valueOf("ENTITY_GENERIC_SMALL_FALL");
                        break;
                    }
                    case ENTITY_GENERIC_SPLASH: {
                        soundEnum = Sound.valueOf("ENTITY_GENERIC_SPLASH");
                        break;
                    }
                    case ENTITY_GENERIC_SWIM: {
                        soundEnum = Sound.valueOf("ENTITY_GENERIC_SWIM");
                        break;
                    }
                    case ENTITY_GHAST_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_GHAST_AMBIENT");
                        break;
                    }
                    case ENTITY_GHAST_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_GHAST_DEATH");
                        break;
                    }
                    case ENTITY_GHAST_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_GHAST_HURT");
                        break;
                    }
                    case ENTITY_GHAST_SCREAM: {
                        soundEnum = Sound.valueOf("ENTITY_GHAST_SCREAM");
                        break;
                    }
                    case ENTITY_GHAST_SHOOT: {
                        soundEnum = Sound.valueOf("ENTITY_GHAST_SHOOT");
                        break;
                    }
                    case ENTITY_GHAST_WARN: {
                        soundEnum = Sound.valueOf("ENTITY_GHAST_WARN");
                        break;
                    }
                    case ENTITY_GUARDIAN_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_GUARDIAN_AMBIENT");
                        break;
                    }
                    case ENTITY_GUARDIAN_AMBIENT_LAND: {
                        soundEnum = Sound.valueOf("ENTITY_GUARDIAN_AMBIENT_LAND");
                        break;
                    }
                    case ENTITY_GUARDIAN_ATTACK: {
                        soundEnum = Sound.valueOf("ENTITY_GUARDIAN_ATTACK");
                        break;
                    }
                    case ENTITY_GUARDIAN_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_GUARDIAN_DEATH");
                        break;
                    }
                    case ENTITY_GUARDIAN_DEATH_LAND: {
                        soundEnum = Sound.valueOf("ENTITY_GUARDIAN_DEATH_LAND");
                        break;
                    }
                    case ENTITY_GUARDIAN_FLOP: {
                        soundEnum = Sound.valueOf("ENTITY_GUARDIAN_FLOP");
                        break;
                    }
                    case ENTITY_GUARDIAN_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_GUARDIAN_HURT");
                        break;
                    }
                    case ENTITY_GUARDIAN_HURT_LAND: {
                        soundEnum = Sound.valueOf("ENTITY_GUARDIAN_HURT_LAND");
                        break;
                    }
                    case ENTITY_HORSE_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_HORSE_AMBIENT");
                        break;
                    }
                    case ENTITY_HORSE_ANGRY: {
                        soundEnum = Sound.valueOf("ENTITY_HORSE_ANGRY");
                        break;
                    }
                    case ENTITY_HORSE_ARMOR: {
                        soundEnum = Sound.valueOf("ENTITY_HORSE_ARMOR");
                        break;
                    }
                    case ENTITY_HORSE_BREATHE: {
                        soundEnum = Sound.valueOf("ENTITY_HORSE_BREATHE");
                        break;
                    }
                    case ENTITY_HORSE_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_HORSE_DEATH");
                        break;
                    }
                    case ENTITY_HORSE_EAT: {
                        soundEnum = Sound.valueOf("ENTITY_HORSE_EAT");
                        break;
                    }
                    case ENTITY_HORSE_GALLOP: {
                        soundEnum = Sound.valueOf("ENTITY_HORSE_GALLOP");
                        break;
                    }
                    case ENTITY_HORSE_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_HORSE_HURT");
                        break;
                    }
                    case ENTITY_HORSE_JUMP: {
                        soundEnum = Sound.valueOf("ENTITY_HORSE_JUMP");
                        break;
                    }
                    case ENTITY_HORSE_LAND: {
                        soundEnum = Sound.valueOf("ENTITY_HORSE_LAND");
                        break;
                    }
                    case ENTITY_HORSE_SADDLE: {
                        soundEnum = Sound.valueOf("ENTITY_HORSE_SADDLE");
                        break;
                    }
                    case ENTITY_HORSE_STEP: {
                        soundEnum = Sound.valueOf("ENTITY_HORSE_STEP");
                        break;
                    }
                    case ENTITY_HORSE_STEP_WOOD: {
                        soundEnum = Sound.valueOf("ENTITY_HORSE_STEP_WOOD");
                        break;
                    }
                    case ENTITY_HOSTILE_BIG_FALL: {
                        soundEnum = Sound.valueOf("ENTITY_HOSTILE_BIG_FALL");
                        break;
                    }
                    case ENTITY_HOSTILE_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_HOSTILE_DEATH");
                        break;
                    }
                    case ENTITY_HOSTILE_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_HOSTILE_HURT");
                        break;
                    }
                    case ENTITY_HOSTILE_SMALL_FALL: {
                        soundEnum = Sound.valueOf("ENTITY_HOSTILE_SMALL_FALL");
                        break;
                    }
                    case ENTITY_HOSTILE_SPLASH: {
                        soundEnum = Sound.valueOf("ENTITY_HOSTILE_SPLASH");
                        break;
                    }
                    case ENTITY_HOSTILE_SWIM: {
                        soundEnum = Sound.valueOf("ENTITY_HOSTILE_SWIM");
                        break;
                    }
                    case ENTITY_HUSK_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_HUSK_AMBIENT");
                        break;
                    }
                    case ENTITY_HUSK_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_HUSK_DEATH");
                        break;
                    }
                    case ENTITY_HUSK_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_HUSK_HURT");
                        break;
                    }
                    case ENTITY_HUSK_STEP: {
                        soundEnum = Sound.valueOf("ENTITY_HUSK_STEP");
                        break;
                    }
                    case ENTITY_IRONGOLEM_ATTACK: {
                        soundEnum = Sound.valueOf("ENTITY_IRONGOLEM_ATTACK");
                        break;
                    }
                    case ENTITY_IRONGOLEM_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_IRONGOLEM_DEATH");
                        break;
                    }
                    case ENTITY_IRONGOLEM_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_IRONGOLEM_HURT");
                        break;
                    }
                    case ENTITY_IRONGOLEM_STEP: {
                        soundEnum = Sound.valueOf("ENTITY_IRONGOLEM_STEP");
                        break;
                    }
                    case ENTITY_ITEM_BREAK: {
                        soundEnum = Sound.valueOf("ENTITY_ITEM_BREAK");
                        break;
                    }
                    case ENTITY_ITEM_PICKUP: {
                        soundEnum = Sound.valueOf("ENTITY_ITEM_PICKUP");
                        break;
                    }
                    case ENTITY_ITEMFRAME_ADD_ITEM: {
                        soundEnum = Sound.valueOf("ENTITY_ITEMFRAME_ADD_ITEM");
                        break;
                    }
                    case ENTITY_ITEMFRAME_BREAK: {
                        soundEnum = Sound.valueOf("ENTITY_ITEMFRAME_BREAK");
                        break;
                    }
                    case ENTITY_ITEMFRAME_PLACE: {
                        soundEnum = Sound.valueOf("ENTITY_ITEMFRAME_PLACE");
                        break;
                    }
                    case ENTITY_ITEMFRAME_REMOVE_ITEM: {
                        soundEnum = Sound.valueOf("ENTITY_ITEMFRAME_REMOVE_ITEM");
                        break;
                    }
                    case ENTITY_ITEMFRAME_ROTATE_ITEM: {
                        soundEnum = Sound.valueOf("ENTITY_ITEMFRAME_ROTATE_ITEM");
                        break;
                    }
                    case ENTITY_LEASHKNOT_BREAK: {
                        soundEnum = Sound.valueOf("ENTITY_LEASHKNOT_BREAK");
                        break;
                    }
                    case ENTITY_LEASHKNOT_PLACE: {
                        soundEnum = Sound.valueOf("ENTITY_LEASHKNOT_PLACE");
                        break;
                    }
                    case ENTITY_LIGHTNING_IMPACT: {
                        soundEnum = Sound.valueOf("ENTITY_LIGHTNING_IMPACT");
                        break;
                    }
                    case ENTITY_LIGHTNING_THUNDER: {
                        soundEnum = Sound.valueOf("ENTITY_LIGHTNING_THUNDER");
                        break;
                    }
                    case ENTITY_LINGERINGPOTION_THROW: {
                        soundEnum = Sound.valueOf("ENTITY_LINGERINGPOTION_THROW");
                        break;
                    }
                    case ENTITY_MAGMACUBE_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_MAGMACUBE_DEATH");
                        break;
                    }
                    case ENTITY_MAGMACUBE_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_MAGMACUBE_HURT");
                        break;
                    }
                    case ENTITY_MAGMACUBE_JUMP: {
                        soundEnum = Sound.valueOf("ENTITY_MAGMACUBE_JUMP");
                        break;
                    }
                    case ENTITY_MAGMACUBE_SQUISH: {
                        soundEnum = Sound.valueOf("ENTITY_MAGMACUBE_SQUISH");
                        break;
                    }
                    case ENTITY_MINECART_INSIDE: {
                        soundEnum = Sound.valueOf("ENTITY_MINECART_INSIDE");
                        break;
                    }
                    case ENTITY_MINECART_RIDING: {
                        soundEnum = Sound.valueOf("ENTITY_MINECART_RIDING");
                        break;
                    }
                    case ENTITY_MOOSHROOM_SHEAR: {
                        soundEnum = Sound.valueOf("ENTITY_MOOSHROOM_SHEAR");
                        break;
                    }
                    case ENTITY_MULE_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_MULE_AMBIENT");
                        break;
                    }
                    case ENTITY_MULE_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_MULE_DEATH");
                        break;
                    }
                    case ENTITY_MULE_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_MULE_HURT");
                        break;
                    }
                    case ENTITY_PAINTING_BREAK: {
                        soundEnum = Sound.valueOf("ENTITY_PAINTING_BREAK");
                        break;
                    }
                    case ENTITY_PAINTING_PLACE: {
                        soundEnum = Sound.valueOf("ENTITY_PAINTING_PLACE");
                        break;
                    }
                    case ENTITY_PIG_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_PIG_AMBIENT");
                        break;
                    }
                    case ENTITY_PIG_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_PIG_DEATH");
                        break;
                    }
                    case ENTITY_PIG_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_PIG_HURT");
                        break;
                    }
                    case ENTITY_PIG_SADDLE: {
                        soundEnum = Sound.valueOf("ENTITY_PIG_SADDLE");
                        break;
                    }
                    case ENTITY_PIG_STEP: {
                        soundEnum = Sound.valueOf("ENTITY_PIG_STEP");
                        break;
                    }
                    case ENTITY_PLAYER_ATTACK_CRIT: {
                        soundEnum = Sound.valueOf("ENTITY_PLAYER_ATTACK_CRIT");
                        break;
                    }
                    case ENTITY_PLAYER_ATTACK_KNOCKBACK: {
                        soundEnum = Sound.valueOf("ENTITY_PLAYER_ATTACK_KNOCKBACK");
                        break;
                    }
                    case ENTITY_PLAYER_ATTACK_NODAMAGE: {
                        soundEnum = Sound.valueOf("ENTITY_PLAYER_ATTACK_NODAMAGE");
                        break;
                    }
                    case ENTITY_PLAYER_ATTACK_STRONG: {
                        soundEnum = Sound.valueOf("ENTITY_PLAYER_ATTACK_STRONG");
                        break;
                    }
                    case ENTITY_PLAYER_ATTACK_SWEEP: {
                        soundEnum = Sound.valueOf("ENTITY_PLAYER_ATTACK_SWEEP");
                        break;
                    }
                    case ENTITY_PLAYER_ATTACK_WEAK: {
                        soundEnum = Sound.valueOf("ENTITY_PLAYER_ATTACK_WEAK");
                        break;
                    }
                    case ENTITY_PLAYER_BIG_FALL: {
                        soundEnum = Sound.valueOf("ENTITY_PLAYER_BIG_FALL");
                        break;
                    }
                    case ENTITY_PLAYER_BREATH: {
                        soundEnum = Sound.valueOf("ENTITY_PLAYER_BREATH");
                        break;
                    }
                    case ENTITY_PLAYER_BURP: {
                        soundEnum = Sound.valueOf("ENTITY_PLAYER_BURP");
                        break;
                    }
                    case ENTITY_PLAYER_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_PLAYER_DEATH");
                        break;
                    }
                    case ENTITY_PLAYER_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_PLAYER_HURT");
                        break;
                    }
                    case ENTITY_PLAYER_LEVELUP: {
                        soundEnum = Sound.valueOf("ENTITY_PLAYER_LEVELUP");
                        break;
                    }
                    case ENTITY_PLAYER_SMALL_FALL: {
                        soundEnum = Sound.valueOf("ENTITY_PLAYER_SMALL_FALL");
                        break;
                    }
                    case ENTITY_PLAYER_SPLASH: {
                        soundEnum = Sound.valueOf("ENTITY_PLAYER_SPLASH");
                        break;
                    }
                    case ENTITY_PLAYER_SWIM: {
                        soundEnum = Sound.valueOf("ENTITY_PLAYER_SWIM");
                        break;
                    }
                    case ENTITY_POLAR_BEAR_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_POLAR_BEAR_AMBIENT");
                        break;
                    }
                    case ENTITY_POLAR_BEAR_BABY_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_POLAR_BEAR_BABY_AMBIENT");
                        break;
                    }
                    case ENTITY_POLAR_BEAR_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_POLAR_BEAR_DEATH");
                        break;
                    }
                    case ENTITY_POLAR_BEAR_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_POLAR_BEAR_HURT");
                        break;
                    }
                    case ENTITY_POLAR_BEAR_STEP: {
                        soundEnum = Sound.valueOf("ENTITY_POLAR_BEAR_STEP");
                        break;
                    }
                    case ENTITY_POLAR_BEAR_WARNING: {
                        soundEnum = Sound.valueOf("ENTITY_POLAR_BEAR_WARNING");
                        break;
                    }
                    case ENTITY_RABBIT_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_RABBIT_AMBIENT");
                        break;
                    }
                    case ENTITY_RABBIT_ATTACK: {
                        soundEnum = Sound.valueOf("ENTITY_RABBIT_ATTACK");
                        break;
                    }
                    case ENTITY_RABBIT_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_RABBIT_DEATH");
                        break;
                    }
                    case ENTITY_RABBIT_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_RABBIT_HURT");
                        break;
                    }
                    case ENTITY_RABBIT_JUMP: {
                        soundEnum = Sound.valueOf("ENTITY_RABBIT_JUMP");
                        break;
                    }
                    case ENTITY_SHEEP_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_SHEEP_AMBIENT");
                        break;
                    }
                    case ENTITY_SHEEP_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_SHEEP_DEATH");
                        break;
                    }
                    case ENTITY_SHEEP_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_SHEEP_HURT");
                        break;
                    }
                    case ENTITY_SHEEP_SHEAR: {
                        soundEnum = Sound.valueOf("ENTITY_SHEEP_SHEAR");
                        break;
                    }
                    case ENTITY_SHEEP_STEP: {
                        soundEnum = Sound.valueOf("ENTITY_SHEEP_STEP");
                        break;
                    }
                    case ENTITY_SHULKER_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_SHULKER_AMBIENT");
                        break;
                    }
                    case ENTITY_SHULKER_BULLET_HIT: {
                        soundEnum = Sound.valueOf("ENTITY_SHULKER_BULLET_HIT");
                        break;
                    }
                    case ENTITY_SHULKER_BULLET_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_SHULKER_BULLET_HURT");
                        break;
                    }
                    case ENTITY_SHULKER_CLOSE: {
                        soundEnum = Sound.valueOf("ENTITY_SHULKER_CLOSE");
                        break;
                    }
                    case ENTITY_SHULKER_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_SHULKER_DEATH");
                        break;
                    }
                    case ENTITY_SHULKER_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_SHULKER_HURT");
                        break;
                    }
                    case ENTITY_SHULKER_HURT_CLOSED: {
                        soundEnum = Sound.valueOf("ENTITY_SHULKER_HURT_CLOSED");
                        break;
                    }
                    case ENTITY_SHULKER_OPEN: {
                        soundEnum = Sound.valueOf("ENTITY_SHULKER_OPEN");
                        break;
                    }
                    case ENTITY_SHULKER_SHOOT: {
                        soundEnum = Sound.valueOf("ENTITY_SHULKER_SHOOT");
                        break;
                    }
                    case ENTITY_SHULKER_TELEPORT: {
                        soundEnum = Sound.valueOf("ENTITY_SHULKER_TELEPORT");
                        break;
                    }
                    case ENTITY_SILVERFISH_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_SILVERFISH_AMBIENT");
                        break;
                    }
                    case ENTITY_SILVERFISH_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_SILVERFISH_DEATH");
                        break;
                    }
                    case ENTITY_SILVERFISH_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_SILVERFISH_HURT");
                        break;
                    }
                    case ENTITY_SILVERFISH_STEP: {
                        soundEnum = Sound.valueOf("ENTITY_SILVERFISH_STEP");
                        break;
                    }
                    case ENTITY_SKELETON_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_SKELETON_AMBIENT");
                        break;
                    }
                    case ENTITY_SKELETON_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_SKELETON_DEATH");
                        break;
                    }
                    case ENTITY_SKELETON_HORSE_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_SKELETON_HORSE_AMBIENT");
                        break;
                    }
                    case ENTITY_SKELETON_HORSE_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_SKELETON_HORSE_DEATH");
                        break;
                    }
                    case ENTITY_SKELETON_HORSE_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_SKELETON_HORSE_HURT");
                        break;
                    }
                    case ENTITY_SKELETON_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_SKELETON_HURT");
                        break;
                    }
                    case ENTITY_SKELETON_SHOOT: {
                        soundEnum = Sound.valueOf("ENTITY_SKELETON_SHOOT");
                        break;
                    }
                    case ENTITY_SKELETON_STEP: {
                        soundEnum = Sound.valueOf("ENTITY_SKELETON_STEP");
                        break;
                    }
                    case ENTITY_SLIME_ATTACK: {
                        soundEnum = Sound.valueOf("ENTITY_SLIME_ATTACK");
                        break;
                    }
                    case ENTITY_SLIME_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_SLIME_DEATH");
                        break;
                    }
                    case ENTITY_SLIME_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_SLIME_HURT");
                        break;
                    }
                    case ENTITY_SLIME_JUMP: {
                        soundEnum = Sound.valueOf("ENTITY_SLIME_JUMP");
                        break;
                    }
                    case ENTITY_SLIME_SQUISH: {
                        soundEnum = Sound.valueOf("ENTITY_SLIME_SQUISH");
                        break;
                    }
                    case ENTITY_SMALL_MAGMACUBE_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_SMALL_MAGMACUBE_DEATH");
                        break;
                    }
                    case ENTITY_SMALL_MAGMACUBE_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_SMALL_MAGMACUBE_HURT");
                        break;
                    }
                    case ENTITY_SMALL_MAGMACUBE_SQUISH: {
                        soundEnum = Sound.valueOf("ENTITY_SMALL_MAGMACUBE_SQUISH");
                        break;
                    }
                    case ENTITY_SMALL_SLIME_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_SMALL_SLIME_DEATH");
                        break;
                    }
                    case ENTITY_SMALL_SLIME_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_SMALL_SLIME_HURT");
                        break;
                    }
                    case ENTITY_SMALL_SLIME_JUMP: {
                        soundEnum = Sound.valueOf("ENTITY_SMALL_SLIME_JUMP");
                        break;
                    }
                    case ENTITY_SMALL_SLIME_SQUISH: {
                        soundEnum = Sound.valueOf("ENTITY_SMALL_SLIME_SQUISH");
                        break;
                    }
                    case ENTITY_SNOWBALL_THROW: {
                        soundEnum = Sound.valueOf("ENTITY_SNOWBALL_THROW");
                        break;
                    }
                    case ENTITY_SNOWMAN_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_SNOWMAN_AMBIENT");
                        break;
                    }
                    case ENTITY_SNOWMAN_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_SNOWMAN_DEATH");
                        break;
                    }
                    case ENTITY_SNOWMAN_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_SNOWMAN_HURT");
                        break;
                    }
                    case ENTITY_SNOWMAN_SHOOT: {
                        soundEnum = Sound.valueOf("ENTITY_SNOWMAN_SHOOT");
                        break;
                    }
                    case ENTITY_SPIDER_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_SPIDER_AMBIENT");
                        break;
                    }
                    case ENTITY_SPIDER_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_SPIDER_DEATH");
                        break;
                    }
                    case ENTITY_SPIDER_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_SPIDER_HURT");
                        break;
                    }
                    case ENTITY_SPIDER_STEP: {
                        soundEnum = Sound.valueOf("ENTITY_SPIDER_STEP");
                        break;
                    }
                    case ENTITY_SPLASH_POTION_BREAK: {
                        soundEnum = Sound.valueOf("ENTITY_SPLASH_POTION_BREAK");
                        break;
                    }
                    case ENTITY_SPLASH_POTION_THROW: {
                        soundEnum = Sound.valueOf("ENTITY_SPLASH_POTION_THROW");
                        break;
                    }
                    case ENTITY_SQUID_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_SQUID_AMBIENT");
                        break;
                    }
                    case ENTITY_SQUID_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_SQUID_DEATH");
                        break;
                    }
                    case ENTITY_SQUID_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_SQUID_HURT");
                        break;
                    }
                    case ENTITY_STRAY_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_STRAY_AMBIENT");
                        break;
                    }
                    case ENTITY_STRAY_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_STRAY_DEATH");
                        break;
                    }
                    case ENTITY_STRAY_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_STRAY_HURT");
                        break;
                    }
                    case ENTITY_STRAY_STEP: {
                        soundEnum = Sound.valueOf("ENTITY_STRAY_STEP");
                        break;
                    }
                    case ENTITY_TNT_PRIMED: {
                        soundEnum = Sound.valueOf("ENTITY_TNT_PRIMED");
                        break;
                    }
                    case ENTITY_VILLAGER_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_VILLAGER_AMBIENT");
                        break;
                    }
                    case ENTITY_VILLAGER_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_VILLAGER_DEATH");
                        break;
                    }
                    case ENTITY_VILLAGER_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_VILLAGER_HURT");
                        break;
                    }
                    case ENTITY_VILLAGER_NO: {
                        soundEnum = Sound.valueOf("ENTITY_VILLAGER_NO");
                        break;
                    }
                    case ENTITY_VILLAGER_TRADING: {
                        soundEnum = Sound.valueOf("ENTITY_VILLAGER_TRADING");
                        break;
                    }
                    case ENTITY_VILLAGER_YES: {
                        soundEnum = Sound.valueOf("ENTITY_VILLAGER_YES");
                        break;
                    }
                    case ENTITY_WITCH_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_WITCH_AMBIENT");
                        break;
                    }
                    case ENTITY_WITCH_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_WITCH_DEATH");
                        break;
                    }
                    case ENTITY_WITCH_DRINK: {
                        soundEnum = Sound.valueOf("ENTITY_WITCH_DRINK");
                        break;
                    }
                    case ENTITY_WITCH_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_WITCH_HURT");
                        break;
                    }
                    case ENTITY_WITCH_THROW: {
                        soundEnum = Sound.valueOf("ENTITY_WITCH_THROW");
                        break;
                    }
                    case ENTITY_WITHER_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_WITHER_AMBIENT");
                        break;
                    }
                    case ENTITY_WITHER_BREAK_BLOCK: {
                        soundEnum = Sound.valueOf("ENTITY_WITHER_BREAK_BLOCK");
                        break;
                    }
                    case ENTITY_WITHER_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_WITHER_DEATH");
                        break;
                    }
                    case ENTITY_WITHER_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_WITHER_HURT");
                        break;
                    }
                    case ENTITY_WITHER_SHOOT: {
                        soundEnum = Sound.valueOf("ENTITY_WITHER_SHOOT");
                        break;
                    }
                    case ENTITY_WITHER_SKELETON_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_WITHER_SKELETON_AMBIENT");
                        break;
                    }
                    case ENTITY_WITHER_SKELETON_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_WITHER_SKELETON_DEATH");
                        break;
                    }
                    case ENTITY_WITHER_SKELETON_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_WITHER_SKELETON_HURT");
                        break;
                    }
                    case ENTITY_WITHER_SKELETON_STEP: {
                        soundEnum = Sound.valueOf("ENTITY_WITHER_SKELETON_STEP");
                        break;
                    }
                    case ENTITY_WITHER_SPAWN: {
                        soundEnum = Sound.valueOf("ENTITY_WITHER_SPAWN");
                        break;
                    }
                    case ENTITY_WOLF_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_WOLF_AMBIENT");
                        break;
                    }
                    case ENTITY_WOLF_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_WOLF_DEATH");
                        break;
                    }
                    case ENTITY_WOLF_GROWL: {
                        soundEnum = Sound.valueOf("ENTITY_WOLF_GROWL");
                        break;
                    }
                    case ENTITY_WOLF_HOWL: {
                        soundEnum = Sound.valueOf("ENTITY_WOLF_HOWL");
                        break;
                    }
                    case ENTITY_WOLF_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_WOLF_HURT");
                        break;
                    }
                    case ENTITY_WOLF_PANT: {
                        soundEnum = Sound.valueOf("ENTITY_WOLF_PANT");
                        break;
                    }
                    case ENTITY_WOLF_SHAKE: {
                        soundEnum = Sound.valueOf("ENTITY_WOLF_SHAKE");
                        break;
                    }
                    case ENTITY_WOLF_STEP: {
                        soundEnum = Sound.valueOf("ENTITY_WOLF_STEP");
                        break;
                    }
                    case ENTITY_WOLF_WHINE: {
                        soundEnum = Sound.valueOf("ENTITY_WOLF_WHINE");
                        break;
                    }
                    case ENTITY_ZOMBIE_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_WOLF_WHINE");
                        break;
                    }
                    case ENTITY_ZOMBIE_ATTACK_DOOR_WOOD: {
                        soundEnum = Sound.valueOf("ENTITY_ZOMBIE_ATTACK_DOOR_WOOD");
                        break;
                    }
                    case ENTITY_ZOMBIE_ATTACK_IRON_DOOR: {
                        soundEnum = Sound.valueOf("ENTITY_ZOMBIE_ATTACK_IRON_DOOR");
                        break;
                    }
                    case ENTITY_ZOMBIE_BREAK_DOOR_WOOD: {
                        soundEnum = Sound.valueOf("ENTITY_ZOMBIE_BREAK_DOOR_WOOD");
                        break;
                    }
                    case ENTITY_ZOMBIE_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_ZOMBIE_DEATH");
                        break;
                    }
                    case ENTITY_ZOMBIE_HORSE_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_ZOMBIE_HORSE_AMBIENT");
                        break;
                    }
                    case ENTITY_ZOMBIE_HORSE_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_ZOMBIE_HORSE_DEATH");
                        break;
                    }
                    case ENTITY_ZOMBIE_HORSE_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_ZOMBIE_HORSE_HURT");
                        break;
                    }
                    case ENTITY_ZOMBIE_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_ZOMBIE_HURT");
                        break;
                    }
                    case ENTITY_ZOMBIE_INFECT: {
                        soundEnum = Sound.valueOf("ENTITY_ZOMBIE_INFECT");
                        break;
                    }
                    case ENTITY_ZOMBIE_PIG_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_ZOMBIE_PIG_AMBIENT");
                        break;
                    }
                    case ENTITY_ZOMBIE_PIG_ANGRY: {
                        soundEnum = Sound.valueOf("ENTITY_ZOMBIE_PIG_ANGRY");
                        break;
                    }
                    case ENTITY_ZOMBIE_PIG_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_ZOMBIE_PIG_DEATH");
                        break;
                    }
                    case ENTITY_ZOMBIE_PIG_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_ZOMBIE_PIG_HURT");
                        break;
                    }
                    case ENTITY_ZOMBIE_STEP: {
                        soundEnum = Sound.valueOf("ENTITY_ZOMBIE_STEP");
                        break;
                    }
                    case ENTITY_ZOMBIE_VILLAGER_AMBIENT: {
                        soundEnum = Sound.valueOf("ENTITY_ZOMBIE_VILLAGER_AMBIENT");
                        break;
                    }
                    case ENTITY_ZOMBIE_VILLAGER_CONVERTED: {
                        soundEnum = Sound.valueOf("ENTITY_ZOMBIE_VILLAGER_CONVERTED");
                        break;
                    }
                    case ENTITY_ZOMBIE_VILLAGER_CURE: {
                        soundEnum = Sound.valueOf("ENTITY_ZOMBIE_VILLAGER_CURE");
                        break;
                    }
                    case ENTITY_ZOMBIE_VILLAGER_DEATH: {
                        soundEnum = Sound.valueOf("ENTITY_ZOMBIE_VILLAGER_DEATH");
                        break;
                    }
                    case ENTITY_ZOMBIE_VILLAGER_HURT: {
                        soundEnum = Sound.valueOf("ENTITY_ZOMBIE_VILLAGER_HURT");
                        break;
                    }
                    case ENTITY_ZOMBIE_VILLAGER_STEP: {
                        soundEnum = Sound.valueOf("ENTITY_ZOMBIE_VILLAGER_STEP");
                        break;
                    }
                    case ITEM_ARMOR_EQUIP_CHAIN: {
                        soundEnum = Sound.valueOf("ITEM_ARMOR_EQUIP_CHAIN");
                        break;
                    }
                    case ITEM_ARMOR_EQUIP_DIAMOND: {
                        soundEnum = Sound.valueOf("ITEM_ARMOR_EQUIP_DIAMOND");
                        break;
                    }
                    case ITEM_ARMOR_EQUIP_GENERIC: {
                        soundEnum = Sound.valueOf("ITEM_ARMOR_EQUIP_GENERIC");
                        break;
                    }
                    case ITEM_ARMOR_EQUIP_GOLD: {
                        soundEnum = Sound.valueOf("ITEM_ARMOR_EQUIP_GOLD");
                        break;
                    }
                    case ITEM_ARMOR_EQUIP_IRON: {
                        soundEnum = Sound.valueOf("ITEM_ARMOR_EQUIP_IRON");
                        break;
                    }
                    case ITEM_ARMOR_EQUIP_LEATHER: {
                        soundEnum = Sound.valueOf("ITEM_ARMOR_EQUIP_LEATHER");
                        break;
                    }
                    case ITEM_BOTTLE_FILL: {
                        soundEnum = Sound.valueOf("ITEM_BOTTLE_FILL");
                        break;
                    }
                    case ITEM_BOTTLE_FILL_DRAGONBREATH: {
                        soundEnum = Sound.valueOf("ITEM_BOTTLE_FILL_DRAGONBREATH");
                        break;
                    }
                    case ITEM_BUCKET_EMPTY: {
                        soundEnum = Sound.valueOf("ITEM_BUCKET_EMPTY");
                        break;
                    }
                    case ITEM_BUCKET_EMPTY_LAVA: {
                        soundEnum = Sound.valueOf("ITEM_BUCKET_EMPTY_LAVA");
                        break;
                    }
                    case ITEM_BUCKET_FILL: {
                        soundEnum = Sound.valueOf("ITEM_BUCKET_FILL");
                        break;
                    }
                    case ITEM_BUCKET_FILL_LAVA: {
                        soundEnum = Sound.valueOf("ITEM_BUCKET_FILL_LAVA");
                        break;
                    }
                    case ITEM_CHORUS_FRUIT_TELEPORT: {
                        soundEnum = Sound.valueOf("ITEM_CHORUS_FRUIT_TELEPORT");
                        break;
                    }
                    case ITEM_ELYTRA_FLYING: {
                        soundEnum = Sound.valueOf("ITEM_ELYTRA_FLYING");
                        break;
                    }
                    case ITEM_FIRECHARGE_USE: {
                        soundEnum = Sound.valueOf("ITEM_FIRECHARGE_USE");
                        break;
                    }
                    case ITEM_FLINTANDSTEEL_USE: {
                        soundEnum = Sound.valueOf("ITEM_FLINTANDSTEEL_USE");
                        break;
                    }
                    case ITEM_HOE_TILL: {
                        soundEnum = Sound.valueOf("ITEM_HOE_TILL");
                        break;
                    }
                    case ITEM_SHIELD_BLOCK: {
                        soundEnum = Sound.valueOf("ITEM_SHIELD_BLOCK");
                        break;
                    }
                    case ITEM_SHIELD_BREAK: {
                        soundEnum = Sound.valueOf("ITEM_SHIELD_BREAK");
                        break;
                    }
                    case ITEM_SHOVEL_FLATTEN: {
                        soundEnum = Sound.valueOf("ITEM_SHOVEL_FLATTEN");
                        break;
                    }
                    case MUSIC_CREATIVE: {
                        soundEnum = Sound.valueOf("MUSIC_CREATIVE");
                        break;
                    }
                    case MUSIC_CREDITS: {
                        soundEnum = Sound.valueOf("MUSIC_CREDITS");
                        break;
                    }
                    case MUSIC_DRAGON: {
                        soundEnum = Sound.valueOf("MUSIC_DRAGON");
                        break;
                    }
                    case MUSIC_END: {
                        soundEnum = Sound.valueOf("MUSIC_END");
                        break;
                    }
                    case MUSIC_GAME: {
                        soundEnum = Sound.valueOf("MUSIC_GAME");
                        break;
                    }
                    case MUSIC_MENU: {
                        soundEnum = Sound.valueOf("MUSIC_MENU");
                        break;
                    }
                    case MUSIC_NETHER: {
                        soundEnum = Sound.valueOf("MUSIC_NETHER");
                        break;
                    }
                    case RECORD_11: {
                        soundEnum = Sound.valueOf("RECORD_11");
                        break;
                    }
                    case RECORD_13: {
                        soundEnum = Sound.valueOf("RECORD_13");
                        break;
                    }
                    case RECORD_BLOCKS: {
                        soundEnum = Sound.valueOf("RECORD_BLOCKS");
                        break;
                    }
                    case RECORD_CAT: {
                        soundEnum = Sound.valueOf("RECORD_CAT");
                        break;
                    }
                    case RECORD_CHIRP: {
                        soundEnum = Sound.valueOf("RECORD_CHIRP");
                        break;
                    }
                    case RECORD_FAR: {
                        soundEnum = Sound.valueOf("RECORD_FAR");
                        break;
                    }
                    case RECORD_MALL: {
                        soundEnum = Sound.valueOf("RECORD_MALL");
                        break;
                    }
                    case RECORD_MELLOHI: {
                        soundEnum = Sound.valueOf("RECORD_MELLOHI");
                        break;
                    }
                    case RECORD_STAL: {
                        soundEnum = Sound.valueOf("RECORD_STAL");
                        break;
                    }
                    case RECORD_STRAD: {
                        soundEnum = Sound.valueOf("RECORD_STRAD");
                        break;
                    }
                    case RECORD_WAIT: {
                        soundEnum = Sound.valueOf("RECORD_WAIT");
                        break;
                    }
                    case RECORD_WARD: {
                        soundEnum = Sound.valueOf("RECORD_WARD");
                        break;
                    }
                    case UI_BUTTON_CLICK: {
                        soundEnum = Sound.valueOf("UI_BUTTON_CLICK");
                        break;
                    }
                    case WEATHER_RAIN: {
                        soundEnum = Sound.valueOf("WEATHER_RAIN");
                        break;
                    }
                    case WEATHER_RAIN_ABOVE: {
                        soundEnum = Sound.valueOf("WEATHER_RAIN_ABOVE");
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
