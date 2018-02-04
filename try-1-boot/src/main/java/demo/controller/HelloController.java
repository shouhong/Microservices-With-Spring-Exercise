package demo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@Value("${name}")
	private String name;
	
	@GetMapping("/hi")
	public @ResponseBody String hi() {
		return "hi " + getRestServiceData();
	}
	
	@GetMapping("/hi/{name}")
	public @ResponseBody String hi(@PathVariable String name) {
		return "hi " + name;
	}
	
	@GetMapping("/hello/{name}")
	public String hello (Map<String, String> model, @PathVariable String name) {
		model.put("name", name);
		return "hello";
	}
	
	public String getRestServiceData1() {
		return "Test Data";
	}
	
	public String getRestServiceData() {

		String targetURL = "http://localhost:8080";
		String output = "";

		try {

			URL restServiceURL = new URL(targetURL);

			HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL.openConnection();
			httpConnection.setRequestMethod("GET");
			httpConnection.setRequestProperty("Accept", "application/json");

			if (httpConnection.getResponseCode() != 200) {
				throw new RuntimeException(
						"HTTP GET Request Failed with Error code : " + httpConnection.getResponseCode());
			}

			BufferedReader responseBuffer = new BufferedReader(
					new InputStreamReader((httpConnection.getInputStream())));

			System.out.println("Output from Server:  \n");
			String line;
			while ((line = responseBuffer.readLine()) != null) {
				output = line;
				System.out.println(line);
			}

			httpConnection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output;
	}
}
