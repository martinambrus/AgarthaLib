// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.text;

public class TextLine implements Text
{
    private final String text;
    
    public TextLine() {
        this("");
    }
    
    public TextLine(final String text) {
        this.text = text;
    }
    
    @Override
    public final String getText() {
        return this.text;
    }
}
