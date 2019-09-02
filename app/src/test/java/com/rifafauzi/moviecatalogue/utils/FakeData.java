package com.rifafauzi.moviecatalogue.utils;

import com.rifafauzi.moviecatalogue.model.Movies;
import com.rifafauzi.moviecatalogue.model.TvShow;

import java.util.ArrayList;
import java.util.List;

public class FakeData {
    public static List<Movies> generateDummyMovies() {
        List<Movies> movies = new ArrayList<>();
        movies.add(new Movies(
                "/dzBtMocZuJbjLOXvrl4zGYigDzh.jpg",
                "Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his.",
                "2019-07-12",
                420818,
                "The Lion King"));
        movies.add(new Movies(
                "/rjbNpRMoVvqHmhmksbokcyCr7wn.jpg",
                "Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent.",
                "2019-06-28",
                429617,
                "Spider-Man: Far from Home"
        ));
        return movies;
    }

    public static Movies getMovieDetail() {
        return new Movies(
                "/dzBtMocZuJbjLOXvrl4zGYigDzh.jpg",
                "Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his.",
                "2019-07-12",
                420818,
                "The Lion King"
        );
    }

    public static List<TvShow> generateDummyTvShow() {
        List<TvShow> tvShows = new ArrayList<>();
        tvShows.add(new TvShow(
                "/b71BaRjp9TwxUZodLGgSRIlkfL8.jpg",
                "The dramatisation of one of the most notorious killing sprees in British history.",
                "",
                11634,
                ""
        ));
        tvShows.add(new TvShow(
                "/MoEKaPFHABtA1xKoOteirGaHl1.jpg",
                "To carry out the biggest heist in history, a mysterious man called The Professor recruits a band of eight robbers who have a single characteristic: none of them has anything to lose. Five months of seclusion - memorizing every step, every detail, every probability - culminate in eleven days locked up in the National Coinage and Stamp Factory of Spain, surrounded by police forces and with dozens of hostages in their power, to find out whether their suicide wager will lead to everything or nothing.",
                "",
                71446,
                ""
        ));
        return tvShows;
    }

    public static TvShow getTvShowsDetail() {
        return new TvShow(
                "/MoEKaPFHABtA1xKoOteirGaHl1.jpg",
                "To carry out the biggest heist in history, a mysterious man called The Professor recruits a band of eight robbers who have a single characteristic: none of them has anything to lose. Five months of seclusion - memorizing every step, every detail, every probability - culminate in eleven days locked up in the National Coinage and Stamp Factory of Spain, surrounded by police forces and with dozens of hostages in their power, to find out whether their suicide wager will lead to everything or nothing.",
                "",
                71446,
                ""
        );
    }
}
