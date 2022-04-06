package entity;

import java.util.Objects;

public abstract class ProductEntity {


    protected Long id;
    protected int quantity;
    protected double price;
    protected String description;
    protected Supplier supplier;

    public ProductEntity() {
    }
    public ProductEntity(int quantity) {
        this.quantity = quantity;
    }

    public ProductEntity(double price) {
        this.price = price;
    }

    public ProductEntity(String description) {
        this.description = description;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductEntity)) return false;
        ProductEntity that = (ProductEntity) o;
        return getQuantity() == that.getQuantity() && Double.compare(that.getPrice(), getPrice()) == 0 && getDescription().equals(that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuantity(), getPrice(), getDescription());
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", supplier=" + supplier +
                '}';
    }
}
