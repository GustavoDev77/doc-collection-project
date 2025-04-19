package com.document.project.config;

import com.document.project.DTO.AutorDTO;
import com.document.project.domain.Post;
import com.document.project.domain.User;
import com.document.project.repository.PostRepository;
import com.document.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... arg0) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Jacksons five", "jackson@gmail.com");
        User alex = new User(null, "Alex Brown", "brown@gmail.com");
        User gustavo = new User(null, "Gustavo Fring", "fring@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, gustavo));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Itaquer", "Ver o Coringão ganhar", new AutorDTO(gustavo));
        Post post2 = new Post(null, sdf.parse("04/07/2012"), "Dia de São Nunca", "Vencemos a liberta, vai Corinthians", new AutorDTO(alex));

        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
