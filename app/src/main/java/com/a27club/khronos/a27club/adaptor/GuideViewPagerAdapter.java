package com.a27club.khronos.a27club.adaptor;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class GuideViewPagerAdapter extends PagerAdapter {

    private List<View> viewList;

    public GuideViewPagerAdapter(List<View> viewList) {
        this.viewList = viewList;
    }

    /**
     * 获取View的总数
     * @return
     */
    @Override
    public int getCount() {
        if (viewList!=null){
            return viewList.size();
        }
        return 0;
    }

    /**
     * PagerAdapter只缓存三张要显示的图片，如果滑动的图片超出了缓存的范围，就会调用这个方法，将图片销毁
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager)container).removeView(viewList.get(position));
    }

    /**
     * 判断显示的是否是同一张图片，这里我们将两个参数相比较返回即可
     * @param view
     * @param o
     * @return
     */
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (View)o;
    }

    /**
     * // 当要显示的图片可以进行缓存的时候，会调用这个方法进行显示图片的初始化，将要显示的ImageView加入到ViewGroup中，然后作为返回值返回即可
     * @param container
     * @param position
     * @return
     */
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ((ViewPager)container).addView(viewList.get(position),0);
        return viewList.get(position);
    }
}
