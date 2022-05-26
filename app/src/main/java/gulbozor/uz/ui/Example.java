package gulbozor.uz.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import java.io.File;

import gulbozor.uz.R;
import gulbozor.uz.core.adapters.ViewPagerAdapter;

public class Example extends AppCompatActivity {
    ViewPager viewPager;
    WormDotsIndicator dot3;
    ViewPagerAdapter viewAdapter;
    String files = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_activity);
        ids();
        viewAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewAdapter);
        dot3.setViewPager(viewPager);
    }

    private void ids() {
        viewPager = findViewById(R.id.view_pager);
        File file = new File(files);
        dot3 = findViewById(R.id.dot3);
    }


}