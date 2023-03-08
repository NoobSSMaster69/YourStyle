package org.example.models;

import org.springframework.data.annotation.Id;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import java.io.IOException;

public class Image {

    @Id
    private int product_id;


    private int image_number;

    @NotEmpty
    private byte[] image_data;

    private MultipartFile image_file;

    private boolean image_main;

    public boolean getImage_main() {
        return image_main;
    }

    public void setImage_main(boolean image_main) {
        this.image_main = image_main;
    }

    public MultipartFile getImage_file() {
        return image_file;
    }

    public void setImage_file(MultipartFile image_file) {
        this.image_file = image_file;
    }

    public byte[] getImage_data() {
        return image_data;
    }

    public void setImage_data(byte[] image_data) {
        this.image_data = image_data;
    }

    public void setImage_data(MultipartFile image_file) throws IOException {
        this.image_data = image_file.getBytes();
    }




    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getImage_number() {
        return image_number;
    }

    public void setImage_number(int image_number) {
        this.image_number = image_number;
    }
//    public String getImgUtility() throws UnsupportedEncodingException {
//
//        byte[] encodeBase64 = Base64.encode(Image());
//        String base64Encoded = new String(encodeBase64, "UTF-8");
//        return base64Encoded;
//    }
}
