package org.example.models;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class Product {
    @Id
    private int product_id;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 100, message = "Name should be between 2 and 30 characters")
    private String product_name;

    @Max(value = 500, message = "About maximum symbol 500.")
    private String product_about;


    @Id
    private int category_id;

    private boolean product_gender;
    public Product(){}

    public Product(int product_id, String product_name, int category_id){
        this.product_id=product_id;
        this.product_name=product_name;
        this.category_id=category_id;
    }

    public boolean getProduct_gender() {
        return product_gender;
    }

    public void setProduct_gender(boolean product_gender) {
        this.product_gender = product_gender;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_about() {
        return product_about;
    }

    public void setProduct_about(String product_about) {
        this.product_about = product_about;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
