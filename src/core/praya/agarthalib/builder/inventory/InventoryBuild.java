// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.inventory;

import org.bukkit.inventory.ItemStack;
import java.util.List;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.ClickType;
import java.util.HashMap;
import core.praya.agarthalib.enums.branch.SoundEnum;
import org.bukkit.inventory.Inventory;

public class InventoryBuild
{
    private boolean isEditable;
    private Inventory inventory;
    private String closeAction;
    private SoundEnum soundClick;
    private SoundEnum soundOpen;
    private HashMap<Integer, HashMap<ClickType, String>> action;
    private HashMap<Integer, HashMap<ClickType, String>> commands;
    private HashMap<Integer, HashMap<ClickType, Boolean>> closeInventory;
    private HashMap<Integer, Boolean> slotEditable;
    
    public InventoryBuild(final Inventory inventory) {
        this.action = new HashMap<Integer, HashMap<ClickType, String>>();
        this.commands = new HashMap<Integer, HashMap<ClickType, String>>();
        this.closeInventory = new HashMap<Integer, HashMap<ClickType, Boolean>>();
        this.slotEditable = new HashMap<Integer, Boolean>();
        this.inventory = inventory;
        this.isEditable = false;
        this.closeAction = null;
        this.soundClick = SoundEnum.BLOCK_WOOD_BUTTON_CLICK_ON;
        this.soundOpen = SoundEnum.BLOCK_CHEST_OPEN;
    }
    
    public InventoryBuild(final Inventory inventory, final boolean isEditable) {
        this.action = new HashMap<Integer, HashMap<ClickType, String>>();
        this.commands = new HashMap<Integer, HashMap<ClickType, String>>();
        this.closeInventory = new HashMap<Integer, HashMap<ClickType, Boolean>>();
        this.slotEditable = new HashMap<Integer, Boolean>();
        this.inventory = inventory;
        this.isEditable = isEditable;
        this.closeAction = null;
        this.soundClick = SoundEnum.BLOCK_WOOD_BUTTON_CLICK_ON;
        this.soundOpen = SoundEnum.BLOCK_CHEST_OPEN;
    }
    
    public InventoryBuild(final Inventory inventory, final boolean isEditable, final String closeMenu) {
        this.action = new HashMap<Integer, HashMap<ClickType, String>>();
        this.commands = new HashMap<Integer, HashMap<ClickType, String>>();
        this.closeInventory = new HashMap<Integer, HashMap<ClickType, Boolean>>();
        this.slotEditable = new HashMap<Integer, Boolean>();
        this.inventory = inventory;
        this.isEditable = isEditable;
        this.closeAction = closeMenu;
        this.soundClick = SoundEnum.BLOCK_WOOD_BUTTON_CLICK_ON;
        this.soundOpen = SoundEnum.BLOCK_CHEST_OPEN;
    }
    
    public InventoryBuild(final Inventory inventory, final boolean isEditable, final String closeMenu, final SoundEnum soundClick) {
        this.action = new HashMap<Integer, HashMap<ClickType, String>>();
        this.commands = new HashMap<Integer, HashMap<ClickType, String>>();
        this.closeInventory = new HashMap<Integer, HashMap<ClickType, Boolean>>();
        this.slotEditable = new HashMap<Integer, Boolean>();
        this.inventory = inventory;
        this.isEditable = isEditable;
        this.closeAction = closeMenu;
        this.soundClick = soundClick;
        this.soundOpen = SoundEnum.BLOCK_CHEST_OPEN;
    }
    
    public InventoryBuild(final Inventory inventory, final boolean isEditable, final String closeMenu, final SoundEnum soundClick, final SoundEnum soundOpen) {
        this.action = new HashMap<Integer, HashMap<ClickType, String>>();
        this.commands = new HashMap<Integer, HashMap<ClickType, String>>();
        this.closeInventory = new HashMap<Integer, HashMap<ClickType, Boolean>>();
        this.slotEditable = new HashMap<Integer, Boolean>();
        this.inventory = inventory;
        this.isEditable = isEditable;
        this.closeAction = closeMenu;
        this.soundClick = soundClick;
        this.soundOpen = soundOpen;
    }
    
