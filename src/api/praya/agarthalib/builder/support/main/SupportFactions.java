// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.support.main;

import org.bukkit.entity.Player;
import java.util.Collection;
import org.bukkit.OfflinePlayer;
import java.util.UUID;

public interface SupportFactions extends SupportGroup, SupportTerritory
{
    UUID getGroupLeaderByID(final String p0);
    
    UUID getGroupLeaderByName(final String p0);
    
    SupportGroupRole getPlayerRole(final OfflinePlayer p0);
    
    boolean matchPlayerRole(final OfflinePlayer p0, final SupportGroupRole p1);
    
    boolean isGroupOwner(final OfflinePlayer p0);
    
    Collection<Player> getOnlinePlayersByGroupID(final String p0, final SupportGroupRole p1);
    
    Collection<Player> getOnlinePlayersByGroupName(final String p0, final SupportGroupRole p1);
    
    Collection<OfflinePlayer> getGroupPlayersByID(final String p0, final SupportGroupRole p1);
    
    Collection<OfflinePlayer> getGroupPlayersByName(final String p0, final SupportGroupRole p1);
    
    public enum SupportFactionsType
    {
        FACTIONS_UUID("FACTIONS_UUID", 0), 
        FACTIONS_MASSIVE("FACTIONS_MASSIVE", 1), 
        FACTIONS_LEGACY("FACTIONS_LEGACY", 2);
        
        private SupportFactionsType(final String name, final int ordinal) {
        }
        
        public static final SupportFactionsType getSupportFactionsType(final String type) {
            if (type != null) {
                SupportFactionsType[] values;
                for (int length = (values = values()).length, i = 0; i < length; ++i) {
                    final SupportFactionsType key = values[i];
                    if (key.toString().equalsIgnoreCase(type)) {
                        return key;
                    }
                }
            }
            return null;
        }
    }
}
