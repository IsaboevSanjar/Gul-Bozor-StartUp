package gulbozor.uz.core.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import gulbozor.uz.R;
import gulbozor.uz.core.adapters.viewholder.ChildViewHolder;
import gulbozor.uz.core.exampleModels.ExampleModel;

public class ChildAdapter extends RecyclerView.Adapter<ChildViewHolder> {
    private final ArrayList<ExampleModel> childItems = new ArrayList<>();
    private onItemClickListener mListener;

    public void setOnClickListener(onItemClickListener listener) {
        mListener = listener;
    }

    public void setChildItems(ArrayList<ExampleModel> childItems) {
        this.childItems.addAll(childItems);
        notifyItemRangeChanged(this.childItems.size() - childItems.size(), childItems.size());
    }

    public void clearData() {
        childItems.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChildViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ad_list,
                        parent,
                        false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder holder, int position) {
        ExampleModel item = childItems.get(position);
        holder.flowerNameItem.setText(item.getFlowerName());
        holder.dateItem.setText(item.getDate());
        holder.priceItem.setText(item.getPrice() + "");
        Glide.with(holder.imageItem)
                .load(item.getImageUrl())
                .into(holder.imageItem);
    }

    @Override
    public int getItemCount() {
        return childItems.size();
    }
}
