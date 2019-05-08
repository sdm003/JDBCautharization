package com.example.Artifact.bootstrap;

import com.example.Artifact.entity.UserRoles;
import com.example.Artifact.entity.Users;
import com.example.Artifact.repository.UserRolesRepository;
import com.example.Artifact.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Bootstraper implements CommandLineRunner {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private UserRolesRepository userRolesRepository;

    @Override
    public void run(String... args) throws Exception {
        BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
        Users user1= new Users("sdm003",passwordEncoder.encode("1230"),(long)1);
        usersRepository.save(user1);
        Users user2= new Users("nargiz",passwordEncoder.encode("123"),(long)1);
usersRepository.save(user2);
        UserRoles userRoles1 = new UserRoles("ADMIN",user1 );
        userRolesRepository.save(userRoles1);

        UserRoles userRoles2 = new UserRoles( "USER",user2);
        userRolesRepository.save(userRoles2);

    }
}
