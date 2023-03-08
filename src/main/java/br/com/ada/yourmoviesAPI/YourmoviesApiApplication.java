package br.com.ada.yourmoviesAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class YourmoviesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(YourmoviesApiApplication.class, args);
	}

}
