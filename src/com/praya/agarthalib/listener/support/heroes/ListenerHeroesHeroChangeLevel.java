// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.listener.support.heroes;

import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import com.herocraftonline.heroes.characters.Hero;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.utility.PlayerUtil;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import com.herocraftonline.heroes.api.events.HeroChangeLevelEvent;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.event.Listener;
import com.praya.agarthalib.handler.HandlerListener;

public class ListenerHeroesHeroChangeLevel extends HandlerListener implements Listener
{
    public ListenerHeroesHeroChangeLevel(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void eventPlayerAccountChange(final HeroChangeLevelEvent event) {
        final Hero hero = event.getHero();
        if (hero != null) {
            final Player player = hero.getPlayer();
            new BukkitRunnable() {
                public void run() {
                    PlayerUtil.setMaxHealth(player);
                }
            }.runTaskLater((Plugin)this.plugin, 2L);
        }
    }
}
