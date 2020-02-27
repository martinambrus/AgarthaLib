// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.support.main;

import org.bukkit.OfflinePlayer;

public interface SupportLevel
{
    int getPlayerLevel(final OfflinePlayer p0);
    
    void addPlayerLevel(final OfflinePlayer p0, final int p1);
    
    void setPlayerLevel(final OfflinePlayer p0, final int p1);
    
    public enum SupportLevelType
    {
        BATTLE_LEVELS("BATTLE_LEVELS", 0), 
        SKILL_API("SKILL_API", 1), 
        SKILLS_PRO("SKILLS_PRO", 2), 
        HEROES("HEROES", 3);
        
        private SupportLevelType(final String name, final int ordinal) {
        }
        
        public static final SupportLevelType getSupportLevelType(final String type) {
            if (type != null) {
                SupportLevelType[] values;
                for (int length = (values = values()).length, i = 0; i < length; ++i) {
                    final SupportLevelType key = values[i];
                    if (key.toString().equalsIgnoreCase(type)) {
                        return key;
                    }
                }
            }
            return null;
        }
    }
}
