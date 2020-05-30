package vn.edu.ntu.recycleview59cntt2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import vn.edu.ntu.controller.ICartController;
import vn.edu.ntu.model.Product;

public class ShoppingCartActivity extends AppCompatActivity {
    ICartController controller;
    TextView txtGioHang,TxtXoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        controller = (ICartController) getApplication();
        addView();
        addEvent();
    }
    private void addView()
    {
        txtGioHang = findViewById(R.id.txtCart);
        displayShoppingCart();

    }
    private void displayShoppingCart()
    {
        List<Product> shoppingCart;
        shoppingCart = controller.getShoppingCart();
        StringBuilder builder = new StringBuilder();
        for (Product p:shoppingCart)
        {
            builder.append(p.getName())
                    .append("\t\t\t")
                    .append(p.getPrice())
                    .append("VND \n ");
        }
        if(builder.toString().length()>0)
            txtGioHang.setText(builder.toString());
        else
         {
            txtGioHang.setText("Nope");
         }
    }
    private void addEvent()
    {

    }
}
