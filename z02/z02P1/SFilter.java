package z02E;

@FunctionalInterface
public interface SFilter {
	
    boolean test(String a);

    public static String[] filter(String[] arr, SFilter filt) {
       
    	String[] array = new String[arr.length];
      
    	int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (filt.test(arr[i])) {
                array[i] = arr[i];
                counter++;
            }
        }
        
        String[] result = new String[counter];
        int counter2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (array[i] != null){
                result[counter2++] = array[i];
            }
        }
        
        return result;

    }
}
