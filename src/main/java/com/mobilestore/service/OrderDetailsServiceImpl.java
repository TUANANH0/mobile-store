package com.mobilestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobilestore.entities.Order;
import com.mobilestore.entities.OrderDetail;
import com.mobilestore.entities.OrderDetailId;
import com.mobilestore.entities.Product;
import com.mobilestore.repository.OrderDetailRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    private List<OrderDetail> cart;

    public List<OrderDetail> createOrderDetails(Order order) {
        if (cart == null) {
            return null;
        }
        for (OrderDetail item : this.cart) {
            item.setOrder(order);
            item.setId(new OrderDetailId(order.getId(), item.getProduct().getId()));
        }
        return orderDetailRepository.saveAll(cart);
    }

    public boolean addToCart(Product product) {
        OrderDetail item = new OrderDetail();
        if (this.cart == null) {
            this.cart = new ArrayList<OrderDetail>();
        }
        if (this.cart.isEmpty()) {
            item.setProduct(product);
            item.setQuantity(1);
            item.setPrice(product.getUnitPrice());
            this.cart.add(item);
            return true;
        } else {
            for (OrderDetail cartItem : this.cart) {
                if (cartItem.getProduct().getId() == product.getId()) {
                    if (cartItem.getQuantity() < product.getStock()) {
                        cartItem.setQuantity(cartItem.getQuantity() + 1);
                        cartItem.setPrice(cartItem.getPrice() * cartItem.getQuantity());
                        return true;
                    } else {
                        return false;
                    }
                }
            }
            item.setProduct(product);
            item.setQuantity(1);
            item.setPrice(product.getUnitPrice());
            this.cart.add(item);
            return true;
        }
    }

    public boolean removeItemInCart(int productCode) {
        for (OrderDetail item : this.cart) {
            if (item.getProduct().getId() == productCode) {
                this.cart.remove(item);
                return true;
            }
        }
        return false;
    }

    public boolean clearCart() {
        if(this.cart == null || this.cart.isEmpty()) {
            return false;
        } else {
            this.cart = new ArrayList<OrderDetail>();
            return true;
        }
    }

    public List<OrderDetail> getCart() {
        if (this.cart == null) {
            this.cart = new ArrayList<OrderDetail>();
        }
        return this.cart;
    }

    public double getCartTotal() {
        double total = 0;
        for (OrderDetail item : this.cart) {
            total += item.getPrice();
        }
        return total;
    }

    public List<Product> upateProductsInStock() {
        List<Product> list = new ArrayList<Product>();
        for (OrderDetail item : this.cart) {
            Product pro = item.getProduct();
            pro.setStock(pro.getStock() - item.getQuantity());
            list.add(pro);
        }
        return list;
    }
}
