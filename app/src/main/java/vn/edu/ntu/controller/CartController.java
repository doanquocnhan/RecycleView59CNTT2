package vn.edu.ntu.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.model.Product;

public class CartController extends Application implements ICartController {
    List<Product> shoppingCart = new ArrayList<>();
    ArrayList<Product> productList = new ArrayList<>();

    public CartController() {
        productList.add(new Product(" Chuối Bà Nha Trang",20000, "Chuối Xanh "));
        productList.add(new Product(" Chuối Lùn Ninh Hòa",25000, "Chuối chín vàng "));
        productList.add(new Product(" Chuối Cau",15000, "Chuối Xanh, chín vàng, trái nhỏ "));
        productList.add(new Product(" Chuối Hột",5000, "Chuối Xanh, trái to, có hột "));
        productList.add(new Product(" Chuối Móc",5000, "Chuối Xanh, trái nhỏ, "));
        productList.add(new Product(" Chuối 75Kg",5000000, "Thử rồi biết "));

    }



    @Override
    public boolean addToCart(Product p) {
        if(shoppingCart.contains(p))
        return false;
        shoppingCart.add(p);
        return true;
    }

    @Override
    public List<Product> getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public void clearShoppingCart() {
        shoppingCart.clear();
    }

    @Override
    public ArrayList<Product> getListProduct() {
        return productList;
    }
}
