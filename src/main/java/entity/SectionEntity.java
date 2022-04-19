package entity;

import java.util.List;

public class SectionEntity {
    private Long id;
    private String name;
    private String description;
    private UserEntity user;
    private List<ProductEntity> products;
}
