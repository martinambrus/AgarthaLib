// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.main;

import java.util.Iterator;
import java.util.Collection;
import core.praya.agarthalib.builder.message.MessageBuild;
import java.util.HashMap;

public class LanguageBuild
{
    private final String locale;
    private final HashMap<String, MessageBuild> mapLanguage;
    
    public LanguageBuild(final String locale, final HashMap<String, MessageBuild> mapLanguage) {
        this.locale = locale;
        this.mapLanguage = mapLanguage;
    }
    
    public final String getLocale() {
        return this.locale;
    }
    
    public final Collection<String> getLanguageKeys() {
        return this.mapLanguage.keySet();
    }
    
    public final Collection<MessageBuild> getListMessage() {
        return this.mapLanguage.values();
    }
    
    public final MessageBuild getMessage(final String key) {
        for (final String part : this.getLanguageKeys()) {
            if (part.equalsIgnoreCase(key)) {
                return this.mapLanguage.get(part);
            }
        }
        return new MessageBuild();
    }
    
    public final boolean hasMessage(final String key) {
        for (final String part : this.getLanguageKeys()) {
            if (part.equalsIgnoreCase(key)) {
                return true;
            }
        }
        return false;
    }
    
    public final void addMessage(final String key, final MessageBuild message) {
        for (final String part : this.getLanguageKeys()) {
            if (part.equalsIgnoreCase(key)) {
                this.mapLanguage.put(part, message);
                return;
            }
        }
        this.mapLanguage.put(key, message);
    }
    
    public final void mergeLanguage(final LanguageBuild language) {
        this.mergeLanguage(language, false);
    }
    
    public final void mergeLanguage(final LanguageBuild language, final boolean combine) {
        for (final String key : language.getLanguageKeys()) {
            final MessageBuild messageBase = language.getMessage(key);
            if (this.hasMessage(key)) {
                final MessageBuild messageTarget = this.getMessage(key);
                if (!combine) {
                    messageTarget.clearText();
                }
                messageTarget.addText(messageBase.getListText());
            }
            else {
                this.addMessage(key, messageBase);
            }
        }
    }
}
