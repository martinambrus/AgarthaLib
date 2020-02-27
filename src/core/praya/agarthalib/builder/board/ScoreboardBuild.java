// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.board;

import org.bukkit.scoreboard.Team;
import com.praya.agarthalib.utility.DataUtil;
import com.praya.agarthalib.utility.TextUtil;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.entity.Player;

public class ScoreboardBuild
{
    private final Player player;
    private final Scoreboard scoreboard;
    
    public ScoreboardBuild(final Player player) {
        this.player = player;
        this.scoreboard = player.getScoreboard();
    }
    
    public final Objective registerObjective() {
        return this.registerObjective("Default", "", DisplaySlot.SIDEBAR);
    }
    
    public final Objective registerObjective(final String name) {
        return this.registerObjective(name, "", DisplaySlot.SIDEBAR);
    }
    
    public final Objective registerObjective(final String name, final String criteria) {
        return this.registerObjective(name, criteria, DisplaySlot.SIDEBAR);
    }
    
    public final Objective registerObjective(final String name, final String criteria, final DisplaySlot slot) {
        final Objective objective = this.scoreboard.registerNewObjective(name, criteria);
        objective.setDisplaySlot(slot);
        return objective;
    }
    
    public final Objective getObjective(final DisplaySlot slot) {
        return (this.scoreboard.getObjective(slot) != null) ? this.scoreboard.getObjective(slot) : this.registerObjective("Default", "", slot);
    }
    
    public final void setDisplayName(final String displayName, final DisplaySlot slot) {
        final Objective objective = this.getObjective(slot);
        final String formatName = TextUtil.colorful(TextUtil.hookPlaceholderAPI(this.player, displayName));
        final String finalName = TextUtil.limitString(formatName, 32);
        objective.setDisplayName(finalName);
    }
    
    public final void setLineboard(final String text, final int index, final DisplaySlot slot) {
        final String message = TextUtil.colorful(TextUtil.hookPlaceholderAPI(this.player, text));
        final String entry = this.getEntry(index);
        final Objective objective = this.getObjective(slot);
        final Team team = this.getLineboard(index, slot);
        final int length = message.length();
        String textPrefix;
        String textSuffix;
        if (length > 0) {
            final int lengthPrefix = (length > 16) ? 16 : length;
            final int lengthLeft = length - lengthPrefix;
            final int lengthSuffix = (lengthLeft > 16) ? 16 : lengthLeft;
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
        final String colorGen = DataUtil.colorGen(textPrefix);
        textSuffix = String.valueOf(colorGen) + textSuffix;
        textSuffix = ((textSuffix.length() > 16) ? textSuffix.substring(0, 16) : textSuffix);
        team.setPrefix(textPrefix);
        team.setSuffix(textSuffix);
        objective.getScore(entry).setScore(index);
    }
    
    private final Team registerLineboard(final int index) {
        final String entry = this.getEntry(index);
        final Team team = this.scoreboard.getTeam(entry);
        team.addEntry(entry);
        return team;
    }
    
    private final Team getLineboard(final int index, final DisplaySlot slot) {
        final String entry = this.getEntry(index);
        return (this.scoreboard.getEntryTeam(entry) != null) ? this.scoreboard.getEntryTeam(entry) : this.registerLineboard(index);
    }
    
    private final String getEntry(final int index) {
        return "Lineboard " + index;
    }
}
