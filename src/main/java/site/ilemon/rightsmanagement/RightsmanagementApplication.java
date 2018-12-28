package site.ilemon.rightsmanagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("site.ilemon.rightsmanagement.dao")
public class RightsmanagementApplication{

	public static void main(String[] args) {
		SpringApplication.run(RightsmanagementApplication.class, args);
	}

	
}

