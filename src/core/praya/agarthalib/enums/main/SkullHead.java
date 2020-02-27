// 
// Decompiled by Procyon v0.5.36
// 

package core.praya.agarthalib.enums.main;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.SkullType;

public enum SkullHead
{
    FOOD_TACO("FOOD_TACO", 0, "Crunchy_Taco34", SkullHeadCategory.FOOD), 
    FOOD_ICE_CREAM_SANDWICH("FOOD_ICE_CREAM_SANDWICH", 1, "DutchGuard", SkullHeadCategory.FOOD), 
    FOOD_POPCORN("FOOD_POPCORN", 2, "ZachWarnerHD", SkullHeadCategory.FOOD), 
    FOOD_CAKE("FOOD_CAKE", 3, "MHF_Cake", SkullHeadCategory.FOOD), 
    FOOD_BURGER("FOOD_BURGER", 4, "ImFatIAteTooMuch", SkullHeadCategory.FOOD), 
    FOOD_CAN_OF_SOUP("FOOD_CAN_OF_SOUP", 5, "FlabbenBaggen", SkullHeadCategory.FOOD), 
    FOOD_COOKIE("FOOD_COOKIE", 6, "QuadratCookie", SkullHeadCategory.FOOD), 
    FRUIT_APPLE("FRUIT_APPLE", 7, "MHF_Apple", SkullHeadCategory.FRUIT), 
    FRUIT_MELON("FRUIT_MELON", 8, "MHF_Melon", SkullHeadCategory.FRUIT), 
    MOB_CREEPER("MOB_CREEPER", 9, "MHF_Creeper", SkullHeadCategory.MOB, "CREEPER"), 
    MOB_DRAGON("MOB_DRAGON", 10, "MHF_Dragon", SkullHeadCategory.MOB, "DRAGON"), 
    MOB_SKELETON("MOB_SKELETON", 11, "MHF_Skeleton", SkullHeadCategory.MOB, "SKELETON"), 
    MOB_ZOMBIE("MOB_ZOMBIE", 12, "MHF_Zombie", SkullHeadCategory.MOB, "ZOMBIE"), 
    MOB_WITHER("MOB_WITHER", 13, "MHF_Wither", SkullHeadCategory.MOB, "WITHER"), 
    MOB_WITHER_SKELETON("MOB_WITHER_SKELETON", 14, "MHF_WSkeleton", SkullHeadCategory.MOB), 
    MOB_LAVA_SLIME("MOB_LAVA_SLIME", 15, "MHF_LavaSlime", SkullHeadCategory.MOB), 
    MOB_MUSHROOM_COW("MOB_MUSHROOM_COW", 16, "MHF_MushroomCow", SkullHeadCategory.MOB), 
    MOB_GOLEM("MOB_GOLEM", 17, "MHF_Golem", SkullHeadCategory.MOB), 
    MOB_GHAST("MOB_GHAST", 18, "MHF_Ghast", SkullHeadCategory.MOB), 
    MOB_ENDERMAN("MOB_ENDERMAN", 19, "MHF_Enderman", SkullHeadCategory.MOB), 
    MOB_COW("MOB_COW", 20, "MHF_Cow", SkullHeadCategory.MOB), 
    MOB_CHICKEN("MOB_CHICKEN", 21, "MHF_Chicken", SkullHeadCategory.MOB), 
    MOB_CAVE_SPIDER("MOB_CAVE_SPIDER", 22, "MHF_CaveSpider", SkullHeadCategory.MOB), 
    MOB_BLAZE("MOB_BLAZE", 23, "MHF_Blaze", SkullHeadCategory.MOB), 
    MOB_EAGLE("MOB_EAGLE", 24, "Ximonic", SkullHeadCategory.MOB), 
    MOB_VILLAGER("MOB_VILLAGER", 25, "MHF_Villager", SkullHeadCategory.MOB), 
    MOB_SQUID("MOB_SQUID", 26, "MHF_Squid", SkullHeadCategory.MOB), 
    MOB_SPIDER("MOB_SPIDER", 27, "MHF_Spider", SkullHeadCategory.MOB), 
    MOB_SLIME("MOB_SLIME", 28, "MHF_Slime", SkullHeadCategory.MOB), 
    MOB_SHEEP("MOB_SHEEP", 29, "MHF_Sheep", SkullHeadCategory.MOB), 
    MOB_PIG_ZOMBIE("MOB_PIG_ZOMBIE", 30, "MHF_PigZombie", SkullHeadCategory.MOB), 
    MOB_PIG("MOB_PIG", 31, "MHF_Pig", SkullHeadCategory.MOB), 
    MOB_OCELOT("MOB_OCELOT", 32, "MHF_Ocelot", SkullHeadCategory.MOB), 
    MOB_PUFFERFISH("MOB_PUFFERFISH", 33, "Luci", SkullHeadCategory.MOB), 
    MOB_BEAR("MOB_BEAR", 34, "Bear", SkullHeadCategory.MOB), 
    MOB_FOX("MOB_FOX", 35, "hugge75", SkullHeadCategory.MOB), 
    MOB_SNOWMAN("MOB_SNOWMAN", 36, "Snowman_7", SkullHeadCategory.MOB), 
    MOB_CHINESE_DRAGON("MOB_CHINESE_DRAGON", 37, "Morhaus", SkullHeadCategory.MOB), 
    MOB_ENDER_DRAGON("MOB_ENDER_DRAGON", 38, "KingEndermen", SkullHeadCategory.MOB), 
    MOB_TURKEY("MOB_TURKEY", 39, "turkeybot69", SkullHeadCategory.MOB), 
    MOB_OWL("MOB_OWL", 40, "Barnyard_Owl", SkullHeadCategory.MOB), 
    MOB_WOLF("MOB_WOLF", 41, "Wolf_Doctor", SkullHeadCategory.MOB), 
    MOB_LION("MOB_LION", 42, "Lion", SkullHeadCategory.MOB), 
    MOB_BUNNY("MOB_BUNNY", 43, "Natalieisawesome", SkullHeadCategory.MOB), 
    BLOCK_CHEST("BLOCK_CHEST", 44, "MHF_Chest", SkullHeadCategory.BLOCK), 
    BLOCK_CACTUS("BLOCK_CACTUS", 45, "MHF_Cactus", SkullHeadCategory.BLOCK), 
    BLOCK_OAK_LOG("BLOCK_OAK_LOG", 46, "MHF_OakLog", SkullHeadCategory.BLOCK), 
    BLOCK_TNT("BLOCK_TNT", 47, "MHF_TNT", SkullHeadCategory.BLOCK), 
    BLOCK_TNT2("BLOCK_TNT2", 48, "MHF_TNT2", SkullHeadCategory.BLOCK), 
    COLOR_ORANGE("COLOR_ORANGE", 49, "wulfric17", SkullHeadCategory.COLOR), 
    COLOR_CREAM("COLOR_CREAM", 50, "Majkel987", SkullHeadCategory.COLOR), 
    COLOR_WHITE("COLOR_WHITE", 51, "cy1337", SkullHeadCategory.COLOR), 
    COLOR_ROYAL_BLUE("COLOR_ROYAL_BLUE", 52, "ztag100", SkullHeadCategory.COLOR), 
    COLOR_MAGENTA("COLOR_MAGENTA", 53, "diablo3pk", SkullHeadCategory.COLOR), 
    COLOR_PINK("COLOR_PINK", 54, "BaconDaGod", SkullHeadCategory.COLOR), 
    COLOR_MEDIUM_GREEN("COLOR_MEDIUM_GREEN", 55, "sean1346", SkullHeadCategory.COLOR), 
    COLOR_GREN("COLOR_GREN", 56, "bananasquad", SkullHeadCategory.COLOR), 
    COLOR_BROWN("COLOR_BROWN", 57, "c0c0nut", SkullHeadCategory.COLOR), 
    COLOR_GREEN("COLOR_GREEN", 58, "Unwary", SkullHeadCategory.COLOR), 
    COLOR_DARK_BLUE("COLOR_DARK_BLUE", 59, "GoldenCharms", SkullHeadCategory.COLOR), 
    SIGN_ARROW_UP("SIGN_ARROW_UP", 60, "MHF_ArrowUp", SkullHeadCategory.SIGN), 
    SIGN_ARROW_DOWN("SIGN_ARROW_DOWN", 61, "MHF_ArrowDown", SkullHeadCategory.SIGN), 
    SIGN_ARROW_LEFT("SIGN_ARROW_LEFT", 62, "MHF_ArrowLeft", SkullHeadCategory.SIGN), 
    SIGN_ARROW_RIGHT("SIGN_ARROW_RIGHT", 63, "MHF_ArrowRight", SkullHeadCategory.SIGN), 
    SIGN_ARROW_EXCLAMATION("SIGN_ARROW_EXCLAMATION", 64, "MHF_Exclamation", SkullHeadCategory.SIGN), 
    SIGN_ARROW_QUESTION("SIGN_ARROW_QUESTION", 65, "MHF_Question", SkullHeadCategory.SIGN), 
    MISC_PRESENT("MISC_PRESENT", 66, "MHF_Present1", SkullHeadCategory.MISC), 
    MISC_PRESENT2("MISC_PRESENT2", 67, "MHF_Present2", SkullHeadCategory.MISC);
    
