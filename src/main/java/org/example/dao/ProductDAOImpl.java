package org.example.dao;

import org.example.dao.interfaces.ProductDAO;
import org.example.mappers.ProductRowMapper;
import org.example.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;
import java.util.Objects;

@Component
public class ProductDAOImpl implements ProductDAO {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final String SQL_FIND_PRODUCT = "select * from product where product_id = ?";
    private final String SQL_FIND_ALL_PRODUCT = "select * from product";
    private final String SQL_FIND_LAST_PRODUCT_ID = "SELECT MAX(product_id) FROM product";
    private final String SQl_FIND_ID_BY_PRODUCT = "select product_id from product where product_name=? and category_id=? and product_about=? and product_gender=?";
//    private final String SQL_INSERT_PRODUCT = "select product_id from product where insert into product(product_id, product_name, category_id, product_about, product_gender) value(default, ?, ?, ?, ?)";

    private final String SQL_INSERT_PRODUCT = "insert into product(product_id, product_name, category_id, product_about, product_gender) value(default, ?, ?, ?, ?)";

    @Override
    public Product getProductById(int id) {
        return jdbcTemplate.queryForObject(SQL_FIND_PRODUCT, new ProductRowMapper(), id);
    }

    @Override
    public List<Product> getAllProduct() {
        return jdbcTemplate.query(SQL_FIND_ALL_PRODUCT, new ProductRowMapper());
    }

    @Override
    public boolean deleteProduct(Product product) {
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        return false;
    }

    @Override
    public void createProduct(Product product) {
        jdbcTemplate.update(SQL_INSERT_PRODUCT, product.getProduct_name(), product.getCategory_id(), product.getProduct_about(), product.getProduct_gender());
    }

    @Override
    public int getLastProductId() {
        System.out.println(jdbcTemplate.queryForObject(SQL_FIND_LAST_PRODUCT_ID, Integer.class));
        return jdbcTemplate.queryForObject(SQL_FIND_LAST_PRODUCT_ID, Integer.class);
    }

    @Override
    public int getIdByProduct(Product product) {
        return Objects.requireNonNull(jdbcTemplate.queryForObject(SQl_FIND_ID_BY_PRODUCT, new ProductRowMapper(), product.getProduct_name(), product.getCategory_id(), product.getProduct_about(), product.getProduct_gender())).getProduct_id();
    }


//   @Override
//    public boolean createProduct(String product_name, int category_id, String product_about, boolean product_gender) {
//        jdbcTemplate.update(SQL_INSERT_PRODUCT, new Object[] {product_name, category_id, product_about, product_gender});
//
//        return true;
//    }

}
