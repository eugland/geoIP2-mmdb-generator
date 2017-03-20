
public class IPref {
	String refv;
	String made;
	
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
		refv = country+province+city;
		made = country+", " + province+", "+city;
	}
	
	public IPref (String Country,  String City){
		country = Country;
		city = City; 		
		refv = country+city;
		made = country+", "+city;
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
