package com.mobilestore.service;

import com.mobilestore.entities.Account;

public interface AccountService {
    Account checkLogin(String username, String password);
}
