package com.rifafauzi.moviecatalogue.ui;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import com.rifafauzi.moviecatalogue.R;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MovieCatalogueTest {

    @Rule
    public ActivityTestRule<HomeActivity> activityRule = new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void toMovieActivityTest() {
        onView(withId(R.id.navigation_movies)).check(matches(isDisplayed()));
        onView(withId(R.id.navigation_movies)).perform(click());
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tgl)).check(matches(isDisplayed()));
        onView(withId(R.id.tgl)).check(matches(withText("October 3, 2018")));
        Espresso.pressBack();
    }

    @Test
    public void toTvShowActivityTest() {
        onView(withId(R.id.navigation_tv_show)).check(matches(isDisplayed()));
        onView(withId(R.id.navigation_tv_show)).perform(click());
        onView(withId(R.id.rv_tvShow)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tvShow)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tgl)).check(matches(isDisplayed()));
        onView(withId(R.id.tgl)).check(matches(withText("October 10, 2012")));
        Espresso.pressBack();
    }

}
