// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.manager.game;

import core.praya.agarthalib.builder.stats.StatsEntityMemory;
import com.praya.agarthalib.effect.EffectEntityMemory;
import com.praya.agarthalib.effect.EffectTypeMemory;
import com.praya.agarthalib.projectile.ProjectilePropertiesMemory;
import com.praya.agarthalib.block.BlockBreakMemory;
import com.praya.agarthalib.menu.MenuMemory;
import com.praya.agarthalib.AgarthaLib;
import com.praya.agarthalib.handler.HandlerManager;

public class GameManager extends HandlerManager
{
    private final MenuManager menuManager;
    private final BlockBreakManager blockBreakManager;
    private final ProjectilePropertiesManager projectilePropertiesManager;
    private final EffectTypeManager effectTypeManager;
    private final EffectEntityManager effectEntityManager;
    private final StatsEntityManager statsEntityManager;
    
    public GameManager(final AgarthaLib plugin) {
        super(plugin);
        this.menuManager = MenuMemory.getInstance();
        this.blockBreakManager = BlockBreakMemory.getInstance();
        this.projectilePropertiesManager = ProjectilePropertiesMemory.getInstance();
        this.effectTypeManager = EffectTypeMemory.getInstance();
        this.effectEntityManager = EffectEntityMemory.getInstance();
        this.statsEntityManager = StatsEntityMemory.getInstance();
    }
    
    public final MenuManager getMenuManager() {
        return this.menuManager;
    }
    
    public final BlockBreakManager getBlockBreakManager() {
        return this.blockBreakManager;
    }
    
    public final ProjectilePropertiesManager getProjectilePropertiesManager() {
        return this.projectilePropertiesManager;
    }
    
    public final EffectTypeManager getEffectTypeManager() {
        return this.effectTypeManager;
    }
    
    public final EffectEntityManager getEffectEntityManager() {
        return this.effectEntityManager;
    }
    
    public final StatsEntityManager getStatsEntityManager() {
        return this.statsEntityManager;
    }
}
