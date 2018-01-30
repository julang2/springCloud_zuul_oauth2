package com.hfcsbc;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;




@SpringBootApplication
@EnableDiscoveryClient
public class AuthServerApplication {

//	@Bean(name = "auditorAware")
//	public AuditorAware<String> auditorAware() {
//		return ()-> SecurityUtils.getCurrentUserUsername();
//	}

	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}

}
