package forum;

import forum.services.Category.CategoryService;
import forum.services.Category.CategoryServiceJpa;
import forum.services.comment.CommentService;
import forum.services.comment.CommentServiceJPA;
import forum.services.profile.ProfileService;
import forum.services.profile.ProfileServiceJPA;
import forum.services.rating.RatingService;
import forum.services.rating.RatingServiceJpa;
import forum.services.rudeWords.RudeWordsService;
import forum.services.rudeWords.RudeWordsServiceJpa;
import forum.services.theme.ThemeService;
import forum.services.theme.ThemeServiceJpa;
import forum.services.user.UserService;
import forum.services.user.UserServiceJpa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class SpringMain {

    public static void main(String[] args) {SpringApplication.run(SpringMain.class, args);}


        @Bean
        public UserService userService() {return new UserServiceJpa();}

        @Bean
        public CommentService commentService(){return new CommentServiceJPA();}

        @Bean
        public RatingService ratingService() {return  new RatingServiceJpa();}

        @Bean
        public ThemeService themeService() {return new ThemeServiceJpa();}

        @Bean
        public CategoryService categoryService(){return new CategoryServiceJpa();}

        @Bean
        public RudeWordsService rudeWordsService(){return new RudeWordsServiceJpa();}

        @Bean
        public ProfileService profileService(){return new ProfileServiceJPA();}
}