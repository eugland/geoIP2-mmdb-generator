import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	String questions[] = {
		"What is the path for your file?  (type 0 for Command prompt manual input)", 
		"Where do you want to store the script? ", 
	};
	String answers[]= new String[questions.length]; 
	Scanner scan;
	Scanner in;
	BufferedWriter fileOut;
	IPpack ippack; 
	
	Main (){
		super();
		ippack = new IPpack();
		scan = new Scanner (System.in);
		
		guide(true);					//is it testing? 
		
		try {
			File file = new File (answers[0]);
			fileOut = new BufferedWriter (new FileWriter (new File (answers[1])));
			in = new Scanner (file); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		if (answers[0].equalsIgnoreCase("keyIN")){
			consoleReadin();
		}else {
			fileReadin ();
		}
		
		
		ippack.display();
		
		
		
		//debug use
		System.out.print(answers[0] + " "+ answers[1]);
	}
	
	private void fileReadin (){
		String buffered = "init";
		while (in.hasNextLine()) {
			buffered = in.nextLine();
			ippack.process (buffered);
		}
	}
	
	private void consoleReadin(){
		String buffered = "init";
		while (!buffered.equalsIgnoreCase("exit")) {
			buffered = scan.nextLine();
			System.out.println (buffered);
		}
	}
	
	
	private void guide (boolean isTesting){
		if (isTesting) {
			answers[0] = "C:\\Users\\eugene\\Desktop\\startup.txt";
			answers[1] = "C:\\Users\\eugene\\Desktop\\Tidi.txt";
			return;
		}
		for (int i = 0; i < questions.length; i++){
			System.out.println(questions[i]);
			answers[i] = scan.nextLine();
		}	
		
	}
	
	public static void main (String args []) {
		new Main ();
	}
	
	
	public void test () {
		CIDR cidrUtils = new CIDR();
		CIDR yolo = new CIDR();
		CIDR last = new CIDR();
		CIDR last1 = new CIDR();
		try {
			cidrUtils = new CIDR("10.21.32.98/24");
			yolo = new CIDR("10.21.31.99/24");
			last = new CIDR("255.255.255.254/1");
			last1 = new CIDR("255.255.255.255/1");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		String networkAddress = cidrUtils.getNetworkAddress();
		String broadcastAddress = cidrUtils.getBroadcastAddress();
		
		Set<CIDR> yol =  new HashSet<CIDR> ();
		yol.add(cidrUtils);
		yol.add(yolo);
		yol.add(last);
		yol.add(last1);
		
		System.out.println(networkAddress + " " + broadcastAddress); 
		System.out.println(cidrUtils.hashCode());
		System.out.println(cidrUtils.getRange());
		System.out.println(cidrUtils.getNetIP());
		System.out.println(cidrUtils.hashCode() + " " + yolo.hashCode() + " " + last.hashCode() + last1.hashCode());
		System.out.println(last.equals (last1));
		System.out.println(cidrUtils.equals (yolo));
		System.out.println(yol.size());
	}
	
	
}
