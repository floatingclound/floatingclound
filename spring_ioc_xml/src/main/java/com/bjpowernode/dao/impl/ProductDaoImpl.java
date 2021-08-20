package com.bjpowernode.dao.impl;

import com.bjpowernode.dao.ProductDao;
import com.bjpowernode.pojo.Product;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.Serializable;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Product product) {
        String sql = "insert into product values(?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, product.getId(), product.getName(),
                product.getTid(), product.getPrice(),
                product.getNum(), product.getImgurl(),
                product.getDescription());
    }

    public void delete(Serializable id) {
        String sql = "delete from product where id=?";
        jdbcTemplate.update(sql, id);
    }

    public void update(Product product) {
        String sql = "update product set name=?,tid=?,num=?,price=?,imgurl=?,description=? where id=?";
        jdbcTemplate.update(sql, product.getName(), product.getTid(), product.getNum(),
                product.getPrice(), product.getImgurl(),
                product.getDescription(), product.getId());
    }

    public Product query(Serializable id) {
        String sql = "select * from product where id=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Product.class), id);
    }

    public List<Product> query() {
        String sql = "select * from product";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }
}
