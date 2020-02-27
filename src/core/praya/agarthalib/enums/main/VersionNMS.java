// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.enums.main;

public enum VersionNMS
{
    V1_7_R4("V1_7_R4", 3, "V1_7_R4"),
    V1_8_R3("V1_8_R3", 6, "V1_8_R3"),
    V1_9_R2("V1_9_R2", 8, "V1_9_R2"),
    V1_10_R1("V1_10_R1", 9, "V1_10_R1"), 
    V1_11_R1("V1_11_R1", 10, "V1_11_R1"), 
    V1_12_R1("V1_12_R1", 11, "V1_12_R1"), 
    V1_13_R2("V1_13_R2", 13, "V1_13_R2"),
    V1_14_R1("V1_14_R1", 14, "V1_14_R1"),
    V1_15_R1("V1_15_R1", 15, "V1_15_R1");
    
    private final String text;
    
    private VersionNMS(final String name, final int ordinal, final String text) {
        this.text = text;
    }
    
    public final String getText() {
        return this.text;
    }
    
    public static final VersionNMS getVersionNMS(final String version) {
        if (version != null) {
            VersionNMS[] values;
            for (int length = (values = values()).length, i = 0; i < length; ++i) {
                final VersionNMS key = values[i];
                if (key.getText().equalsIgnoreCase(version)) {
                    return key;
                }
            }
        }
        return null;
    }
    
    public static final boolean isVersionNMSExists(final String version) {
        return getVersionNMS(version) != null;
    }
}
