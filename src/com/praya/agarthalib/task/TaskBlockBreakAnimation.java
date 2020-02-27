// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.task;

import org.bukkit.entity.Entity;
import core.praya.agarthalib.bridge.main.MainBridge;
import com.praya.agarthalib.utility.EntityUtil;
import org.bukkit.entity.EntityType;
import com.praya.agarthalib.AgarthaLibConfig;
import com.praya.agarthalib.utility.PlayerUtil;
import com.praya.agarthalib.utility.LocationUtil;
import org.bukkit.plugin.java.JavaPlugin;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.entity.Player;
import java.util.Collection;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

@Deprecated
public class TaskBlockBreakAnimation extends BukkitRunnable
{
    private final Location space;
    private final Location loc;
    private final int stage;
    private final int thickness;
    private final Collection<Player> players;
    private int t;
    
    public TaskBlockBreakAnimation(final Location loc, final int stage, final int thickness) {
        this.t = 0;
        final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
        final AgarthaLibConfig mainConfig = plugin.getMainConfig();
        this.loc = loc;
        this.space = LocationUtil.createLocation(loc.getWorld(), 0.0, 0.0, 0.0);
        this.stage = stage;
        this.thickness = thickness;
        this.players = PlayerUtil.getNearbyPlayers(loc, mainConfig.getEffectRange());
    }
    
    public void run() {
        if (this.t >= this.thickness) {
            this.cancel();
            return;
        }
        final Entity entity = EntityUtil.addEntity(this.space, EntityType.EXPERIENCE_ORB);
        MainBridge.getBridgeBlock().sendBlockBreakAnimation(entity, this.players, this.loc, this.stage);
        entity.remove();
        ++this.t;
    }
}
