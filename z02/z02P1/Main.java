package z02E;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
    	
        LenFilter len1 = new LenFilter(4);
        
        SFilter len2 = new SFilter() {
            @Override
            public boolean test(String a) {
                int l_a = (int) 'A';
                int l_d = (int) 'D';
                return (((int) a.charAt(0) < l_d)&&((int) a.charAt(0) >= l_a));
            }
        };
        
        SFilter len3 = (String a) -> {
            int l_h = (int) 'H';
            int l_z = (int) 'Z';
            return (int) a.charAt(0) > l_h && (int) a.charAt(0) < l_z;
        };
        
        String[] arr = {"Alice", "Sue", "Janet", "Bea"};
        System.out.println(Arrays.toString(arr));

        String[] a1 = SFilter.filter(arr,len1);
        System.out.println(Arrays.toString(a1));

        String[] a2 = SFilter.filter(arr,len2);
        System.out.println(Arrays.toString(a2));

        String[] a3 = SFilter.filter(arr,len3);
        System.out.println(Arrays.toString(a3));
    }


}

