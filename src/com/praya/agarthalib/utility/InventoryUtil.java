// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import org.bukkit.event.inventory.InventoryType;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.entity.Player;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Inventory;

public class InventoryUtil
{
    public static final void removeItem(final Inventory inventory, final ItemStack item) {
        if (inventory != null && item != null) {
            removeItem(inventory, item, 1);
        }
    }
    
    public static final void removeItem(final Inventory inventory, final ItemStack item, int total) {
        if (inventory != null && item != null) {
            final ItemStack[] contents = inventory.getContents();
            for (int t = 0; t < contents.length && total > 0; ++t) {
                final ItemStack content = contents[t];
                if (content != null && content.isSimilar(item)) {
                    final int amount = content.getAmount();
                    if (total < amount) {
                        final int leftContent = amount - total;
                        EquipmentUtil.setAmount(content, leftContent);
                        return;
                    }
                    inventory.setItem(t, (ItemStack)null);
                    total -= amount;
                }
            }
        }
    }
    
    public static final void setItem(final Inventory inventory, final int slot, final ItemStack item) {
        if (inventory != null && item != null) {
            final int size = inventory.getSize();
            if (slot < size) {
                inventory.setItem(slot, item);
            }
        }
    }
    
    public static final void addItem(final Inventory inventory, final ItemStack item) {
        addItem(inventory, item, 1);
    }
    
    public static final void addItem(final Inventory inventory, final ItemStack item, final int amount) {
        if (inventory != null && item != null) {
            final ItemStack clone = item.clone();
            clone.setAmount(amount);
            inventory.addItem(new ItemStack[] { clone });
        }
    }
    
    @Deprecated
    public static final int getFirstSlot(final Inventory inventory, final ItemStack item) {
        if (inventory != null && item != null) {
            final ItemStack[] contents = inventory.getContents();
            for (int index = 0; index < contents.length; ++index) {
                final ItemStack content = contents[index];
                if (content != null && content.isSimilar(item)) {
                    return index;
                }
            }
        }
        return -1;
    }
    
    public static final int getFirstSlotItem(final Inventory inventory) {
        return getFirstSlotItem(inventory, null);
    }
    
    public static final int getFirstSlotItem(final Inventory inventory, final ItemStack item) {
        if (inventory != null) {
            final ItemStack[] contents = inventory.getContents();
            for (int index = 0; index < contents.length; ++index) {
                final ItemStack content = contents[index];
                if (content != null && (item == null || content.isSimilar(item))) {
                    return index;
                }
            }
        }
        return -1;
    }
    
    public static final int getFirstSlotMaterial(final Inventory inventory, final Material material) {
        if (inventory != null) {
            final ItemStack[] contents = inventory.getContents();
            for (int index = 0; index < contents.length; ++index) {
                final ItemStack content = contents[index];
                if (content != null) {
                    final Material contentMaterial = content.getType();
                    if (material == null || contentMaterial.equals((Object)material)) {
                        return index;
                    }
                }
            }
        }
        return -1;
    }
    
    @Deprecated
    public static final int getSlot(final Inventory inventory, final ItemStack item) {
        final ItemStack[] contents = inventory.getContents();
        for (int t = 0; t < contents.length; ++t) {
            final ItemStack content = contents[t];
            if (EquipmentUtil.isSolid(content) && item.isSimilar(content)) {
                return t;
            }
        }
        return -1;
    }
    
    @Deprecated
    public static final int getAvailable(final Inventory inventory, final ItemStack item) {
        return getAvailableItem(inventory, item);
    }
    
    public static final int getAvailableItem(final Inventory inventory, final ItemStack item) {
        int available = 0;
        if (inventory != null && item != null) {
            final int maxStackSize = item.getMaxStackSize();
            ItemStack[] contents;
            for (int length = (contents = inventory.getContents()).length, i = 0; i < length; ++i) {
                final ItemStack content = contents[i];
                if (content != null) {
                    if (content.isSimilar(item)) {
                        final int amount = content.getAmount();
                        final int slot = maxStackSize - amount;
                        available += slot;
                    }
                }
                else {
                    available += maxStackSize;
                }
            }
        }
        return available;
    }
    
    public static final int getAvailableItemBackpack(final Player player, final ItemStack item) {
        int available = 0;
        if (player != null && item != null) {
            final PlayerInventory inventory = player.getInventory();
            final ItemStack[] contents = inventory.getContents();
            final int maxStackSize = item.getMaxStackSize();
            for (int i = 0; i < 36; ++i) {
                final ItemStack content = contents[i];
                if (content != null) {
                    if (content.isSimilar(item)) {
                        final int amount = content.getAmount();
                        final int slot = maxStackSize - amount;
                        available += slot;
                    }
                }
                else {
                    available += maxStackSize;
                }
            }
        }
        return available;
    }
    
