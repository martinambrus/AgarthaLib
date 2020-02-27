// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.manager.task;

import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.task.TaskEffectEntity;
import org.bukkit.Bukkit;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.scheduler.BukkitTask;
import com.praya.agarthalib.handler.HandlerManager;

public class TaskEffectEntityManager extends HandlerManager
{
    private BukkitTask taskEffectEntity;
    
    protected TaskEffectEntityManager(final AgarthaLib plugin) {
        super(plugin);
        this.reloadTaskEffectEntity();
    }
    
    public final void reloadTaskEffectEntity() {
        if (this.taskEffectEntity != null) {
            this.taskEffectEntity.cancel();
        }
        this.taskEffectEntity = this.createTaskEffectEntity();
    }
    
    private final BukkitTask createTaskEffectEntity() {
        final BukkitScheduler scheduler = Bukkit.getScheduler();
        final Runnable runnable = new TaskEffectEntity(this.plugin);
        final int delay = 0;
        final int period = 20;
        final BukkitTask task = scheduler.runTaskTimer((Plugin)this.plugin, runnable, 0L, 20L);
        return task;
    }
}
