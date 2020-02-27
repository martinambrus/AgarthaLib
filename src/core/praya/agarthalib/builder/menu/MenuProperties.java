// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.menu;

import core.praya.agarthalib.builder.text.TextLine;
import core.praya.agarthalib.builder.text.TextList;
import java.util.List;
import core.praya.agarthalib.builder.text.Text;

public class MenuProperties
{
    private boolean editable;
    private Text title;
    
    public MenuProperties(final List<String> titles) {
        this(new TextList(titles), false);
    }
    
    public MenuProperties(final String title) {
        this(title, false);
    }
    
    public MenuProperties(final List<String> titles, final boolean editable) {
        this(new TextList(titles), editable);
    }
    
    public MenuProperties(final String title, final boolean editable) {
        this(new TextLine(title), editable);
    }
    
    public MenuProperties(final Text title, final boolean editable) {
        this.title = title;
        this.editable = editable;
    }
    
    public final boolean isMenuEditable() {
        return this.editable;
    }
    
    public final void setMenuEditable(final boolean flag) {
        this.editable = flag;
    }
    
    public final Text getTitle() {
        return this.title;
    }
    
    public final void setTitle(final Text title) {
        this.title = title;
    }
}
