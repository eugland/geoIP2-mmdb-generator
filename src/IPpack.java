import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPpack {
	
	Map<IPref, TreeSet<CIDR>> ipMap;	
	//TODO sortout the Pattern Usage
	//private static Pattern ipPattern = Pattern.compile("(\d+\.\d+\.\d+\.\d+)");
	
	public IPpack (){
		ipMap = new HashMap<IPref, TreeSet<CIDR>> ();	
	}
	
	
	private String encoder (){
		return null;
	}
	
	
	public void process(String buffered) {
		CIDR cidr = new CIDR();
		IPref ref = null; 
		//Matcher m = ipPattern.matcher(buffered);
		
		//split into ip field and reference field
		String twoparts[] = buffered.split("\\(");
		//System.out.println(twoparts.length);
		
		if (twoparts.length != 2) {
			return;
		}
		
		//Handling IPs: split init and end ip
		String[]ips = twoparts[0].split("-");
		for (int i = 0; i < ips.length; i++ ){
			ips[i] = ips[i].trim();
		}
		
		//Handling IPs		
		try {
			cidr = new CIDR(ips[0], 24);
		} catch (Exception e){}
		
		
		
		if (cidr.exist && ref != null){
			this.add(ref, cidr);
		}
		
		
		
	}
	
	
	private void add (IPref ref, CIDR ip) {
		TreeSet<CIDR> set; 
		set = (ipMap.get(ref) == null)? new TreeSet<CIDR> (): ipMap.get(ref);
		set.add(ip);
		ipMap.put(ref, set);
	}

	
}

