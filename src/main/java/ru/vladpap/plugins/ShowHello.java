package ru.vladpap.plugins;

import ru.sbt.plugin.Plugin;

public class ShowHello implements Plugin {
    @Override
    public void doUsefull() {
        System.out.println("Hello World !!!");
    }
}
