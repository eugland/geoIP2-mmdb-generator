import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
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
	PrintWriter fileOut;
	IPpack ippack; 
	
	Main (){
		super();
		ippack = new IPpack();
		scan = new Scanner (System.in);
		
		guide(true);					//is it testing? 
		
		try {
			File file = new File (answers[0]);
			fileOut = new PrintWriter (new BufferedWriter (new FileWriter (new File (answers[1]) ) ) );
			in = new Scanner (file); 
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		if (answers[0].equalsIgnoreCase("keyIN")){
			
			consoleReadin();
		}else {
			
			fileReadin ();
		}
		
		try {
			fileOut.println(yo.ini_command);
			
			ippack.write(fileOut);
			fileOut.write(yo.end_command);
			fileOut.close();
			
			
			System.out.println("output?");
		} catch (Exception e){
			System.out.println(e);
		}
		
		
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
	
	static class yo{
		static String ini_command =  
		  "use MaxMind::DB::Writer::Tree;"
		+ "my %types = ("
		+ "		color => 'utf8_string',"
		+ "		dogs  => [ 'array', 'utf8_string' ],"
		+ "		size  => 'uint16',"
		+ ");"				
				
		+ "my $tree = MaxMind::DB::Writer::Tree->new("
		+ "		ip_version            => 4,"
		+ "		record_size           => 24,"
		+ "		database_type         => 'My-IP-Data',"
		+ "		languages             => ['en'],"
		+ "		description           => { en => 'My database of IP data' },"
		+ "		map_key_type_callback => sub { $types{ $_[0] } },"
		+ ");" 
	 	+ "$tree->insert_network(";
	 	
	 	
	 	static String mid_command = 
	 	  "		    '2001:db8::/48',								"
	 	+ "		    {												"
	 	+ "		        color => 'blue',							"
	 	+ "		        dogs  => [ 'Fido', 'Ms. Pretty Paws' ],		"
	 	+ "		        size  => 42,								"
	 	+ "		    },												";
	 	
	 	
	 	static String end_command = 
	 	  "		);"	 	
	 	+ "		open my $fh, '>:raw', 'my-ip-data.mmdb';"
	 	+ "		$tree->write_tree($fh);";
				
	}
	
	
}
