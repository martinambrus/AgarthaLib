// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class TabCompleterUtil
{
    public static final List<String> returnList(final List<String> tabList) {
        return returnList(tabList, null);
    }
    
    public static final List<String> returnList(final List<String> tabList, final String[] args) {
        if (tabList == null || tabList.isEmpty()) {
            return null;
        }
        if (args != null && args.length > 0) {
            final int index = args.length - 1;
            final String check = args[index].toLowerCase();
            final List<String> checkList = new ArrayList<String>();
            for (final String component : tabList) {
                if (component.toLowerCase().contains(check)) {
                    checkList.add(component);
                }
            }
            return checkList;
        }
        return tabList;
    }
}
