package service;

import entity.CardEntity;
import entity.CheckEntity;
import entity.ClientEntity;
import entity.PaymentEntity;

public interface IPayable {
    //Using generic
    void pay(Double amount, PaymentEntity paymentEntity)throws Exception;
}
