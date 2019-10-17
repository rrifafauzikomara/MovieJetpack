package com.rifafauzi.moviecatalogue.ui.favorite;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.rifafauzi.moviecatalogue.R;
import com.rifafauzi.moviecatalogue.adapter.ViewPagerAdapter;

import java.util.Objects;

public class FavoriteFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    public static Fragment newInstance() {
        return new FavoriteFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = view.findViewById(R.id.tabs);
        viewPager = view.findViewById(R.id.viewpager);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        setupTab();
    }

    private void setupTab() {
        TextView tabMovies = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab, null);
        tabMovies.setText(getString(R.string.movies));
        Objects.requireNonNull(tabLayout.getTabAt(0)).setCustomView(tabMovies);

        TextView tabTvShow = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.custom_tab, null);
        tabTvShow.setText(getString(R.string.tv_show));
        Objects.requireNonNull(tabLayout.getTabAt(1)).setCustomView(tabTvShow);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFragment(new FavoriteMovieFragment(), getString(R.string.movies));
        adapter.addFragment(new FavoriteTvShowFragment(), getString(R.string.tv_show));
        viewPager.setAdapter(adapter);
    }

}
