package vn.edu.ntu.recycleview59cntt2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.controller.ICartController;
import vn.edu.ntu.model.Product;
public class MainActivity extends AppCompatActivity {
    RecyclerView rvLisdsHH;
    Adapter adapter;
    ArrayList<Product> Listproduct;
    ICartController Controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();

    }

    public void addView() {
        rvLisdsHH = findViewById(R.id.rMatHang);
        rvLisdsHH.setLayoutManager(new LinearLayoutManager(this));
        Controller = (ICartController) getApplication();
        Listproduct = Controller.getListProduct();
        adapter = new Adapter(Listproduct);
        rvLisdsHH.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        // Chuyển menu vừa tạo vào menu của Activity
        inflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Tạo ID
        int id = item.getItemId();
        switch (id)
        {
            case R.id.mnu_close:
                finish();
            case R.id.mnu_cart:
                hienThiGioHang();
                // break cho lịch sự ko cũng được
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void hienThiGioHang(){

        Intent intent = new Intent(MainActivity.this, ShoppingCartActivity.class);
        startActivity(intent);
    }

    //Khong viết các phương thức của MainAcivity Phía dưới đây ?
    // Lớp cài đặt cho việc hiển thị của 1 product
    private class ProductViewHolder extends RecyclerView.ViewHolder  implements  View.OnClickListener{
        TextView txtName, txtPrice, txtDeacription;
        ImageView imageVtoCart;
        Product product;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = this.itemView.findViewById(R.id.textName);
            txtPrice = this.itemView.findViewById(R.id.textPrice);
            txtDeacription = this.itemView.findViewById(R.id.textDeacription);
            imageVtoCart = this.itemView.findViewById(R.id.imageVtoCart);
            imageVtoCart.setOnClickListener(this);
        }

        public void bind(Product p)
        {
            this.product = p;
            txtName.setText(p.getName());
            txtPrice.setText(new Integer(p.getPrice()).toString());
            txtDeacription.setText(p.getDeacription());
        }

        @Override
        public void onClick(View v) {
            if (Controller.addToCart(product))
            {
                Toast.makeText(MainActivity.this,
                        "Da Them:"+ product.getName()+ " vào giỏ hàng",
                        Toast.LENGTH_SHORT ).show();
            }
            else
            {
                Toast.makeText(MainActivity.this,
                        "Da có:"+ product.getName()+ " trong giỏ hàng",
                        Toast.LENGTH_SHORT ).show();
            }
        }
    }

    // Lớp Adapter kết nối RecyclerView vs dữ liệu
    private class Adapter extends RecyclerView.Adapter<ProductViewHolder> {
        List<Product> listProduct;

        public Adapter(ArrayList<Product> listProduct) {
            this.listProduct = listProduct;
        }

        @NonNull
        @Override // tạo ra một cái view Holder để hiển thị dữ liệu
        public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            //Chuyển layot đã thiết kế bằng XML thành dối tượng View.
            LayoutInflater layoutInflater = getLayoutInflater();
            View View = layoutInflater.inflate(R.layout.product,
                    parent, false);

            return new ProductViewHolder(View);
        }

        //Kết nối một dữ liệu trong danh sách với 1 cái view Holder
        @Override
        public void onBindViewHolder(@NonNull final ProductViewHolder holder, int position) {
            holder.bind(listProduct.get(position));

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), holder.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return listProduct.size();
        }
    }
}
