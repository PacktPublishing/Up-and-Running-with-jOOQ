package com.classicmodels;

import com.classicmodels.entity.Employee;
import com.classicmodels.entity.Office;
import com.classicmodels.service.ClassicModelsService;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import java.util.List;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.classicmodels"})
@EntityScan(basePackages = {"com.classicmodels.entity"})
@ComponentScan(basePackages = {"com.classicmodels"})
public class MainApplication {

    private final ClassicModelsService classicModelsService;

    public MainApplication(ClassicModelsService classicModelsService) {
        this.classicModelsService = classicModelsService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            
            System.out.println("Fetch employees and least salary:");
            System.out.println(classicModelsService.fetchEmployeesAndLeastSalary());

            System.out.println("Fetch employees and least salary via contructor mapping:");
            System.out.println(classicModelsService.findEmployeesAndLeastSalaryCntr());

            System.out.println("Fetch employees in city:");
            System.out.println(classicModelsService.fetchEmployeeInCity("Boston"));
            
            System.out.println("Fetch employees by salary:");
            System.out.println(classicModelsService.fetchEmployeeBySalary(60000));
            
            System.out.println("Fetch employees by job title:");
            System.out.println(classicModelsService.fetchByJobTitle("Sales Manager (APAC)"));
             
            List<Object[]> result = classicModelsService.fetchEmployeeAndOffices();
            result.forEach((Object[] entities) -> {
                Employee employee = (Employee) entities[0];
                Office office = (Office) entities[1];
                System.out.println(office + " / " + employee);
            });

        };
    }

    @Bean
    public Hibernate5Module hibernate5Module() {
        return new Hibernate5Module();
    }
}
