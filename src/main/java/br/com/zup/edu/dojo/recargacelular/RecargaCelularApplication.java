package br.com.zup.edu.dojo.recargacelular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class RecargaCelularApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecargaCelularApplication.class, args);
	}

}
