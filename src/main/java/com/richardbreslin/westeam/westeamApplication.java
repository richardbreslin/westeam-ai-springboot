package com.richardbreslin.westeam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class westeamApplication {

	public static void main(String[] args) {
		SpringApplication.run(westeamApplication.class, args);
	}

}
