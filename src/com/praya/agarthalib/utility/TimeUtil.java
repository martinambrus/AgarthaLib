// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import com.praya.agarthalib.manager.plugin.LanguageManager;
import com.praya.agarthalib.manager.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.praya.agarthalib.AgarthaLib;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil
{
    public static final long getNow() {
        return System.currentTimeMillis();
    }
    
    public static final Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }
    
    public static final Calendar convertDateToCalendar(final Date date) {
        if (date != null) {
            final Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar;
        }
        return null;
    }
    
    public static final Date convertCalendarToDate(final Calendar calendar) {
        return (calendar != null) ? calendar.getTime() : null;
    }
    
    public static final int getDate(final Date date) {
        return (date != null) ? convertDateToCalendar(date).get(5) : -1;
    }
    
    public static final int getDay(final Date date) {
        return (date != null) ? convertDateToCalendar(date).get(7) : -1;
    }
    
    public static final int getMonth(final Date date) {
        return (date != null) ? convertDateToCalendar(date).get(2) : -1;
    }
    
    public static final int getYear(final Date date) {
        return (date != null) ? convertDateToCalendar(date).get(1) : -1;
    }
    
    public static final int getSecond(final Date date) {
        return (date != null) ? convertDateToCalendar(date).get(13) : -1;
    }
    
    public static final int getMinute(final Date date) {
        return (date != null) ? convertDateToCalendar(date).get(12) : -1;
    }
    
    public static final int getHour(final Date date) {
        return (date != null) ? convertDateToCalendar(date).get(11) : -1;
    }
    
    public static final String getTextTime(final long milis) {
        final AgarthaLib agarthaLib = (AgarthaLib)JavaPlugin.getPlugin((Class)AgarthaLib.class);
        final PluginManager pluginManager = agarthaLib.getPluginManager();
        final LanguageManager lang = pluginManager.getLanguageManager();
        final String timeDays = lang.getText("Time_Days");
        final String timeHours = lang.getText("Time_Hours");
        final String timeMinutes = lang.getText("Time_Minutes");
        final String timeSeconds = lang.getText("Time_Seconds");
        final StringBuilder timeBuilder = new StringBuilder();
        double leftTime = (double)milis;
        leftTime /= 1000.0;
        final int days = (int)(leftTime / 86400.0);
        leftTime -= days * 86400;
        final int hours = (int)(leftTime / 3600.0);
        leftTime -= hours * 3600;
        final int minutes = (int)(leftTime / 60.0);
        leftTime -= minutes * 60;
        final double seconds = MathUtil.roundNumber(leftTime, 2);
        if (days > 0) {
            timeBuilder.append(days).append(" ").append(timeDays).append(" ");
            timeBuilder.append(hours).append(" ").append(timeHours).append(" ");
            timeBuilder.append(minutes).append(" ").append(timeMinutes).append(" ");
            timeBuilder.append(seconds).append(" ").append(timeSeconds);
        }
        else if (hours > 0) {
            timeBuilder.append(hours).append(" ").append(timeHours).append(" ");
            timeBuilder.append(minutes).append(" ").append(timeMinutes).append(" ");
            timeBuilder.append(seconds).append(" ").append(timeSeconds);
        }
        else if (minutes > 0) {
            timeBuilder.append(minutes).append(" ").append(timeMinutes).append(" ");
            timeBuilder.append(seconds).append(" ").append(timeSeconds);
        }
        else {
            timeBuilder.append(seconds).append(" ").append(timeSeconds);
        }
        return timeBuilder.toString();
    }
}
