package com.thewhite.aoplesson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AOPLessonApplication {

	public static void main(String[] args) {
		SpringApplication.run(AOPLessonApplication.class, args);
	}

}
