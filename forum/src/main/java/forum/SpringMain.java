package forum;

import forum.service.commentService.CommentService;
import forum.service.commentService.CommentServiceJPA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
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

}


