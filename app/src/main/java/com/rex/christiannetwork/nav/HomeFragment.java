package com.rex.christiannetwork.nav;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rex.christiannetwork.MainActivity;
import com.rex.christiannetwork.R;
import com.rex.christiannetwork.fragments.main.TimelineFragment;
import com.rex.christiannetwork.fragments.main.TrendingFragment;
import com.rex.christiannetwork.fragments.main.WallFragment;

/**
 * Created by Rex on 10/16/2017.
 */

public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.home_fragment, container, false);
        View inflatedView = inflater.inflate(R.layout.home_fragment, container, false);
        TabLayout tabLayout = (TabLayout) inflatedView.findViewById(R.id.tbl_pages);
        tabLayout.addTab(tabLayout.newTab().setText("Wall"));
        tabLayout.addTab(tabLayout.newTab().setText("Timeline"));
        tabLayout.addTab(tabLayout.newTab().setText("Trending"));
        final ViewPager viewPager = (ViewPager) inflatedView.findViewById(R.id.vp_pages);

        viewPager.setAdapter(new PagerAdapter(getFragmentManager(), tabLayout.getTabCount()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return inflatedView;
    }



    public class PagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;

        public PagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    WallFragment tab1 = new WallFragment();
                    return tab1;
                case 1:
                    TimelineFragment tab2 = new TimelineFragment();
                    return tab2;
                case 2:
                    TrendingFragment tab3 = new TrendingFragment();
                    return tab3;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }
}
