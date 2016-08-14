package ru.sbt;

import ru.sbt.plugin.Plugin;
import ru.sbt.plugin.PluginManager;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PluginManager pluginManager = new PluginManager("brousePlugins/");
        List<String> listPlugin = new ArrayList<>();
        listPlugin.add("ru.sbt.plugins.MultiplicationTable");
        listPlugin.add("ru.sbt.plugins.ShowHello");
        listPlugin.add("ru.vladpap.plugins.ShowHello");
        listPlugin.add("ru.vladpap.plugins.ShowHelloEncrypted");
        for (String s : listPlugin) {
//            Plugin plugin = pluginManager.load("", s);
//            plugin.doUsefull();
            ShowLine();
        }
        Plugin plugin = pluginManager.loadEncripted("ru.vladpap.plugins.ShowHelloEncrypted", "vladpap");
        plugin.doUsefull();
    }

    private static void ShowLine() {
        System.out.println("----------------------------------------\r\n");
    }
}
