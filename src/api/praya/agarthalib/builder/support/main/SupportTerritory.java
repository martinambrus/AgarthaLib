// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.support.main;

import org.bukkit.OfflinePlayer;
import org.bukkit.Location;
import org.bukkit.block.Block;

public interface SupportTerritory
{
    String getTerritoryOwner(final Block p0);
    
    String getTerritoryOwner(final Location p0);
    
    boolean hasTerritoryOwner(final Block p0);
    
    boolean hasTerritoryOwner(final Location p0);
    
    boolean isTerritoryOwner(final Block p0, final OfflinePlayer p1);
    
    boolean isTerritoryOwner(final Block p0, final String p1);
    
    boolean isTerritoryOwner(final Location p0, final OfflinePlayer p1);
    
    boolean isTerritoryOwner(final Location p0, final String p1);
    
    double getTerritoryPower(final OfflinePlayer p0);
    
    double getTerritoryPower(final String p0);
    
    double getTerritoryMaxPower(final OfflinePlayer p0);
    
    double getTerritoryMaxPower(final String p0);
    
    double getTerritoryPermanentPower(final OfflinePlayer p0);
    
    double getTerritoryPermanentPower(final String p0);
    
    void setTerritoryPermanentPower(final OfflinePlayer p0, final double p1);
    
    void setTerritoryPermanentPower(final String p0, final double p1);
    
    double getPlayerPower(final OfflinePlayer p0);
    
    double getPlayerMaxPower(final OfflinePlayer p0);
    
    void setPlayerPower(final OfflinePlayer p0, final double p1);
    
    public enum SupportTerritoryType
    {
        FACTIONS("FACTIONS", 0);
        
        private SupportTerritoryType(final String name, final int ordinal) {
        }
        
        public static final SupportTerritoryType getSupportTerritoryType(final String type) {
            if (type != null) {
                SupportTerritoryType[] values;
                for (int length = (values = values()).length, i = 0; i < length; ++i) {
                    final SupportTerritoryType key = values[i];
                    if (key.toString().equalsIgnoreCase(type)) {
                        return key;
                    }
                }
            }
            return null;
        }
    }
}
