// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.menu;

import org.bukkit.event.inventory.ClickType;
import java.util.HashSet;
import java.util.Collection;
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class MenuSlotAction
{
    private final List<String> commandPlayer;
    private final List<String> commandAdmin;
    private final List<String> commandConsole;
    private String[] arguments;
    private String openMenu;
    private boolean closed;
    
    public MenuSlotAction() {
        this(null, null, false);
    }
    
    public MenuSlotAction(final String fullArguments) {
        this(fullArguments, null, false);
    }
    
    public MenuSlotAction(final String fullArguments, final boolean closed) {
        this(fullArguments, null, closed);
    }
    
    public MenuSlotAction(final String fullArguments, final String openMenu, final boolean closed) {
        this.commandPlayer = new ArrayList<String>();
        this.commandAdmin = new ArrayList<String>();
        this.commandConsole = new ArrayList<String>();
        this.arguments = (String[])((fullArguments != null) ? fullArguments.split(" ") : null);
        this.openMenu = openMenu;
        this.closed = closed;
    }
    
    public final List<String> getPlayerCommands() {
        return this.commandPlayer;
    }
    
    public final List<String> getAdminCommands() {
        return this.commandAdmin;
    }
    
    public final List<String> getConsoleCommands() {
        return this.commandConsole;
    }
    
    public final boolean hasPlayerCommand() {
        return !this.commandPlayer.isEmpty();
    }
    
    public final boolean hasAdminCommand() {
        return !this.commandAdmin.isEmpty();
    }
    
    public final boolean hasConsoleCommand() {
        return !this.commandConsole.isEmpty();
    }
    
    public final MenuSlotAction addPlayerCommand(final String command) {
        if (command != null) {
            this.commandPlayer.add(command);
        }
        return this;
    }
    
    public final MenuSlotAction addAdminCommand(final String command) {
        if (command != null) {
            this.commandAdmin.add(command);
        }
        return this;
    }
    
    public final MenuSlotAction addConsoleCommand(final String command) {
        if (command != null) {
            this.commandConsole.add(command);
        }
        return this;
    }
    
    public final MenuSlotAction clearPlayerCommand() {
        this.commandPlayer.clear();
        return this;
    }
    
    public final MenuSlotAction clearAdminCommand() {
        this.commandAdmin.clear();
        return this;
    }
    
    public final MenuSlotAction clearConsoleCommand() {
        this.commandConsole.clear();
        return this;
    }
    
    public final String[] getArguments() {
        return this.arguments;
    }
    
    public final boolean hasArguments() {
        return this.arguments != null;
    }
    
    public final MenuSlotAction setArguments(final String fullArguments) {
        this.arguments = (String[])((fullArguments != null) ? fullArguments.split(" ") : null);
        return this;
    }
    
    public final MenuSlotAction setArguments(final String... arguments) {
        this.arguments = arguments;
        return this;
    }
    
    public final MenuSlotAction clearArguments() {
        this.arguments = new String[0];
        return this;
    }
    
    public final String getOpenMenu() {
        return this.openMenu;
    }
    
    public final boolean hasOpenMenu() {
        return this.openMenu != null;
    }
    
    public final MenuSlotAction setOpenMenu(final String menu) {
        this.openMenu = menu;
        return this;
    }
    
    public final boolean isClosed() {
        return this.closed;
    }
    
    public final MenuSlotAction setClosed(final boolean flag) {
        this.closed = flag;
        return this;
    }
    
    public enum ActionCategory
    {
        ALL((Collection<ActionType>)Arrays.asList(ActionType.RIGHT_CLICK, ActionType.LEFT_CLICK, ActionType.SHIFT_RIGHT_CLICK, ActionType.SHIFT_LEFT_CLICK, ActionType.HOTBAR_1, ActionType.HOTBAR_2, ActionType.HOTBAR_3, ActionType.HOTBAR_4, ActionType.HOTBAR_5, ActionType.HOTBAR_6, ActionType.HOTBAR_7, ActionType.HOTBAR_8, ActionType.HOTBAR_9)), 
        ALL_CLICK((Collection<ActionType>)Arrays.asList(ActionType.RIGHT_CLICK, ActionType.LEFT_CLICK, ActionType.SHIFT_RIGHT_CLICK, ActionType.SHIFT_LEFT_CLICK)), 
        ALL_RIGHT_CLICK((Collection<ActionType>)Arrays.asList(ActionType.RIGHT_CLICK, ActionType.SHIFT_RIGHT_CLICK)), 
        ALL_LEFT_CLICK((Collection<ActionType>)Arrays.asList(ActionType.LEFT_CLICK, ActionType.SHIFT_LEFT_CLICK)), 
        ALL_HOTBAR((Collection<ActionType>)Arrays.asList(ActionType.HOTBAR_1, ActionType.HOTBAR_2, ActionType.HOTBAR_3, ActionType.HOTBAR_4, ActionType.HOTBAR_5, ActionType.HOTBAR_6, ActionType.HOTBAR_7, ActionType.HOTBAR_8, ActionType.HOTBAR_9));
        
        private final Set<ActionType> actionTypes;
        
        private ActionCategory(final Collection<ActionType> actionTypes) {
            this.actionTypes = new HashSet<ActionType>(actionTypes);
        }
        
        public final Set<ActionType> getActionTypes() {
            return this.actionTypes;
        }
    }
    
    public enum ActionType
    {
        RIGHT_CLICK("RIGHT_CLICK", 0), 
        LEFT_CLICK("LEFT_CLICK", 1), 
        MIDDLE_CLICK("MIDDLE_CLICK", 2), 
        SHIFT_LEFT_CLICK("SHIFT_LEFT_CLICK", 3), 
        SHIFT_RIGHT_CLICK("SHIFT_RIGHT_CLICK", 4), 
        HOTBAR_1("HOTBAR_1", 5), 
        HOTBAR_2("HOTBAR_2", 6), 
        HOTBAR_3("HOTBAR_3", 7), 
        HOTBAR_4("HOTBAR_4", 8), 
        HOTBAR_5("HOTBAR_5", 9), 
        HOTBAR_6("HOTBAR_6", 10), 
        HOTBAR_7("HOTBAR_7", 11), 
        HOTBAR_8("HOTBAR_8", 12), 
        HOTBAR_9("HOTBAR_9", 13);
        
        private ActionType(final String name, final int ordinal) {
        }
        
        public static final ActionType getActionType(final ClickType clickType) {
            return getActionType(clickType, -1);
        }
        
        public static final ActionType getActionType(final ClickType clickType, final int data) {
            if (clickType.equals((Object)ClickType.NUMBER_KEY)) {
                switch (data) {
                    case 0: {
                        return ActionType.HOTBAR_1;
                    }
                    case 1: {
                        return ActionType.HOTBAR_2;
                    }
                    case 2: {
                        return ActionType.HOTBAR_3;
                    }
                    case 3: {
                        return ActionType.HOTBAR_4;
                    }
                    case 4: {
                        return ActionType.HOTBAR_5;
                    }
                    case 5: {
                        return ActionType.HOTBAR_6;
                    }
                    case 6: {
                        return ActionType.HOTBAR_7;
                    }
                    case 7: {
                        return ActionType.HOTBAR_8;
                    }
                    case 8: {
                        return ActionType.HOTBAR_9;
                    }
                    default: {
                        return null;
                    }
                }
            }
            else {
                switch (clickType) {
                    case LEFT: {
                        return ActionType.LEFT_CLICK;
                    }
                    case RIGHT: {
                        return ActionType.RIGHT_CLICK;
                    }
                    case MIDDLE: {
                        return ActionType.MIDDLE_CLICK;
                    }
                    case SHIFT_LEFT: {
                        return ActionType.SHIFT_LEFT_CLICK;
                    }
                    case SHIFT_RIGHT: {
                        return ActionType.SHIFT_RIGHT_CLICK;
                    }
                    default: {
                        return null;
                    }
                }
            }
        }
    }
}
