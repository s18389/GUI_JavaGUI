package z04P3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class Casino implements Iterable <Integer>, Iterator<Integer> {

	int counter = 1;
	int random;
	int temp = -1;
	
	@Override
	public Iterator<Integer> iterator() {
		return this;
	}

	@Override
	public boolean hasNext() {
		if(counter == 3) return false;
		return true;
	}
	
	Random generator = new Random();
	@Override
	public Integer next() {

		if(!hasNext()) throw new NoSuchElementException();

		random = generator.nextInt(2);
		
		if(random == temp) counter++;
		if(random != temp) counter = 1;
		temp = random;
		return random;
	}

}
