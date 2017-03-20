
public class IPref {
	int id;
	
	String dataCenter;
	String environment;
	String desc;
	
	String country;
	String province;
	String city;
	
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
		
		
	}
	
	public IPref (){
		
	}
	
	
	
}
