package com.example.akangfood.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.akangfood.R;

import java.util.List;

public class FnBAdapter extends RecyclerView.Adapter<FnBAdapter.ViewHolder> {

    private List<FnBModel> fnbList;
    private FnBAdapterListener listener;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvNama, tvCal, tvRasa, tvHarga;
        public ImageView ivImg, ivFav;
        public boolean isFav;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvCal = itemView.findViewById(R.id.tvCal);
            tvRasa = itemView.findViewById(R.id.tvRasa);
            tvHarga = itemView.findViewById(R.id.tvHarga);
            ivImg = itemView.findViewById(R.id.ivImg);
            ivFav = itemView.findViewById(R.id.ivFav);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        FnBModel currentItem = fnbList.get(position);
                        currentItem.setFav(!currentItem.isFav()); // Toggle the isFav value
                        notifyItemChanged(position); // Update the RecyclerView item
                    }
                }
            });
        }
    }

    public FnBAdapter(List<FnBModel> fnbList, FnBAdapterListener listener){
        this.fnbList = fnbList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FnBAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FnBAdapter.ViewHolder holder, int position) {
        final FnBModel model = this.fnbList.get(position);
        holder.tvNama.setText(model.getNameText());
        holder.tvCal.setText(model.getCalText());
        holder.tvRasa.setText(model.getRasaText());
        holder.tvHarga.setText(model.getHargaText());
        holder.ivImg.setImageResource(model.getFnbImg());

        // Set favorite icon based on isFav state
        if (model.isFav()) {
            holder.ivFav.setImageResource(R.drawable.ic_fav_on);
        } else {
            holder.ivFav.setImageResource(R.drawable.ic_fav_off);
        }
    }

    @Override
    public int getItemCount() {
        return this.fnbList.size();
    }

    public interface FnBAdapterListener {
        void onFnBSelected(FnBModel fnbSelect);
    }
}

