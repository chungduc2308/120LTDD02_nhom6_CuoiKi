package product;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiki.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{
    private List<Product> mProduct;

    public void setData(List<Product> list){
        this.mProduct = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_trangchu, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = mProduct.get(position);
        if(product == null)
            return;
        holder.imgProduct.setImageResource(product.getResourceId());
        holder.tvtitle.setText(product.getTitle());
        holder.tvprice.setText(product.getPrice());
    }

    @Override
    public int getItemCount() {
        if (mProduct !=null)
            return mProduct.size();
        return 0;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgProduct;
        private TextView tvtitle;
        private TextView tvprice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.img_book);
            tvtitle = itemView.findViewById(R.id.tv_title);
            tvprice = itemView.findViewById(R.id.tv_price);
        }
    }
}
