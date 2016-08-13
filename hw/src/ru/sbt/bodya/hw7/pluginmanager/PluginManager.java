package ru.sbt.bodya.hw7.pluginmanager;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class PluginManager {

    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException, MalformedURLException {


        URL url = new URL(pluginRootDirectory.toString() + pluginName + "/");
        URLClassLoader loader = new PluginClassLoader(new URL[]{url});
        Plugin plugin = (Plugin)loader.loadClass(pluginClassName).newInstance();
        return plugin;

    }

}
