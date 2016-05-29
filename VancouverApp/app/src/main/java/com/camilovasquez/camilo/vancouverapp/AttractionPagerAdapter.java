package com.camilovasquez.camilo.vancouverapp;

/**
 * Created by camiv on 2016-03-10.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class AttractionPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public AttractionPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                _AttractionsFragment tab1 = new _AttractionsFragment();
                return tab1;

            case 1:
                _ParksFragment tab2 = new _ParksFragment();
                return tab2;
            case 2:
                _BarsFragment tab3 = new _BarsFragment();
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