package org.example.controllers;

import org.example.dao.ProductDAOImpl;
import org.example.models.Image;
import org.example.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {
    ProductDAOImpl productDAO;

    @Autowired
    public ShopController(ProductDAOImpl productDAO){
        this.productDAO=productDAO;
    }
    @GetMapping("/payInfo")
    public String payInfoPage(){return "shop/pay";}
    @GetMapping("/main")
    public String mainPage(){return "shop/index";}

    @GetMapping("/about")
    public String aboutPage(){return "shop/about";}

    @GetMapping("/reviews")
    public String reviewsPage(){return "shop/reviews";}

    @GetMapping("/categories")
    public String categoryPage(Model model){
        model.addAttribute("products", productDAO.getAllProduct());
        return "shop/categories";}

    @GetMapping("/product/{id}")
    public String productPage(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productDAO.getProductById(id));

        return "shop/productPage";
    }


//    @GetMapping("/product/insert")
//    public String insertProductPage(@ModelAttribute("product") Product product){return "shop/insertProduct";}
//
//    @PostMapping("/product/insert")
//    public String saveProduct(@ModelAttribute("product") @Valid Product product,
//                              BindingResult bindingResult){
////        if (bindingResult.hasErrors()) return "redirect:/shop/product/insert";
//        productDAO.createProduct(product);
//        product.setProduct_id(productDAO.getIdByProduct(product));
//        return "redirect:/shop/product/insert/image/" + product.getProduct_id();
//    }

}
