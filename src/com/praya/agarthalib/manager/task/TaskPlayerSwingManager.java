// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.manager.task;

import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.task.TaskPlayerSwing;
import org.bukkit.Bukkit;
import com.praya.agarthalib.utility.ServerUtil;
import core.praya.agarthalib.enums.main.VersionNMS;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.scheduler.BukkitTask;
import com.praya.agarthalib.handler.HandlerManager;

public class TaskPlayerSwingManager extends HandlerManager
{
    private BukkitTask taskPlayerSwing;
    
    protected TaskPlayerSwingManager(final AgarthaLib plugin) {
        super(plugin);
        this.reloadTaskPlayerSwing();
    }
    
    public final void reloadTaskPlayerSwing() {
        if (this.taskPlayerSwing != null) {
            this.taskPlayerSwing.cancel();
        }
        this.taskPlayerSwing = this.createTaskPlayerSwing();
    }
    
    private final BukkitTask createTaskPlayerSwing() {
        if (ServerUtil.isCompatible(VersionNMS.V1_9_R2)) {
            final BukkitScheduler scheduler = Bukkit.getScheduler();
            final Runnable runnable = new TaskPlayerSwing(this.plugin);
            final int delay = 0;
            final int period = 1;
            final BukkitTask task = scheduler.runTaskTimer((Plugin)this.plugin, runnable, 0L, 1L);
            return task;
        }
        return null;
    }
}
