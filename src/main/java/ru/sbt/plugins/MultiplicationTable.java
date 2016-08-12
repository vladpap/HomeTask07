package ru.sbt.plugins;

import ru.papin.model.Person;
import ru.sbt.plugin.Plugin;

public class MultiplicationTable implements Plugin {
    @Override
    public void doUsefull() {
        Person person = new Person("Oleg", 23);
        System.out.println("\t\t  Multiplication Table");
        for (int k = 1; k <= 10; k++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%4d", k * j);
            }
            System.out.println("");
        }
        System.out.println();
        System.out.println(person);
        System.out.println(this.getClass().getName());
        System.out.println(person.getClass().getName() + " " + person.getClass().getClassLoader());
    }
}