package com.example.BankingApplication.JpaRepository;

import com.example.BankingApplication.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account,Long>
{}
