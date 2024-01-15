package io.github.ecustse211;

import org.mybatis.spring.annotation.MapperScan;
import org.opencv.core.Core;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.ecustse211.utils.ImageUtil;
@SpringBootApplication
@MapperScan("io.github.ecustse211.mapper")
public class EcustSe211Application {

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		SpringApplication.run(EcustSe211Application.class, args);
	}

}
