import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class IPpack {
	Map<IPref, TreeSet<CIDR>> ipMap;
	
	public IPpack (){
		ipMap = new HashMap<IPref, TreeSet<CIDR>> ();
		
		
	}
	private String encoder (){
		return null;
	}
	
	
	public void process(String buffered) {
		String [] bf = buffered.split("\\(\\(-,");
		
		for (int i = 0; i < bf.length; i ++){
			System.out.print(bf[i] + "|");
		}
		System.out.println();
	}
	
	private void add (IPref ref, CIDR ip) {
		TreeSet<CIDR> set; 
		set = (ipMap.get(ref) == null)? new TreeSet<CIDR> (): ipMap.get(ref);
		set.add(ip);
		ipMap.put(ref, set);
	}
	
}

