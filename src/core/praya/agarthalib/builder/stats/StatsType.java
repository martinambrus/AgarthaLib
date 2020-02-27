// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.builder.stats;

public enum StatsType
{
    BASE_ADDITIONAL_DAMAGE("BASE_ADDITIONAL_DAMAGE", 0, StatsTypeAction.ACCRETION, 0.0), 
    BASE_ADDITIONAL_DEFENSE("BASE_ADDITIONAL_DEFENSE", 1, StatsTypeAction.ACCRETION, 0.0), 
    BASE_PERCENT_DAMAGE("BASE_PERCENT_DAMAGE", 2, StatsTypeAction.ACCRETION, 0.0), 
    BASE_PERCENT_DEFENSE("BASE_PERCENT_DEFENSE", 3, StatsTypeAction.ACCRETION, 0.0), 
    INSTANT_ADDITIONAL_DAMAGE("INSTANT_ADDITIONAL_DAMAGE", 4, StatsTypeAction.ACCRETION, 0.0), 
    INSTANT_ADDITIONAL_DEFENSE("INSTANT_ADDITIONAL_DEFENSE", 5, StatsTypeAction.ACCRETION, 0.0), 
    INSTANT_PERCENT_DAMAGE("INSTANT_PERCENT_DAMAGE", 6, StatsTypeAction.ACCRETION, 0.0), 
    INSTANT_PERCENT_DEFENSE("INSTANT_PERCENT_DEFENSE", 7, StatsTypeAction.ACCRETION, 0.0), 
    FINAL_MULTIPLIER("FINAL_MULTIPLIER", 8, StatsTypeAction.MULTIPLICATION, 1.0);
    
    private final StatsTypeAction action;
    private final double value;
    
    private StatsType(final String name, final int ordinal, final StatsTypeAction action, final double value) {
        this.action = action;
        this.value = value;
    }
    
    public final StatsTypeAction getAction() {
        return this.action;
    }
    
    public final double getValue() {
        return this.value;
    }
    
    public static final StatsType getStatsType(final String type) {
        if (type != null) {
            StatsType[] values;
            for (int length = (values = values()).length, i = 0; i < length; ++i) {
                final StatsType key = values[i];
                if (key.toString().equalsIgnoreCase(type)) {
                    return key;
                }
            }
        }
        return null;
    }
    
    public enum StatsTypeAction
    {
        ACCRETION("ACCRETION", 0), 
        MULTIPLICATION("MULTIPLICATION", 1);
        
        private StatsTypeAction(final String name, final int ordinal) {
        }
        
        public static final StatsTypeAction getStatsTypeAction(final String type) {
            if (type != null) {
                StatsTypeAction[] values;
                for (int length = (values = values()).length, i = 0; i < length; ++i) {
                    final StatsTypeAction key = values[i];
                    if (key.toString().equalsIgnoreCase(type)) {
                        return key;
                    }
                }
            }
            return null;
        }
    }
}
