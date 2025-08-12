package model;

import general.Child;
import general.DemoKt;
import general.ExtensionFunctionKt;
import general.Parent;


public class Main {
    public void updateWeather(int degrees) {
        String description;
        Color color;
        if  (degrees < 10) {
            description = "Cold";
            color = Color.BLUE;
        } else if (degrees < 25) {
            description = "Mild";
            color = Color.ORANGE;
        } else {
            description = "Hot";
            color = Color.RED;
        }
    }

    public static void sumOverloads() {
        var s = DemoKt.sum(1, 1, 1);
        System.out.println(s);
        s = DemoKt.sum(1, 1);
        System.out.println(s);
        s = DemoKt.sum(1);
        System.out.println(s);
        s = DemoKt.sum();
        System.out.println(s);
    }

    public static void main(String[] args) {
        sumOverloads();
        System.out.println(ExtensionFunctionKt.repeat("abcd", 3));
        Parent p = new Child();
        System.out.println(ExtensionFunctionKt.foo(p));
        System.out.println(ExtensionFunctionKt.foo(new Child()));
    }
}
