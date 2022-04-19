package entity;

public class CheckEntity extends PaymentEntity{
     private String description;

    public CheckEntity(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    //Polymorphism
    @Override
    public void pay(Double amount,PaymentEntity check) throws Exception {
        System.out.println("The total amount is: "+ amount);
        check.amount = check.amount-amount;
    }
}
