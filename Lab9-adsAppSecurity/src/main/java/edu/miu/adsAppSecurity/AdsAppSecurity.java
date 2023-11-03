package edu.miu.adsAppSecurity;

import edu.miu.adsAppSecurity.model.Role;
import edu.miu.adsAppSecurity.model.User;
import edu.miu.adsAppSecurity.repository.RoleRepository;
import edu.miu.adsAppSecurity.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AdsAppSecurity {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public AdsAppSecurity(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(AdsAppSecurity.class, args);
    }

    @PostConstruct
    public void initAdminUser() {
        var adminUser = userRepository.findByUsername("admin");
        if (adminUser.isEmpty()) {
            List<Role> listAdminRoles = new ArrayList<>();
            var adminRole = roleRepository.findByRoleName("ROLE_ADMIN");
            if (adminRole.isEmpty()) {
                var newAdminRole = new Role(null, "ROLE_ADMIN");
                listAdminRoles.add(newAdminRole);
            } else {
                listAdminRoles.add(adminRole.get());
            }
            User newAdminUser = new User(null, "Admin", "Admin", "Admin", "admin",
                    passwordEncoder.encode("test123"), "admin@gmail.com",
                    true,true, true, true);
            newAdminUser.setRoles(listAdminRoles);
            userRepository.save(newAdminUser);
        }
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return (args) -> {
            System.out.println("Hello RESTful Web API");
            System.out.println("Ads WebAPI server. Starting...");
            System.out.println("Ads WebAPI server. Started.\nRunning Apache Tomcat service and Listening for HTTP Request on Port number, 8080");
            System.out.println("To see list of Publishers, send HTTP GET Request to the URI,\nhttp://localhost:8080/adsApp/api/v1/patient/list");
        };
    }
}
