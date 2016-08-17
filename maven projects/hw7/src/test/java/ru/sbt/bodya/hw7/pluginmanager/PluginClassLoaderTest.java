package ru.sbt.bodya.hw7.pluginmanager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PluginClassLoaderTest {


    List<Plugin> pluginList;
    String pluginRootDirectory;
    PluginManager pluginManager;

    @Before
    public void before() {


        pluginList = new ArrayList<>();

        pluginRootDirectory = "file:/Users/bogdanpopov/Desktop/Sbertechnology/maven projects/hw7/src/main/java/ru/sbt/bodya/hw7/pluginmanager/pluginRootDirectory/";

        pluginManager = new PluginManager(pluginRootDirectory);

    }

    @Test
    public void loadExistingClassFromRootDirectory() {

        before();

        try {

            pluginList.add(pluginManager.load("facebook", "ru.sbt.bodya.hw7.pluginmanager.plugins.facebook.FacebookPlugin"));
            assertEquals("ru.sbt.bodya.hw7.pluginmanager.plugins.facebook.FacebookPlugin", pluginList.get(0).getClass().getName());


        } catch (ClassNotFoundException | IllegalAccessException | MalformedURLException | InstantiationException e) {

            System.out.println("Unexpected exception, should be unreachable");


        }

    }

    @Test(expected = ClassNotFoundException.class)
    public void loadNonExistingClassFromRootDirectory() throws ClassNotFoundException {

        before();

        try {

            pluginList.add(pluginManager.load("vk", "ru.sbt.bodya.hw7.pluginmanager.plugins.facebook.FacebookPlugin"));


        } catch (IllegalAccessException | MalformedURLException | InstantiationException e) {

            System.out.println("Unexpected exception, should be unreachable");


        }


    }


    @Test(expected = MalformedURLException.class)
    public void loadFromWrongURL() throws MalformedURLException {


        pluginRootDirectory = "Users/bogdanpopov/Desktop/Sbertechnology/maven projects/hw7/src/main/java/ru/sbt/bodya/hw7/pluginmanager/pluginRootDirectory/";

        pluginManager = new PluginManager(pluginRootDirectory);

        try {

            pluginList.add(pluginManager.load("vk", "ru.sbt.bodya.hw7.pluginmanager.plugins.facebook.FacebookPlugin"));


        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {

            System.out.println("Unexpected exception, should be unreachable");


        }

    }


    @Test
    public void testingMethodsOfPlugins() {

        before();

        try {

            pluginList.add(pluginManager.load("facebook", "ru.sbt.bodya.hw7.pluginmanager.plugins.facebook.FacebookPlugin"));
            pluginList.add(pluginManager.load("vk", "ru.sbt.bodya.hw7.pluginmanager.plugins.vk.FacebookPlugin"));
            pluginList.add(pluginManager.load("google", "ru.sbt.bodya.hw7.pluginmanager.plugins.google.GooglePlugin"));
            pluginList.add(pluginManager.load("yandex", "ru.sbt.bodya.hw7.pluginmanager.plugins.yandex.YandexPlugin"));

        } catch (ClassNotFoundException | IllegalAccessException | MalformedURLException | InstantiationException e) {

            System.out.println("Unexpected exception, should be unreachable");

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