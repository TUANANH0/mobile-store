package com.mobilestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mobilestore.service.AccountService;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/login")
    public ModelAndView getLoginForm() {
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView checkLogin(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        String url = "login";
        String username = req.getParameter("txtUsername");
        String password = req.getParameter("txtPassword");

        if(accountService.checkLogin(username, password) != null) {
            url = "addProduct";
        } else {
            mav.addObject("Result", "Wrong username or password");
        }
        mav.setViewName(url);
        return mav;
    }

    @GetMapping("/logout")
    public ModelAndView logout() {
        return new ModelAndView("index");
    }
}
