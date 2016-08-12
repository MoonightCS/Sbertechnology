package ru.sbt.bodya.hw7.pluginmanager;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class TestPluginClassLoader {

    public static void main(String[] args)  {

        List<Plugin> pluginList = new ArrayList<>();

        String pluginRootDirectory = "file:/Users/bogdanpopov/Desktop/Sbertechnology/out/production/hw/";


        PluginManager pluginManager = new PluginManager(pluginRootDirectory);

        try {

            pluginList.add(pluginManager.load("facebook", "ru.sbt.bodya.hw7.pluginmanager.plugins.facebook.FacebookPlugin"));
            pluginList.add(pluginManager.load("vk", "ru.sbt.bodya.hw7.pluginmanager.plugins.vk.FacebookPlugin"));
            pluginList.add(pluginManager.load("google", "ru.sbt.bodya.hw7.pluginmanager.plugins.google.GooglePlugin"));
            pluginList.add(pluginManager.load("yandex", "ru.sbt.bodya.hw7.pluginmanager.plugins.yandex.YandexPlugin"));

        } catch (ClassNotFoundException | IllegalAccessException | MalformedURLException | InstantiationException e) {

            System.out.println(e.getMessage());

        }

        System.out.println();
        for (Plugin plugin: pluginList) {

            plugin.doUsefull();
            System.out.println(plugin.getClass().getClassLoader());
            System.out.println(plugin.getClass().getName());
            System.out.println("_____________________________________________________________________\n");


        }


    }


}
