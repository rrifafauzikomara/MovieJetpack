package com.rifafauzi.moviecatalogue.ui.favorite;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.rule.ActivityTestRule;

import com.rifafauzi.moviecatalogue.testing.SingleFragmentActivity;
import com.rifafauzi.moviecatalogue.utils.EspressoIdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class FavoriteMovieFragmentTest {

    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private FavoriteMovieFragment favoriteMoviesFragment = new FavoriteMovieFragment();

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
        activityRule.getActivity().setFragment(favoriteMoviesFragment);
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadFavoriteMovie() {
//        onView(withId(R.id.rv_movies_favorite)).check(matches(isDisplayed()));
//        onView(withId(R.id.rv_movies_favorite)).check(new RecyclerViewItemCountAssertion(1));
    }

}