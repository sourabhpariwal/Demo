package demo.example.com.demo;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

class VPAdapter extends FragmentPagerAdapter {
    List<Fragment> list = new ArrayList<>();
    List<String> fragTitles = new ArrayList<>();

    public VPAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragTitles.get(position);
    }

    public void addFragment(Fragment fragment, String title) {

        list.add(fragment);
        fragTitles.add(title);
    }
}
