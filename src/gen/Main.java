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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {	
	String questions[] = {
		"What is the path for your file?  (type 0 for Command prompt manual input)", 
		"Where do you want to store the script? ", 
	};
	String answers[] = {
			"raw-ip.txt",
			"script.pl"
	};
	Scanner scan;
	Scanner in;
	PrintWriter out;
	
	Main ()  {
		super();	
		long time = System.currentTimeMillis();
		scan = new Scanner (System.in);
		//guide(); //is it testing? 
		try {
		out = new PrintWriter (new BufferedWriter (new FileWriter (new File (answers[1]) ) ) );
		in = new Scanner (new File (answers[0])); 
		} catch (IOException e) {e.printStackTrace();}
		
		if (answers[0].contains("ip")){
			System.out.println("ip");
			new IPpack().process(in, out);
		} else if (answers[0].contains("post")){
			System.out.println("post");
			new PostalPack ().process (in, out);
		} else {
			
		}		
			
		in.close();
		out.close();		
		System.out.println("File Process Complete: " + answers[0] + ", "+ answers[1]);
		System.out.println((System.currentTimeMillis()-time)/1000);
	}
			
	private void guide (){
		for (int i = 0; i < questions.length; i++){
			System.out.println(questions[i]);
			answers[i] = scan.nextLine();
		}			
	}
	
	public static void main (String args []) throws Exception {
		new Main ();
		
	}	
	
	private static void ex (){
		
	}
}
