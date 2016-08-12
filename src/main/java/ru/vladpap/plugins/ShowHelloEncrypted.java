package ru.vladpap.plugins;

import ru.papin.model.Person;
import ru.sbt.plugin.Plugin;

public class ShowHelloEncrypted implements Plugin {
    @Override
    public void doUsefull() {
        System.out.println("Hello World !!!\r\nClass no encripted");
        System.out.println(this.getClass().getName() + " " + this.getClass().getClassLoader());
    }
}
