package org.example.dao.interfaces;

import org.example.models.Product;

import java.util.List;

public interface ProductDAO {
    Product getProductById(int id);

    public List<Product> getAllProduct();


    boolean deleteProduct(Product product);

    boolean updateProduct(Product product);

//    boolean createProduct(String product_name, int category_id, String product_about, boolean product_gender);
    void createProduct(Product product);

    int getLastProductId();

    public int getIdByProduct(Product product);

}
