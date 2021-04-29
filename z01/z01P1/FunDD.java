package z01P1;

@FunctionalInterface
interface FunDD {

    double fun(double x);

    static double xminim(FunDD f, double a, double b) {

    	double x = a;
    	double x_min = a;
        double min = f.fun(x);
        
   //     System.out.println(min);
        
        while(x <= b){
           if(f.fun(x) < min) {
        	   min = f.fun(x);
        	   x_min = x;
           }
                  // System.out.print(f.fun(x) + " ");
           x+=1e-5;
        }
        return x_min;
    }

}
