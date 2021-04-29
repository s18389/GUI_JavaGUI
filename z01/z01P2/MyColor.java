package z01P2;

public class MyColor extends java.awt.Color {

	int r;
	int g;
	int b;
	
	public MyColor(int r, int g, int b) {
		super(r, g, b);
		this.r = r;
		this.g = g;
		this.b = b;
	}

	@Override
	public String toString() {
		return "(" + r + "," + g + "," + b + ")";
 }


	
	
}
