package br.com.jcn.service.utils;

import br.com.jcn.model.Customer;
import br.com.jcn.model.Product;

import java.math.BigDecimal;

public class ProductData {

    public static Product oneProductData(){
        Product product = new Product();
        product.setId(1L);
        product.setName("Coca Cola 350ML");
        product.setUnitPrice(BigDecimal.valueOf(5.5));
        return product;
    }
}
