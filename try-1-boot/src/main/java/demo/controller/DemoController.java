package demo.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.DemoInfo;

@RestController
public class DemoController {
	
	@GetMapping("/")
	public DemoInfo getDemoInfo() {
		InetAddress addr;
		String ip = "";
		try {
			addr = InetAddress.getLocalHost();
			ip = addr.getHostAddress().toString();//获得本机IP
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		DemoInfo demoInfo = new DemoInfo();
		demoInfo.setDescription("云服务中心应用包部署Demo");
		demoInfo.setData("Test Data");
		demoInfo.setSourceIP(ip);
		return demoInfo;
	}
}