    public static final int getCountItem(final Inventory inventory, final ItemStack item) {
        int count = 0;
        if (inventory != null && item != null) {
            final ItemStack[] contents = inventory.getContents();
            ItemStack[] array;
            for (int length = (array = contents).length, i = 0; i < length; ++i) {
                final ItemStack content = array[i];
                if (content != null && content.isSimilar(item)) {
                    count += EquipmentUtil.getAmount(content);
                }
            }
        }
        return count;
    }
    
    public static final int getCountItemBackpack(final Player player, final ItemStack item) {
        int count = 0;
        if (player != null && item != null) {
            final PlayerInventory inventory = player.getInventory();
            final ItemStack[] contents = inventory.getContents();
            for (int i = 0; i < 36; ++i) {
                final ItemStack content = contents[i];
                if (content != null && content.isSimilar(item)) {
                    count += EquipmentUtil.getAmount(content);
                }
            }
        }
        return count;
    }
    
    public static final boolean hasEmptySlot(final Inventory inventory) {
        return getFirstEmpty(inventory) != -1;
    }
    
    public static final int getFirstEmpty(final Inventory inventory) {
        if (inventory != null) {
            final ItemStack[] contents = inventory.getContents();
            for (int i = 0; i < contents.length; ++i) {
                final ItemStack content = contents[i];
                if (content == null) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    @Deprecated
    public static final int getFirstEmpty(final PlayerInventory inventory) {
        if (inventory != null) {
            final ItemStack[] contents = inventory.getContents();
            for (int i = 0; i < 36; ++i) {
                final ItemStack content = contents[i];
                if (content == null) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    public static final int getFirstEmptyBackpack(final PlayerInventory inventory) {
        if (inventory != null) {
            final ItemStack[] contents = inventory.getContents();
            for (int i = 0; i < 36; ++i) {
                final ItemStack content = contents[i];
                if (content == null) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    public static final int getFirstEmptyHotbar(final PlayerInventory inventory) {
        if (inventory != null) {
            final ItemStack[] contents = inventory.getContents();
            for (int i = 0; i < 9; ++i) {
                final ItemStack content = contents[i];
                if (content == null) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    public static final List<Integer> getListEmptySlot(final Inventory inventory) {
        final List<Integer> list = new ArrayList<Integer>();
        if (inventory != null) {
            final ItemStack[] contents = inventory.getContents();
            for (int i = 0; i < inventory.getSize(); ++i) {
                final ItemStack content = contents[i];
                if (content == null) {
                    list.add(i);
                }
            }
        }
        return list;
    }
    
    public static final int getTotalEmpty(final Inventory inventory) {
        return getListEmptySlot(inventory).size();
    }
    
    public static final boolean containsItem(final Inventory inventory, final ItemStack item) {
        return containsItem(inventory, item, 1);
    }
    
    public static final boolean containsItem(final Inventory inventory, final ItemStack item, final int total) {
        if (inventory != null && item != null) {
            final int count = getCountItem(inventory, item);
            return count >= total;
        }
        return false;
    }
    
    public static final boolean containsMaterial(final Inventory inventory, final Material material) {
        if (inventory != null && material != null) {
            ItemStack[] contents;
            for (int length = (contents = inventory.getContents()).length, i = 0; i < length; ++i) {
                final ItemStack item = contents[i];
                if (item != null && item.getType().equals((Object)material)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Deprecated
    public static final int getFirstMaterial(final Inventory inventory, final Material material) {
        if (inventory != null && material != null) {
            final ItemStack[] contents = inventory.getContents();
            for (int t = 0; t < contents.length; ++t) {
                final ItemStack content = contents[t];
                if (content != null && content.getType().equals((Object)material)) {
                    return t;
                }
            }
        }
        return -1;
    }
    
    public static final boolean isInside(final InventoryType.SlotType slot) {
        return slot != null && !slot.equals((Object)InventoryType.SlotType.OUTSIDE);
    }
    
    public static final boolean isStorage(final Inventory inventory) {
        return inventory != null && inventory.getType().equals((Object)InventoryType.CHEST);
    }
    
    public static final boolean isBackpack(final Inventory inventory) {
        return inventory != null && inventory.getType().equals((Object)InventoryType.PLAYER);
    }
}
