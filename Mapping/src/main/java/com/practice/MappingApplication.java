package com.practice;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.practice.payloads.AppConstant;
import com.practice.repo.RoleDao;

@SpringBootApplication
public class MappingApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleDao roleDao;
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(MappingApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("password is " + this.passwordEncoder.encode("xyz"));	
		try {
			
			com.practice.model.Role role = new com.practice.model.Role();
			role.setId(AppConstant.ROLE_ADMIN);
			role.setName("ROLE_ADMIN");
			
			com.practice.model.Role role1 = new com.practice.model.Role();
			role1.setId(AppConstant.ROLE_USER);
			role1.setName("ROLE_NORMAL");
			
			List<com.practice.model.Role> roles = List.of(role, role1);
			
			List<com.practice.model.Role> result = this.roleDao.saveAll(roles);
			
			result.forEach(r -> {
				System.out.println(r.getName());
			});
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}	
}
