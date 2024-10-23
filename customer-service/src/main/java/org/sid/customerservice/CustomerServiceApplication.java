package org.sid.customerservice;

import org.sid.customerservice.Repository.CustomerRepository;
import org.sid.customerservice.Entity.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class CustomerServiceApplication {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository) {
        return args -> {
            try {
                Customer customer1 = customerRepository.save(new Customer(null, "eni", "contact@eni.tn"));
                Customer customer2 = customerRepository.save(new Customer(null, "FST", "contact@fst.tn"));
                Customer customer3 = customerRepository.save(new Customer(null, "ENSI", "contact@ensi.tn"));

                logger.info("Clients ajoutés avec succès !");

                logger.info("Customer 1 ID: {}", customer1.getId());
                logger.info("Customer 2 ID: {}", customer2.getId());
                logger.info("Customer 3 ID: {}", customer3.getId());
            } catch (Exception e) {
                logger.error("Erreur lors de l'ajout des clients : ", e);
            }
        };
    }
}
