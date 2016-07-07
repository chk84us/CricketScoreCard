package cricket.app;

import cricket.exceptions.InningsExceededException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;

/**
 * @author Harish Chakravarthy
 */
@EntityScan(basePackages = "cricket")
@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public CommandLineRunner demo(CricketRepository repository) {
//        return (args) -> {
//            try {
//                repository.save(new CricketGameController().cricketGame(1));
//            } catch (InningsExceededException e) {
//                log.error("CricketRepository Error: " + e);
//                log.info("-----------------");
//            }
//
//            log.info("CricketRepository");
//            log.info("-----------------");
//            log.info("Game ID " + repository.findById(1).getId());
//            log.info("-----------------");
//        };
//    }
}
