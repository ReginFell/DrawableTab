package ua.zabelnikov.pagerdrawable;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewPager;

public abstract class DrawablePagerAdapter extends FragmentPagerAdapter {

    public DrawablePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setupWithTabLayoutAndViewPager(TabLayout tabLayout, ViewPager viewPager) {
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        setTabsFromPagerAdapter(tabLayout);
        tabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    }

    private void setTabsFromPagerAdapter(TabLayout tabLayout) {
        final ColorStateList tabColors = tabLayout.getTabTextColors();
        for (int i = 0; i < getCount(); i++) {
            final int iconRes = getPageTitleIconRes(i);
            Drawable icon = ResourcesCompat.getDrawable(tabLayout.getResources(), iconRes, null);
            if (icon != null) {
                icon = DrawableCompat.wrap(icon);
                DrawableCompat.setTintList(icon, tabColors);
                tabLayout.addTab(tabLayout.newTab()
                        .setIcon(icon)
                        .setContentDescription(getPageTitle(i)));
            }
        }
    }

    public abstract int getPageTitleIconRes(int position);
}
