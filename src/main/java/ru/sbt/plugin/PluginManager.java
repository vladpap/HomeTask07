package ru.sbt.plugin;
import java.net.URLClassLoader;

public class PluginManager { //extends URLClassLoader {

    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

/*    public Plugin load(String pluginName, String pluginClassName) {

        //todo
        return new Plugin;
    }*/

/*    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.startsWith("java") || name.equals("ru.sbt.plugin.Plugin")) {
            return super.loadClass(name);
        }
        return findClass(name);
    }
*/
}
