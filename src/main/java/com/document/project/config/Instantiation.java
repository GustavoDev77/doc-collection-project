package com.document.project.config;

import com.document.project.domain.User;
import com.document.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... arg0) throws Exception {

        userRepository.deleteAll();

        User maria = new User(null, "Jacksons five", "jackson@gmail.com");
        User alex = new User(null, "Alex Brown", "brown@gmail.com");
        User gustavo = new User(null, "Gustavo Fring", "fring@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, gustavo));
    }
}
