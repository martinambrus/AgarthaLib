// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.support.main;

import org.bukkit.entity.Player;
import org.bukkit.OfflinePlayer;
import java.util.Collection;

public interface SupportGroup
{
    Collection<String> getGroupIDs();
    
    Collection<String> getGroupNames();
    
    String getGroupNameByID(final String p0);
    
    String getGroupIDByName(final String p0);
    
    boolean isGroupIDExists(final String p0);
    
    boolean isGroupNameExists(final String p0);
    
    boolean isPlayerJoinGroup(final OfflinePlayer p0);
    
    Collection<Player> getOnlinePlayersByGroupID(final String p0);
    
    Collection<Player> getOnlinePlayersByGroupName(final String p0);
    
    Collection<OfflinePlayer> getGroupPlayersByID(final String p0);
    
    Collection<OfflinePlayer> getGroupPlayersByName(final String p0);
    
    String getPlayerGroupID(final OfflinePlayer p0);
    
    String getPlayerGroupName(final OfflinePlayer p0);
    
    public enum SupportGroupRole
    {
        LEADER("LEADER", 0, 4), 
        CO_LEADER("CO_LEADER", 1, 3), 
        MODERATOR("MODERATOR", 2, 2), 
        MEMBER("MEMBER", 3, 1);
        
        private final int priority;
        
        private SupportGroupRole(final String name, final int ordinal, final int priority) {
            this.priority = priority;
        }
        
        public final int getPriority() {
            return this.priority;
        }
        
        public final boolean hasPermission(final SupportGroupRole supportGroupRole) {
            if (supportGroupRole != null) {
                final int priority = supportGroupRole.getPriority();
                return priority <= this.getPriority();
            }
            return true;
        }
        
        public static final SupportGroupRole getSupportGroupRole(final String type) {
            if (type != null) {
                SupportGroupRole[] values;
                for (int length = (values = values()).length, i = 0; i < length; ++i) {
                    final SupportGroupRole key = values[i];
                    if (key.toString().equalsIgnoreCase(type)) {
                        return key;
                    }
                }
            }
            return null;
        }
    }
    
    public enum SupportGroupType
    {
        FACTIONS("FACTIONS", 0), 
        KINGDOMS("KINGDOMS", 1), 
        GANGS("GANGS", 2), 
        TOWNY("TOWNY", 3), 
        SIMPLE_CLANS("SIMPLE_CLANS", 4);
        
        private SupportGroupType(final String name, final int ordinal) {
        }
        
        public static final SupportGroupType getSupportGroupType(final String type) {
            if (type != null) {
                SupportGroupType[] values;
                for (int length = (values = values()).length, i = 0; i < length; ++i) {
                    final SupportGroupType key = values[i];
                    if (key.toString().equalsIgnoreCase(type)) {
                        return key;
                    }
                }
            }
            return null;
        }
    }
}
