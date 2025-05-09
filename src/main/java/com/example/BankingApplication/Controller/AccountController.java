package com.example.BankingApplication.Controller;

import com.example.PRECTICE.Entity.Account;
import com.example.PRECTICE.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public Account createAccount(@RequestBody Account account){
         return accountService.createAccount(account);
    }

    @GetMapping
    public List<Account> getAccount(){
         return accountService.getAccount();
    }

    @GetMapping("/{id}")
    public Optional<Account> getAccountById(@PathVariable Long id){
         return accountService.getAccountById(id);
    }

    @PostMapping("/{id}/deposit")
    public Account deposit(@PathVariable Long id, @RequestBody Map<String, Double> request){
       Double amount = request.get("amount");
       return accountService.deposit(id,amount);
    }

    @PostMapping("/{id}/withdarw")
    public Account withdraw(@PathVariable Long id,@RequestBody Map<String,Double> request){
        Double amount = request.get("amount");
        return accountService.withdraw(id,amount);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable  Long id){
         accountService.delete(id);
    }

    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable Long id,@RequestBody Account account){
         return accountService.updateAccount(id, account);
    }
}
