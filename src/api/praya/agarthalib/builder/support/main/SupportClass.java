// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.support.main;

import java.util.List;
import org.bukkit.OfflinePlayer;

public interface SupportClass
{
    String getPlayerMainClassName(final OfflinePlayer p0);
    
    List<String> getClasses();
    
    List<String> getPlayerClasses(final OfflinePlayer p0);
    
    boolean isSupportMultiClass();
    
    boolean isPlayerHasMainClass(final OfflinePlayer p0);
    
    boolean isPlayerHasClass(final OfflinePlayer p0, final String p1);
    
    boolean isPlayerJoinClass(final OfflinePlayer p0, final String p1);
    
    boolean isClassExists(final String p0);
    
    public enum SupportClassType
    {
        SKILL_API("SKILL_API", 0), 
        SKILLS_PRO("SKILLS_PRO", 1), 
        HEROES("HEROES", 2);
        
        private SupportClassType(final String name, final int ordinal) {
        }
        
        public static final SupportClassType getSupportClassType(final String type) {
            if (type != null) {
                SupportClassType[] values;
                for (int length = (values = values()).length, i = 0; i < length; ++i) {
                    final SupportClassType key = values[i];
                    if (key.toString().equalsIgnoreCase(type)) {
                        return key;
                    }
                }
            }
            return null;
        }
    }
}
