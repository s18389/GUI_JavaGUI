package z05P1;

import java.awt.Color;

public class Car {
    String name;
    Color color;

    public Car(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public String toString() {
        return this.name + " " + this.color.getRed() + " " + this.color.getGreen() + " " + this.color.getBlue();
    }
}
