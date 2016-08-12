package ru.sbt.plugins;

import ru.papin.model.Person;
import ru.sbt.plugin.Plugin;

import java.util.Scanner;

public class ShowHello implements Plugin {
    @Override
    public void doUsefull() {
        Person person = new Person("Ivan", 26);
        System.out.println("Hello " + person.getName() + " ...");
        System.out.println(person);
        System.out.println(this.getClass().getName());
        System.out.println(person.getClass().getName() + " " + person.getClass().getClassLoader());
    }
}
