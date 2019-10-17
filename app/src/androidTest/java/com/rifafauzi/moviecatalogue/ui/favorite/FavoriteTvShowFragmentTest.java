package com.rifafauzi.moviecatalogue.ui.favorite;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.rule.ActivityTestRule;

import com.rifafauzi.moviecatalogue.testing.SingleFragmentActivity;
import com.rifafauzi.moviecatalogue.utils.EspressoIdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class FavoriteTvShowFragmentTest {

    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private FavoriteTvShowFragment favoriteTvShowFragment = new FavoriteTvShowFragment();

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
        activityRule.getActivity().setFragment(favoriteTvShowFragment);
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadFavoriteTvShow() {
//        onView(withId(R.id.rv_tvShow_favorite)).check(matches(isDisplayed()));
//        onView(withId(R.id.rv_tvShow_favorite)).check(new RecyclerViewItemCountAssertion(1));
    }

}