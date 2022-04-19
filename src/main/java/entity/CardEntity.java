package entity;

public class CardEntity extends PaymentEntity{
    private Long number;

    public CardEntity(Long number) {
        this.number = number;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    //Polymorphism
    @Override
    public void pay(Double amount, PaymentEntity card) throws Exception {
        System.out.println("The total amount is: "+ amount);
        card.amount = card.amount-amount;
        System.out.println("Thanks for choosing us ");
    }
}
