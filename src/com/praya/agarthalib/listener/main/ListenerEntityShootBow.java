// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.listener.main;

import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import com.praya.agarthalib.projectile.ProjectileProperties;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Entity;
import com.praya.agarthalib.manager.game.ProjectilePropertiesManager;
import com.praya.agarthalib.manager.game.GameManager;
import core.praya.agarthalib.bridge.unity.Bridge;
import core.praya.agarthalib.enums.main.Slot;
import com.praya.agarthalib.utility.EquipmentUtil;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.EntityShootBowEvent;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.event.Listener;
import com.praya.agarthalib.handler.HandlerListener;

public class ListenerEntityShootBow extends HandlerListener implements Listener
{
    public ListenerEntityShootBow(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void entityShootBowEvent(final EntityShootBowEvent event) {
        final GameManager gameManager = this.plugin.getGameManager();
        final ProjectilePropertiesManager projectilePropertiesManager = gameManager.getProjectilePropertiesManager();
        if (!event.isCancelled()) {
            final Entity entityProjectile = event.getProjectile();
            if (entityProjectile instanceof Projectile) {
                final LivingEntity shooter = event.getEntity();
                final Projectile projectile = (Projectile)entityProjectile;
                final Slot slotMain = EquipmentUtil.getActiveSlotBow(shooter);
                final Slot slotDeputy = (slotMain != null && slotMain.equals(Slot.OFFHAND)) ? Slot.MAINHAND : Slot.OFFHAND;
                final ItemStack itemMain = event.getBow();
                final ItemStack itemDeputy = Bridge.getBridgeEquipment().getEquipment(shooter, slotDeputy);
                final ProjectileProperties projectileProperties = projectilePropertiesManager.getProjectileProperties(projectile, true);
                projectileProperties.setItemMain(itemMain);
                projectileProperties.setItemDeputy(itemDeputy);
            }
        }
    }
}
