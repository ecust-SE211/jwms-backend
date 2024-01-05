package io.github.ecustse211;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="io.github.ecustse211.mapper")
public class EcustSe211Application {

	public static void main(String[] args) {
		SpringApplication.run(EcustSe211Application.class, args);
	}

}
