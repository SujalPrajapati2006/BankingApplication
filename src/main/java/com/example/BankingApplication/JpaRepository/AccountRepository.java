package com.example.BankingApplication.JpaRepository;

import com.example.BankingApplication.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {

}
