package z01P1;

public class Parabola implements FunDD {

    double a;
    double b;
    double c;

    public Parabola(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double fun(double x) {
        return a*x*x + b*x + c;
    }
    
    @Override
    public String toString(){
        return a + "x^2 + " + b + "x + " + c;
    }
}
