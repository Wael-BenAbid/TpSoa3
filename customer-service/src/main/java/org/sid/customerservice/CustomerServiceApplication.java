package org.sid.customerservice;

import org.sid.customerservice.Repository.CustomerRepository;
import org.sid.customerservice.Entity.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(new Customer(null, "eni", "contact@eni.tn"));
            customerRepository.save(new Customer(null, "FST", "contact@fst.tn"));
            customerRepository.save(new Customer(null, "ENSI", "contact@ensi.tn"));
        };
    }

}
