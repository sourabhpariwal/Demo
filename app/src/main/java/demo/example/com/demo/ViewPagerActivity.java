package demo.example.com.demo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

public class ViewPagerActivity extends AppCompatActivity {
    ViewPager pager;
    SmartTabLayout tabLayout;
    VPAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        pager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.viewpagertab);

        adapter = new VPAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentOne(), "Fragment 1");
        adapter.addFragment(new Fragment2(), "Fragment 2");
        pager.setAdapter(adapter);
        tabLayout.setViewPager(pager);
        pager.setCurrentItem(1);

    }
}
