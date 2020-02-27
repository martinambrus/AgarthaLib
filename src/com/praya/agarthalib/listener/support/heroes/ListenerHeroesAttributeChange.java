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
import com.herocraftonline.heroes.attributes.AttributeType;
import com.herocraftonline.heroes.api.events.AttributeChangeEvent;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.event.Listener;
import com.praya.agarthalib.handler.HandlerListener;

public class ListenerHeroesAttributeChange extends HandlerListener implements Listener
{
    public ListenerHeroesAttributeChange(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void eventAttributeChange(final AttributeChangeEvent event) {
        if (!event.isCancelled()) {
            final Hero hero = event.getHero();
            final AttributeType attribute = event.getAttributeType();
            if (hero != null && attribute.equals((Object)AttributeType.CONSTITUTION)) {
                final Player player = hero.getPlayer();
                new BukkitRunnable() {
                    public void run() {
                        PlayerUtil.setMaxHealth(player);
                    }
                }.runTaskLater((Plugin)this.plugin, 2L);
            }
        }
    }
}
