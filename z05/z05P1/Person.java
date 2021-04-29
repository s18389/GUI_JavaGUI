package z05P1;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class Person {
    String name;
    int yearOfBirth;
    Car car;

    public Person(String name, int yearOfBirth, Car car) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.car = car;
    }

    public String toString() {
        return this.name + " " + this.yearOfBirth + " " + this.car;
    }

    public static List<Car> findAllCars(List<Person> list) {
        ArrayList cars = new ArrayList();
        for (Person p : list) {
            if (p.car != null) cars.add(p.car);
        }
        return cars;
    }

    public static List<Person> findOwners(List<Person> list, String carName) {
        ArrayList people_with_car = new ArrayList();
        for (Person p : list) {
            if(p.car != null) {
                if (p.car.name.equals(carName)) people_with_car.add(p.name);
            }
        }
        return people_with_car;
    }

    public static Color findColor(List<Person> list, String name, int year){

        for (Person p : list) {
            if(p.car != null) {
                if (p.name.equals(name) && p.yearOfBirth == year) {
                    ExColor result = new ExColor(p.car.color.getRed(),p.car.color.getGreen(),p.car.color.getBlue());
                    return result;
                }
            }
        }
        return null;
    }
}

class ExColor extends Color{

    public ExColor(int r, int g, int b) {
        super(r, g, b);
    }

    @Override
    public String toString(){
        return getRed()+ " " + getGreen()+ " " + getBlue();
    }
}