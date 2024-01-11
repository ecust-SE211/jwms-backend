package io.github.ecustse211;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.ecustse211.utils.ImageUtil;
@SpringBootApplication
@MapperScan("io.github.ecustse211.mapper")
public class EcustSe211Application {

	public static void main(String[] args) {
		SpringApplication.run(EcustSe211Application.class, args);
		//String base64 = ImageUtil.convertImageToBase64("src/main/resources/tempImage/21013030.png");
		//System.out.println(base64);
	}

}
