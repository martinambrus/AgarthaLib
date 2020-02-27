// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.menu;

import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;
import org.bukkit.inventory.ItemStack;
import core.praya.agarthalib.builder.item.Item;
import java.util.Collection;
import org.bukkit.event.Event;
import com.praya.agarthalib.utility.ServerEventUtil;
import com.praya.agarthalib.event.MenuCreateEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import com.praya.agarthalib.utility.ServerUtil;
import core.praya.agarthalib.enums.main.VersionNMS;
import com.praya.agarthalib.utility.TextUtil;
import com.praya.agarthalib.utility.MathUtil;
import java.util.concurrent.ConcurrentHashMap;
import core.praya.agarthalib.builder.text.Text;
import core.praya.agarthalib.builder.text.TextLine;
import org.bukkit.entity.Player;
import java.util.Map;
import org.bukkit.inventory.Inventory;

public class MenuGUI extends Menu
{
    private final String id;
    private final Inventory inventory;
    private final MenuProperties properties;
    private final Map<Integer, MenuSlot> mapSlot;
    private Player owner;
    private MenuExecutor executor;
    
    public MenuGUI(final Player owner, final int row) {
        this(owner, "Default", row, new TextLine("Menu"), null, false);
    }
    
    public MenuGUI(final Player owner, final String id, final int row) {
        this(owner, id, row, new TextLine("Menu"), null, false);
    }
    
    public MenuGUI(final Player owner, final String id, final int row, final String title) {
        this(owner, id, row, new TextLine(title), null, false);
    }
    
    public MenuGUI(final Player owner, final String id, final int row, final Text title) {
        this(owner, id, row, title, null, false);
    }
    
    public MenuGUI(final Player owner, final String id, final int row, final Text title, final boolean editable) {
        this(owner, id, row, title, null, editable);
    }
    
    public MenuGUI(final Player owner, final String id, final int row, final Text title, final MenuExecutor executor, final boolean editable) {
        this(owner, id, row, title, executor, editable, new ConcurrentHashMap<Integer, MenuSlot>());
    }
    
    public MenuGUI(final Player owner, final String id, final int row, final Text title, final MenuExecutor executor, final boolean editable, final Map<Integer, MenuSlot> mapSlot) {
        final MenuProperties properties = new MenuProperties(title, editable);
        final int size = MathUtil.limitInteger(row, 1, 6) * 9;
        final String titleText = (title != null) ? TextUtil.colorful(title.getText()) : "Menu";
        final String header = ServerUtil.isCompatible(VersionNMS.V1_9_R2) ? titleText : ((titleText.length() > 32) ? titleText.substring(0, 32) : titleText);
        this.id = id;
        this.owner = owner;
        this.properties = properties;
        this.executor = executor;
        this.mapSlot = mapSlot;
        this.inventory = Bukkit.createInventory((InventoryHolder)this, size, header);
        final MenuCreateEvent menuCreateEvent = new MenuCreateEvent(this);
        ServerEventUtil.callEvent(menuCreateEvent);
    }
    
    @Override
    public String getID() {
        return this.id;
    }
    
    @Override
    public Player getOwner() {
        return this.owner;
    }
    
    @Override
    public boolean hasOwner() {
        return this.owner != null;
    }
    
    @Override
    public void setOwner(final Player owner) {
        this.owner = owner;
    }
    
    @Override
    public boolean isOwner(final Player player) {
        return this.owner != null && this.owner.equals(player);
    }
    
    @Override
    public MenuProperties getProperties() {
        return this.properties;
    }
    
    @Override
    public MenuExecutor getExecutor() {
        return this.executor;
    }
    
    @Override
    public boolean hasExecutor() {
        return this.executor != null;
    }
    
    @Override
    public void setExecutor(final MenuExecutor executor) {
        this.executor = executor;
    }
    
    @Override
    public void removeExecutor() {
        this.executor = null;
    }
    
