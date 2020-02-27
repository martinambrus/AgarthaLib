// 
// Decompiled by Procyon v0.5.36
// 

package com.praya.agarthalib.utility;

import java.util.regex.Pattern;
import java.net.MalformedURLException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.CopyOption;
import java.nio.file.Paths;
import java.io.Reader;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.file.FileConfiguration;
import java.io.File;
import org.bukkit.plugin.java.JavaPlugin;

public class FileUtil
{
    public static final File getFile(final JavaPlugin plugin, final String path) {
        return getFile(plugin, path, true);
    }
    
    public static final File getFile(final JavaPlugin plugin, final String path, final boolean inFolder) {
        if (plugin != null && path != null) {
            return inFolder ? new File(plugin.getDataFolder(), path) : new File(path);
        }
        return null;
    }
    
    public static final boolean isExist(final JavaPlugin plugin, final String path) {
        return isExist(plugin, path, true);
    }
    
    public static final boolean isExist(final JavaPlugin plugin, final String path, final boolean inFolder) {
        return getFile(plugin, path, inFolder) != null;
    }
    
    public static final FileConfiguration getFileConfiguration(final File file) {
        return (FileConfiguration)((file != null) ? YamlConfiguration.loadConfiguration(file) : null);
    }
    
    public static final FileConfiguration getFileConfigurationURL(final String address) {
        final URL url = createLinkSilent(address);
        return getFileConfigurationURL(url);
    }
    
    public static final FileConfiguration getFileConfigurationURL(final URL url) {
        if (url != null) {
            final InputStream stream = openStream(url);
            if (stream != null) {
                final Reader reader = new InputStreamReader(stream);
                final FileConfiguration config = (FileConfiguration)YamlConfiguration.loadConfiguration(reader);
                try {
                    stream.close();
                }
                catch (IOException ex) {}
                return config;
            }
        }
        return null;
    }
    
    public static final FileConfiguration getFileConfigurationResource(final JavaPlugin plugin, final String path) {
        if (plugin != null && path != null) {
            final InputStream stream = plugin.getResource(path);
            final Reader reader = new InputStreamReader(stream);
            return (FileConfiguration)YamlConfiguration.loadConfiguration(reader);
        }
        return null;
    }
    
    @Deprecated
    public static final FileConfiguration getFileConfiguration(final JavaPlugin plugin, final String path) {
        final InputStream stream = plugin.getResource(path);
        final Reader reader = new InputStreamReader(stream);
        return (FileConfiguration)YamlConfiguration.loadConfiguration(reader);
    }
    
    public static final void addObject(final JavaPlugin plugin, final String fileName, final String path, final Object object) {
        addObject(plugin, fileName, true, path, object);
    }
    
    public static final void addObject(final JavaPlugin plugin, final String fileName, final Boolean inFolder, final String path, final Object object) {
        final File file = getFile(plugin, fileName, inFolder);
        addObject(file, path, object);
    }
    
    public static final void addObject(final File file, final String path, final Object object) {
        if (file != null && path != null && object != null) {
            final FileConfiguration config = getFileConfiguration(file);
            config.set(path, object);
            saveFileSilent(file, config);
        }
    }
    
    public static final void removeObject(final JavaPlugin plugin, final String fileName, final String path) {
        removeObject(plugin, fileName, true, path);
    }
    
    public static final void removeObject(final JavaPlugin plugin, final String fileName, final Boolean inFolder, final String path) {
        final File file = getFile(plugin, fileName, inFolder);
        removeObject(file, path);
    }
    
    public static final void removeObject(final File file, final String path) {
        if (file != null && path != null) {
            final FileConfiguration config = getFileConfiguration(file);
            config.set(path, (Object)null);
            saveFileSilent(file, config);
        }
    }
    
    public static final boolean createFile(final File file) {
        if (file != null) {
            final File folder = file.getParentFile();
            try {
                if (folder != null) {
                    folder.mkdirs();
                }
                return file.createNewFile();
            }
            catch (IOException ex) {}
        }
        return false;
    }
    
    public static final boolean createFileSilent(final File file) {
        if (file != null) {
            final File folder = file.getParentFile();
            try {
                if (folder != null) {
                    folder.mkdirs();
                }
                return file.createNewFile();
            }
            catch (IOException ex) {}
        }
        return false;
    }
    
    public static final void moveFile(final File source, final File target) throws IOException {
        moveFile(source, target, true);
    }
    
    public static final void moveFile(final File source, final File target, final boolean overwrite) throws IOException {
        if (source != null && target != null) {
            final Path pathSource = Paths.get(source.getPath(), new String[0]);
            final Path pathTarget = Paths.get(target.getPath(), new String[0]);
            final CopyOption[] options = overwrite ? new CopyOption[] { StandardCopyOption.REPLACE_EXISTING } : new CopyOption[0];
            target.mkdirs();
            Files.move(pathSource, pathTarget, options);
        }
    }
    
    public static final void moveFileSilent(final File source, final File target) {
        moveFileSilent(source, target, true);
    }
    
    public static final void moveFileSilent(final File source, final File target, final boolean overwrite) {
        try {
            moveFile(source, target, overwrite);
        }
        catch (IOException ex) {}
    }
    
    @Deprecated
    public static final void saveFile(final File file, final FileConfiguration config) {
        if (file != null & config != null) {
            try {
                config.save(file);
            }
            catch (IOException ex) {}
        }
    }
    
