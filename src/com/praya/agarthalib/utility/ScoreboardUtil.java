// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import org.bukkit.scoreboard.Team;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.entity.Player;

public class ScoreboardUtil
{
    public static final boolean hasScoreboard(final Player player) {
        return player != null && player.getScoreboard() != null;
    }
    
    public static final Objective getObjective(final Player player, final DisplaySlot slot) {
        if (player != null && slot != null) {
            final Scoreboard scoreboard = player.getScoreboard();
            return (scoreboard != null) ? scoreboard.getObjective(slot) : null;
        }
        return null;
    }
    
    public static final Objective getObjective(final Player player, final String name) {
        if (player != null && name != null) {
            final Scoreboard scoreboard = player.getScoreboard();
            return (scoreboard != null) ? scoreboard.getObjective(name) : null;
        }
        return null;
    }
    
    public static final String getObjectiveName(final Player player, final DisplaySlot slot) {
        return (player != null && slot != null) ? (hasObjective(player, slot) ? getObjective(player, slot).getName() : null) : null;
    }
    
    public static final boolean hasObjective(final Player player, final DisplaySlot slot) {
        return hasScoreboard(player) && getObjective(player, slot) != null;
    }
    
    public static final boolean hasObjective(final Player player, final String name) {
        return hasScoreboard(player) && getObjective(player, name) != null;
    }
    
    public static final boolean isMatch(final Player player, final String name, final DisplaySlot slot) {
        return player != null && name != null && slot != null && hasObjective(player, slot) && name.equalsIgnoreCase(getObjectiveName(player, slot));
    }
    
    public static final void setTitle(final Player player, final Objective objective, String title) {
        if (objective != null && title != null) {
            title = TextUtil.hookPlaceholderAPI(player, title);
            title = TextUtil.colorful(title);
            objective.setDisplayName(title);
        }
    }
    
    public static final void setMessage(final Player player, final Team team, final String message, final int index, final int prefix, final int suffix, final boolean update) {
        final String textEntry = generateEntry(index);
        if (textEntry != null) {
            setMessage(player, team, message, textEntry, prefix, suffix, update);
        }
    }
    
    public static final void setMessage(final Player player, final Team team, final String rawMessage, final String rawEntry, final int prefix, final int suffix, final boolean update) {
        if (team != null && rawMessage != null && rawEntry != null) {
            final String message = TextUtil.colorful(TextUtil.hookPlaceholderAPI(player, rawMessage));
            final String entry = TextUtil.colorful(TextUtil.hookPlaceholderAPI(player, rawEntry));
            final int length = message.length();
            String textPrefix;
            String textSuffix;
            if (length > 0) {
                final int lengthPrefix = (length > prefix) ? prefix : length;
                final int lengthLeft = length - lengthPrefix;
                final int lengthSuffix = (lengthLeft > suffix) ? suffix : lengthLeft;
                textPrefix = message.substring(0, lengthPrefix);
                textSuffix = ((lengthLeft > 0) ? message.substring(lengthPrefix, lengthPrefix + lengthSuffix) : "");
            }
            else {
                final int lengthPrefix = 0;
                final int lengthLeft = 0;
                final int lengthSuffix = 0;
                textPrefix = "";
                textSuffix = "";
            }
            if (!update) {
                team.addEntry(entry);
            }
            final String colorGen = DataUtil.colorGen(textPrefix);
            textSuffix = String.valueOf(colorGen) + textSuffix;
            textSuffix = ((textSuffix.length() > suffix) ? textSuffix.substring(0, suffix) : textSuffix);
            team.setPrefix(textPrefix);
            team.setSuffix(textSuffix);
        }
    }
    
    public static final void updateScore(final Player player, final Objective objective, final int index) {
        if (objective != null) {
            final String entry = TextUtil.colorful(TextUtil.hookPlaceholderAPI(player, generateEntry(index)));
            objective.getScore(entry).setScore(index);
        }
    }
    
    public static final String generateEntry(final int index) {
        String space = "";
        for (int t = 0; t < index; ++t) {
            space = String.valueOf(space) + "&r";
        }
        return TextUtil.colorful(space);
    }
}
