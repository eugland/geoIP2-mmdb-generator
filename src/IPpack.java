import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class IPpack {
	Map<IPref, TreeSet> ipMap;
	
	public IPpack (){
		ipMap = new HashMap<IPref, TreeSet> ();
		
		
	}
	private String encoder (){
		return null;
	}
	
	
	public void process(String buffered) {
		String [] bf = buffered.split("()-,");
		
		for (int i = 0; i < bf.length; i ++){
			System.out.print(bf[i] + "|");
		}
		System.out.println();
	}
	
}

