package gulbozor.uz.core.adapters.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import gulbozor.uz.R;

public class ChildViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageItem;
    public TextView flowerNameItem, dateItem, priceItem;

    public ChildViewHolder(@NonNull View itemView) {
        super(itemView);
        imageItem = itemView.findViewById(R.id.image_item);
        flowerNameItem = itemView.findViewById(R.id.flower_name);
        dateItem = itemView.findViewById(R.id.date_item);
        priceItem = itemView.findViewById(R.id.price_item);
    }
}
