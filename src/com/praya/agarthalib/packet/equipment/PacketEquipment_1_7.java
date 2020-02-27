// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.packet.equipment;

import org.bukkit.inventory.PlayerInventory;
import org.bukkit.entity.LivingEntity;
import core.praya.agarthalib.enums.main.Slot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;
import com.praya.agarthalib.AgarthaLib;
import core.praya.agarthalib.builder.bridge.EquipmentTools;
import com.praya.agarthalib.handler.HandlerPacket;

public class PacketEquipment_1_7 extends HandlerPacket implements EquipmentTools
{
    public PacketEquipment_1_7(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @Override
    public ItemStack getEquipment(final Player player, final int id) {
        return this.getEquipment(player, Slot.get(id));
    }
    
    @Override
    public ItemStack getEquipment(final Player player, final Slot slot) {
        if (player == null || slot == null) {
            return null;
        }
        switch (slot) {
            case MAINHAND: {
                return player.getInventory().getItemInHand();
            }
            case OFFHAND: {
                return null;
            }
            case HELMET: {
                return player.getInventory().getHelmet();
            }
            case CHESTPLATE: {
                return player.getInventory().getChestplate();
            }
            case LEGGINGS: {
                return player.getInventory().getLeggings();
            }
            case BOOTS: {
                return player.getInventory().getBoots();
            }
            default: {
                return null;
            }
        }
    }
    
    @Override
    public ItemStack getEquipment(final LivingEntity livingEntity, final int id) {
        return this.getEquipment(livingEntity, Slot.get(id));
    }
    
    @Override
    public ItemStack getEquipment(final LivingEntity livingEntity, final Slot slot) {
        if (livingEntity == null || slot == null) {
            return null;
        }
        switch (slot) {
            case MAINHAND: {
                return livingEntity.getEquipment().getItemInHand();
            }
            case OFFHAND: {
                return null;
            }
            case HELMET: {
                return livingEntity.getEquipment().getHelmet();
            }
            case CHESTPLATE: {
                return livingEntity.getEquipment().getChestplate();
            }
            case LEGGINGS: {
                return livingEntity.getEquipment().getLeggings();
            }
            case BOOTS: {
                return livingEntity.getEquipment().getBoots();
            }
            default: {
                return null;
            }
        }
    }
    
    @Override
    public ItemStack getEquipment(final PlayerInventory inventory, final int id) {
        return this.getEquipment(inventory, Slot.get(id));
    }
    
    @Override
    public ItemStack getEquipment(final PlayerInventory inventory, final Slot slot) {
        if (inventory == null || slot == null) {
            return null;
        }
        switch (slot) {
            case MAINHAND: {
                return inventory.getItemInHand();
            }
            case OFFHAND: {
                return null;
            }
            case HELMET: {
                return inventory.getHelmet();
            }
            case CHESTPLATE: {
                return inventory.getChestplate();
            }
            case LEGGINGS: {
                return inventory.getLeggings();
            }
            case BOOTS: {
                return inventory.getBoots();
            }
            default: {
                return null;
            }
        }
    }
    
    @Override
    public void setEquipment(final Player player, final ItemStack item, final int id) {
        this.setEquipment(player, item, Slot.get(id));
    }
    
    @Override
    public void setEquipment(final Player player, final ItemStack item, final Slot slot) {
        if (player == null || slot == null) {
            return;
        }
        switch (slot) {
            case MAINHAND: {
                player.setItemInHand(item);
            }
            case OFFHAND: {}
            case HELMET: {
                player.getInventory().setHelmet(item);
            }
            case CHESTPLATE: {
                player.getInventory().setChestplate(item);
            }
            case LEGGINGS: {
                player.getInventory().setLeggings(item);
            }
            case BOOTS: {
                player.getInventory().setBoots(item);
            }
            default: {}
        }
    }
    
    @Override
    public void setEquipment(final LivingEntity livingEntity, final ItemStack item, final int id) {
        this.setEquipment(livingEntity, item, Slot.get(id));
    }
    
    @Override
    public void setEquipment(final LivingEntity livingEntity, final ItemStack item, final Slot slot) {
        if (livingEntity == null || slot == null) {
            return;
        }
        switch (slot) {
            case MAINHAND: {
                livingEntity.getEquipment().setItemInHand(item);
            }
            case OFFHAND: {}
            case HELMET: {
                livingEntity.getEquipment().setHelmet(item);
            }
            case CHESTPLATE: {
                livingEntity.getEquipment().setChestplate(item);
            }
            case LEGGINGS: {
                livingEntity.getEquipment().setLeggings(item);
            }
            case BOOTS: {
                livingEntity.getEquipment().setBoots(item);
            }
            default: {}
        }
    }
    
    @Override
    public void setEquipment(final PlayerInventory inventory, final ItemStack item, final int id) {
        this.setEquipment(inventory, item, Slot.get(id));
    }
    
    @Override
    public void setEquipment(final PlayerInventory inventory, final ItemStack item, final Slot slot) {
        if (inventory == null || slot == null) {
            return;
        }
        switch (slot) {
            case MAINHAND: {
                inventory.setItemInHand(item);
            }
            case OFFHAND: {}
            case HELMET: {
                inventory.setHelmet(item);
            }
            case CHESTPLATE: {
                inventory.setChestplate(item);
            }
            case LEGGINGS: {
                inventory.setLeggings(item);
            }
            case BOOTS: {
                inventory.setBoots(item);
            }
            default: {}
        }
    }
}
