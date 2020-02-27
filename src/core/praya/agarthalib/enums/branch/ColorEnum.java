// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.enums.branch;

import java.util.Iterator;
import java.util.Arrays;
import java.util.List;
import org.bukkit.Color;

public enum ColorEnum
{
    AQUA(Color.AQUA, Arrays.asList("Aqua", "Light Blue")), 
    BLACK(Color.BLACK, Arrays.asList("Black")), 
    BLUE(Color.BLUE, Arrays.asList("Blue")), 
    FUCHSIA(Color.FUCHSIA, Arrays.asList("Fuchsia")), 
    GRAY(Color.GRAY, Arrays.asList("Gray")), 
    GREEN(Color.GREEN, Arrays.asList("Green")), 
    LIME(Color.LIME, Arrays.asList("Lime")), 
    MAROON(Color.MAROON, Arrays.asList("Maroon")), 
    NAVY(Color.NAVY, Arrays.asList("Navy")), 
    OLIVE(Color.OLIVE, Arrays.asList("Olive")), 
    ORANGE(Color.ORANGE, Arrays.asList("Orange")), 
    PURPLE(Color.PURPLE, Arrays.asList("Purple")), 
    RED(Color.RED, Arrays.asList("Red")), 
    SILVER(Color.SILVER, Arrays.asList("Silver")), 
    TEAL(Color.TEAL, Arrays.asList("Teal")), 
    WHITE(Color.WHITE, Arrays.asList("White")), 
    YELLOW(Color.YELLOW, Arrays.asList("Yellow"));
    
    private final Color color;
    private final List<String> aliases;
    
    private ColorEnum(final Color color, final List<String> aliases) {
        this.color = color;
        this.aliases = aliases;
    }
    
    private ColorEnum(final int red, final int green, final int blue, final List<String> aliases) {
        this.color = Color.fromRGB(red, green, blue);
        this.aliases = aliases;
    }
    
    public final Color getColor() {
        return this.color;
    }
    
    public final List<String> getAliases() {
        return this.aliases;
    }
    
    public static final ColorEnum getColorEnum(final String color) {
        if (color != null) {
            ColorEnum[] values;
            for (int length = (values = values()).length, i = 0; i < length; ++i) {
                final ColorEnum key = values[i];
                for (final String aliases : key.getAliases()) {
                    if (aliases.equalsIgnoreCase(color)) {
                        return key;
                    }
                }
            }
        }
        return null;
    }
}
