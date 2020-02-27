// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.enums.main;

import java.util.Iterator;
import java.util.Arrays;
import java.util.List;

public enum JsonOption
{
    TEXT(Arrays.asList("Text"), "text"), 
    COLOR(Arrays.asList("Color", "Clr"), "color"), 
    INSERTION(Arrays.asList("Insertion", "Insert"), "insertion"), 
    CLICK_OPEN_URL(Arrays.asList("URL", "Link"), "open_url"), 
    CLICK_RUN_COMMAND(Arrays.asList("Command", "Cmd", "Run"), "run_command"), 
    CLICK_SUGGEST_COMMAND(Arrays.asList("Suggest Command", "Suggest_Command", "SuggestCommand", "Suggest", "Sgt"), "suggest_command"), 
    CLICK_CHANGE_PAGE(Arrays.asList("Change Page", "Change Pages", "Change_Page", "Change_Pages", "Page", "Pages"), "change_page"), 
    HOVER_SHOW_TEXT(Arrays.asList("Show Text", "Show_Text", "Tooltip", "Ttp"), "show_text"), 
    HOVER_SHOW_ACHIEVEMENT(Arrays.asList("Achievement", "Ach"), "show_achievement"), 
    HOVER_SHOW_ENTITY(Arrays.asList("Entity"), "show_entity"), 
    HOVER_SHOW_ITEM(Arrays.asList("Item", "Itm"), "show_item");
    
    private List<String> aliases;
    private String text;
    
    private JsonOption(final List<String> aliases, final String text) {
        this.aliases = aliases;
        this.text = text;
    }
    
    public final List<String> getAliases() {
        return this.aliases;
    }
    
    public final String getText() {
        return this.text;
    }
    
    public static final JsonOption getJsonOption(final String option) {
        if (option != null) {
            JsonOption[] values;
            for (int length = (values = values()).length, i = 0; i < length; ++i) {
                final JsonOption key = values[i];
                for (final String aliases : key.getAliases()) {
                    if (aliases.equalsIgnoreCase(option)) {
                        return key;
                    }
                }
            }
        }
        return JsonOption.TEXT;
    }
    
    @Deprecated
    public static final JsonOption get(final String option) {
        return getJsonOption(option);
    }
}
