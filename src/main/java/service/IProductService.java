package service;

import entity.ProductEntity;

import java.util.List;

public interface IProductService {
    List<ProductEntity> getAllProducts(List<ProductEntity> entities)throws Exception;
    ProductEntity modify(int quantity, double price, String description)throws Exception;
    ProductEntity save(ProductEntity productEntity)throws Exception;
    ProductEntity getProductById(Long id)throws Exception;
    void delete(Long id)throws Exception;
}
