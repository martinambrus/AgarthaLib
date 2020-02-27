// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.enums.main;

public enum Dependency
{
    SOFT_DEPENDENCY("SOFT_DEPENDENCY", 0, "Soft-Dependency"), 
    HARD_DEPENDENCY("HARD_DEPENDENCY", 1, "Hard-Dependency");
    
    private final String name;
    
    private Dependency(final String name2, final int ordinal, final String name) {
        this.name = name;
    }
    
    public final String getName() {
        return this.name;
    }
}
