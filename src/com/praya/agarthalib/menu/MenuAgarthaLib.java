// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.menu;

import core.praya.agarthalib.builder.plugin.PluginTypePropertiesBuild;
import java.util.Set;
import org.bukkit.plugin.Plugin;
import java.util.Iterator;
import java.util.List;
import java.util.Collection;
import com.praya.agarthalib.manager.plugin.LanguageManager;
import com.praya.agarthalib.manager.plugin.PluginPropertiesManager;
import com.praya.agarthalib.manager.plugin.PlaceholderManager;
import com.praya.agarthalib.manager.plugin.PluginManager;
import core.praya.agarthalib.builder.menu.Menu;
import core.praya.agarthalib.builder.item.Item;
import core.praya.agarthalib.builder.menu.MenuSlotAction;
import core.praya.agarthalib.builder.menu.MenuSlot;
import core.praya.agarthalib.builder.menu.MenuGUI;
import core.praya.agarthalib.builder.item.ItemList;
import org.bukkit.inventory.ItemStack;
import com.praya.agarthalib.utility.EquipmentUtil;
import core.praya.agarthalib.enums.branch.MaterialEnum;
import com.praya.agarthalib.utility.TextUtil;
import com.praya.agarthalib.utility.MathUtil;
import com.praya.agarthalib.utility.PluginUtil;
import java.util.HashMap;
import core.praya.agarthalib.builder.plugin.PluginPropertiesStreamBuild;
import core.praya.agarthalib.builder.face.Agartha;
import java.util.ArrayList;
import org.bukkit.entity.Player;
import core.praya.agarthalib.builder.menu.MenuExecutor;
import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerMenu;

public class MenuAgarthaLib extends HandlerMenu
{
    protected MenuAgarthaLib(final AgarthaLib plugin, final MenuExecutor menuExecutor) {
        super(plugin, menuExecutor);
    }
    
    public final void openMenuUpdater(final Player player) {
        this.openMenuUpdater(player, 1);
    }
    
