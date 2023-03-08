package org.example.dao;

import org.example.dao.interfaces.ImageDAO;
import org.example.mappers.ImageRowMapper;
import org.example.models.Image;
import org.example.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class ImageDAOImpl implements ImageDAO {

    JdbcTemplate jdbcTemplate;
    @Autowired
    public ImageDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final String SQL_FIND_IMAGE = "select * from image where `product_id` = ?";
    private final String SQL_FIND_NUM_IMAGE = "select * from image where `product_id` = ? and `image_number` = ?";
    private final String SQL_FIND_MAIN_IMAGE = "select * from image where `product_id` = ? and `image_main` = true";
    private final String SQL_INSERT_IMAGE = "insert into image(product_id, image_data, image_main) value(?,?,?)";

    @Override
    public Image getImageByIdNum(int id, int num){
        return jdbcTemplate.queryForObject(SQL_FIND_NUM_IMAGE, new ImageRowMapper(), new Object[] { id, num });
    }

    @Override
    public List<Image> getImagesById(int id) {
        return jdbcTemplate.query(SQL_FIND_IMAGE, new ImageRowMapper(), new Object[] {id});
//        return jdbcTemplate.queryForObject(SQL_FIND_IMAGE, new ImageRowMapper(), new Object[] {id});
    }

    @Override
    public Image getMainImageById(int id) {
        return jdbcTemplate.queryForObject(SQL_FIND_MAIN_IMAGE, new ImageRowMapper(), new Object[] {id});
    }

    @Override
    public boolean deleteImage(Product product) {
        return false;
    }

    @Override
    public boolean updateImage(Product product) {
        return false;
    }

    @Override
    public void createImage(Image image) {
        jdbcTemplate.update(SQL_INSERT_IMAGE, new Object[] {image.getProduct_id(), image.getImage_data(),image.getImage_main()});

    }
}
