package forum;

import forum.service.commentService.CommentService;
import forum.service.commentService.CommentServiceJPA;
import forum.services.UserService;
import forum.services.UserServiceJpa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootConfiguration
@Configuration
public class SpringMain {

    public static void main(String[] args) {
        SpringApplication.run(SpringMain.class, args);
    }
        @Bean
        public CommentService commentService() {
            return new CommentServiceJPA();
        }

        @Bean
        public UserService userService() {
            return new UserServiceJpa();
        }

}


