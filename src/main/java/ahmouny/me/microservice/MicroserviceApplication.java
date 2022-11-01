package ahmouny.me.microservice;

import ahmouny.me.microservice.Entities.Account;
import ahmouny.me.microservice.Entities.Customer;
import ahmouny.me.microservice.enums.AccountType;
import ahmouny.me.microservice.repositories.BankAccountrepository;
import ahmouny.me.microservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class MicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceApplication.class, args);
    }

    // Part 2 : 01:20
    @Bean
    CommandLineRunner start(BankAccountrepository br, CustomerRepository cr)
    {
        return args -> {
            Stream.of("Mohamed", "Amina", "Fatima")
                    .forEach(c -> {
                        Customer customer = new Customer();
                        customer.setName(c);
                        cr.save(customer);
                    });
            cr.findAll().forEach(c -> {
                for (int i = 0; i < 10; i++)
                {
                    Account account = Account.builder().id(UUID.randomUUID().toString())
                            .balance(Math.random() * 1600)
                            .created(new Date())
                            .currency("Mad")
                            .type(Math.random() > 0.5? AccountType.CURRENT_ACCOUNT: AccountType.SAVING_ACCOUNT)
                            .customer(c)
                            .build();
                    br.save(account);
                }
            });


        };
    }

}

