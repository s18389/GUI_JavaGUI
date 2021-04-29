public class MyColor extends java.awt.Color implements Comparable <MyColor> {


    public MyColor(int red, int green, int blue){
        super(red, green, blue);
    }

    @Override
    public int compareTo(MyColor other) {
        
        return 0;
    }

    @Override
    public String toString() {
        return "(" + getRed() + "," + getGreen() + "," + getBlue() + ")";
    }
}
