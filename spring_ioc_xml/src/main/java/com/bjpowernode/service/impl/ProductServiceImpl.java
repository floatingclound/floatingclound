package com.bjpowernode.service.impl;

import com.bjpowernode.dao.ProductDao;
import com.bjpowernode.pojo.Product;
import com.bjpowernode.service.ProductService;

import java.io.Serializable;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao;
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void save(Product product) {
        productDao.save(product);
    }

    public void delete(Serializable id) {
        productDao.delete(id);
    }

    public void update(Product product) {
        productDao.update(product);
    }

    public Product query(Serializable id) {
        return productDao.query(id);
    }

    public List<Product> query() {
        return productDao.query();
    }
}