    @Override
    public boolean hasViewer() {
        return !this.inventory.getViewers().isEmpty();
    }
    
    public Inventory getInventory() {
        return this.inventory;
    }
    
    public final Collection<MenuSlot> getMenuSlots() {
        return this.mapSlot.values();
    }
    
    public final MenuSlot getMenuSlot(final int slot) {
        return this.mapSlot.get(slot);
    }
    
    public final boolean hasMenuSlot(final int slot) {
        return this.mapSlot.containsKey(slot);
    }
    
    public final void setMenuSlot(final MenuSlot menuSlot) {
        final int slot = menuSlot.getSlot();
        final int size = this.inventory.getSize();
        this.mapSlot.put(slot, menuSlot);
        if (slot >= 0 && slot < size) {
            final Item item = menuSlot.getItem();
            if (item != null) {
                final ItemStack itemStack = item.getItemStack();
                this.inventory.setItem(slot, itemStack);
            }
        }
    }
    
    public enum SlotCell
    {
        A1("A1", 0, 0, SlotColumn.COLUMN_A, SlotRow.ROW_1), 
        A2("A2", 1, 9, SlotColumn.COLUMN_A, SlotRow.ROW_2), 
        A3("A3", 2, 18, SlotColumn.COLUMN_A, SlotRow.ROW_3), 
        A4("A4", 3, 27, SlotColumn.COLUMN_A, SlotRow.ROW_4), 
        A5("A5", 4, 36, SlotColumn.COLUMN_A, SlotRow.ROW_5), 
        A6("A6", 5, 45, SlotColumn.COLUMN_A, SlotRow.ROW_6), 
        B1("B1", 6, 1, SlotColumn.COLUMN_B, SlotRow.ROW_1), 
        B2("B2", 7, 10, SlotColumn.COLUMN_B, SlotRow.ROW_2), 
        B3("B3", 8, 19, SlotColumn.COLUMN_B, SlotRow.ROW_3), 
        B4("B4", 9, 28, SlotColumn.COLUMN_B, SlotRow.ROW_4), 
        B5("B5", 10, 37, SlotColumn.COLUMN_B, SlotRow.ROW_5), 
        B6("B6", 11, 46, SlotColumn.COLUMN_B, SlotRow.ROW_6), 
        C1("C1", 12, 2, SlotColumn.COLUMN_C, SlotRow.ROW_1), 
        C2("C2", 13, 11, SlotColumn.COLUMN_C, SlotRow.ROW_2), 
        C3("C3", 14, 20, SlotColumn.COLUMN_C, SlotRow.ROW_3), 
        C4("C4", 15, 29, SlotColumn.COLUMN_C, SlotRow.ROW_4), 
        C5("C5", 16, 38, SlotColumn.COLUMN_C, SlotRow.ROW_5), 
        C6("C6", 17, 47, SlotColumn.COLUMN_C, SlotRow.ROW_6), 
        D1("D1", 18, 3, SlotColumn.COLUMN_D, SlotRow.ROW_1), 
        D2("D2", 19, 12, SlotColumn.COLUMN_D, SlotRow.ROW_2), 
        D3("D3", 20, 21, SlotColumn.COLUMN_D, SlotRow.ROW_3), 
        D4("D4", 21, 30, SlotColumn.COLUMN_D, SlotRow.ROW_4), 
        D5("D5", 22, 39, SlotColumn.COLUMN_D, SlotRow.ROW_5), 
        D6("D6", 23, 48, SlotColumn.COLUMN_D, SlotRow.ROW_6), 
        E1("E1", 24, 4, SlotColumn.COLUMN_E, SlotRow.ROW_1), 
        E2("E2", 25, 13, SlotColumn.COLUMN_E, SlotRow.ROW_2), 
        E3("E3", 26, 22, SlotColumn.COLUMN_E, SlotRow.ROW_3), 
        E4("E4", 27, 31, SlotColumn.COLUMN_E, SlotRow.ROW_4), 
        E5("E5", 28, 40, SlotColumn.COLUMN_E, SlotRow.ROW_5), 
        E6("E6", 29, 49, SlotColumn.COLUMN_E, SlotRow.ROW_6), 
        F1("F1", 30, 5, SlotColumn.COLUMN_F, SlotRow.ROW_1), 
        F2("F2", 31, 14, SlotColumn.COLUMN_F, SlotRow.ROW_2), 
        F3("F3", 32, 23, SlotColumn.COLUMN_F, SlotRow.ROW_3), 
        F4("F4", 33, 32, SlotColumn.COLUMN_F, SlotRow.ROW_4), 
        F5("F5", 34, 41, SlotColumn.COLUMN_F, SlotRow.ROW_5), 
        F6("F6", 35, 50, SlotColumn.COLUMN_F, SlotRow.ROW_6), 
        G1("G1", 36, 6, SlotColumn.COLUMN_G, SlotRow.ROW_1), 
        G2("G2", 37, 15, SlotColumn.COLUMN_G, SlotRow.ROW_2), 
        G3("G3", 38, 24, SlotColumn.COLUMN_G, SlotRow.ROW_3), 
        G4("G4", 39, 33, SlotColumn.COLUMN_G, SlotRow.ROW_4), 
        G5("G5", 40, 42, SlotColumn.COLUMN_G, SlotRow.ROW_5), 
        G6("G6", 41, 51, SlotColumn.COLUMN_G, SlotRow.ROW_6), 
        H1("H1", 42, 7, SlotColumn.COLUMN_H, SlotRow.ROW_1), 
        H2("H2", 43, 16, SlotColumn.COLUMN_H, SlotRow.ROW_2), 
        H3("H3", 44, 25, SlotColumn.COLUMN_H, SlotRow.ROW_3), 
        H4("H4", 45, 34, SlotColumn.COLUMN_H, SlotRow.ROW_4), 
        H5("H5", 46, 43, SlotColumn.COLUMN_H, SlotRow.ROW_5), 
        H6("H6", 47, 52, SlotColumn.COLUMN_H, SlotRow.ROW_6), 
        I1("I1", 48, 8, SlotColumn.COLUMN_I, SlotRow.ROW_1), 
        I2("I2", 49, 17, SlotColumn.COLUMN_I, SlotRow.ROW_2), 
        I3("I3", 50, 26, SlotColumn.COLUMN_I, SlotRow.ROW_3), 
        I4("I4", 51, 35, SlotColumn.COLUMN_I, SlotRow.ROW_4), 
        I5("I5", 52, 44, SlotColumn.COLUMN_I, SlotRow.ROW_5), 
        I6("I6", 53, 53, SlotColumn.COLUMN_I, SlotRow.ROW_6);
        
