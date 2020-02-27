// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.manager.core;

import core.praya.agarthalib.builder.menu.MenuGUI;
import core.praya.agarthalib.builder.menu.MenuBuilder;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collection;
import core.praya.agarthalib.builder.menu.Menu;
import java.util.concurrent.ConcurrentHashMap;
import com.praya.agarthalib.AgarthaLib;
import core.praya.agarthalib.builder.menu.MenuRegister;
import java.util.Map;
import com.praya.agarthalib.handler.HandlerManager;

public class CoreMenuManager extends HandlerManager
{
    private final Map<String, MenuRegister> mapMenuGUI;
    
    protected CoreMenuManager(final AgarthaLib plugin) {
        super(plugin);
        this.mapMenuGUI = new ConcurrentHashMap<String, MenuRegister>();
    }
    
    public final Collection<String> getIDs(final Menu.MenuType type) {
        switch (type) {
            case GUI: {
                return this.mapMenuGUI.keySet();
            }
            default: {
                return new ArrayList<String>();
            }
        }
    }
    
    public final Collection<MenuRegister> getAllRegisteredMenu(final Menu.MenuType type) {
        switch (type) {
            case GUI: {
                return this.mapMenuGUI.values();
            }
            default: {
                return new ArrayList<MenuRegister>();
            }
        }
    }
    
    public final MenuRegister getRegisteredMenu(final String id, final Menu.MenuType type) {
        final Collection<MenuRegister> registeredMenu = new ArrayList<MenuRegister>(this.getAllRegisteredMenu(type));
        for (final MenuRegister register : registeredMenu) {
            final MenuBuilder menuBuilder = register.getBuilder();
            final String menuID = menuBuilder.getID();
            if (menuID.equalsIgnoreCase(id)) {
                return register;
            }
        }
        return null;
    }
    
    public final boolean isRegisteredMenuExists(final String id, final Menu.MenuType type) {
        return this.getRegisteredMenu(id, type) != null;
    }
    
    public final boolean registerMenu(final MenuRegister menuRegister) {
        final MenuBuilder builder = menuRegister.getBuilder();
        final String id = builder.getID();
        Menu.MenuType type;
        if (builder instanceof MenuGUI.MenuGUIBuilder) {
            type = Menu.MenuType.GUI;
        }
        else {
            type = null;
        }
        if (type != null && !this.isRegisteredMenuExists(id, type)) {
            switch (type) {
                case GUI: {
                    this.mapMenuGUI.put(id, menuRegister);
                    break;
                }
            }
            return true;
        }
        return false;
    }
}
