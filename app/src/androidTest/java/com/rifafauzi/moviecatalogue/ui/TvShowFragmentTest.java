package com.rifafauzi.moviecatalogue.ui;

import androidx.test.rule.ActivityTestRule;

import com.rifafauzi.moviecatalogue.R;
import com.rifafauzi.moviecatalogue.testing.SingleFragmentActivity;
import com.rifafauzi.moviecatalogue.utils.RecyclerViewItemCountAssertion;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class TvShowFragmentTest {

    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private TvShowFragment tvShowFragment = new TvShowFragment();

    @Before
    public void setUp() {
        activityRule.getActivity().setFragment(tvShowFragment);
    }

    @Test
    public void loadTvShow() {
        onView(withId(R.id.rv_tvShow)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tvShow)).check(new RecyclerViewItemCountAssertion(10));
    }

}