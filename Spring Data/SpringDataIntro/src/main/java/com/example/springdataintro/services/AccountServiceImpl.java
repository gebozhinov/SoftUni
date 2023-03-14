package com.example.springdataintro.services;

import com.example.springdataintro.models.Account;
import com.example.springdataintro.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal drawMoney, Long id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isEmpty()) {
            throw new RuntimeException("Account does not exist");
        }

        BigDecimal currentBalance = account.get().getBalance();
        if (drawMoney.compareTo(currentBalance) > 0) {
            throw new RuntimeException("Not enough money!");
        }

        account.get().setBalance(currentBalance.subtract(drawMoney));
        accountRepository.save(account.get());

    }

    @Override
    public void depositMoney(BigDecimal depositMoney, Long id) {
        Account account = this.accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exist"));

        account.setBalance(account.getBalance().add(depositMoney));

        this.accountRepository.save(account);

    }
}
