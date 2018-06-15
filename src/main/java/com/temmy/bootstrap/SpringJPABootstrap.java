package com.temmy.bootstrap;

import com.temmy.domain.Customer;
import com.temmy.domain.Product;
import com.temmy.services.CustomerService;
import com.temmy.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private ProductService productService;
    private CustomerService customerService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadProducts();
        loadCustomers();

    }

    public void loadCustomers() {
        Customer customer1 = new Customer();
        customer1.setFirstName("Temi");
        customer1.setLastName("Blackson");
        customer1.setAddressLine1("1 Main St");
        customer1.setCity("ik");
        customer1.setState("Lagos");
        customer1.setZipCode("33101");
        customer1.setEmail("tboy@sohh.com");
        customer1.setPhoneNumber("08133085048");
        customerService.saveOrUpdate(customer1);
 }

    public void loadProducts(){

        Product product1 = new Product();
        product1.setDescription("Product 1");
        product1.setPrice(new BigDecimal("12.99"));
        product1.setImageUrl("http://example.com/product1");
        productService.saveOrUpdate(product1);

        Product product2 = new Product();
        product2.setDescription("Product 2");
        product2.setPrice(new BigDecimal("14.09"));
        product2.setImageUrl("http://example.com/product2");
        productService.saveOrUpdate(product2);

        Product product3 = new Product();
        product3.setDescription("Product 3");
        product3.setPrice(new BigDecimal("30.99"));
        product3.setImageUrl("http://example.com/product3");
        productService.saveOrUpdate(product3);

    }
}