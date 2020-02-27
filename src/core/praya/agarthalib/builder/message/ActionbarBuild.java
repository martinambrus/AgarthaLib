// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.message;

import java.util.Collection;
import core.praya.agarthalib.bridge.unity.Bridge;
import org.bukkit.entity.Player;

public class ActionbarBuild
{
    private final String message;
    private final String id;
    private final int priority;
    
    public ActionbarBuild(final String message) {
        this(message, "default", 0);
    }
    
    public ActionbarBuild(final String message, final String id) {
        this(message, id, 0);
    }
    
    public ActionbarBuild(final String message, final int priority) {
        this(message, "default", priority);
    }
    
    public ActionbarBuild(final String message, final String id, final int priority) {
        this.message = message;
        this.id = id;
        this.priority = priority;
    }
    
    public final String getMessage() {
        return this.message;
    }
    
    public final String getID() {
        return this.id;
    }
    
    public final int getPriority() {
        return this.priority;
    }
    
    public final void sendActionbar(final Player player) {
        Bridge.getBridgeMessage().sendActionbar(player, this.message);
    }
    
    public final void sendActionbar(final Collection<Player> players) {
        Bridge.getBridgeMessage().sendActionbar(players, this.message);
    }
    
    public final void sendProtectedActionbar(final Player player) {
        this.sendProtectedActionbar(player, 3000L, false);
    }
    
    public final void sendProtectedActionbar(final Player player, final long cooldown) {
        this.sendProtectedActionbar(player, cooldown, false);
    }
    
    public final void sendProtectedActionbar(final Player player, final long cooldown, final boolean bypass) {
        Bridge.getBridgeMessage().sendProtectedActionbar(player, this.message, this.id, this.priority, cooldown, bypass);
    }
    
    public final void sendProtectedActionbar(final Collection<Player> players) {
        this.sendProtectedActionbar(players, 3000L, false);
    }
    
    public final void sendProtectedActionbar(final Collection<Player> players, final long cooldown) {
        this.sendProtectedActionbar(players, cooldown, false);
    }
    
    public final void sendProtectedActionbar(final Collection<Player> players, final long cooldown, final boolean bypass) {
        Bridge.getBridgeMessage().sendProtectedActionbar(players, this.message, this.id, this.priority, cooldown, bypass);
    }
}
