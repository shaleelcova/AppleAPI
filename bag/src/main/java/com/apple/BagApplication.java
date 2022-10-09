package com.apple;

import com.apple.model.AppleBag;
import com.apple.repository.AppleRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BagApplication {
	@Autowired
	private AppleRepository appleRepository;

	public static void main(String[] args) {
		SpringApplication.run(BagApplication.class, args);
	}
////	@Bean
////	InitializingBean sendDatabase() {
////		return () -> {
////			appleRepository.save(new AppleBag("Royal Gala", 2, 5.50));
////			appleRepository.save(new AppleBag("Royal Gala", 5, 2.55));
////			appleRepository.save(new AppleBag("Royal Gala", 5, 1.00));
////		};
//	}
}
