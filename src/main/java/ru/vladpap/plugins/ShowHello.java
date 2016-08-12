package ru.vladpap.plugins;

import ru.papin.model.Person;
import ru.sbt.plugin.Plugin;

public class ShowHello implements Plugin {
    @Override
    public void doUsefull() {
        Person person = new Person("Bob", 25);
        System.out.println("Hello World !!!");
        System.out.println(person);
        System.out.println(this.getClass().getName());
        System.out.println(person.getClass().getName() + " " + person.getClass().getClassLoader());
    }
}
