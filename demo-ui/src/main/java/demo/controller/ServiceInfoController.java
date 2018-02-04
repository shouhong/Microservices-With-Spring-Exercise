package demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import demo.domain.ServiceInfo;

@Controller
public class ServiceInfoController {
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${serviceUrl}") String serviceUrl;
	
	@GetMapping("/")
	public String getServiceInfo(Map<String,String> model) {
		ServiceInfo serviceInfo = this.restTemplate.getForObject(serviceUrl, ServiceInfo.class);
		model.put("title", serviceInfo.getTitle());
		model.put("description", serviceInfo.getDescription());
		model.put("source", serviceInfo.getSource());
		model.put("version", serviceInfo.getVersion());
		return "ServiceInfo";
	}
}
