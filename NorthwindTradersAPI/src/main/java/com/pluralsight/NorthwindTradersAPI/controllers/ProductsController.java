package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.data.ProductDao;
import com.pluralsight.NorthwindTradersAPI.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {
    ProductDao productDao;

    @Autowired
    public ProductsController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @RequestMapping(path = "products")
    public List<Product> getAll() {
        List<Product> products = productDao.getAll();
        return products;
    }

    @RequestMapping(path = "products/{id}")
    public Product findById(@PathVariable int id) {
        return productDao.getById(id);
    }


    @RequestMapping(path = "products", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product) {
        Product newProduct = productDao.insert(product);
        return newProduct;
    }

    @RequestMapping(path = "products/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void updateProduct(@PathVariable int id, @RequestBody Product product) {
        productDao.update(id, product);
    }

    @RequestMapping(path = "products/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable int id) {
        productDao.deleteById(id);
    }
}