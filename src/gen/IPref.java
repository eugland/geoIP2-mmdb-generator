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
	
	long lat;
	long lng;
	
	
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
		JSONObject jsobj = new JsonReader ().getGoogleLatLon(made.replace(" ", ""));
		System.out.println(made + " | " + jsobj) ;
		lat = jsobj.getLong("lat");
		lng = jsobj.getLong("lng");
	}
	
	private void mader (){
		if (city.contains("GCC")){
			made = country+", " + province+", "+"guelph";
		} else if (province == ""){
			made = country+", " +city;
		} else {
			made = country+", " + province+", "+city;
		}			
	}
	
	public String itemReturn (){
		
		
		
		
		/*
		 * This is the Logstash Output
		 {
          "path" => "C:/Users/eugene/Documents/codes/file/test.txt",
         "srcip" => "54.164.49.176",
    "@timestamp" => 2017-03-21T05:33:42.181Z,
         "geoip" => {
              "timezone" => "America/New_York",
                    "ip" => "54.164.49.176",
              "latitude" => 39.0481,
        "continent_code" => "NA",
             "city_name" => "Ashburn",
         "country_code2" => "US",
          "country_name" => "United States",
              "dma_code" => 511,
         "country_code3" => "US",
           "region_name" => "Virginia",
              "location" => [
            [0] -77.4728,
            [1] 39.0481
        ],
           "postal_code" => "20149",
             "longitude" => -77.4728,
           "region_code" => "VA"
    },
      
		 
		 
		 * This is the perl Format
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
