// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.message;

import java.util.Iterator;
import java.util.Arrays;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import java.util.Collection;

public interface BossBar
{
    String getID();
    
    int getPriority();
    
    Collection<Player> getPlayers();
    
    void addPlayer(final Player p0);
    
    void removePlayer(final Player p0);
    
    void remove();
    
    Color getColor();
    
    void setColor(final Color p0);
    
    Style getStyle();
    
    void setStyle(final Style p0);
    
    void setProperty(final Property p0, final boolean p1);
    
    String getMessage();
    
    void setVisible(final boolean p0);
    
    boolean isVisible();
    
    float getProgress();
    
    void setProgress(final float p0);
    
    void copyData(final BossBar p0);
    
    float getMaxHealth();
    
    void setHealth(final float p0);
    
    float getHealth();
    
    void setMessage(final String p0);
    
    Player getReceiver();
    
    Location getLocation();
    
    void updateMovement();
    
    public enum Color
    {
        PINK(Arrays.asList("Pink")), 
        BLUE(Arrays.asList("Blue")), 
        RED(Arrays.asList("Red")), 
        GREEN(Arrays.asList("Green")), 
        YELLOW(Arrays.asList("Yellow")), 
        PURPLE(Arrays.asList("Purple")), 
        WHITE(Arrays.asList("White"));
        
        private final List<String> aliases;
        
        private Color(final List<String> aliases) {
            this.aliases = aliases;
        }
        
        public final List<String> getAliases() {
            return this.aliases;
        }
        
        public static final Color getColor(final String color) {
            Color[] values;
            for (int length = (values = values()).length, i = 0; i < length; ++i) {
                final Color key = values[i];
                for (final String aliases : key.getAliases()) {
                    if (aliases.equalsIgnoreCase(color)) {
                        return key;
                    }
                }
            }
            return null;
        }
    }
    
    public enum Property
    {
        DARKEN_SKY(Arrays.asList("Darken_Sky")), 
        PLAY_MUSIC(Arrays.asList("Play_Music")), 
        CREATE_FOG(Arrays.asList("Create_Fog"));
        
        private final List<String> aliases;
        
        private Property(final List<String> aliases) {
            this.aliases = aliases;
        }
        
        public final List<String> getAliases() {
            return this.aliases;
        }
        
        public static final Property getProperty(final String property) {
            Property[] values;
            for (int length = (values = values()).length, i = 0; i < length; ++i) {
                final Property key = values[i];
                for (final String aliases : key.getAliases()) {
                    if (aliases.equalsIgnoreCase(property)) {
                        return key;
                    }
                }
            }
            return null;
        }
    }
    
    public enum Style
    {
        PROGRESS(Arrays.asList("Progress")), 
        NOTCHED_6(Arrays.asList("Notched_6")), 
        NOTCHED_10(Arrays.asList("Notched_10")), 
        NOTCHED_12(Arrays.asList("Notched_12")), 
        NOTCHED_20(Arrays.asList("Notched_20"));
        
        private final List<String> aliases;
        
        private Style(final List<String> aliases) {
            this.aliases = aliases;
        }
        
        public final List<String> getAliases() {
            return this.aliases;
        }
        
        public static final Style getStyle(final String style) {
            Style[] values;
            for (int length = (values = values()).length, i = 0; i < length; ++i) {
                final Style key = values[i];
                for (final String aliases : key.getAliases()) {
                    if (aliases.equalsIgnoreCase(style)) {
                        return key;
                    }
                }
            }
            return null;
        }
    }
}
