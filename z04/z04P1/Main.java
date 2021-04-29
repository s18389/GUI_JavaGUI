package z04P1;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
      java.util.Scanner n = new java.util.Scanner(System.in);
      ArrayList<Person> people = new ArrayList<Person>();
      String name;
      int year;
      
        for (int i = 0; ; i++) {
                System.out.println("Name:");
                name = n.next();
                if (name.equals("end")) break;
                
                System.out.println("Birth:");
                
                while(true)
                    try {
                    	String number = n.next();
                       	year = Integer.parseInt(number);
                        break;
                        }
                	catch (Exception e){
                		System.out.println("ISNT NUMBER MOTHERFUCKER");
                		continue;
                		}
                
                Person p1 = new Person(name, year);
                people.add(p1);
        }  
        System.out.println(people);
        System.out.println(Person.findInColl(people, "Kuba", "1997"));
    }
}
