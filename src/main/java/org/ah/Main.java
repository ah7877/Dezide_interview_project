package org.ah;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        ProgramArgs values = parser.mainArgs(args);

        CostConverter costConverter = new CostConverter();
        System.out.println(costConverter.complexConvert(values.getMinutes(), values.money, values.model, values.configs));
    }
}