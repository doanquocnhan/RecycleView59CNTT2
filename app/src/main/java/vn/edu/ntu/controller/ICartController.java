package vn.edu.ntu.controller;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.model.Product;


public interface ICartController {
     ArrayList<Product> getListProduct();
    public boolean addToCart(Product p);
    public List<Product> getShoppingCart();
    public void clearShoppingCart();
}
