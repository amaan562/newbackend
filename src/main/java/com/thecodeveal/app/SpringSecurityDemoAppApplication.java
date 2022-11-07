package com.thecodeveal.app;



import org.jboss.jandex.VoidType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.thecodeveal.app.model.Authority;
import com.thecodeveal.app.model.BankDetails;
import com.thecodeveal.app.model.Department;
import com.thecodeveal.app.model.User;
import com.thecodeveal.app.repo.AuthorityDetailsRepository;
import com.thecodeveal.app.repo.BankDetailsRepository;
import com.thecodeveal.app.repo.DepartmentRepository;
import com.thecodeveal.app.repo.UserDetailsRepository;
import com.thecodeveal.app.service.AuthorityService;

import java.util.*;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringSecurityDemoAppApplication {

	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	@Autowired
	BankDetailsRepository bankDetailsRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthorityDetailsRepository authorityDetailsRepository;
	
	@Autowired
	AuthorityService authorityService;
	
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDemoAppApplication.class, args);
	}
	
	@PostConstruct
	protected void init()
	{

		
		
		if(userDetailsRepository.findByUsername("saicharanpoleboina@gmail.com")==null)
		{
			
			System.out.println("ok");
			
			Authority authority =new Authority((long)2, "USER");
			
			authorityService.saveAuthority(authority);
			
			Authority authority2 =new Authority((long)3, "EMP");
			
			authorityService.saveAuthority(authority2);
			
			
			Authority authority3 =new Authority((long)5, "ADMIN");
			
			authorityService.saveAuthority(authority3);
			
			
			List<Authority>authorityList=new ArrayList<>();
			
			authorityList.addAll(authorityService.findAuthority((long) 1));
			
			User user =new User();
		
			user.setUsername("saicharanpoleboina@gmail.com");
			
			user.setPassword(passwordEncoder.encode("CHara!4545"));
			
			user.setAuthorites(authorityList);
			
			user.setProfilepic("https://northmemorial.com/wp-content/uploads/2016/10/PersonPlaceholder.png");
			
			BankDetails bankDetails = new BankDetails("","","",false);
//			bankDetails.setAccountNumber(null);
//			bankDetails.setFirstEmployment(false);
//			bankDetails.setIfsc(null);
//			bankDetails.setPan(null);
			
//			user.setBankDetails(bankDetails);
			
			userDetailsRepository.save(user);
			bankDetailsRepository.save(bankDetails);
			
			System.out.println(user.getUsername() +" "+user.getPassword());
			
			
			
			
			Department department = new Department("INTERN", "intern");
			
			departmentRepository.save(department);
			
			department = new Department("IT", "information Technology");
			
			departmentRepository.save(department);
			
			department = new Department("HR", "Human Resources");
			
			departmentRepository.save(department);
			
			
			department = new Department("SAL", "Sales");
			
			departmentRepository.save(department);
			
			
			
			department = new Department("MRKT", "Marketing");
			
			departmentRepository.save(department);
			
			department = new Department("MNGMT", "Management");
			
			departmentRepository.save(department);
			
			
			
			
		}
		
		
		
		if(userDetailsRepository.findByUsername("saicharanpoleboina2@gmail.com")==null)
		{
			List<Authority>authorityList=new ArrayList<>();
			
			authorityList.addAll(authorityService.findAuthority((long) 1));
			
			User user =new User();
		
			user.setUsername("saicharanpoleboina2@gmail.com");
			
			user.setPassword(passwordEncoder.encode("CHara!4545"));
			
			user.setAuthorites(authorityList);
			
			user.setProfilepic("https://northmemorial.com/wp-content/uploads/2016/10/PersonPlaceholder.png");
			BankDetails bankDetails = new BankDetails("","","",false);
			
			userDetailsRepository.save(user);
			bankDetailsRepository.save(bankDetails);
			
		System.out.println(user.getUsername() +" "+user.getPassword());
		}
		
		if(userDetailsRepository.findByUsername("admin@virtusa.com")==null)
		{
			List<Authority>authorityList=new ArrayList<>();
			
			authorityList.addAll(authorityService.findAuthority((long) 3));
			
			User user =new User();
		
			user.setUsername("admin@virtusa.com");
			
			user.setPassword(passwordEncoder.encode("SPrin!3972"));
			
			user.setAuthorites(authorityList);
			
			user.setProfilepic("https://northmemorial.com/wp-content/uploads/2016/10/PersonPlaceholder.png");
			
			
					userDetailsRepository.save(user);
			
				System.out.println(user.getUsername() +" "+user.getPassword());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

    private Authority createAuthority(String roleCode,String roleDescription)
    {
    	Authority authority=new Authority();
    	authority.setRoleCode(roleCode);

    	return authority;
    	
    	
    }
	
	
	
	
	
}
