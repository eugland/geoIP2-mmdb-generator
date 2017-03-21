
public class IPref {
	String refv;
	String made;
	
	String dataCenter;
	String environment;
	String desc;
	
	String country;
	String province;
	String city;
	String timeZone; 
	
	String CountryCode0;
	String CountryCode1;
	String CountryCode2;
	
	String postalCode;
	String areaCode;
	
	Geo geo;	
	
	static class Geo{
		double lattitude = 0;
		double longitude = 0; 
		
		private Geo (double x, double y){
			lattitude = x;
			longitude = y;
		}		
	}
	
	public IPref (String Country, String Province, String City){
		country = Country;
		province = Province; 
		city = City; 
		refv = country+province+city;
		made = country+", " + province+", "+city;
		geo = new Geo (0.0, 0.0);
	}
	
	public IPref (String Country,  String City){
		country = Country;
		city = City; 		
		refv = country+city;
		made = country+", "+city;
		province = "";
		made = country+", " + province+", "+city;
		geo = new Geo (0.0, 0.0);
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
		bf = bf + "\n\t	location  =>  [" + geo.longitude + "," + geo.lattitude + "]"
				+ ",\n\t	latitude => '" + geo.lattitude
				+ "',\n\t 	longitude => '" + geo.longitude
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
