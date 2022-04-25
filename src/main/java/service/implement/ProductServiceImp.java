package service.implement;

import entity.ProductEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.IProductService;

import java.util.List;

public class ProductServiceImp implements IProductService {
    static final Logger LOGGER = LogManager.getLogger(ProductServiceImp.class);
    @Override
    public List<ProductEntity> getAllProducts(List<ProductEntity> entities)throws Exception {
        LOGGER.info("Program started.... "); //To write something to the log text file
        LOGGER.error("ERROR");
        LOGGER.warn("WARNING");
        LOGGER.fatal("FATAL");
        LOGGER.debug("DEBUG");
        LOGGER.info("INFO");
        System.out.println("Final Output");
        try {
                return entities;
            } catch (Exception e) {
                LOGGER.info(e.getMessage());
                throw new Exception(e.getMessage());
            }
        }

    @Override
    public ProductEntity modify(int quantity, double price, String description) {
        return null;
    }

    @Override
    public ProductEntity save(ProductEntity productEntity) {
        return null;
    }

    @Override
    public ProductEntity getProductById(Long id) {

        return null;
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("Deleted correctly");
    }
}
