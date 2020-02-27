// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.listener.main;

import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import com.praya.agarthalib.projectile.ProjectileProperties;
import org.bukkit.inventory.ItemStack;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.entity.Projectile;
import com.praya.agarthalib.manager.game.ProjectilePropertiesManager;
import com.praya.agarthalib.manager.game.GameManager;
import core.praya.agarthalib.bridge.unity.Bridge;
import core.praya.agarthalib.enums.main.Slot;
import com.praya.agarthalib.utility.EquipmentUtil;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.event.Listener;
import com.praya.agarthalib.handler.HandlerListener;

public class ListenerProjectileLaunch extends HandlerListener implements Listener
{
    public ListenerProjectileLaunch(final AgarthaLib plugin) {
        super(plugin);
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void projectileLaunchEvent(final ProjectileLaunchEvent event) {
        final GameManager gameManager = this.plugin.getGameManager();
        final ProjectilePropertiesManager projectilePropertiesManager = gameManager.getProjectilePropertiesManager();
        if (!event.isCancelled()) {
            final Projectile projectile = event.getEntity();
            final ProjectileSource projectileSource = projectile.getShooter();
            if (projectileSource != null && projectileSource instanceof LivingEntity) {
                final LivingEntity shooter = (LivingEntity)projectileSource;
                final Slot slotMain = EquipmentUtil.holdBow(shooter) ? EquipmentUtil.getActiveSlotBow(shooter) : Slot.MAINHAND;
                final Slot slotDeputy = slotMain.equals(Slot.OFFHAND) ? Slot.MAINHAND : Slot.OFFHAND;
                final ItemStack itemMain = Bridge.getBridgeEquipment().getEquipment(shooter, slotMain);
                final ItemStack itemDeputy = Bridge.getBridgeEquipment().getEquipment(shooter, slotDeputy);
                final ProjectileProperties projectileProperties = projectilePropertiesManager.getProjectileProperties(projectile, true);
                projectileProperties.setItemMain(itemMain);
                projectileProperties.setItemDeputy(itemDeputy);
            }
        }
    }
}
