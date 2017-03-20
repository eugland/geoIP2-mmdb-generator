import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPpack {
	
	Map<IPref, TreeSet<CIDR>> ipMap;	
	private static Pattern ipPattern = Pattern.compile("(\d+\.\d+\.\d+\.\d+)");
	
	public IPpack (){
		ipMap = new HashMap<IPref, TreeSet<CIDR>> ();	
	}
	
	
	private String encoder (){
		return null;
	}
	
	
	public void process(String buffered) {
		Matcher m = ipPattern.matcher(buffered);
		System.out.println(buffered);
        if (m.matches()) {
        	
            System.out.println(" matches; first part is " + m.group(0));
        } else {
            System.out.println(" does not match.");
        }
	}
	
	
	private void add (IPref ref, CIDR ip) {
		TreeSet<CIDR> set; 
		set = (ipMap.get(ref) == null)? new TreeSet<CIDR> (): ipMap.get(ref);
		set.add(ip);
		ipMap.put(ref, set);
	}

	
}

