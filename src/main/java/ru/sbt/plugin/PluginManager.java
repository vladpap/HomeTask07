package ru.sbt.plugin;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

public class PluginManager {

    private final String pluginRootDirectory;
    private static Map<String, Plugin> uploadPlugins = new HashMap<>();

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) {

        URL url;
        Plugin result;

        try {
            url = new File(pluginRootDirectory).toURI().toURL();
        } catch (MalformedURLException e) {
            throw new PluginManagerException("Error url", e);
        }

        URLClassLoader loader = new PluginClassLoader(new URL[]{url});
        Class<?> clazz;

        try {
            clazz = loader.loadClass(pluginClassName);
            result = (Plugin) clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new PluginManagerException("Error", e);
        }

        return result;
    }

}