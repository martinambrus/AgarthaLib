// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.menu;

import org.bukkit.inventory.Inventory;
import com.praya.agarthalib.manager.core.CoreMenuManager;
import com.praya.agarthalib.manager.core.CoreManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.praya.agarthalib.AgarthaLib;
import org.bukkit.entity.Player;
import java.util.UUID;
import org.bukkit.inventory.InventoryHolder;

public abstract class Menu implements InventoryHolder
{
    private final UUID uuid;
    
    protected Menu() {
        this.uuid = UUID.randomUUID();
    }
    
    public abstract String getID();
    
    public abstract Player getOwner();
    
    public abstract boolean hasOwner();
    
    public abstract void setOwner(final Player p0);
    
    public abstract boolean isOwner(final Player p0);
    
    public abstract MenuProperties getProperties();
    
    public abstract MenuExecutor getExecutor();
    
    public abstract void setExecutor(final MenuExecutor p0);
    
    public abstract boolean hasExecutor();
    
    public abstract void removeExecutor();
    
    public abstract boolean hasViewer();
    
    public final UUID getUniqueID() {
        return this.uuid;
    }
    
    public static final void openMenu(final Player player, final String id) {
        openMenu(player, id, MenuType.GUI, false);
    }
    
    public static final void openMenu(final Player player, final String id, final MenuType type) {
        openMenu(player, id, type, false);
    }
    
    public static final void openMenu(final Player player, final String id, final MenuType type, final boolean setOwner) {
        final AgarthaLib plugin = (AgarthaLib)JavaPlugin.getProvidingPlugin((Class)AgarthaLib.class);
        final CoreManager coreManager = plugin.getCoreManager();
        final CoreMenuManager coreMenuManager = coreManager.getCoreMenuManager();
        final MenuRegister menuRegister = coreMenuManager.getRegisteredMenu(id, type);
        if (menuRegister != null) {
            final MenuBuilder menuBuilder = menuRegister.getBuilder();
            final Player owner = setOwner ? player : null;
            final Menu menu = menuBuilder.build(owner);
            openMenu(player, menu);
        }
    }
    
    public static final void openMenu(final Player player, final Menu menu) {
        final Inventory inventory = menu.getInventory();
        player.openInventory(inventory);
    }
    
    public enum MenuType
    {
        GUI("GUI", 0);
        
        private MenuType(final String name, final int ordinal) {
        }
    }
}
