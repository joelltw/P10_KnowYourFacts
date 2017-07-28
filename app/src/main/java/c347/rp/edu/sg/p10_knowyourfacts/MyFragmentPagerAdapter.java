package c347.rp.edu.sg.p10_knowyourfacts;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 14056921 on 28/7/2017.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment>fragments;

    public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment>al) {
        super(fm);
        fragments = al;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
