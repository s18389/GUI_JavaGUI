package z01P2;
import java.util.Comparator;

public class MyColorCompar implements Comparator<MyColor> {
	
	int color;
	
	public MyColorCompar(int color){
		this.color = color;
	}

	@Override
	public int compare(MyColor o1, MyColor o2) {
		int result = 0;
		if(color == 0){
			if (o1.r > o2.r) result = 1;
			else result = -1;
		}
		
		if(color == 1){
			if (o1.g > o2.g) result = 1;
			else result = -1;
		}
		
		if(color == 2){
			if (o1.b > o2.b) result = 1;
			else result = -1;
		}
		return result;
	}
	
	



}
