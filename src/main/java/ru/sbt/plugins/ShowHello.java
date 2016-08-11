package ru.sbt.plugins;

import ru.sbt.plugin.Plugin;

import java.util.Scanner;

public class ShowHello implements Plugin {
    @Override
    public void doUsefull() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name : ");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + " ...\r\n");

    }
}
