package z04P2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Hailstone implements Iterator<Integer>, Iterable<Integer> {

    public int a0;

    public Hailstone(int a0) {
        this.a0 = a0;
    }

    @Override
    public boolean hasNext() {
        return a0 != 1;
    }

    @Override
    public Integer next() {
        if(!hasNext()) throw new NoSuchElementException();
         if(a0 % 2 == 0) {
        	 a0 = a0 / 2;
        	 return a0;
         }
         if(a0 % 2 == 1) {
        	 a0 = 3*a0 + 1;
        	 return a0;
         }
		return a0;
    }

    @Override
    public Iterator<Integer> iterator() {
        return this;
    }

	@Override
	public String toString() {
		return "Hailstone [a0=" + a0 + "]";
	}

}