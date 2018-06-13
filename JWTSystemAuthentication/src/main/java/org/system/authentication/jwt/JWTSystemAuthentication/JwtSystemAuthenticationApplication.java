package org.system.authentication.jwt.JWTSystemAuthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.system.authentication.jwt.JWTSystemAuthentication.dao.UserRepository;
import org.system.authentication.jwt.JWTSystemAuthentication.entities.AppUser;

import java.util.stream.Stream;

@SpringBootApplication
public class JwtSystemAuthenticationApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JwtSystemAuthenticationApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		Stream.of("U1","U2","U3").forEach(u->{
				userRepository.save(new AppUser(u,"pwd1",null));
				System.out.println(u);
		});

	}
}
