/*
* The MIT License
*
* Copyright (c) 2013 Eugene Wang (euhome.github.io)
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
* THE SOFTWARE.
*
* */
package gen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

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
			fileOut = new PrintWriter (new BufferedWriter (new FileWriter (new File (answers[1]) ) ) );
			in = new Scanner (new File (answers[0])); 
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
			answers[0] = "raw.txt";
			answers[1] = "script.pl";
			return;
		}
		for (int i = 0; i < questions.length; i++){
			System.out.println(questions[i]);
			answers[i] = scan.nextLine();
		}			
	}
	
	public static void main (String args []) {
		//new Main ();
		test();
	}
	
	private static void test () {
		executePost("https://www.baidu.com");
		
	}
	
	private static void executePost(String address) {
		//Tis the calling address:
		//http://maps.googleapis.com/maps/api/geocode/json?address=Toronto
		
		URL yahoo;
		try {
			yahoo = new URL(address);
	        URLConnection yc = yahoo.openConnection();
	        BufferedReader in = new BufferedReader(
	                                new InputStreamReader(
	                                yc.getInputStream()));
	        String inputLine;
	
	        while ((inputLine = in.readLine()) != null) 
	            System.out.println(inputLine);
	        in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	static class yo{
		static String ini_command =  
		  "use MaxMind::DB::Writer::Tree;\n"
		+ "my %types = (\n"
		+ "	color => 'utf8_string',\n"
		+ "	dogs  => [ 'array', 'utf8_string' ],\n"
		+ "	size  => 'uint16',\n"
		+ ");\n\n"				
				
		+ "my $tree = MaxMind::DB::Writer::Tree->new(\n"
		+ "	ip_version            => 4,\n"
		+ "	record_size           => 24,\n"
		+ "	database_type         => 'My-IP-Data',\n"
		+ "	languages             => ['en'],\n"
		+ "	description           => { en => 'My database of IP data' },\n"
		+ "	map_key_type_callback => sub { $types{ $_[0] } },\n"
		+ ");\n" 
	 	+ "$tree->insert_network(\n";
	 	
	 	
	 	static String mid_command = 
	 	  "		    '2001:db8::/48',								"
	 	+ "		    {												"
	 	+ "		        color => 'blue',							"
	 	+ "		        dogs  => [ 'Fido', 'Ms. Pretty Paws' ],		"
	 	+ "		        size  => 42,								"
	 	+ "		    },												";
	 	
	 	
	 	static String end_command = 
	 	  ");\n"	 	
	 	+ "open my $fh, '>:raw', 'my-ip-data.mmdb';\n"
	 	+ "$tree->write_tree($fh);\n"
	 	+ "print \"writing finished \\n;\"";

	}
	
	
}
