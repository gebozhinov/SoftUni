package com.example.springdataintro.services;

import java.math.BigDecimal;

public interface AccountService {

    void withdrawMoney(BigDecimal drawMoney, Long id);
    void depositMoney(BigDecimal drawMoney, Long id);

}
