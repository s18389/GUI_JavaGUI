package z02E;

public class LenFilter implements SFilter {
	
    int milLen;
    
    public LenFilter(int a){
        milLen = a;
    }
    
    public boolean test(String a){
         return a.length()>=milLen;
    }

}
