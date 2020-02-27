// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SortUtil
{
    @Deprecated
    public static final List<String> toArray(final Set<String> list) {
        final List<String> array = new ArrayList<String>();
        if (list != null) {
            for (final String key : list) {
                array.add(TextUtil.colorful(key));
            }
        }
        return array;
    }
    
    public static final List<String> toList(final Set<String> components) {
        return toList(components, false);
    }
    
    public static final List<String> toList(final Set<String> components, final boolean colorful) {
        final List<String> array = new ArrayList<String>();
        if (components != null) {
            for (final String component : components) {
                if (colorful) {
                    array.add(TextUtil.colorful(component));
                }
                else {
                    array.add(component);
                }
            }
        }
        return array;
    }
    
    @Deprecated
    public static final Collection<String> toCollection(final Set<String> list) {
        final Collection<String> collection = new ArrayList<String>();
        if (list != null) {
            for (final String key : list) {
                collection.add(TextUtil.colorful(key));
            }
        }
        return collection;
    }
    
    @Deprecated
    public static final List<String> toArray(final String[] list) {
        final List<String> array = new ArrayList<String>();
        if (list != null) {
            for (final String key : list) {
                array.add(TextUtil.colorful(key));
            }
        }
        return array;
    }
    
    public static final List<String> toList(final String[] components) {
        return toList(components, false);
    }
    
    public static final List<String> toList(final String[] components, final boolean colorful) {
        final List<String> array = new ArrayList<String>();
        if (components != null) {
            for (final String component : components) {
                if (colorful) {
                    array.add(TextUtil.colorful(component));
                }
                else {
                    array.add(component);
                }
            }
        }
        return array;
    }
    
    @Deprecated
    public static final Collection<String> toCollection(final String[] list) {
        final Collection<String> collection = new ArrayList<String>();
        if (list != null) {
            for (final String key : list) {
                collection.add(TextUtil.colorful(key));
            }
        }
        return collection;
    }
    
    @Deprecated
    public static final List<String> toArray(final Collection<String> collection) {
        final List<String> array = new ArrayList<String>();
        if (collection != null) {
            for (final String key : collection) {
                array.add(TextUtil.colorful(key));
            }
        }
        return array;
    }
    
    public static final List<String> toList(final Collection<String> components) {
        return toList(components, false);
    }
    
    public static final List<String> toList(final Collection<String> components, final boolean colorful) {
        final List<String> array = new ArrayList<String>();
        if (components != null) {
            for (final String component : components) {
                if (colorful) {
                    array.add(TextUtil.colorful(component));
                }
                else {
                    array.add(component);
                }
            }
        }
        return array;
    }
    
    public static final List<String> addListComponent(List<String> list, final String text) {
        list = ((list != null) ? list : new ArrayList<String>());
        if (text != null) {
            list.add(TextUtil.colorful(text));
        }
        return list;
    }
    
    public static final List<String> addListComponent(final List<String> list, final int index, final String text) {
        return addListComponent(list, index, text, false);
    }
    
    public static final List<String> addListComponent(List<String> list, final int index, final String text, final boolean replace) {
        list = ((list != null) ? list : new ArrayList<String>());
        final int size = list.size();
        final int loop = index - size;
        if (loop > 0) {
            for (int t = 0; t < loop; ++t) {
                list.add("");
            }
        }
        if (replace && loop < 0) {
            list.remove(index);
        }
        list.add(index, text);
        return list;
    }
    
    public static final List<String> removeListComponent(List<String> list, final int index) {
        list = ((list != null) ? list : new ArrayList<String>());
        final int size = list.size();
        if (index >= 0 && index < size) {
            list.remove(index);
        }
        return list;
    }
    
    public static final Map<String, Integer> sortByValue(final Map<String, Integer> unsortMap) {
        return sortByValue(unsortMap, true);
    }
    
    public static final Map<String, Integer> sortByValue(final Map<String, Integer> unsortMap, final boolean ascend) {
        final Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        if (unsortMap != null) {
            final List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());
            final Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(final Map.Entry<String, Integer> map1, final Map.Entry<String, Integer> map2) {
                    final Integer value1 = map1.getValue();
                    final Integer value2 = map2.getValue();
                    return ascend ? value1.compareTo(value2) : value2.compareTo(value1);
                }
            };
            Collections.sort(list, comparator);
            for (final Map.Entry<String, Integer> entry : list) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }
        }
        return sortedMap;
    }
    
    public static final double sumDoubleValue(final Collection<Double> values) {
        double sum = 0.0;
        if (values != null) {
            for (final double value : values) {
                sum += value;
            }
        }
        return sum;
    }
    
    public static final int sumIntegerValue(final Collection<Integer> values) {
        int sum = 0;
        if (values != null) {
            for (final int value : values) {
                sum += value;
            }
        }
        return sum;
    }
}