        private final int index;
        private final SlotColumn column;
        private final SlotRow row;
        
        private SlotCell(final String name, final int ordinal, final int index, final SlotColumn column, final SlotRow row) {
            this.index = index;
            this.column = column;
            this.row = row;
        }
        
        public final int getIndex() {
            return this.index;
        }
        
        public final SlotColumn getColumn() {
            return this.column;
        }
        
        public final SlotRow getRow() {
            return this.row;
        }
        
        public static final SlotCell getCell(final SlotColumn column, final SlotRow row) {
            if (column != null && row != null) {
                SlotCell[] values;
                for (int length = (values = values()).length, i = 0; i < length; ++i) {
                    final SlotCell cell = values[i];
                    final SlotColumn cellColumn = cell.getColumn();
                    final SlotRow cellRow = cell.getRow();
                    if (column.equals(cellColumn) && row.equals(cellRow)) {
                        return cell;
                    }
                }
            }
            return null;
        }
        
        public static final Set<SlotCell> getCellsByColumn(final SlotColumn column) {
            final Set<SlotCell> cells = new HashSet<SlotCell>();
            if (column != null) {
                SlotCell[] values;
                for (int length = (values = values()).length, i = 0; i < length; ++i) {
                    final SlotCell cell = values[i];
                    final SlotColumn cellColumn = cell.getColumn();
                    if (cellColumn.equals(column)) {
                        cells.add(cell);
                    }
                }
            }
            return cells;
        }
        
