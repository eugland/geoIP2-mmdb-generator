import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
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
		
		
		twoparts[1] = twoparts[1].replace (")", "" ).trim();
		//System.out.println(twoparts[1]);
		String[]strRef = twoparts[1].split(",");
		for (int i = 0; i < strRef.length; i++ ){
			strRef[i] = strRef[i].trim();
			//System.out.print(strRef[i]+"|");
		}
		
		if (strRef.length == 3) {
			ref = new IPref (strRef[0],strRef[1],strRef[2]);
		} else if (strRef.length == 2){
			ref = new IPref (strRef[0],strRef[1]);
		}
		
		
		
		if (cidr.exist && ref != null){
			this.add(ref, cidr);
		}
		
		
		
	}
	
	public void display(){
		Iterator<Entry<IPref, TreeSet<CIDR>>> it = ipMap.entrySet().iterator();
		while (it.hasNext()){
			Map.Entry<IPref, TreeSet<CIDR>> pair = (Map.Entry<IPref, TreeSet<CIDR>>)it.next();
			System.out.println(((IPref)pair.getKey()) + "\n===========================");
			TreeSet<CIDR> set = (TreeSet<CIDR>)pair.getValue();
			for (CIDR ci : set){
				System.out.println("\t"+ci);
			}
			System.out.println();
		}
		
	}
	
	private void add (IPref ref, CIDR ip) {
		TreeSet<CIDR> set; 
		set = (ipMap.get(ref) == null)? new TreeSet<CIDR> (): ipMap.get(ref);
		set.add(ip);
		ipMap.put(ref, set);
	}

	
}

