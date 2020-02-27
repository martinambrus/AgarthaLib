// 
// Decompiled by Procyon v0.5.36
// 

package api.praya.agarthalib.builder.support;

import java.util.ArrayList;
import com.gamingmesh.jobs.container.JobProgression;
import java.util.UUID;
import com.gamingmesh.jobs.container.JobsPlayer;
import org.bukkit.OfflinePlayer;
import java.util.Iterator;
import com.gamingmesh.jobs.Jobs;
import com.gamingmesh.jobs.container.Job;
import java.util.Collection;
import org.bukkit.plugin.Plugin;
import com.praya.agarthalib.AgarthaLib;
import api.praya.agarthalib.builder.support.main.Support;

public class SupportJobsReborn extends Support
{
    public SupportJobsReborn(final AgarthaLib plugin, final Plugin source) {
        super(plugin, source);
    }
    
    public final Collection<Job> getJobs() {
        return (Collection<Job>)Jobs.getJobs();
    }
    
    public final Job getJob(final String name) {
        if (name != null) {
            for (final Job job : this.getJobs()) {
                final String jobName = job.getName();
                if (jobName.equalsIgnoreCase(name)) {
                    return job;
                }
            }
        }
        return null;
    }
    
    public final boolean isJobExists(final String name) {
        return this.getJob(name) != null;
    }
    
    public final JobsPlayer getJobsPlayer(final OfflinePlayer player) {
        if (player != null) {
            final UUID playerID = player.getUniqueId();
            return Jobs.getPlayerManager().getJobsPlayer(playerID);
        }
        return null;
    }
    
    public final Collection<JobProgression> getJobProgressionList(final OfflinePlayer player) {
        final JobsPlayer jobsPlayer = this.getJobsPlayer(player);
        return (jobsPlayer != null) ? jobsPlayer.getJobProgression() : new ArrayList<JobProgression>();
    }
    
    public final JobProgression getJobProgression(final OfflinePlayer player, final Job job) {
        final JobsPlayer jobsPlayer = this.getJobsPlayer(player);
        return (jobsPlayer != null && job != null) ? jobsPlayer.getJobProgression(job) : null;
    }
    
    public final double getExperience(final OfflinePlayer player, final String name) {
        final Job job = this.getJob(name);
        return this.getExperience(player, job);
    }
    
    public final double getExperience(final OfflinePlayer player, final Job job) {
        final JobProgression jobProgression = this.getJobProgression(player, job);
        return (jobProgression != null) ? jobProgression.getExperience() : 0.0;
    }
    
    public final double getMaxExperience(final OfflinePlayer player, final String name) {
        final Job job = this.getJob(name);
        return (job != null) ? this.getMaxExperience(player, job) : 0.0;
    }
    
    public final double getMaxExperience(final OfflinePlayer player, final Job job) {
        if (player != null && job != null) {
            final int level = this.getLevel(player, job);
            return this.getMaxExperience(player, job, level);
        }
        return 0.0;
    }
    
    public final double getMaxExperience(final OfflinePlayer player, final String name, final int level) {
        final Job job = this.getJob(name);
        return (job != null) ? this.getMaxExperience(player, job, level) : 0.0;
    }
    
    public final double getMaxExperience(final OfflinePlayer player, final Job job, final int level) {
        final JobProgression jobProgression = this.getJobProgression(player, job);
        return (jobProgression != null) ? jobProgression.getMaxExperience(level) : 0;
    }
    
    public final int getLevel(final OfflinePlayer player, final String name) {
        final Job job = this.getJob(name);
        return (job != null) ? this.getLevel(player, job) : 0;
    }
    
    public final int getLevel(final OfflinePlayer player, final Job job) {
        final JobProgression jobProgression = this.getJobProgression(player, job);
        return (jobProgression != null) ? jobProgression.getLevel() : 0;
    }
    
    public final void addExperience(final OfflinePlayer player, final String name, final double exp) {
        final Job job = this.getJob(name);
        if (job != null) {
            this.addExperience(player, job, exp);
        }
    }
    
    public final void addExperience(final OfflinePlayer player, final Job job, final double exp) {
        final JobProgression jobProgression = this.getJobProgression(player, job);
        if (jobProgression != null) {
            jobProgression.addExperience(exp);
        }
    }
    
    public final void setExperience(final OfflinePlayer player, final String name, final double exp) {
        final Job job = this.getJob(name);
        if (job != null) {
            this.setExperience(player, job, exp);
        }
    }
    
    public final void setExperience(final OfflinePlayer player, final Job job, final double exp) {
        final JobProgression jobProgression = this.getJobProgression(player, job);
        if (jobProgression != null) {
            jobProgression.setExperience(exp);
        }
    }
    
    public final void takeExperience(final OfflinePlayer player, final String name, final double exp) {
        final Job job = this.getJob(name);
        if (job != null) {
            this.takeExperience(player, job, exp);
        }
    }
    
    public final void takeExperience(final OfflinePlayer player, final Job job, final double exp) {
        final JobProgression jobProgression = this.getJobProgression(player, job);
        if (jobProgression != null) {
            jobProgression.takeExperience(exp);
        }
    }
    
    public final void setLevel(final OfflinePlayer player, final String name, final int level) {
        final Job job = this.getJob(name);
        if (job != null) {
            this.setLevel(player, job, level);
        }
    }
    
    public final void setLevel(final OfflinePlayer player, final Job job, final int level) {
        final JobProgression jobProgression = this.getJobProgression(player, job);
        if (jobProgression != null) {
            jobProgression.setLevel(level);
        }
    }
}
