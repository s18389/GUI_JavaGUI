package z01P2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ColorComparing {
    public static void main(String[] args) {
        List<MyColor> list = Arrays.asList(
            new MyColor(  1,  2,  3),
            new MyColor(255,  0,  0),
            new MyColor( 55, 55,100),
            new MyColor( 10,255, 10)
        );
        System.out.println(list);
        
  //      Collections.sort(list);
  //      System.out.println(list);
        
        Collections.sort(list, new MyColorCompar(0));
        System.out.println(list);
        
        Collections.sort(list, new MyColorCompar(1));
        System.out.println(list);
        
        Collections.sort(list, new MyColorCompar(2));
        System.out.println(list);
    }
}