// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.manager.plugin;

import com.praya.agarthalib.metrics.service.BStats;
import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerManager;

public abstract class MetricsManager extends HandlerManager
{
    protected MetricsManager(final AgarthaLib plugin) {
        super(plugin);
    }
    
    public abstract BStats getMetricsBStats();
}
