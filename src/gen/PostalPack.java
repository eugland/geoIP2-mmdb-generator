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

import java.io.PrintWriter;
import java.util.Scanner;

public class PostalPack {
	public PostalPack (){}
	public void process (Scanner in, PrintWriter out){
		String buffered = "init";
		while (in.hasNextLine()) {
			buffered = in.nextLine();			
			String bf[] = buffered.split(",");
			//System.out.print(bf[0] + "|" + bf[2] + ":" + bf[3]);		
			out.println ("\""+bf[0]+"\":\""+bf[2]+","+bf[3]+"\",");	
			out.flush();
		}			
	}		
}