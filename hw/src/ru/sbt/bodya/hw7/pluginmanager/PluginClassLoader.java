package ru.sbt.bodya.hw7.pluginmanager;

import java.net.URL;
import java.net.URLClassLoader;

public class PluginClassLoader extends URLClassLoader {

    public PluginClassLoader(URL[] urls) {
        super(urls);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.startsWith("java") || name.equals("ru.sbt.bodya.hw7.pluginmanager.Plugin")) {
            return super.loadClass(name);
        }

        return findClass(name);
    }
}