        public static final Set<SlotCell> getCellsByRow(final SlotRow row) {
            final Set<SlotCell> cells = new HashSet<SlotCell>();
            if (row != null) {
                SlotCell[] values;
                for (int length = (values = values()).length, i = 0; i < length; ++i) {
                    final SlotCell cell = values[i];
                    final SlotRow cellRow = cell.getRow();
                    if (cellRow.equals(row)) {
                        cells.add(cell);
                    }
                }
            }
            return cells;
        }
        
        public static final Set<SlotCell> getConditionalCells(final SlotColumn[] columns, final SlotRow[] rows) {
            final Set<SlotCell> cells = new HashSet<SlotCell>();
            for (final SlotColumn column : columns) {
                for (final SlotRow row : rows) {
                    final SlotCell cell = getCell(column, row);
                    if (cell != null) {
                        cells.add(cell);
                    }
                }
            }
            return cells;
        }
        
        public static final Set<SlotCell> getConditionalCells(final Set<SlotColumn> columns, final Set<SlotRow> rows) {
            final Set<SlotCell> cells = new HashSet<SlotCell>();
            for (final SlotColumn column : columns) {
                for (final SlotRow row : rows) {
                    final SlotCell cell = getCell(column, row);
                    if (cell != null) {
                        cells.add(cell);
                    }
                }
            }
            return cells;
        }
    }
    
    public enum SlotColumn
    {
        COLUMN_A("COLUMN_A", 0), 
        COLUMN_B("COLUMN_B", 1), 
        COLUMN_C("COLUMN_C", 2), 
        COLUMN_D("COLUMN_D", 3), 
        COLUMN_E("COLUMN_E", 4), 
        COLUMN_F("COLUMN_F", 5), 
        COLUMN_G("COLUMN_G", 6), 
        COLUMN_H("COLUMN_H", 7), 
        COLUMN_I("COLUMN_I", 8);
        
        private SlotColumn(final String name, final int ordinal) {
        }
        
        public static final SlotColumn getColumnByOrdinal(final int ordinal) {
            SlotColumn[] values;
            for (int length = (values = values()).length, i = 0; i < length; ++i) {
                final SlotColumn column = values[i];
                final int columnOrdinal = column.ordinal();
                if (columnOrdinal == ordinal) {
                    return column;
                }
            }
            return null;
        }
        
        public static final Set<SlotColumn> getColumnRange(final SlotColumn min, final SlotColumn max) {
            if (min != null && max != null) {
                final int ordinalMin = min.ordinal();
                final int ordinalMax = max.ordinal();
                return getColumnRange(ordinalMin, ordinalMax);
            }
            return new HashSet<SlotColumn>();
        }
        
        public static final Set<SlotColumn> getColumnRange(final int min, final int max) {
            final Set<SlotColumn> columns = new HashSet<SlotColumn>();
            SlotColumn[] values;
            for (int length = (values = values()).length, i = 0; i < length; ++i) {
                final SlotColumn column = values[i];
                final int ordinal = column.ordinal();
                if (ordinal >= min && ordinal <= max) {
                    columns.add(column);
                }
            }
            return columns;
        }
    }
    
    public enum SlotRow
    {
        ROW_1("ROW_1", 0), 
        ROW_2("ROW_2", 1), 
        ROW_3("ROW_3", 2), 
        ROW_4("ROW_4", 3), 
        ROW_5("ROW_5", 4), 
        ROW_6("ROW_6", 5);
        
        private SlotRow(final String name, final int ordinal) {
        }
        
