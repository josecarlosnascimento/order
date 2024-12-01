package br.com.jcn.service.utils;

import br.com.jcn.model.Customer;

public class CustomerData {

    public static Customer oneCustomerData(){
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Bar do Zé");
        customer.setDocument("244321012332199");
        return customer;
    }
}
