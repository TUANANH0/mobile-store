package com.mobilestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobilestore.entities.Account;
import com.mobilestore.repository.AccountRepository;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository repository;

    public Account checkLogin(String username, String password) {
        List<Account> list =  repository.findAll();
        for (Account acc : list) {
            if (acc.getUsername().equals(username)) {
                if(acc.getPassword().equals(password))
                    return acc;
                else
                    return null;
            }
        }
        return null;
    }
}
