// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.menu;

import java.util.List;
import java.util.Iterator;
import core.praya.agarthalib.builder.item.ItemSingle;
import org.bukkit.inventory.ItemStack;
import java.util.concurrent.ConcurrentHashMap;
import core.praya.agarthalib.builder.item.Item;
import java.util.Map;

public class MenuSlot
{
    private final int slot;
    private final Map<MenuSlotAction.ActionType, MenuSlotAction> mapActions;
    private Item item;
    private Boolean editable;
    
    public MenuSlot(final int slot) {
        this(slot, null);
    }
    
    public MenuSlot(final int slot, final Boolean editable) {
        this.slot = slot;
        this.editable = editable;
        this.mapActions = new ConcurrentHashMap<MenuSlotAction.ActionType, MenuSlotAction>();
    }
    
    public final int getSlot() {
        return this.slot;
    }
    
    public final Item getItem() {
        return this.item;
    }
    
    public final boolean hasItem() {
        return this.item != null;
    }
    
    public final MenuSlot setItem(final ItemStack item) {
        this.item = new ItemSingle(item);
        return this;
    }
    
    public final MenuSlot setItem(final Item item) {
        this.item = item;
        return this;
    }
    
    public final Boolean isEditable() {
        return this.editable;
    }
    
    public final boolean isEditableFlagExists() {
        return this.editable != null;
    }
    
    public final MenuSlot setEditable(final Boolean flag) {
        this.editable = flag;
        return this;
    }
    
    public final MenuSlotAction getMenuSlotAction(final MenuSlotAction.ActionType type) {
        return this.mapActions.get(type);
    }
    
    public final boolean hasMenuSlotAction(final MenuSlotAction.ActionType type) {
        return this.mapActions.containsKey(type);
    }
    
    public final MenuSlot setMenuSlotAction(final MenuSlotAction.ActionType type, final MenuSlotAction action) {
        this.mapActions.put(type, action);
        return this;
    }
    
    public final MenuSlot setMenuSlotAction(final MenuSlotAction.ActionCategory category, final MenuSlotAction action) {
        for (final MenuSlotAction.ActionType type : category.getActionTypes()) {
            this.setMenuSlotAction(type, action);
        }
        return this;
    }
    
    public final MenuSlot addPlayerCommand(final MenuSlotAction.ActionCategory category, final String command) {
        for (final MenuSlotAction.ActionType type : category.getActionTypes()) {
            this.addPlayerCommand(type, command);
        }
        return this;
    }
    
    public final MenuSlot addPlayerCommand(final MenuSlotAction.ActionType type, final String command) {
        if (!this.hasMenuSlotAction(type)) {
            final MenuSlotAction action = new MenuSlotAction();
            action.addPlayerCommand(command);
            this.setMenuSlotAction(type, action);
        }
        else {
            final MenuSlotAction action = this.getMenuSlotAction(type);
            action.addPlayerCommand(command);
        }
        return this;
    }
    
    public final MenuSlot addPlayerCommands(final MenuSlotAction.ActionCategory category, final List<String> commands) {
        for (final MenuSlotAction.ActionType type : category.getActionTypes()) {
            this.addPlayerCommands(type, commands);
        }
        return this;
    }
    
    public final MenuSlot addPlayerCommands(final MenuSlotAction.ActionType type, final List<String> commands) {
        if (!this.hasMenuSlotAction(type)) {
            final MenuSlotAction action = new MenuSlotAction();
            for (final String command : commands) {
                action.addPlayerCommand(command);
            }
            this.setMenuSlotAction(type, action);
        }
        else {
            final MenuSlotAction action = this.getMenuSlotAction(type);
            for (final String command : commands) {
                action.addPlayerCommand(command);
            }
        }
        return this;
    }
    
    public final MenuSlot addAdminCommand(final MenuSlotAction.ActionCategory category, final String command) {
        for (final MenuSlotAction.ActionType type : category.getActionTypes()) {
            this.addAdminCommand(type, command);
        }
        return this;
    }
    
    public final MenuSlot addAdminCommand(final MenuSlotAction.ActionType type, final String command) {
        if (!this.hasMenuSlotAction(type)) {
            final MenuSlotAction action = new MenuSlotAction();
            action.addAdminCommand(command);
            this.setMenuSlotAction(type, action);
        }
        else {
            final MenuSlotAction action = this.getMenuSlotAction(type);
            action.addAdminCommand(command);
        }
        return this;
    }
    
    public final MenuSlot addAdminCommands(final MenuSlotAction.ActionCategory category, final List<String> commands) {
        for (final MenuSlotAction.ActionType type : category.getActionTypes()) {
            this.addAdminCommands(type, commands);
        }
        return this;
    }
    
