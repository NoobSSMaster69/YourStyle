package org.example.dao.interfaces;

import org.example.models.Image;
import org.example.models.Product;

import java.util.List;


public interface ImageDAO {

    Image getImageByIdNum(int id, int num);

    List<Image> getImagesById(int id);

    Image getMainImageById(int id);

    boolean deleteImage(Product product);

    boolean updateImage(Product product);

    void createImage(Image image);

}
