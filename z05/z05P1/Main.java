package z05P1;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner sc2 = null;

        try {
            sc2 = new Scanner(new File("C:\\Users\\s18389\\IdeaProjects\\untitled1\\src\\z05P1\\main.txt"));
        } catch (FileNotFoundException var13) {
            var13.printStackTrace();
        }

        ArrayList people = new ArrayList();

        while(sc2.hasNextLine()) {

            Scanner s2 = new Scanner(sc2.nextLine());

            while(s2.hasNext()) {
                String name = s2.next();
                int yearOfBirth = s2.nextInt();
                if (s2.hasNext()) {
                    String carName = s2.next();
                    int red = s2.nextInt();
                    int green = s2.nextInt();
                    int blue = s2.nextInt();
                    Color color = new Color(red, green, blue);
                    Car car = new Car(carName, color);
                    Person person = new Person(name, yearOfBirth, car);
                    people.add(person);
                } else {
                    Person person = new Person(name, yearOfBirth, (Car)null);
                    people.add(person);
                }
            }
        }
        System.out.println(people);
        System.out.println(Person.findAllCars(people));
        System.out.println(Person.findOwners(people, "Skoda"));
        System.out.println(Person.findColor(people, "Alice", 1993));
        System.out.println(Person.findColor(people, "Kuba", 1997));
    }


}