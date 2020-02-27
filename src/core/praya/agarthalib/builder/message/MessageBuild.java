// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.message;

import com.praya.agarthalib.utility.TextUtil;
import com.praya.agarthalib.utility.SenderUtil;
import org.bukkit.command.CommandSender;
import java.util.HashMap;
import java.util.Collection;
import com.praya.agarthalib.utility.SystemUtil;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class MessageBuild
{
    private final List<String> messages;
    
    public MessageBuild() {
        this.messages = new ArrayList<String>();
    }
    
    public MessageBuild(final String message) {
        final List<String> messages = new ArrayList<String>();
        messages.add(message);
        this.messages = messages;
    }
    
    public MessageBuild(final List<String> messages) {
        this.messages = messages;
    }
    
    public final List<String> getListText() {
        return this.messages;
    }
    
    public final String getText() {
        return this.messages.isEmpty() ? "" : this.messages.get(0);
    }
    
    public final boolean isSet() {
        return !this.messages.isEmpty();
    }
    
    public final void addText(final String message) {
        this.messages.add(message);
    }
    
    public final void addText(final List<String> messages) {
        for (final String message : messages) {
            this.addText(message);
        }
    }
    
    public final void clearText() {
        this.messages.clear();
    }
    
    public final void sendMessage() {
        for (final String message : this.messages) {
            SystemUtil.sendMessage(message);
        }
    }
    
    public final void sendMessage(final String placeholder, final String replacement) {
        final List<String> messages = new ArrayList<String>(this.getListText());
        this.placeholder(messages, placeholder, replacement);
        for (final String message : messages) {
            SystemUtil.sendMessage(message);
        }
    }
    
    public final void sendMessage(final HashMap<String, String> map) {
        final List<String> messages = new ArrayList<String>(this.getListText());
        this.placeholder(messages, map);
        for (final String message : messages) {
            SystemUtil.sendMessage(message);
        }
    }
    
    public final void sendMessage(final CommandSender sender) {
        for (final String message : this.messages) {
            SenderUtil.sendMessage(sender, message, true);
        }
    }
    
    public final void sendMessage(final CommandSender sender, final String placeholder, final String replacement) {
        final List<String> messages = new ArrayList<String>(this.getListText());
        this.placeholder(messages, placeholder, replacement);
        for (final String message : messages) {
            SenderUtil.sendMessage(sender, message, true);
        }
    }
    
    public final void sendMessage(final CommandSender sender, final HashMap<String, String> map) {
        final List<String> messages = new ArrayList<String>(this.getListText());
        this.placeholder(messages, map);
        for (final String message : messages) {
            SenderUtil.sendMessage(sender, message, true);
        }
    }
    
    private final void placeholder(final List<String> messages, final String placeholder, final String replacement) {
        final HashMap<String, String> map = new HashMap<String, String>();
        map.put(placeholder, replacement);
        this.placeholder(messages, map);
    }
    
    private final void placeholder(final List<String> messages, final HashMap<String, String> map) {
        final List<String> clone = new ArrayList<String>(messages);
        messages.clear();
        for (final String message : TextUtil.placeholder(map, clone)) {
            messages.add(message);
        }
    }
}
