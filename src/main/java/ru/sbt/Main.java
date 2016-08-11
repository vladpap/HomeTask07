package ru.sbt;

import ru.sbt.plugins.MultiplicationTable;
import ru.sbt.plugins.ShowHello;

public class Main {
    public static void main(String[] args) {
        ShowHello showHello = new ShowHello();
        showHello.doUsefull();
        MultiplicationTable multiplicationTable = new MultiplicationTable();
        multiplicationTable.doUsefull();
    }
}