    public final MenuSlot addAdminCommands(final MenuSlotAction.ActionType type, final List<String> commands) {
        if (!this.hasMenuSlotAction(type)) {
            final MenuSlotAction action = new MenuSlotAction();
            for (final String command : commands) {
                action.addAdminCommand(command);
            }
            this.setMenuSlotAction(type, action);
        }
        else {
            final MenuSlotAction action = this.getMenuSlotAction(type);
            for (final String command : commands) {
                action.addAdminCommand(command);
            }
        }
        return this;
    }
    
    public final MenuSlot addConsoleCommand(final MenuSlotAction.ActionCategory category, final String command) {
        for (final MenuSlotAction.ActionType type : category.getActionTypes()) {
            this.addConsoleCommand(type, command);
        }
        return this;
    }
    
    public final MenuSlot addConsoleCommand(final MenuSlotAction.ActionType type, final String command) {
        if (!this.hasMenuSlotAction(type)) {
            final MenuSlotAction action = new MenuSlotAction();
            action.addConsoleCommand(command);
            this.setMenuSlotAction(type, action);
        }
        else {
            final MenuSlotAction action = this.getMenuSlotAction(type);
            action.addConsoleCommand(command);
        }
        return this;
    }
    
    public final MenuSlot addConsoleCommands(final MenuSlotAction.ActionCategory category, final List<String> commands) {
        for (final MenuSlotAction.ActionType type : category.getActionTypes()) {
            this.addConsoleCommands(type, commands);
        }
        return this;
    }
    
    public final MenuSlot addConsoleCommands(final MenuSlotAction.ActionType type, final List<String> commands) {
        if (!this.hasMenuSlotAction(type)) {
            final MenuSlotAction action = new MenuSlotAction();
            for (final String command : commands) {
                action.addConsoleCommand(command);
            }
            this.setMenuSlotAction(type, action);
        }
        else {
            final MenuSlotAction action = this.getMenuSlotAction(type);
            for (final String command : commands) {
                action.addConsoleCommand(command);
            }
        }
        return this;
    }
    
    public final MenuSlot setActionArguments(final MenuSlotAction.ActionCategory category, final String fullArguments) {
        return this.setActionArguments(category, (String[])((fullArguments != null) ? fullArguments.split(" ") : null));
    }
    
    public final MenuSlot setActionArguments(final MenuSlotAction.ActionCategory category, final String[] arguments) {
        for (final MenuSlotAction.ActionType type : category.getActionTypes()) {
            this.setActionArguments(type, arguments);
        }
        return this;
    }
    
    public final MenuSlot setActionArguments(final MenuSlotAction.ActionType type, final String fullArguments) {
        return this.setActionArguments(type, (String[])((fullArguments != null) ? fullArguments.split(" ") : null));
    }
    
    public final MenuSlot setActionArguments(final MenuSlotAction.ActionType type, final String[] arguments) {
        if (!this.hasMenuSlotAction(type)) {
            final MenuSlotAction action = new MenuSlotAction();
            action.setArguments(arguments);
            this.setMenuSlotAction(type, action);
        }
        else {
            final MenuSlotAction action = this.getMenuSlotAction(type);
            action.setArguments(arguments);
        }
        return this;
    }
    
    public final MenuSlot setActionOpenMenu(final MenuSlotAction.ActionCategory category, final String openMenu) {
        for (final MenuSlotAction.ActionType type : category.getActionTypes()) {
            this.setActionOpenMenu(type, openMenu);
        }
        return this;
    }
    
    public final MenuSlot setActionOpenMenu(final MenuSlotAction.ActionType type, final String openMenu) {
        if (!this.hasMenuSlotAction(type)) {
            final MenuSlotAction action = new MenuSlotAction();
            action.setOpenMenu(openMenu);
            this.setMenuSlotAction(type, action);
        }
        else {
            final MenuSlotAction action = this.getMenuSlotAction(type);
            action.setOpenMenu(openMenu);
        }
        return this;
    }
    
    public final MenuSlot setActionClosed(final MenuSlotAction.ActionCategory category, final boolean flag) {
        for (final MenuSlotAction.ActionType type : category.getActionTypes()) {
            this.setActionClosed(type, flag);
        }
        return this;
    }
    
    public final MenuSlot setActionClosed(final MenuSlotAction.ActionType type, final boolean flag) {
        if (!this.hasMenuSlotAction(type)) {
            final MenuSlotAction action = new MenuSlotAction();
            action.setClosed(flag);
            this.setMenuSlotAction(type, action);
        }
        else {
            final MenuSlotAction action = this.getMenuSlotAction(type);
            action.setClosed(flag);
        }
        return this;
    }
}
