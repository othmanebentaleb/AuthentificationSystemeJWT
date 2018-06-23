package org.system.authentication.jwt.JWTSystemAuthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.system.authentication.jwt.JWTSystemAuthentication.dao.UserRepository;
import org.system.authentication.jwt.JWTSystemAuthentication.entities.AppRole;
import org.system.authentication.jwt.JWTSystemAuthentication.entities.AppUser;
import org.system.authentication.jwt.JWTSystemAuthentication.service.IAccountService;

import java.util.stream.Stream;

@SpringBootApplication
public class JwtSystemAuthenticationApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JwtSystemAuthenticationApplication.class, args);
	}


	@Autowired
	private IAccountService accountService;

	@Override
	public void run(String... args) throws Exception {

		accountService.saveUser(new AppUser("admin","1234",null));
		accountService.saveUser(new AppUser("othmane","1234",null));

		accountService.saveRole(new AppRole("ADMIN"));
		accountService.saveRole(new AppRole("USER"));

		accountService.addRoleToUser("admin","ADMIN");
		accountService.addRoleToUser("admin","USER");
		accountService.addRoleToUser("othmane","USER");




		/*Stream.of("U1","U2","U3").forEach(u->{
				userRepository.save(new AppUser(u,"pwd1",null));
				System.out.println(u);
		});*/

	}
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
