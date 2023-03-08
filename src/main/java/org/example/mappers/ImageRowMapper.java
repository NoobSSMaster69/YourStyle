package org.example.mappers;

import org.example.models.Image;
import org.example.models.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageRowMapper implements RowMapper<Image>{
        @Override
        public Image mapRow(ResultSet rs, int rowNum) throws SQLException {
            Image image = new Image();
            image.setProduct_id(rs.getInt("product_id"));
            image.setImage_number(rs.getInt("image_number"));
            image.setImage_data(rs.getBytes("image_data"));
            image.setImage_main(rs.getBoolean("image_main"));

            return image;
        }
}
