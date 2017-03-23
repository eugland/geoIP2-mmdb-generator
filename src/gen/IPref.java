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

import org.json.JSONObject;

public class IPref {
	String refv;
	String made;
	
	String country="";
	String province ="";
	String city ="";
	String timeZone = ""; 
		
	String postalCode;
	String areaCode;
	
	double lat;
	double lng;
	
	
	public IPref (String Country, String Province, String City){
		country = Country;
		province = Province; 
		city = City; 		
		made = country+", " + province+", "+city;
		init();		
	}
	
	public IPref (String Country,  String City){
		country = Country;
		city = City; 		
		made = country+", "+city;
		init();		
	}
	
	private void init(){
		mader();
		refv = country+province+city;
	}
	
	private void mader (){
		if (city.contains("GCC")){
			made = country+", " + province+", "+"guelph";
		}else if (city.contains("MCC")){
			made = country+", " + province+", "+"Markham";
		} else if (province == ""){
			made = country+", " +city;
		} else {
			made = country+", " + province+", "+city;
		}			
	}
	
	public void complete (){
		int tries = 0; 
		boolean fail = false; 
		do {
			try {
			JSONObject jsobj = new JsonReader ().getGoogleLatLon(made.replace(" ", ""));
			lat = jsobj.getDouble("lat");
			lng = jsobj.getDouble("lng");
			//System.out.print(" "+ lat + ":"+ lng );
			fail = false;
			System.out.println("OK at " + made);
			} catch (Exception e){
				tries ++; 
				fail = true;				
			}
		} while (fail && tries < 3);
		if (fail){
			System.out.println("failed at " + made);
		}
	}
	
	public String itemReturn (){
		/* This is the perl Format
			'2001:db8::/48',
	        {
	            color => 'blue',
	            dogs  => [ 'Fido', 'Ms. Pretty Paws' ],
	            size  => 42,
	        },
	     */		
		String bf = "\t{";
		bf = bf + "\n\t	location  =>  [" + lng + "," + lat + "]"
				+ ",\n\t	latitude => '" + lat
				+ "',\n\t 	longitude => '" + lng
				+ "',\n\t 	country => '" + country
				+ "',\n\t 	region_name => '" + province
 				+ "',\n\t 	city_name => '" + city
 				+ "',\n\t 	timezone => 'America/New_York'"
				+ ", \n\t},\n\n"    ;
		return bf;
	}
	
	@Override 
	public String toString(){
		return made;
	}
	
	@Override 
	public int hashCode (){
		return refv.hashCode();
	}
	
	@Override 
	public boolean equals (Object o){
		return o.hashCode() == this.hashCode();
	}
	
	public IPref (){
		
	}
	
	
	
}
