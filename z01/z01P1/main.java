package z01P1;

public class main {

    public static void main(String args[]){

        Parabola p1 = new Parabola(1,-1,5/4);
    
       FunDD p2 = new FunDD(){
		@Override
		public double fun(double x) {
			return Math.sqrt((x-0.75)*(x-0.75) +1 );
		}
       };
       
       FunDD p3 = (double x) -> {
    	   return x*x*(x-2);
       };
       
       
       System.out.println("Min in this function is in x: " + FunDD.xminim(p1, 0,1));
       System.out.println("Min in this function is in x: " + FunDD.xminim(p2, 0,2));
       System.out.println("Min in this function is in x: " + FunDD.xminim(p3, 0,2));
       
       
    }
}
