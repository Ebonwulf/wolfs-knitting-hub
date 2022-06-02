package com.nology.wolfsknittinghubbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication//(exclude ={DataSourceAutoConfiguration.class}) no longer
// needed now that it is connected to a GCP database
public class WolfsKnittingHubBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(WolfsKnittingHubBackendApplication.class, args);
	}

}