    public static final void saveFileSilent(final File file, final FileConfiguration config) {
        if (file != null & config != null) {
            try {
                config.save(file);
            }
            catch (IOException ex) {}
        }
    }
    
    public static final void saveResource(final JavaPlugin plugin, final String path) {
        saveResource(plugin, path, false);
    }
    
    public static final void saveResource(final JavaPlugin plugin, final String path, final boolean replace) {
        if (plugin != null && path != null) {
            plugin.saveResource(path, replace);
        }
    }
    
    public static final boolean setRaw(final JavaPlugin plugin, final String path) {
        return setRaw(plugin, path, true);
    }
    
    public static final boolean setRaw(final JavaPlugin plugin, final String path, final boolean inFolder) {
        final File file = getFile(plugin, path, inFolder);
        return setRaw(file);
    }
    
    public static final boolean setRaw(final File file) {
        if (file != null && !file.exists() && file.mkdirs()) {
            try {
                return file.createNewFile();
            }
            catch (IOException ex) {}
        }
        return false;
    }
    
    public static final void saveStream(final JavaPlugin plugin, final String path, final Object object) {
        saveStream(plugin, path, object, true);
    }
    
    public static final void saveStream(final JavaPlugin plugin, final String path, final Object object, final boolean inFolder) {
        final File file = getFile(plugin, path, inFolder);
        if (file != null && (file.exists() || setRaw(file))) {
            writeObjectSilent(file, object);
        }
    }
    
    public static final Object loadStream(final JavaPlugin plugin, final String path, final Object object) {
        return loadStream(plugin, path, true);
    }
    
    public static final Object loadStream(final JavaPlugin plugin, final String path, final boolean inFolder) {
        final File file = getFile(plugin, path, inFolder);
        return (file != null && file.exists()) ? loadObjectSilent(file) : null;
    }
    
    public static final void writeObject(final File file, final Object object) {
        if (file != null && object != null) {
            try {
                final FileOutputStream fileOutputStream = new FileOutputStream(file);
                final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(object);
                objectOutputStream.close();
            }
            catch (IOException ex) {}
        }
    }
    
    public static final void writeObjectSilent(final File file, final Object object) {
        if (file != null && object != null) {
            try {
                final FileOutputStream fileOutputStream = new FileOutputStream(file);
                final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(object);
                objectOutputStream.close();
            }
            catch (IOException ex) {}
        }
    }
    
    public static final void writeString(final File file, final String text) {
        if (file != null && text != null) {
            try {
                final FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(text);
                fileWriter.flush();
                fileWriter.close();
            }
            catch (IOException ex) {}
        }
    }
    
    public static final void writeStringSilent(final File file, final String text) {
        if (file != null && text != null) {
            try {
                final FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(text);
                fileWriter.flush();
                fileWriter.close();
            }
            catch (IOException ex) {}
        }
    }
    
    public static final Object loadObject(final File file) {
        if (file != null) {
            try {
                final FileInputStream fileInputStream = new FileInputStream(file);
                final ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                final Object result = objectInputStream.readObject();
                objectInputStream.close();
                return result;
            }
            catch (ClassNotFoundException ex) {}
            catch (IOException ex2) {}
        }
        return null;
    }
    
    public static final Object loadObjectSilent(final File file) {
        if (file != null) {
            try {
                final FileInputStream fileInputStream = new FileInputStream(file);
                final ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                final Object result = objectInputStream.readObject();
                objectInputStream.close();
                return result;
            }
            catch (ClassNotFoundException ex) {}
            catch (IOException ex2) {}
        }
        return null;
    }
    
    public static final FileReader getFileReader(final File file) {
        if (file != null) {
            try {
                final FileReader reader = new FileReader(file);
                return reader;
            }
            catch (FileNotFoundException ex) {}
        }
        return null;
    }
    
    public static final FileReader getFileReaderSilent(final File file) {
        if (file != null) {
            try {
                final FileReader reader = new FileReader(file);
                return reader;
            }
            catch (FileNotFoundException ex) {}
        }
        return null;
    }
    
    public static final URL createLink(final String link) {
        if (link != null) {
            try {
                final URL url = new URL(link);
                return url;
            }
            catch (MalformedURLException ex) {}
        }
        return null;
    }
    
    public static final URL createLinkSilent(final String link) {
        if (link != null) {
            try {
                final URL url = new URL(link);
                return url;
            }
            catch (MalformedURLException ex) {}
        }
        return null;
    }
    
    public static final InputStream openStream(final URL url) {
        if (url != null) {
            try {
                final InputStream is = url.openStream();
                return is;
            }
            catch (IOException ex) {}
        }
        return null;
    }
    
    public static final InputStream openStreamSilent(final URL url) {
        if (url != null) {
            try {
                final InputStream is = url.openStream();
                return is;
            }
            catch (IOException ex) {}
        }
        return null;
    }
    
    public static final String getName(final File file) {
        if (file == null) {
            return null;
        }
        if (file.isDirectory()) {
            return file.getName();
        }
        final String[] elements = file.getName().split(Pattern.quote("."));
        final int length = elements.length;
        String name = "";
        if (length > 0) {
            for (int t = 0; t < elements.length - 1; ++t) {
                final String part = elements[t];
                name = ((t == 0) ? part : (String.valueOf(name) + "." + part));
            }
        }
        return name;
    }
}
