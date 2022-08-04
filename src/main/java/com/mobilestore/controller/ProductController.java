package com.mobilestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.mobilestore.entities.Product;
import com.mobilestore.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping({"","/","/product"})
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ModelAndView productList() {
        ModelAndView mav = new ModelAndView("productList");
        mav.addObject("List", productService.getProducts());
        return mav;
    }

    @GetMapping("/details/{id}")
    public ModelAndView productDetail(@PathVariable int id){
        ModelAndView mav = new ModelAndView("productDetail");
        mav.addObject("Product", productService.getProductByCode(id));
        return mav;
    }

    /*
    * Add product using th:object and field ( *{} )
    * throw many error using if in thymeleaf or just abandon ship
    *
    * Note: security config for login and admin only function*/
    @GetMapping("/add")
    public ModelAndView addProductForm() {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    @PostMapping("/add")
    public ModelAndView addProduct(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView("addProduct");
        Map<String, Object> model = new HashMap<String, Object>();
        boolean error = false;

        Product product = new Product(0, req.getParameter("txtProductName"),
                req.getParameter("txtDescription"), req.getParameter("imgProductImage"),
                Double.parseDouble(req.getParameter("txtUnitPrice")),
                Integer.parseInt(req.getParameter("txtUnitsInStock")),
                req.getParameter("txtManufacturer"), req.getParameter("cboCondition")
                );

        if (product.getName().trim().length() < 2 || product.getName().length() > 40) {
            model.put("nameError", "Invalid name");
            error = true;
        }

        if (product.getManufacturer().trim().length() < 2 || product.getManufacturer().length() > 40) {
            model.put("manufactureError", "Invalid manufacture name");
            error = true;
        }

        if(product.getImage().trim().length() < 2) {
            model.put("imageError", "Invalid image link");
            error = true;
        }

        if (product.getDescription().trim().length() < 2) {
            model.put("descriptionError", "Description can't be blank or too short");
            error = true;
        }

        if (product.getUnitPrice() < 0) {
            model.put("unitPriceError", "Unit price can't be negative number");
            error = true;
        }

        if (product.getStock() < 0) {
            model.put("stockError", "Stock can't be negative number");
            error = true;
        }

        if (!error) {
            model.put("Result","Add " + productService.addProduct(product).getName() +" success");
        }

        return mav.addAllObjects(model);
    }
}
