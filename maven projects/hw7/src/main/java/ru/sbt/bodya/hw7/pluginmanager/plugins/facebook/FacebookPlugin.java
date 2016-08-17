package ru.sbt.bodya.hw7.pluginmanager.plugins.facebook;

import ru.sbt.bodya.hw7.pluginmanager.Plugin;

public class FacebookPlugin implements Plugin {

    @Override
    public void doUsefull() {
        System.out.println("Facebook impl");
    }


    private void doPrivateUsage() {

        System.out.printf("Private usage");


    }
}
