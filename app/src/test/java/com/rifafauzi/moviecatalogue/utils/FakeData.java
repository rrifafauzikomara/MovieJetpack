package com.rifafauzi.moviecatalogue.utils;

import com.rifafauzi.moviecatalogue.helper.local.entity.MoviesEntity;
import com.rifafauzi.moviecatalogue.helper.local.entity.TvShowEntity;
import com.rifafauzi.moviecatalogue.model.Movies;

import java.util.ArrayList;
import java.util.List;

public class FakeData {

    public static List<MoviesEntity> generateDummyLocalMovies() {
        List<MoviesEntity> moviesEntities = new ArrayList<>();
        moviesEntities.add(new MoviesEntity(
                384018,
                "Fast & Furious Presents: Hobbs & Shaw",
                "A spinoff of The Fate of the Furious, focusing on Johnson's US Diplomatic Security Agent Luke Hobbs forming an unlikely alliance with Statham's Deckard Shaw.",
                "2019-08-01",
                null,
                "/keym7MPn1icW1wWfzMnW3HeuzWU.jpg"
        ));
        moviesEntities.add(new MoviesEntity(
                420818,
                "The Lion King",
                "Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his.",
                "2019-07-12",
                null,
                "/dzBtMocZuJbjLOXvrl4zGYigDzh.jpg"
        ));
        return moviesEntities;
    }

    public static List<Movies> generateDummyApiMovies() {
        List<Movies> movies = new ArrayList<>();
        movies.add(new Movies(
                "/dzBtMocZuJbjLOXvrl4zGYigDzh.jpg",
                "Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his.",
                "2019-07-12",
                "2019-07-12",
                420818,
                "The Lion King",
                "The Lion King"));
        movies.add(new Movies(
                "/rjbNpRMoVvqHmhmksbokcyCr7wn.jpg",
                "Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent.",
                "2019-06-28",
                "2019-06-28",
                429617,
                "Spider-Man: Far from Home",
                "Spider-Man: Far from Home"
        ));
        return movies;
    }

    public static MoviesEntity getMovieDetail() {
        return new MoviesEntity(
                420818,
                "The Lion King",
                "Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his.",
                "2019-07-12",
                null,
                "/dzBtMocZuJbjLOXvrl4zGYigDzh.jpg"
        );
    }

    public static List<TvShowEntity> generateDummyLocalTvShow() {
        List<TvShowEntity> tvShowEntities = new ArrayList<>();
        tvShowEntities.add(new TvShowEntity(
                60735,
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "2014-10-07",
                null,
                "/fki3kBlwJzFp8QohL43g9ReV455.jpg"
        ));
        tvShowEntities.add(new TvShowEntity(
                60735,
                "The Simpsons",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "2014-10-07",
                null,
                "/fki3kBlwJzFp8QohL43g9ReV455.jpg"
        ));
        return tvShowEntities;
    }

    public static List<Movies> generateDummyApiTvShow() {
        List<Movies> tvShows = new ArrayList<>();
        tvShows.add(new Movies(
                "/b71BaRjp9TwxUZodLGgSRIlkfL8.jpg",
                "The dramatisation of one of the most notorious killing sprees in British history.",
                "",
                "",
                11634,
                "The Flash",
                ""
        ));
        tvShows.add(new Movies(
                "/MoEKaPFHABtA1xKoOteirGaHl1.jpg",
                "To carry out the biggest heist in history, a mysterious man called The Professor recruits a band of eight robbers who have a single characteristic: none of them has anything to lose. Five months of seclusion - memorizing every step, every detail, every probability - culminate in eleven days locked up in the National Coinage and Stamp Factory of Spain, surrounded by police forces and with dozens of hostages in their power, to find out whether their suicide wager will lead to everything or nothing.",
                "",
                "",
                71446,
                "",
                ""
        ));
        return tvShows;
    }

    public static TvShowEntity getTvShowsDetail() {
        return new TvShowEntity(
                60735,
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "2014-10-07",
                null,
                "/fki3kBlwJzFp8QohL43g9ReV455.jpg"
        );
    }
}
