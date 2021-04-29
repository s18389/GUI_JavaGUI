package z02P2;

public class StrToInt implements Transform<String, Integer>{
	
	String d;
	public StrToInt(String d){
		this.d = d;
	}

	@Override
	public Integer apply(String s) {
		return s.length();
	}
	
}