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
		StringTokenizer st = new StringTokenizer (buffered, "()-,");
		while (st.hasMoreTokens()){
			
			String bf = st.nextToken().trim();
			System.out.print(bf + "|");
			
		}
		System.out.println();
	}
	
}

