package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.data.ProductDao;
import com.pluralsight.NorthwindTradersAPI.data.ProductDaoJdbc;
import com.pluralsight.NorthwindTradersAPI.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    ProductDao productDao;



    @RequestMapping(path="products")
    public List<Product> getAll(){
        List<Product> products = productDao.getAll();
        return products;

    }

}