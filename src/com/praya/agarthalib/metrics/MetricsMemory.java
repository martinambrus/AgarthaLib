// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.metrics;

import org.bukkit.plugin.java.JavaPlugin;
import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.metrics.service.BStats;
import com.praya.agarthalib.manager.plugin.MetricsManager;

public class MetricsMemory extends MetricsManager
{
    private BStats metricsBStats;
    
    private MetricsMemory(final AgarthaLib plugin) {
        super(plugin);
        this.metricsBStats = new BStats(plugin);
    }
    
    public static final MetricsMemory getInstance() {
        return MetricsMemorySingleton.instance;
    }
    
    @Override
    public final BStats getMetricsBStats() {
        return this.metricsBStats;
    }
    
    private static class MetricsMemorySingleton
    {
        private static final MetricsMemory instance;
        
        static {
            final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
            instance = new MetricsMemory(plugin);
        }
    }
}
