// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.text;

import java.util.ArrayList;
import java.util.List;

public class TextList implements Text
{
    private final List<String> textList;
    private int index;
    
    public TextList() {
        this(new ArrayList<String>());
    }
    
    public TextList(final String text) {
        final List<String> list = new ArrayList<String>();
        list.add(text);
        this.textList = list;
        this.index = 0;
    }
    
    public TextList(final List<String> textList) {
        this.textList = textList;
        this.index = 0;
    }
    
    @Override
    public final String getText() {
        return this.textList.isEmpty() ? "" : this.textList.get(0);
    }
    
    public final List<String> getTextList() {
        return this.textList;
    }
    
    public final void addText(final String text) {
        this.textList.add(text);
    }
    
    public final void removeLastText() {
        final int size = this.textList.size();
        if (size > 0) {
            this.textList.remove(size - 1);
        }
    }
    
    public final void clearText() {
        this.textList.clear();
    }
    
    public final String next() {
        final int size = this.textList.size();
        final String text = (this.index < size) ? this.textList.get(this.index) : "";
        ++this.index;
        if (this.index >= size) {
            this.index = 0;
        }
        return text;
    }
}
