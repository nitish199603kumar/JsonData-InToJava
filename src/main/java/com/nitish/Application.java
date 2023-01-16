package com.nitish;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws ParseException, IOException {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		ReadDataFromJson bean = run.getBean(ReadDataFromJson.class);
		bean.fileReader();
	}

}
