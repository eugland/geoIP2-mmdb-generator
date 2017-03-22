package gen;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonReader {
	String url;
	BufferedReader rd;
	InputStream is;
	
	public JsonReader (String recurl){
		url = recurl;
	}
	public JsonReader (){
		url = "http://maps.googleapis.com/maps/api/geocode/json?address=";
	}
	

	String readAll() throws IOException {
		is = new URL(url).openStream();
        rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        
		StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }
	
	JSONObject readJsonFromUrl() throws IOException, JSONException {
	    is = new URL(url).openStream();
	    try {
	      rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = this.readAll();
	      JSONObject json = new JSONObject(jsonText);
	      return json;
	    } finally {
	      is.close();
	    }
	  }
	
	JSONObject getGoogleLatLon (String address){
		//Tis the calling address:
		//http://maps.googleapis.com/maps/api/geocode/json?address=Toronto
		JSONObject rawResponse = null;
		
		
		try {
			rawResponse = new JsonReader (url+address).readJsonFromUrl();
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}
		
		
		JSONArray jsArray =  rawResponse.getJSONArray("results");
		JSONObject jsItemLocation = jsArray.getJSONObject(0).getJSONObject("geometry").getJSONObject("location");
		
	    return jsItemLocation;
	}

 
}