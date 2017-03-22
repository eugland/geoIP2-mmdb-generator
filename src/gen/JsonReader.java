package gen;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonReader {
	String url;
	BufferedReader rd;
	InputStream is;
	
	public JsonReader (String recurl){
		url = recurl;
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

 
}