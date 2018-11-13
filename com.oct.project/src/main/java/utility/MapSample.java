package utility;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class MapSample {
	
	
	@Test
	public void getValues() {
		
		Map<String, String> data = new HashMap<String, String>();
		
		/*
		 *  Data will store on Key and Value Basic
		 *  
		 *  Duplicate Keys are not allowed
		 */
		data.put("189", "Suresh");
		data.put("456", "Nageen");
		data.put("789", "Sampath");
		data.put("189", "Suuresh");
		
		
		System.out.println(data.get("456"));
		
		System.out.println(data.get("189"));
		
		System.out.println(data.get("789"));
		
		
		
	}

}
