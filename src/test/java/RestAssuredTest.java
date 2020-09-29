import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
public class RestAssuredTest {

String api = "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
	
	
	@Test
	 public void GetWeatherDetails()
	 {   
		int code = get(api).getStatusCode();
		System.out.println("Code response: " + code);
		org.testng.Assert.assertEquals(code, 200);
	 
	 }
	@Test
	 public void GetWeatherDetailsBody()
	 {   
		List<String> validations = new ArrayList<String>();
		validations.add("coord");
		validations.add("weather");
		validations.add("id");
		validations.add("main");
		validations.add("description");
		validations.add("base");
		validations.add("temp");
		validations.add("pressure");
		validations.add("humidity");
		validations.add("temp_min");
		validations.add("temp_max");
		validations.add("visibility");
		validations.add("wind");
		validations.add("speed");
		validations.add("clouds");
		validations.add("all");
		validations.add("dt");
		validations.add("sys");
		validations.add("message");
		validations.add("country");
		validations.add("sunrise");
		validations.add("sunset");
		validations.add("name");
		validations.add("cod");
		validations.add("200");
		validations.add("London");
					
		
		String bodyResponse = get(api).getBody().asString();
		System.out.println("Body response: " + bodyResponse);
		for(String element : validations )
		{
			org.testng.Assert.assertTrue(bodyResponse.contains(element), "The body request doesn't contains: "+element);
		}
		
		
	 
	 }
}
