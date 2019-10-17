package com.rifafauzi.moviecatalogue.ui;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import com.rifafauzi.moviecatalogue.R;
import com.rifafauzi.moviecatalogue.ui.home.HomeActivity;
import com.rifafauzi.moviecatalogue.utils.EspressoIdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class MovieCatalogueTest {

    @Rule
    public ActivityTestRule<HomeActivity> activityRule = new ActivityTestRule<>(HomeActivity.class);

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void toMovieActivityTest() {
        onView(withId(R.id.navigation_movies)).check(matches(isDisplayed()));
        onView(withId(R.id.navigation_movies)).perform(click());
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tgl)).check(matches(isDisplayed()));
//        onView(withId(R.id.tgl)).check(matches(withText("2018-09-27")));
        Espresso.pressBack();
    }

    @Test
    public void toTvShowActivityTest() {
        onView(withId(R.id.navigation_tv_show)).check(matches(isDisplayed()));
        onView(withId(R.id.navigation_tv_show)).perform(click());
        onView(withId(R.id.rv_tvShow)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tvShow)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tgl)).check(matches(isDisplayed()));
//        onView(withId(R.id.tgl)).check(matches(withText("2014-10-07")));
        Espresso.pressBack();
    }

    @Test
    public void toMoviesFavorite() {
        onView(withId(R.id.navigation_favorite)).check(matches(isDisplayed()));
        onView(withId(R.id.navigation_favorite)).perform(click());
        onView(withId(R.id.rv_movies_favorite)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies_favorite)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }

}