    public final void openMenuUpdater(final Player player, int page) {
        final PluginManager pluginManager = this.plugin.getPluginManager();
        final PlaceholderManager placeholderManager = pluginManager.getPlaceholderManager();
        final PluginPropertiesManager pluginPropertiesManager = pluginManager.getPluginPropertiesManager();
        final LanguageManager lang = pluginManager.getLanguageManager();
        final MenuExecutor executor = this.getMenuExecutor();
        final String id = "AgarthaLib Updater";
        final String prefix = placeholderManager.getPlaceholder("prefix");
        final Collection<PluginPropertiesStreamBuild> allPlugins = pluginPropertiesManager.getAllPluginProperties();
        final List<Agartha> pluginUpToDate = new ArrayList<Agartha>();
        final List<Agartha> pluginOutDated = new ArrayList<Agartha>();
        final List<PluginPropertiesStreamBuild> propertiesNotInstalled = new ArrayList<PluginPropertiesStreamBuild>();
        final HashMap<String, String> map = new HashMap<String, String>();
        for (final PluginPropertiesStreamBuild property : allPlugins) {
            final String pluginID = property.getName();
            final Plugin pluginJava = PluginUtil.getPlugin(pluginID);
            if (pluginJava != null && pluginJava instanceof Agartha) {
                final Agartha agartha = (Agartha)pluginJava;
                try {
                    final String version = agartha.getPluginVersion();
                    final String latest = agartha.getPluginLatest();
                    if (version.equalsIgnoreCase(latest)) {
                        pluginUpToDate.add(agartha);
                    }
                    else {
                        pluginOutDated.add(agartha);
                    }
                }
                catch (AbstractMethodError exception) {
                    propertiesNotInstalled.add(property);
                }
            }
            else {
                if (!property.isTypeExists("Premium") && !property.isTypeExists("Free")) {
                    continue;
                }
                propertiesNotInstalled.add(property);
            }
        }
        final int totalNotInstalled = propertiesNotInstalled.size();
        final int totalUpToDate = pluginUpToDate.size();
        final int totalOutDated = pluginOutDated.size();
        final int totalInstalled = totalUpToDate + totalOutDated;
        final int totalPlugin = totalInstalled + totalNotInstalled;
        final int row = 5;
        final int maxPage = Math.max(1, (totalPlugin % 5 != 0) ? (totalPlugin / 5 + 1) : (totalPlugin / 5));
        page = MathUtil.limitInteger(page, 1, maxPage);
        String title = lang.getText("Menu_Page_Title_Updater");
        String headerPagePrevious = lang.getText("Menu_Item_Header_Previous");
        String headerPageNext = lang.getText("Menu_Item_Header_Next");
        List<String> loresPagePrevious = lang.getListText("Menu_Item_Lores_Previous");
        List<String> loresPageNext = lang.getListText("Menu_Item_Lores_Next");
        map.put("page", String.valueOf(page));
        map.put("maxPage", String.valueOf(maxPage));
        title = TextUtil.placeholder(map, title);
        headerPagePrevious = TextUtil.placeholder(map, headerPagePrevious);
        headerPageNext = TextUtil.placeholder(map, headerPageNext);
        loresPagePrevious = TextUtil.placeholder(map, loresPagePrevious);
        loresPageNext = TextUtil.placeholder(map, loresPageNext);
        final ItemStack itemWoolBlack = EquipmentUtil.createItem(MaterialEnum.BLACK_WOOL, prefix, 1);
        final ItemStack itemWoolRed = EquipmentUtil.createItem(MaterialEnum.RED_WOOL, prefix, 1);
        final ItemStack itemPagePrevious = EquipmentUtil.createItem(MaterialEnum.RED_STAINED_GLASS_PANE, headerPagePrevious, 1, loresPagePrevious);
        final ItemStack itemPageNext = EquipmentUtil.createItem(MaterialEnum.RED_STAINED_GLASS_PANE, headerPageNext, 1, loresPageNext);
        final ItemList itemListWool_0 = new ItemList(new ItemStack[] { itemWoolRed, itemWoolBlack, itemWoolBlack, itemWoolBlack, itemWoolBlack, itemWoolBlack });
        final ItemList itemListWool_A = new ItemList(new ItemStack[] { itemWoolBlack, itemWoolRed, itemWoolBlack, itemWoolBlack, itemWoolBlack, itemWoolBlack });
        final ItemList itemListWool_B = new ItemList(new ItemStack[] { itemWoolBlack, itemWoolBlack, itemWoolRed, itemWoolBlack, itemWoolBlack, itemWoolBlack });
        final ItemList itemListWool_C = new ItemList(new ItemStack[] { itemWoolBlack, itemWoolBlack, itemWoolBlack, itemWoolRed, itemWoolBlack, itemWoolBlack });
        final ItemList itemListWool_D = new ItemList(new ItemStack[] { itemWoolBlack, itemWoolBlack, itemWoolBlack, itemWoolBlack, itemWoolRed, itemWoolBlack });
        final ItemList itemListWool_E = new ItemList(new ItemStack[] { itemWoolBlack, itemWoolBlack, itemWoolBlack, itemWoolBlack, itemWoolBlack, itemWoolRed });
        final ItemStack itemPaneBlack = EquipmentUtil.createItem(MaterialEnum.BLACK_STAINED_GLASS_PANE, prefix, 1);
        final MenuGUI.SlotRow[] arrayRowWool_Animated = { MenuGUI.SlotRow.ROW_1, MenuGUI.SlotRow.ROW_5 };
        final MenuGUI.SlotRow[] arrayRowWool_Stay = { MenuGUI.SlotRow.ROW_2, MenuGUI.SlotRow.ROW_4 };
        final Set<MenuGUI.SlotRow> setRowPaneBlack = MenuGUI.SlotRow.getRowRange(MenuGUI.SlotRow.ROW_2, MenuGUI.SlotRow.ROW_4);
        final MenuGUI.SlotColumn[] arrayColumnWool_A = { MenuGUI.SlotColumn.COLUMN_A, MenuGUI.SlotColumn.COLUMN_I };
        final MenuGUI.SlotColumn[] arrayColumnWool_B = { MenuGUI.SlotColumn.COLUMN_B, MenuGUI.SlotColumn.COLUMN_H };
        final MenuGUI.SlotColumn[] arrayColumnWool_C = { MenuGUI.SlotColumn.COLUMN_C, MenuGUI.SlotColumn.COLUMN_G };
        final MenuGUI.SlotColumn[] arrayColumnWool_D = { MenuGUI.SlotColumn.COLUMN_D, MenuGUI.SlotColumn.COLUMN_F };
        final MenuGUI.SlotColumn[] arrayColumnWool_E = { MenuGUI.SlotColumn.COLUMN_E };
        final Set<MenuGUI.SlotColumn> setColumnWool_Stay = MenuGUI.SlotColumn.getColumnRange(MenuGUI.SlotColumn.COLUMN_B, MenuGUI.SlotColumn.COLUMN_H);
        final Set<MenuGUI.SlotCell> cellsWool_0 = MenuGUI.SlotCell.getConditionalCells(arrayColumnWool_A, arrayRowWool_Stay);
        final Set<MenuGUI.SlotCell> cellsWool_A = MenuGUI.SlotCell.getConditionalCells(arrayColumnWool_A, arrayRowWool_Animated);
        final Set<MenuGUI.SlotCell> cellsWool_B = MenuGUI.SlotCell.getConditionalCells(arrayColumnWool_B, arrayRowWool_Animated);
        final Set<MenuGUI.SlotCell> cellsWool_C = MenuGUI.SlotCell.getConditionalCells(arrayColumnWool_C, arrayRowWool_Animated);
        final Set<MenuGUI.SlotCell> cellsWool_D = MenuGUI.SlotCell.getConditionalCells(arrayColumnWool_D, arrayRowWool_Animated);
        final Set<MenuGUI.SlotCell> cellsWool_E = MenuGUI.SlotCell.getConditionalCells(arrayColumnWool_E, arrayRowWool_Animated);
        final Set<MenuGUI.SlotCell> cellsPaneBlack = MenuGUI.SlotCell.getConditionalCells(setColumnWool_Stay, setRowPaneBlack);
        final MenuSlot menuSlotPrevious = new MenuSlot(MenuGUI.SlotCell.A3.getIndex());
        final MenuSlot menuSlotNext = new MenuSlot(MenuGUI.SlotCell.I3.getIndex());
        final MenuGUI menuGUI = new MenuGUI(player, "AgarthaLib Updater", 5, title);
        cellsPaneBlack.remove(MenuGUI.SlotCell.C3);
        cellsPaneBlack.remove(MenuGUI.SlotCell.D3);
        cellsPaneBlack.remove(MenuGUI.SlotCell.E3);
        cellsPaneBlack.remove(MenuGUI.SlotCell.F3);
        cellsPaneBlack.remove(MenuGUI.SlotCell.G3);
        menuSlotPrevious.setItem(itemPagePrevious);
        menuSlotNext.setItem(itemPageNext);
        menuSlotPrevious.setActionArguments(MenuSlotAction.ActionCategory.ALL_CLICK, "AgarthaLib Menu Updater " + (page - 1));
        menuSlotNext.setActionArguments(MenuSlotAction.ActionCategory.ALL_CLICK, "AgarthaLib Menu Updater " + (page + 1));
        menuGUI.setMenuSlot(menuSlotPrevious);
        menuGUI.setMenuSlot(menuSlotNext);
        for (final MenuGUI.SlotCell cell : cellsWool_0) {
            final int slot = cell.getIndex();
            final MenuSlot menuSlot = new MenuSlot(slot);
            final ItemList itemList = itemListWool_0.clone();
            menuSlot.setItem(itemList);
            menuGUI.setMenuSlot(menuSlot);
        }
        for (final MenuGUI.SlotCell cell : cellsWool_A) {
            final int slot = cell.getIndex();
            final MenuSlot menuSlot = new MenuSlot(slot);
            final ItemList itemList = itemListWool_A.clone();
            menuSlot.setItem(itemList);
            menuGUI.setMenuSlot(menuSlot);
        }
        for (final MenuGUI.SlotCell cell : cellsWool_B) {
            final int slot = cell.getIndex();
            final MenuSlot menuSlot = new MenuSlot(slot);
            final ItemList itemList = itemListWool_B.clone();
            menuSlot.setItem(itemList);
            menuGUI.setMenuSlot(menuSlot);
        }
        for (final MenuGUI.SlotCell cell : cellsWool_C) {
            final int slot = cell.getIndex();
            final MenuSlot menuSlot = new MenuSlot(slot);
            final ItemList itemList = itemListWool_C.clone();
            menuSlot.setItem(itemList);
            menuGUI.setMenuSlot(menuSlot);
        }
        for (final MenuGUI.SlotCell cell : cellsWool_D) {
            final int slot = cell.getIndex();
            final MenuSlot menuSlot = new MenuSlot(slot);
            final ItemList itemList = itemListWool_D.clone();
            menuSlot.setItem(itemList);
            menuGUI.setMenuSlot(menuSlot);
        }
        for (final MenuGUI.SlotCell cell : cellsWool_E) {
            final int slot = cell.getIndex();
            final MenuSlot menuSlot = new MenuSlot(slot);
            final ItemList itemList = itemListWool_E.clone();
            menuSlot.setItem(itemList);
            menuGUI.setMenuSlot(menuSlot);
        }
        for (final MenuGUI.SlotCell cell : cellsPaneBlack) {
            final int slot = cell.getIndex();
            final MenuSlot menuSlot = new MenuSlot(slot);
            menuSlot.setItem(itemPaneBlack);
            menuGUI.setMenuSlot(menuSlot);
        }
        int index = 0;
        for (int slot2 = 20; slot2 < 25; ++slot2) {
            final int indexRegister = index + 5 * (page - 1);
            if (indexRegister < totalPlugin) {
                String plStatus;
                String plName;
                String plType;
                String plVersion;
                String plLatest;
                String plWebsite;
                MaterialEnum plMaterial;
                List<String> loresPlugin;
                if (indexRegister < totalInstalled) {
                    final Agartha agartha2 = (indexRegister < totalUpToDate) ? pluginUpToDate.get(indexRegister) : pluginOutDated.get(indexRegister - totalUpToDate);
                    plStatus = ((indexRegister < totalUpToDate) ? lang.getText("Updater_Status_Latest") : lang.getText("Updater_Status_Outdated"));
                    plName = agartha2.getPluginName();
                    plType = agartha2.getPluginType();
                    plVersion = agartha2.getPluginVersion();
                    plLatest = agartha2.getPluginLatest();
                    plWebsite = agartha2.getPluginWebsite();
                    plMaterial = MaterialEnum.BOOK;
                    loresPlugin = lang.getListText("Menu_Item_Lores_Plugin_Installed");
                }
                else {
                    final PluginPropertiesStreamBuild properties = propertiesNotInstalled.get(indexRegister - totalInstalled);
                    final PluginTypePropertiesBuild typeProperties = properties.isTypeExists("Premium") ? properties.getTypeProperties("Premium") : properties.getTypeProperties("Free");
                    plStatus = lang.getText("Updater_Status_Not_Installed");
                    plName = properties.getName();
                    plType = typeProperties.getType();
                    plVersion = typeProperties.getVersion();
                    plLatest = typeProperties.getVersion();
                    plWebsite = typeProperties.getWebsite();
                    plMaterial = MaterialEnum.WRITABLE_BOOK;
                    loresPlugin = lang.getListText("Menu_Item_Lores_Plugin_Not_Installed");
                }
                final String action = "AgarthaLib About " + plName + " " + plType;
                final MenuSlot menuSlot2 = new MenuSlot(slot2);
                String headerPlugin = lang.getText("Menu_Item_Header_Plugin");
                map.clear();
                map.put("plugin_status", plStatus);
                map.put("plugin_name", plName);
                map.put("plugin_type", plType);
                map.put("plugin_version", plVersion);
                map.put("plugin_latest", plLatest);
                map.put("plugin_website", plWebsite);
                headerPlugin = TextUtil.placeholder(map, headerPlugin);
                loresPlugin = TextUtil.placeholder(map, loresPlugin);
                final ItemStack itemPlugin = EquipmentUtil.createItem(plMaterial, headerPlugin, 1, loresPlugin);
                menuSlot2.setActionArguments(MenuSlotAction.ActionCategory.ALL_CLICK, action);
                menuSlot2.setActionClosed(MenuSlotAction.ActionCategory.ALL_CLICK, true);
                menuSlot2.setItem(itemPlugin);
                menuGUI.setMenuSlot(menuSlot2);
            }
            ++index;
        }
        menuGUI.setExecutor(executor);
        Menu.openMenu(player, menuGUI);
    }
}
