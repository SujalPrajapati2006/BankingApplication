package com.example.BankingApplication.service;

import com.example.PRECTICE.Entity.Account;
import com.example.PRECTICE.Repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepo;

    public Account createAccount(Account account) {
        return accountRepo.save(account);
    }

    public List<Account> getAccount() {
        return accountRepo.findAll();
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepo.findById(id);
    }

    public Account deposit(Long id, double amount) {
        Account account = getAccountById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        account.setBalance(account.getBalance() + amount);
        return accountRepo.save(account);
    }

    public Account withdraw(Long id, double amount) {
        Account account = getAccountById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient Balance");
        }
        account.setBalance(account.getBalance() - amount);
        return accountRepo.save(account);
    }

    public void delete(Long id){
         if(!accountRepo.existsById(id)){
              throw new RuntimeException("Account not found");
         }
         accountRepo.deleteById(id);
    }

    public Account updateAccount(Long id,Account updateAccount){
         Account existingAccount = getAccountById(id).orElseThrow(() -> new RuntimeException("Account not found"));
         existingAccount.setAccountHolderName(updateAccount.getAccountHolderName());
         existingAccount.setBalance(updateAccount.getBalance());
         return accountRepo.save(existingAccount);
    }
}
