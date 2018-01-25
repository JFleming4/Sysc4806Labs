package AddressBook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(BuddyInfoRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new BuddyInfo("Jack", "789456123"));
            repository.save(new BuddyInfo("Chloe", "321987654"));
            repository.save(new BuddyInfo("Kim", "654321798"));
            repository.save(new BuddyInfo("David", "789174369"));
            repository.save(new BuddyInfo("Michelle", "963852741"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo buddy : repository.findAll()) {
                log.info(buddy.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            BuddyInfo buddy = repository.findOne(1L);
            log.info("Customer found with findOne(1L):");
            log.info("--------------------------------");
            log.info(buddy.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByName('David'):");
            log.info("--------------------------------------------");
            for (BuddyInfo jack : repository.findByName("David")) {
                log.info(jack.toString());
            }
            log.info("");
        };
    }

}
