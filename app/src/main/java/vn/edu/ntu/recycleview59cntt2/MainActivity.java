package vn.edu.ntu.recycleview59cntt2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.model.product;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Lớp cài đặt cho việc hiển thị của 1 product
    private class ProductViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtName, txtPrice, txtDeacription;
        ImageView imageVtoCart;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = this.itemView.findViewById(R.id.textName);
            txtPrice = this.itemView.findViewById(R.id.textPrice);
            txtDeacription = this.itemView.findViewById(R.id.textDeacription);
            imageVtoCart = this.itemView.findViewById(R.id.imageVtoCart);
        }
        public void bind(product p)
        {

            txtName.setText(p.getName());
            txtPrice.setText(new Integer(p.getPrice()).toString());
            txtDeacription.setText(p.getDeacription());
            imageVtoCart.setImageResource(R.drawable.ic_action_add_to_cart);

        }
    }
    // Lớp Adapter kết nối RecyclerView vs dữ liệu
    private class Adapter extends RecyclerView.Adapter<ProductViewHolder>
    {
        ArrayList<product> listProduct;

        public Adapter(ArrayList<product> listProduct) {
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
        public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return listProduct.size();
        }
    }
