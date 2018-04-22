package com.Ilvcode;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;


@Component
public class CustomizationBean implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
	@Value("${port:8070}")
	private Integer myPort;
	@Value("${useLocalHost:true}")
	private Boolean useLocalHost;
	@Override
	public void customize(ConfigurableServletWebServerFactory server) {
		server.setPort(myPort);
		InetAddress address; 
		try {
			//Based on the input parameter to decide use localhost or loopback address
			if(useLocalHost) {
				address = InetAddress.getLocalHost();
			} else {
				address = InetAddress.getLoopbackAddress();
			}
			server.setAddress(address);
		} catch (UnknownHostException e) {
			System.out.println(e);
		}
		
	}

}
