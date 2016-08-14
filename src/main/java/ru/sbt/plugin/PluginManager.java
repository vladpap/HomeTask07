package ru.sbt.plugin;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class PluginManager {

    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin loadEncripted(String pluginClassName, String key) {
        Plugin result;
        ClassLoader loader = new PluginEncriptClassLoader(pluginRootDirectory, key);
        Class<?> clazz;
        try {
            clazz = loader.loadClass(pluginClassName);
        } catch (ClassNotFoundException e) {
            throw new PluginManagerException("Error", e);
        }
        try {
            result = (Plugin) clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new PluginManagerException("Error", e);
        }
        return result;
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