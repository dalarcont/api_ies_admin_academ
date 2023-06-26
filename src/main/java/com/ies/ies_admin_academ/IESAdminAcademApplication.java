package com.ies.ies_admin_academ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class IESAdminAcademApplication {

	private static final Logger logger = LogManager.getLogger(IESAdminAcademApplication.class);
	public static void main(String[] args) {

		SpringApplication.run(IESAdminAcademApplication.class, args);
		logger.trace("STARTING IES ADMIN ACADEM JAVA SPRINGBOOT");
	}

}
