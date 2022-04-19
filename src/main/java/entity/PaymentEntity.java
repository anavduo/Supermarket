package entity;

import service.IPayable;

public abstract class PaymentEntity implements IPayable {
    protected ClientEntity client;
    protected double  amount;

    public PaymentEntity() {
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
