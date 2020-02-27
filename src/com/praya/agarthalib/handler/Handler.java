// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.handler;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collection;
import com.praya.agarthalib.AgarthaLib;
import java.util.HashMap;

public abstract class Handler
{
    private static final HashMap<Class<?>, Handler> mapHandler;
    protected final AgarthaLib plugin;
    
    static {
        mapHandler = new HashMap<Class<?>, Handler>();
    }
    
    protected Handler(final AgarthaLib plugin) {
        if (plugin != null) {
            final Class<?> clazz = this.getClass();
            Handler.mapHandler.put(clazz, this);
        }
        this.plugin = plugin;
    }
    
    public static final Collection<Handler> getAllHandler() {
        return Handler.mapHandler.values();
    }
    
    public static final Handler getProvidingHandler(final Class<?> clazz) {
        return (clazz != null) ? Handler.mapHandler.get(clazz) : null;
    }
    
    public static final <T extends Handler> T getHandler(final Class<T> clazz) {
        if (clazz != null) {
            final Handler handler = Handler.mapHandler.get(clazz);
            if (handler != null) {
                return clazz.cast(handler);
            }
        }
        return null;
    }
    
    public static final <T extends Handler> Collection<T> getHandlers(final Class<T> clazz) {
        final Collection<T> handlers = new ArrayList<T>();
        if (clazz != null) {
            for (final Handler handler : getAllHandler()) {
                if (handler.getClass().isAssignableFrom(clazz)) {
                    handlers.add((T)handler);
                }
            }
        }
        return handlers;
    }
}
