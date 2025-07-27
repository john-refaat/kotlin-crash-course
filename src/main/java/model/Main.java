package model;

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
}
