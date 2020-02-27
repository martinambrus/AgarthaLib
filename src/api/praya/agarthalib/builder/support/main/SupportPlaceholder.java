// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.support.main;

import org.bukkit.OfflinePlayer;

public interface SupportPlaceholder
{
    String setPlaceholders(final OfflinePlayer p0, final String p1);
    
    public enum SupportPlaceholderType
    {
        PLACEHOLDER_API("PLACEHOLDER_API", 0), 
        PLACEHOLDER_MVDW("PLACEHOLDER_MVDW", 1);
        
        private SupportPlaceholderType(final String name, final int ordinal) {
        }
        
        public static final SupportPlaceholderType getSupportPlaceholderType(final String type) {
            if (type != null) {
                SupportPlaceholderType[] values;
                for (int length = (values = values()).length, i = 0; i < length; ++i) {
                    final SupportPlaceholderType key = values[i];
                    if (key.toString().equalsIgnoreCase(type)) {
                        return key;
                    }
                }
            }
            return null;
        }
    }
}
