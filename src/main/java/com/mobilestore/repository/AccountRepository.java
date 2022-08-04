package com.mobilestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobilestore.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
}