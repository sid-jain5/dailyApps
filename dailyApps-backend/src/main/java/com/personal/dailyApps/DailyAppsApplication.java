package com.personal.dailyApps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DailyAppsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailyAppsApplication.class, args);
		System.out.println("DailyApps Application Running in background");
	}

}
