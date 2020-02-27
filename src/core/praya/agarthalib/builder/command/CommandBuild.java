// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.command;

import java.util.Iterator;
import java.util.List;

public class CommandBuild
{
    private final String id;
    private final String main;
    private final String permission;
    private final List<String> aliases;
    
    public CommandBuild(final String id, final String main, final String permission, final List<String> aliases) {
        this.id = id;
        this.main = main;
        this.permission = permission;
        this.aliases = aliases;
    }
    
    @Deprecated
    public CommandBuild(final String id, final String permission, final List<String> aliases) {
        this(id, id, permission, aliases);
    }
    
    public final String getId() {
        return this.id;
    }
    
    public final String getMain() {
        return this.main;
    }
    
    public final String getPermission() {
        return this.permission;
    }
    
    public final List<String> getAliases() {
        return this.aliases;
    }
    
    public final boolean isMatch(final String command) {
        for (final String key : this.aliases) {
            if (key.equalsIgnoreCase(command)) {
                return true;
            }
        }
        return false;
    }
    
    @Deprecated
    public final String getID() {
        return this.id;
    }
}
