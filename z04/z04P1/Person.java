package z04P1;

import java.util.Collection;

public class Person implements Comparable<Person> {
	
	String name;
    int yearOfBirth;

    public Person(String name, int yearOfBirth) {
		this.name = name;
		this.yearOfBirth = yearOfBirth;
	}
    
    public static boolean findInColl(Collection<Person> coll, String names, CharSequence year) {
		boolean result = false;
		if(coll.equals(names) && coll.equals(year)) result = true;
	//	System.out.println(coll);
    	return result;
    }

	@Override
	public boolean equals(Object other){
    	if (other == null || getClass() != other.getClass()) return false;
    	Person p = (Person)other;
    	return yearOfBirth == p.yearOfBirth && name.equals(p.name);
	}

	@Override
	public int hashCode(){
    	return name.hashCode() + yearOfBirth;
	}

	@Override
	public String toString() {
		return  name + " " + yearOfBirth;
	}

    @Override
    public int compareTo(Person o){
        if(this.yearOfBirth)
        return 0;
    }
}
