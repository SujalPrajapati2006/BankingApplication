package com.example.BankingApplication.service;


import com.example.BankingApplication.Entity.Account;
import com.example.BankingApplication.JpaRepository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account){
         return accountRepository.save(account);
    }

    public Optional<Account> getAccount(Long id){
        return accountRepository.findById(id);
    }

    public Account deposit(Long id,double amount){
         Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account Not Found"));
         account.setBalance(account.getBalance() + amount);
         return accountRepository.save(account);
    }

    public Account withdraw(Long id, double amount) {
        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }
        account.setBalance(account.getBalance() - amount);
        return accountRepository.save(account);
    }

    public void deleteAccount(Long id){
         if(!accountRepository.existsById(id)){
             throw new RuntimeException("Account Not Found");
         }
         accountRepository.deleteById(id);
    }

    public Account updateAccount(Long id,Account updateAccount){
          Account existingAccount = getAccount(id).orElseThrow(() -> new RuntimeException("Account Not Found"));
          existingAccount.setAccountHolderName(updateAccount.getAccountHolderName());
          existingAccount.setBalance(updateAccount.getBalance());
          return  accountRepository.save(existingAccount);
    }


}
