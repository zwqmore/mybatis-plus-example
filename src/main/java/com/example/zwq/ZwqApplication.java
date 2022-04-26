package com.example.zwq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.zwq.sys.mapper")
public class ZwqApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZwqApplication.class, args);
	}

}