        public static final SlotRow getRowByOrdinal(final int ordinal) {
            SlotRow[] values;
            for (int length = (values = values()).length, i = 0; i < length; ++i) {
                final SlotRow row = values[i];
                final int rowOrdinal = row.ordinal();
                if (rowOrdinal == ordinal) {
                    return row;
                }
            }
            return null;
        }
        
        public static final Set<SlotRow> getRowRange(final SlotRow min, final SlotRow max) {
            if (min != null && max != null) {
                final int ordinalMin = min.ordinal();
                final int ordinalMax = max.ordinal();
                return getRowRange(ordinalMin, ordinalMax);
            }
            return new HashSet<SlotRow>();
        }
        
        public static final Set<SlotRow> getRowRange(final int min, final int max) {
            final Set<SlotRow> rows = new HashSet<SlotRow>();
            SlotRow[] values;
            for (int length = (values = values()).length, i = 0; i < length; ++i) {
                final SlotRow row = values[i];
                final int ordinal = row.ordinal();
                if (ordinal >= min && ordinal <= max) {
                    rows.add(row);
                }
            }
            return rows;
        }
    }
    
    public static class MenuGUIBuilder extends MenuBuilder
    {
        private final String id;
        private final int row;
        private final Map<Integer, MenuSlot> mapSlot;
        private Text title;
        private boolean editable;
        private MenuExecutor executor;
        
        public MenuGUIBuilder(final Player owner, final String id, final int row, final String title) {
            this(owner, id, row, new TextLine(title), null, false);
        }
        
        public MenuGUIBuilder(final Player owner, final String id, final int row, final Text title) {
            this(owner, id, row, title, null, false);
        }
        
        public MenuGUIBuilder(final Player owner, final String id, final int row, final Text title, final boolean editable) {
            this(owner, id, row, title, null, editable);
        }
        
        public MenuGUIBuilder(final Player owner, final String id, final int row, final Text title, final MenuExecutor executor, final boolean editable) {
            this(owner, id, row, title, executor, editable, new ConcurrentHashMap<Integer, MenuSlot>());
        }
        
        public MenuGUIBuilder(final Player owner, final String id, final int row, final Text title, final MenuExecutor executor, final boolean editable, final Map<Integer, MenuSlot> mapSlot) {
            this.id = id;
            this.row = MathUtil.limitInteger(row, 1, 6);
            this.title = title;
            this.editable = editable;
            this.executor = executor;
            this.mapSlot = mapSlot;
        }
        
        @Override
        public String getID() {
            return this.id;
        }
        
        @Override
        public Text getTitle() {
            return this.title;
        }
        
        @Override
        public void setTitle(final Text title) {
            this.title = title;
        }
        
        @Override
        public boolean isEditable() {
            return this.editable;
        }
        
        @Override
        public void setEditable(final boolean flag) {
            this.editable = flag;
        }
        
        @Override
        public MenuExecutor getExecutor() {
            return this.executor;
        }
        
        @Override
        public boolean hasExecutor() {
            return this.executor != null;
        }
        
        @Override
        public void setExecutor(final MenuExecutor executor) {
            this.executor = executor;
        }
        
        @Override
        public void removeExecutor() {
            this.executor = null;
        }
        
        public final int getRow() {
            return this.row;
        }
        
        public final MenuSlot getMenuSlot(final int slot) {
            return this.mapSlot.get(slot);
        }
        
        public final boolean hasMenuSlot(final int slot) {
            return this.mapSlot.containsKey(slot);
        }
        
        public final void setMenuSlot(final int slot, final MenuSlot menuSlot) {
            this.mapSlot.put(slot, menuSlot);
        }
        
        @Override
        public Menu build() {
            return this.build(null);
        }
        
        @Override
        public Menu build(final Player player) {
            return new MenuGUI(player, this.id, this.row, this.title, this.executor, this.editable, this.mapSlot);
        }
    }
}
