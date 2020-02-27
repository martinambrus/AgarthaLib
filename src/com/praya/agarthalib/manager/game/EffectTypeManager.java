// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.manager.game;

import com.praya.agarthalib.effect.EffectType;
import java.util.Collection;
import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerManager;

public abstract class EffectTypeManager extends HandlerManager
{
    protected EffectTypeManager(final AgarthaLib plugin) {
        super(plugin);
    }
    
    public abstract Collection<String> getEffectTypeIds();
    
    public abstract Collection<EffectType> getAllEffectType();
    
    public abstract EffectType getEffectType(final String p0);
    
    public abstract boolean isRegistered(final EffectType p0);
    
    public final boolean isExists(final String id) {
        return this.getEffectType(id) != null;
    }
}
