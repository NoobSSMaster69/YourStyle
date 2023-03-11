package org.example.controllers;

import org.example.dao.ImageDAOImpl;
import org.example.dao.interfaces.ImageDAO;
import org.example.models.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Controller
public class ImageController {
    private final ImageDAOImpl imageDAO;
    @Autowired
    public ImageController(ImageDAOImpl imageDAO) {
        this.imageDAO = imageDAO;
    }


    @RequestMapping(value = "/image/{id}/{num}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<?> getImage(@PathVariable("id") int id,
                                      @PathVariable("num") int num){
        Image image = imageDAO.getImageByIdNum(id,num);
        return ResponseEntity.ok()
                .body(new InputStreamResource(new ByteArrayInputStream(image.getImage_data())));
    }

    @RequestMapping(value = "/image/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<?> getMainImage(@PathVariable("id") int id){
        Image image = imageDAO.getMainImageById(id);
        byte[] bytes = image.getImage_data();
        if(bytes.length==0) {
            return ResponseEntity.ok()
                    .body(new InputStreamResource(new ByteArrayInputStream(imageDAO.getDefaultProductImage().getImage_data())));
        }
        else return ResponseEntity.ok()
                .body(new InputStreamResource(new ByteArrayInputStream(image.getImage_data())));
    }



    @RequestMapping(value = "/shop/product/insert/image", method = RequestMethod.GET)
    public String submitGet(){
//        @PathVariable("person_id") int person_id,
//        Model model
//        model.addAttribute("id", person_id);
//        model.addAttribute("imageDAO", imageDAO);
        return "shop/insertImage";
    }

    @RequestMapping(value = "/shop/product/insert/image", method = RequestMethod.POST)
    public String submit(@RequestParam("file") MultipartFile file
//            ,
//                         @RequestParam("main") boolean main,
//                         @ModelAttribute("ident") int ident
    ) throws IOException {
        Image image = new Image();
        image.setProduct_id(20);
        image.setImage_data(file);
        image.setImage_main(false);
        imageDAO.createImage(image);
        return "redirect:/shop/product/insert/image";
    }

}