    private final String name;
    private final SkullHeadCategory category;
    private final String type;
    
    private SkullHead(final String s, final int n, final String name, final SkullHeadCategory category) {
        this(s, n, name, category, "Player");
    }
    
    private SkullHead(final String name2, final int ordinal, final String name, final SkullHeadCategory category, final String type) {
        this.name = name;
        this.category = category;
        this.type = type;
    }
    
    public final String getName() {
        return this.name;
    }
    
    public final SkullHeadCategory getCategory() {
        return this.category;
    }
    
    public final String getType() {
        return this.type;
    }
    
    public final int getTypeID() {
        final String upperCase;
        switch (upperCase = this.type.toUpperCase()) {
            case "PLAYER": {
                return 2;
            }
            case "WITHER": {
                return 4;
            }
            case "ZOMBIE": {
                return 5;
            }
            case "SKELETON": {
                return 3;
            }
            case "CREEPER": {
                return 0;
            }
            case "DRAGON": {
                return 1;
            }
            default:
                break;
        }
        return -1;
    }
    
    @Deprecated
    public final SkullType getSkullType() {
        final String type = this.getType();
        return (type != null) ? getSkullTypeByName(type) : SkullType.PLAYER;
    }
    
    @Deprecated
    public static final SkullType getSkullTypeByName(final String type) {
        if (type != null) {
            SkullType[] values;
            for (int length = (values = SkullType.values()).length, i = 0; i < length; ++i) {
                final SkullType key = values[i];
                if (key.name().equalsIgnoreCase(type)) {
                    return key;
                }
            }
        }
        return null;
    }
    
    public static final SkullHead getSkullHeadByLivingEntity(final LivingEntity entity) {
        if (entity != null) {
            final EntityType type = entity.getType();
            final String typeName = type.name();
            final String id = "MOB_" + typeName;
            SkullHead[] values;
            for (int length = (values = values()).length, i = 0; i < length; ++i) {
                final SkullHead key = values[i];
                if (key.getCategory().equals(SkullHeadCategory.MOB) && key.name().equalsIgnoreCase(id)) {
                    return key;
                }
            }
        }
        return null;
    }
    
    public enum SkullHeadCategory
    {
        FOOD("FOOD", 0), 
        FRUIT("FRUIT", 1), 
        DRINK("DRINK", 2), 
        MOB("MOB", 3), 
        RACE("RACE", 4), 
        CHARACTER("CHARACTER", 5), 
        BLOCK("BLOCK", 6), 
        COLOR("COLOR", 7), 
        LETTER("LETTER", 8), 
        SIGN("SIGN", 9), 
        MISC("MISC", 10);
        
        private SkullHeadCategory(final String name, final int ordinal) {
        }
    }
}
