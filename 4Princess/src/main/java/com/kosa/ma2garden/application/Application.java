package com.kosa.ma2garden.application;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableJpaAuditing
@EntityScan(basePackages = "com.*")
@ComponentScan(basePackages = "com.*")
@EnableJpaRepositories(basePackages = "com.*")
@SpringBootApplication
public class Application {	
	

	public static void main(String[] args) {
		
		SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder(Application.class);
		springApplicationBuilder.build().addListeners(new ApplicationPidFileWriter("/home/ec2-user/ma2garden/conf/server.pid"));
		springApplicationBuilder.run(args);
	}
}