    public final void openInventory(final HumanEntity player) {
        player.openInventory(this.getInventory());
    }
    
    public final List<HumanEntity> getViewers() {
        return (List<HumanEntity>)this.getInventory().getViewers();
    }
    
    public final InventoryBuild setItem(final int slot, final ItemStack item) {
        if (this.checkSlot(slot)) {
            if (this.getInventory().getItem(slot) != null) {
                this.clear(slot);
            }
            this.getInventory().setItem(slot, item);
        }
        return this;
    }
    
    public final InventoryBuild setAction(final int slot, final String action) {
        return this.setAction(slot, null, action);
    }
    
    public final InventoryBuild setAction(final int slot, final ClickType click, final String action) {
        if (this.checkSlot(slot)) {
            if (click == null) {
                ClickType[] values;
                for (int length = (values = ClickType.values()).length, i = 0; i < length; ++i) {
                    final ClickType type = values[i];
                    this.getMapAction(slot).put(type, action);
                }
            }
            else {
                this.getMapAction(slot).put(click, action);
            }
        }
        return this;
    }
    
    public final InventoryBuild setCommand(final int slot, final String command) {
        return this.setCommand(slot, null, command);
    }
    
    public final InventoryBuild setCommand(final int slot, final ClickType click, final String command) {
        if (this.checkSlot(slot)) {
            if (click == null) {
                ClickType[] values;
                for (int length = (values = ClickType.values()).length, i = 0; i < length; ++i) {
                    final ClickType type = values[i];
                    this.getMapCommands(slot).put(type, command);
                }
            }
            else {
                this.getMapCommands(slot).put(click, command);
            }
        }
        return this;
    }
    
    public final InventoryBuild setCloseInventory(final int slot, final boolean close) {
        return this.setCloseInventory(slot, null, close);
    }
    
    public final InventoryBuild setCloseInventory(final int slot, final ClickType click, final boolean close) {
        if (this.checkSlot(slot)) {
            if (click == null) {
                ClickType[] values;
                for (int length = (values = ClickType.values()).length, i = 0; i < length; ++i) {
                    final ClickType type = values[i];
                    this.getMapCloseInventory(slot).put(type, close);
                }
            }
            else {
                this.getMapCloseInventory(slot).put(click, close);
            }
        }
        return this;
    }
    
    public final InventoryBuild setSlotEditable(final int slot, final boolean isEditable) {
        if (this.checkSlot(slot)) {
            this.slotEditable.put(slot, isEditable);
        }
        return this;
    }
    
    public final InventoryBuild setCloseAction(final String closeAction) {
        this.closeAction = closeAction;
        return this;
    }
    
    public final InventoryBuild setSoundClick(final SoundEnum sound) {
        this.soundClick = sound;
        return this;
    }
    
    public final InventoryBuild setSoundOpen(final SoundEnum sound) {
        this.soundOpen = sound;
        return this;
    }
    
    public final boolean isEditable() {
        return this.isEditable;
    }
    
    public final boolean hasCloseAction() {
        return this.closeAction != null;
    }
    
    public final boolean hasSoundClick() {
        return this.soundClick != null;
    }
    
    public final boolean hasSoundOpen() {
        return this.soundOpen != null;
    }
    
    public final boolean hasAction(final int slot, final ClickType click) {
        return this.getMapAction(slot).containsKey(click);
    }
    
    public final boolean hasCommand(final int slot, final ClickType click) {
        return this.getMapCommands(slot).containsKey(click);
    }
    
    public final boolean hasCloseInventory(final int slot, final ClickType click) {
        return this.getMapCloseInventory(slot).containsKey(click);
    }
    
    public final boolean hasSlotEditable(final int slot) {
        return this.slotEditable.containsKey(slot);
    }
    
