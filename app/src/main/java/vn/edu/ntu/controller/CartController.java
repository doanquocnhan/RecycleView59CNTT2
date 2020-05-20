package vn.edu.ntu.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.model.product;

public class CartController extends Application implements ICartController {
    ArrayList<product> productList = new ArrayList<>();

    public CartController() {
        productList.add(new product(" Chuối Bà Nha Trang",20000, "Chuối Xanh "));
        productList.add(new product(" Chuối Lùn Ninh Hòa",25000, "Chuối chín vàng "));
        productList.add(new product(" Chuối Cau",15000, "Chuối Xanh, chín vàng, trái nhỏ "));
        productList.add(new product(" Chuối Hột",5000, "Chuối Xanh, trái to, có hột "));
        productList.add(new product(" Chuối Móc",5000, "Chuối Xanh, trái nhỏ, "));
        productList.add(new product(" Chuối 75Kg",5000000, "Thử rồi biết "));

    }

    @Override
    public ArrayList<product> getListProduct() {
        return null;
    }
}
