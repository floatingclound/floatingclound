package com.bjpowernode.dao;

import com.bjpowernode.pojo.Product;

import java.io.Serializable;
import java.util.List;

public interface ProductDao {
    void save(Product product);
    // String 和 基本类型的包装类都实现了 Serializable 接口
    void delete(Serializable id);
    void update(Product product);
    Product query(Serializable id);
    List<Product> query();
}
