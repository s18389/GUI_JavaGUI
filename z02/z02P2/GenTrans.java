package z02P2;
import java.util.Arrays;

import z02E.SFilter;

public class GenTrans {
	
	
    private static <T, R>
    
    void transform(T[] in, R[] out, Transform<T, R> trans) {
      for(int i=0;i<in.length;i++){
    	  out[i] = trans.apply(in[i]);
      }
    }

    public static void main (String[] args) {
    	
        String[]  sin = {"Alice", "Sue", "Janet", "Bea"};
       
        System.out.println(Arrays.toString(sin) + '\n');

        Integer[] iout = new Integer[sin.length];
        transform(sin, iout, new StrToInt(Arrays.toString(sin)));
        System.out.println(Arrays.toString(iout));

   //     Transform obj = new Transform<String, Character>() {

	//		@Override
	//		public Character apply(String s) {
	//			 Character result = new Character;
	//			 result = charValue(result)
	//			return result;
	//		}
        	

    //    };
        
 //       Character[] cout = new Character[sin.length];
 //       transform(sin, cout, obj);
 //       System.out.println(Arrays.toString(cout));

        Transform<String, String> obj3 = (String s) -> {
            return s.toUpperCase();
        };
        
        String[] sout = new String[sin.length];
        transform(sin, sout, obj3);
        System.out.println(Arrays.toString(sout));
    }
}