package entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class FoodProductEntity extends ProductEntity{
    private LocalDateTime expirationDate;
    public FoodProductEntity() {
    }

    public FoodProductEntity(int quantity) {
        super(quantity);
    }

    public FoodProductEntity(double price) {
        super(price);
    }

    public FoodProductEntity(String description) {
        super(description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FoodProductEntity)) return false;
        if (!super.equals(o)) return false;
        FoodProductEntity that = (FoodProductEntity) o;
        return Objects.equals(expirationDate, that.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), expirationDate);
    }
}
