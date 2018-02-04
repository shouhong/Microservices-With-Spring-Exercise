package demo.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.ServiceInfo;

@RestController
public class ServiceInfoController {
	@GetMapping("/")
	public ServiceInfo getServiceInfo(){
		InetAddress addr;
		String hostname = "";
		try {
			addr = InetAddress.getLocalHost();
			hostname = addr.getHostName().toString();//获得本机IP
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		ServiceInfo serviceInfo = new ServiceInfo();
		serviceInfo.setTitle("云服务中心微服务简介");
		serviceInfo.setDescription("云服务中心微服务可以通过应用包部署，也可以通过容器镜像部署。运行在云服务中心上的微服务具有弹性伸缩、高可用、故障自愈等特性。");
		serviceInfo.setSource(hostname);
		serviceInfo.setVersion("v1.0");
		return serviceInfo;
	}
}
