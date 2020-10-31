package com.classicmodels.controller;

import com.classicmodels.service.CustomerOrderManagementService;
import java.util.List;
import jooq.generated.tables.pojos.Customer;
import jooq.generated.tables.pojos.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerOrderManagementController {

    private final CustomerOrderManagementService customerOrderManagementService;

    public CustomerOrderManagementController(CustomerOrderManagementService customerOrderManagementService) {
        this.customerOrderManagementService = customerOrderManagementService;
    }

    @GetMapping("/customersOrderedByCreditLimit")
    public List<Customer> fetchCustomersOrderedByCreditLimit() {

        return customerOrderManagementService.fetchCustomersOrderedByCreditLimit();
    }
    
    @GetMapping("/customerByPhone")
    public List<Customer> fetchCustomerByPhone(@RequestParam String phone) {
        
        return customerOrderManagementService.fetchCustomerByPhone(phone);
    }
    
    @GetMapping("/top10By")
    public List<com.classicmodels.entity.Customer> fetchTop10By() {
        
        return customerOrderManagementService.fetchTop10By();
    }

    @GetMapping("/orderStatus")
    public List<String> fetchOrderStatus() {
        
        return customerOrderManagementService.fetchOrderStatus();
    }
    
    @GetMapping("/orderById")
    public Order fetchOrderById(@RequestParam Long id) {
        
        return customerOrderManagementService.fetchOrderById(id);
    }
    
    @GetMapping("/first5ByStatusOrderByShippedDateAsc")
    public List<com.classicmodels.entity.Order> fetchFirst5ByStatusOrderByShippedDateAsc(
            @RequestParam String status) {
        
        return customerOrderManagementService.fetchFirst5ByStatusOrderByShippedDateAsc(status);
    }
}
