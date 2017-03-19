
public class IPref {
	int id;
	
	String country;
	String province;
	String city;
	Geo geo;	
	String dataCenter;
	
	static class Geo{
		double lattitude = 0;
		double longitude = 0; 
		
		private Geo (double x, double y){
			lattitude = x;
			longitude = y;
		}		
	}
	
	public IPref (){
	}
	
	
	
}
