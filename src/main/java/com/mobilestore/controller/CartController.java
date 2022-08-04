package com.mobilestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.mobilestore.entities.Order;
import com.mobilestore.entities.Product;
import com.mobilestore.service.OrderDetailsService;
import com.mobilestore.service.OrderService;
import com.mobilestore.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailsService orderDetailsService;

    @PostMapping("/add")
    public ModelAndView addToCart(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView("productList");
        int id = Integer.parseInt(req.getParameter("code"));
        Map<String, Object> model = new HashMap<String, Object>();

        Product product = productService.getProductByCode(id);

        boolean result = orderDetailsService.addToCart(product);

        model.put("Result",result?"Add success " + product.getName() + " to cart" : "Maximum product in stock");
        model.put("List", productService.getProducts());
        mav.addAllObjects(model);
        return mav;
    }

    @GetMapping("/view")
    public ModelAndView viewCart() {
        ModelAndView mav = new ModelAndView("cart");
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("List", productService.getProducts());
        model.put("Cart", orderDetailsService.getCart());
        model.put("Total", orderDetailsService.getCartTotal());
        mav.addAllObjects(model);
        return mav;
    }

    @PostMapping("/remove")
    public ModelAndView removeCartItem(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView("cart");
        int code = Integer.parseInt(req.getParameter("code"));
        String productName = req.getParameter("name");
        boolean result = orderDetailsService.removeItemInCart(code);
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("Cart", orderDetailsService.getCart());
        model.put("Total", orderDetailsService.getCartTotal());
        model.put("Result",result?"Remove success " + productName + " from cart" : "Cart is empty");
        return mav.addAllObjects(model);
    }

    @GetMapping("/clear")
    public ModelAndView clearCart(){
        ModelAndView mav = new ModelAndView("cart");
        boolean result = orderDetailsService.clearCart();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("Cart", orderDetailsService.getCart());
        model.put("Total", orderDetailsService.getCartTotal());
        model.put("Result", result?"Cart clear success":"Cart is empty");
        return mav.addAllObjects(model);
    }

    @GetMapping("/checkout")
    public ModelAndView checkOut(){
        /* create order in db
        * take order id for order-details
        * save order-details to db
        * update product in stock
        * if no product in cart show can't check out
        *
        * if in thymeleaf for note out of order product*/
        ModelAndView mav = new ModelAndView("cart");
        Map<String, Object> model = new HashMap<String, Object>();
        if (!orderDetailsService.getCart().isEmpty()) {
            Order order = new Order();
            order.setTotal(orderDetailsService.getCartTotal());
            orderService.createOrder(order);
            order = orderService.getNewestOrder();
            orderDetailsService.createOrderDetails(order);
            productService.updateProducts(orderDetailsService.upateProductsInStock());
            orderDetailsService.clearCart();
            model.put("Result", "Check out succes");
        } else {
            model.put("Result", "There is nothing in cart to check out");
        }
        model.put("Cart", orderDetailsService.getCart());
        model.put("Total", orderDetailsService.getCartTotal());
        return mav.addAllObjects(model);
    }
}
