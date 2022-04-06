package entity;

public class DairyProductEntity extends FoodProductEntity{
    private String trade;

    public DairyProductEntity() {
    }

    public DairyProductEntity(int quantity) {
        super(quantity);
    }

    public DairyProductEntity(double price) {
        super(price);
    }

    public DairyProductEntity(String description) {
        super(description);
    }

    public DairyProductEntity(int quantity, String trade) {
        super(quantity);
        this.trade = trade;
    }

    public DairyProductEntity(double price, String trade) {
        super(price);
        this.trade = trade;
    }

    public DairyProductEntity(String description, String trade) {
        super(description);
        this.trade = trade;
    }
}

