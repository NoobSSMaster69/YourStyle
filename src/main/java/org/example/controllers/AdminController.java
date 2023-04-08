package org.example.controllers;

import org.example.dao.ImageDAOImpl;
import org.example.dao.ProductDAOImpl;
import org.example.dao.interfaces.ProductDAO;
import org.example.models.Image;
import org.example.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/admin")

public class AdminController {

    private final ProductDAOImpl productDAO;
    private final ImageDAOImpl imageDAO;

    @Autowired
    public AdminController(ProductDAOImpl productDAO, ImageDAOImpl imageDAO) {
        this.productDAO = productDAO;
        this.imageDAO = imageDAO;
    }

    @GetMapping("/main")
    public String adminPage(){
        return "admin/adminMain";
    }
//    @PreAuthorize("hasRole('ADMIN')")

    @GetMapping("/product/insert")
    public String insertProductPage(@ModelAttribute("product") Product product){return "shop/insertProduct";}

    @PostMapping("/product/insert")
    public String saveProduct(@ModelAttribute("product") @Valid Product product,
                              BindingResult bindingResult){
//        if (bindingResult.hasErrors()) return "redirect:/shop/product/insert";
        productDAO.createProduct(product);
//        productDAO.getIdByProduct(product)
        product.setProduct_id(productDAO.getLastProductId());
        return "redirect:/admin/product/insert/image?id=" + product.getProduct_id();
    }
    @RequestMapping(value = "/product/insert/image", method = RequestMethod.GET)
    public String submitGet(@RequestParam("id") int id, Model model){
//        @PathVariable("person_id") int person_id,
//        model.addAttribute("id", person_id);
        System.out.println(id);
        Image image = new Image();
        image.setProduct_id(id);
        model.addAttribute("image", image);
        return "shop/insertImage";
    }

    @RequestMapping(value = "/product/insert/image", method = RequestMethod.POST)
    public String submit(@RequestParam("file") MultipartFile file, @ModelAttribute("image") Image image
//            ,@PathVariable("id") int id
//                         @RequestParam("id") int id
//                         @ModelAttribute("ident") int ident
    ) throws IOException {
//        Image image = new Image();
//        image.setProduct_id(7);
        image.setImage_data(file);
        imageDAO.createImage(image);
        return "redirect:/shop/product/"+image.getProduct_id();
    }


}
