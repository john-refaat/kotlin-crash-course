package model;

import org.example.Child;
import org.example.DemoKt;
import org.example.Parent;

import static org.example.ExtensionFunctionKt.*;


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
        System.out.println(repeat("abcd", 3));
        Parent p = new Child();
        System.out.println(foo(p));
        System.out.println(foo(new Child()));
    }
}
