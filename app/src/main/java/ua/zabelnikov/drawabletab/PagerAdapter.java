package ua.zabelnikov.drawabletab;

import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import ua.zabelnikov.pagerdrawable.DrawablePagerAdapter;

public class PagerAdapter extends DrawablePagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getPageTitleIconRes(int position) {
        @DrawableRes int drawableRes;
        switch (position) {
            case 0:
                drawableRes = R.drawable.ic_laptop_chromebook_black_24dp;
                break;
            case 1:
                drawableRes = R.drawable.ic_android_black_24dp;
                break;
            case 2:
                drawableRes = R.drawable.ic_aspect_ratio_black_24dp;
                break;
            default:
                throw new RuntimeException("Icon not implemented for this position");
        }
        return drawableRes;
    }

    @Override
    public Fragment getItem(int position) {
        return new Fragment();
    }

    @Override
    public int getCount() {
        return 3;
    }
}
