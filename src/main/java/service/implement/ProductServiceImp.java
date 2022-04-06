package service.implement;

import entity.ProductEntity;
import service.IProductService;

import java.util.List;

public class ProductServiceImp implements IProductService {

    @Override
    public List<ProductEntity> getAllProducts(List<ProductEntity> entities)throws Exception {
            try {
                return entities;
            } catch (Exception e) {
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

    }
}
