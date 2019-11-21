package com.marliao.fragmentviewpage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class FirstFragment extends Fragment {

    private ViewPager vp1;
    private List<View> picturelist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, null);
        vp1 = (ViewPager) view.findViewById(R.id.vp_1);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initAdapter();
    }


    private void initAdapter() {
        MyViewPageAdapter myViewPageAdapter = new MyViewPageAdapter();
        vp1.setAdapter(myViewPageAdapter);
    }

    private void initView() {
        picturelist = new ArrayList<>();
        View view1 = new View(getContext());
        view1.setBackgroundResource(R.drawable.bg);
        picturelist.add(view1);
        View view2 = new View(getContext());
        view2.setBackgroundResource(R.drawable.move_head);
        picturelist.add(view2);
        View view3 = new View(getContext());
        view3.setBackgroundResource(R.drawable.move_list_bg);
        picturelist.add(view3);
    }

    public class MyViewPageAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return picturelist.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            ImageView imageView = new ImageView(getContext());
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }

}
