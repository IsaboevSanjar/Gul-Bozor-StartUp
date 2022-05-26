package gulbozor.uz.core.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import gulbozor.uz.R;
import gulbozor.uz.core.exampleModels.ExampleModel;

public class ViewPagerAdapter extends PagerAdapter {

    private final ArrayList<ExampleModel> childItems = new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<String> images = new ArrayList<>();

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_view_pager, null);
        ImageView imageView = view.findViewById(R.id.imageView_viewPager);
        ExampleModel item = childItems.get(position);
        ExampleModel item1 = new ExampleModel("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.OHnOWmJ2tZi5gTR3vEO1YgHaJ4%26pid%3DApi&f=1",
                "",
                "",
                0);
        Glide.with(imageView)
                .load(item1.getImageUrl())
                .into(imageView);

        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}
