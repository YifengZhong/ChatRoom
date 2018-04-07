package com.Ilvcode.controller;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;


@Component
public class CustomizationBean implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
	@Value("${port}")
	private Integer myPort;
	@Override
	public void customize(ConfigurableServletWebServerFactory server) {
		server.setPort(myPort);
		InetAddress address = InetAddress.getLoopbackAddress();
		System.out.println("Zhong.address:" + address.toString());
		server.setAddress(address);
		
	}

}
