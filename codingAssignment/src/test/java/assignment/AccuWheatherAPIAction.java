package assignment;

import java.util.HashMap;

import com.google.gson.JsonObject;
import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
//import net.minidev.json.JSONObject;

import com.jayway.jsonpath.JsonPath;

public class AccuWheatherAPIAction {

	public static HashMap<String, Integer> accuwheather(){
		HashMap<String, Integer> dataAPI = new HashMap<String, Integer>();
		RestAssured.baseURI ="https://api.openweathermap.org/data/2.5/"; 
		 RequestSpecification request = RestAssured.given();
		 
		 Response response = request.queryParam("q", "Noida") 
		                    .queryParam("appid", "7fe67bf08c80ded756e598d6f8fedaea") 
		                    .get("/weather");
		 
		 String jsonString = response.asString();
		double temperature =  JsonPath.read(jsonString, "$.main.temp");
		int humidity = JsonPath.read(jsonString, "$.main.humidity");
		int tempCelcius = Math.round(convertKelvinToCelsius(temperature));
		dataAPI.put("tempAPI", tempCelcius);
		dataAPI.put("humidityAPI", humidity);
		return  dataAPI;
	}
	
	private static float convertKelvinToCelsius(double temperature) {

		   float tempInCelcius = (float) (temperature - 273.15);
		   return tempInCelcius;
		 }
}
