package z02P2;

@FunctionalInterface

public interface Transform<T,R> {
	
	R apply(T s);

}