    public final HashMap<ClickType, String> getMapAction(final int slot) {
        this.checkAction(slot);
        return this.action.get(slot);
    }
    
    public final HashMap<ClickType, String> getMapCommands(final int slot) {
        this.checkCommands(slot);
        return this.commands.get(slot);
    }
    
    public final HashMap<ClickType, Boolean> getMapCloseInventory(final int slot) {
        this.checkCloseInventory(slot);
        return this.closeInventory.get(slot);
    }
    
    public final void checkAction(final int slot) {
        if (!this.action.containsKey(slot)) {
            final HashMap<ClickType, String> emptyMap = new HashMap<ClickType, String>();
            this.action.put(slot, emptyMap);
        }
    }
    
    public final void checkCommands(final int slot) {
        if (!this.commands.containsKey(slot)) {
            final HashMap<ClickType, String> emptyMap = new HashMap<ClickType, String>();
            this.commands.put(slot, emptyMap);
        }
    }
    
    public final void checkCloseInventory(final int slot) {
        if (!this.closeInventory.containsKey(slot)) {
            final HashMap<ClickType, Boolean> emptyMap = new HashMap<ClickType, Boolean>();
            this.closeInventory.put(slot, emptyMap);
        }
    }
    
    public final boolean checkSlot(final int slot) {
        return slot >= 0 && slot < this.getInventory().getSize();
    }
    
    public final Inventory getInventory() {
        return this.inventory;
    }
    
    public final String getCloseAction() {
        return this.hasCloseAction() ? this.closeAction : null;
    }
    
    public final SoundEnum getSoundClick() {
        return this.hasSoundClick() ? this.soundClick : null;
    }
    
    public final SoundEnum getSoundOpen() {
        return this.hasSoundOpen() ? this.soundOpen : null;
    }
    
    public final String getAction(final int slot, final ClickType click) {
        return this.hasAction(slot, click) ? this.getMapAction(slot).get(click) : null;
    }
    
    public final String getCommand(final int slot, final ClickType click) {
        return this.hasCommand(slot, click) ? this.getMapCommands(slot).get(click) : null;
    }
    
    public final boolean getCloseInventory(final int slot, final ClickType click) {
        return this.hasCloseInventory(slot, click) && this.getMapCloseInventory(slot).get(click);
    }
    
    public final boolean getSlotEditable(final int slot) {
        return this.hasSlotEditable(slot) && this.slotEditable.get(slot);
    }
    
    public final boolean isItemSet(final int slot) {
        return this.getItem(slot) != null;
    }
    
    public final ItemStack getItem(final int slot) {
        return this.getInventory().getItem(slot);
    }
    
    public final InventoryBuild removeItem(final int slot) {
        this.getInventory().setItem(slot, (ItemStack)null);
        return this;
    }
    
    public final InventoryBuild removeAction(final int slot) {
        if (this.action.containsKey(slot)) {
            this.action.remove(slot);
        }
        return this;
    }
    
    public final InventoryBuild removeAction(final int slot, final ClickType click) {
        if (this.hasAction(slot, click)) {
            this.getMapAction(slot).remove(click);
        }
        return this;
    }
    
    public final InventoryBuild removeCommand(final int slot) {
        if (this.commands.containsKey(slot)) {
            this.commands.remove(slot);
        }
        return this;
    }
    
    public final InventoryBuild removeCommand(final int slot, final ClickType click) {
        if (this.hasCommand(slot, click)) {
            this.getMapCommands(slot).remove(click);
        }
        return this;
    }
    
    public final InventoryBuild removeSlotEditable(final int slot) {
        if (this.hasSlotEditable(slot)) {
            this.slotEditable.remove(slot);
        }
        return this;
    }
    
    public final InventoryBuild clear(final int slot) {
        this.removeItem(slot);
        this.removeAction(slot);
        this.removeCommand(slot);
        this.removeSlotEditable(slot);
        return this;
    }
}
