package com.groupeisi.adminservice;

import com.groupeisi.adminservice.domaine.AppUser;
import com.groupeisi.adminservice.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class AdminServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(AdminServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(AppUserService appUserService){
		return args -> {
			appUserService.createAppUser(new AppUser(1,"med@gmail.com","com"));
			appUserService.createAppUser(new AppUser(2,"sou@gmail.com","123"));
		};
	}
}